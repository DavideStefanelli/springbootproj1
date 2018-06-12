package sys.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import sys.entities.UserEntity;
import sys.beans.AuthenticationBean;
import sys.beans.RegistrationBean;
import sys.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Marker serviceMarker = MarkerFactory.getMarker("ACCESS_SERVICE");

    @Override
    public RegistrationBean registerUser(UserEntity u) {
        String salt = Long.toUnsignedString(ThreadLocalRandom.current().nextLong());
        String passwordHash = DigestUtils.sha256Hex(u.getPassword() + salt);
        u.setSalt(salt);
        u.setPassword(passwordHash);
        u.setShop(null);
        u.setCreationdate(Timestamp.from(Instant.now()));
        RegistrationBean registrationBean = new RegistrationBean();
        try{
            registrationBean.setUser(userRepository.saveAndFlush(u));
            registrationBean.setStatus(RegistrationBean.REGISTRATION_STATUS.SUCCESS);
        }catch (Exception ex) {
            if(ex.getCause() != null && ex.getCause() instanceof ConstraintViolationException){
                ConstraintViolationException e = (ConstraintViolationException)ex.getCause();
                if(e.getConstraintName().equals("UNIQUE_EMAIL")) {
                    registrationBean.setStatus(RegistrationBean.REGISTRATION_STATUS.ACCOUNT_EXISTING);
                    logger.info(serviceMarker, "Account existing: " + u.getEmail());
                } else {
                    registrationBean.setStatus(RegistrationBean.REGISTRATION_STATUS.ERROR);
                    logger.error(serviceMarker, "Unhandled error during registration : Constraint violated -> " + e.getConstraintName());
                }
            }  else {
                registrationBean.setStatus(RegistrationBean.REGISTRATION_STATUS.ERROR);
                logger.error(serviceMarker, "Unhandled error during registration!", ex);
            }
        }
        return registrationBean;
    }

    @Override
    public AuthenticationBean authenticateUser(String email, String password) {
        UserEntity user = userRepository.findByEmail(email);
        AuthenticationBean authenticationBean = new AuthenticationBean();
        if(user != null){
            String passwordHash = DigestUtils.sha256Hex(password + user.getSalt());
            if(user.getPassword().equals(passwordHash)) {
                authenticationBean.setUser(user);
                authenticationBean.setStatus(AuthenticationBean.LOGIN_STATUS.LOGIN_OK);
            } else {
                authenticationBean.setStatus(AuthenticationBean.LOGIN_STATUS.WRONG_PASSWORD);
            }
        }else{
            authenticationBean.setStatus(AuthenticationBean.LOGIN_STATUS.ACCOUNT_NOT_EXISTING);
        }
        return authenticationBean;
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

}
