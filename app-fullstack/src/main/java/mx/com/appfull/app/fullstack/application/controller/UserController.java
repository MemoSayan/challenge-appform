package mx.com.appfull.app.fullstack.application.controller;

import mx.com.appfull.app.fullstack.domain.dto.UserDTO;
import mx.com.appfull.app.fullstack.domain.services.UserService;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/api/v1")
public class UserController {

private static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> index() {
        return userService.findAll();
    }
}
