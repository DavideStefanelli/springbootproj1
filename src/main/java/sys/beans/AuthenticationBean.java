package sys.beans;

import sys.entities.UserEntity;

public class AuthenticationBean {

    private UserEntity user;

    public enum LOGIN_STATUS { LOGIN_OK, ACCOUNT_NOT_EXISTING, WRONG_PASSWORD }

    private LOGIN_STATUS status;

    private String token;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public LOGIN_STATUS getStatus() {
        return status;
    }

    public void setStatus(LOGIN_STATUS status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
