package sys.services;

import sys.entities.UserEntity;
import sys.entities.messages.AuthenticationMessage;

public interface IUserService {

    boolean registerUser(UserEntity u);
    AuthenticationMessage authenticateUser(String email, String password);

}
