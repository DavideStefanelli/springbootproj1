package sys.dtos;


import sys.beans.RegistrationBean;

public class RegistrationDTO extends BasicDTO {

    private UserDTO user;

    private RegistrationBean.REGISTRATION_STATUS status;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public RegistrationBean.REGISTRATION_STATUS getStatus() {
        return status;
    }

    public void setStatus(RegistrationBean.REGISTRATION_STATUS status) {
        this.status = status;
    }
}
