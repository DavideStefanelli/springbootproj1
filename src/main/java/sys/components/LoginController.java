package sys.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sys.entities.UserEntity;
import sys.entities.messages.AuthenticationMessage;
import sys.services.IUserService;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

@RestController
@RequestMapping("/access")
public class LoginController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public AuthenticationMessage login(@RequestParam("email") String email, @RequestParam("password") String password) {
        return userService.authenticateUser(email, password);
    }

    @RequestMapping(value = "/doRegistration", method = RequestMethod.POST)
    public boolean registration(@RequestBody UserEntity user) {
        user.setCreationdate(Timestamp.from(Instant.now()));
        return userService.registerUser(user);
    }

}
