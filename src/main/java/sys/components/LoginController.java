package sys.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sys.entities.UserEntity;
import sys.entities.messages.AuthenticationMessage;
import sys.services.IUserService;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/access")
public class LoginController {

    @Autowired
    IUserService userService;

    @CrossOrigin
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public AuthenticationMessage login(@RequestParam("email") String email, @RequestParam("password") String password) {
        return userService.authenticateUser(email, password);
    }

    @CrossOrigin
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @CrossOrigin
    @RequestMapping(value = "/doRegistration", method = RequestMethod.POST)
    public boolean registration(@RequestBody UserEntity user) {
        user.setCreationdate(Timestamp.from(Instant.now()));
        return userService.registerUser(user);
    }

}
