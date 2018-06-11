package sys.components;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sys.dtos.AuthenticationDTO;
import sys.dtos.RegistrationDTO;
import sys.dtos.UserDTO;
import sys.entities.UserEntity;
import sys.beans.AuthenticationBean;
import sys.beans.RegistrationBean;
import sys.services.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/access")
public class AccessController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public AuthenticationDTO login(@RequestParam("email") String email, @RequestParam("password") String password) {
        return modelMapper.map(userService.authenticateUser(email, password), AuthenticationDTO.class);
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<UserDTO> getUsers() {
        return userService.getUsers().stream()
                .map(user -> user.toDto(modelMapper, UserDTO.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/doRegistration", method = RequestMethod.POST)
    public RegistrationDTO registration(@RequestBody UserEntity user) {
        return modelMapper.map(userService.registerUser(user), RegistrationDTO.class);
    }

}
