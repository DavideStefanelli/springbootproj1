package sys.dtos;

import sys.beans.AuthenticationBean;

public class AuthenticationDTO extends BasicDTO {

    private UserDTO user;

    private AuthenticationBean.LOGIN_STATUS status;

    private String token;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public AuthenticationBean.LOGIN_STATUS getStatus() {
        return status;
    }

    public void setStatus(AuthenticationBean.LOGIN_STATUS status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
