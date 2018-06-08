package sys.services;

import sys.entities.UserEntity;
import sys.entities.messages.AuthenticationMessage;
import sys.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean registerUser(UserEntity u) {
        u.setSalt("sale"); //todo
        u.setGroupid(1);   //todo
        u.setShop(null);
        return userRepository.saveAndFlush(u) != null; //todo
    }

    @Override
    public AuthenticationMessage authenticateUser(String email, String password) {
        UserEntity user = userRepository.findByEmail(email);
        AuthenticationMessage authenticationMsg = new AuthenticationMessage();
        if(user != null){
            if(user.getPassword().equals(password)) {
                authenticationMsg.setUser(user);
                authenticationMsg.setStatus(AuthenticationMessage.LOGIN_STATUS.LOGIN_OK);
            } else {
                authenticationMsg.setStatus(AuthenticationMessage.LOGIN_STATUS.WRONG_PASSWORD);
            }
        }else{
            authenticationMsg.setStatus(AuthenticationMessage.LOGIN_STATUS.ACCOUNT_NOT_EXISTING);
        }
        return authenticationMsg;
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}
