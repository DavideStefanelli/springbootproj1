package sys.beans;

import sys.entities.UserEntity;

public class RegistrationBean {
    private UserEntity user;

    public enum REGISTRATION_STATUS { SUCCESS, ACCOUNT_EXISTING, ERROR }

    private REGISTRATION_STATUS status;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public REGISTRATION_STATUS getStatus() {
        return status;
    }

    public void setStatus(REGISTRATION_STATUS status) {
        this.status = status;
    }
}
