package sys.services;

import sys.entities.UserEntity;
import sys.entities.messages.AuthenticationMessage;

import java.util.List;

public interface IUserService {

    boolean registerUser(UserEntity u);
    AuthenticationMessage authenticateUser(String email, String password);
    List<UserEntity> getUsers();

}
