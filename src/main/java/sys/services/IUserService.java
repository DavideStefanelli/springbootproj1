package sys.services;

import sys.entities.UserEntity;
import sys.beans.AuthenticationBean;
import sys.beans.RegistrationBean;

import java.util.List;

public interface IUserService {

    RegistrationBean registerUser(UserEntity u);
    AuthenticationBean authenticateUser(String email, String password);
    List<UserEntity> getUsers();

}
