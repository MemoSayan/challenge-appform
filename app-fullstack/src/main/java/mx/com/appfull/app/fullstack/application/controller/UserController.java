package mx.com.appfull.app.fullstack.application.controller;

import mx.com.appfull.app.fullstack.domain.dto.UserDTO;
import mx.com.appfull.app.fullstack.domain.services.UserService;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/api/v1")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> index() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO, BindingResult result) {
        LOGGER.info(".:create:. userDTO {}, result {}", userDTO, result);
        UserDTO newUserDTO = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> err.getField() + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            newUserDTO = userService.save(userDTO);
        } catch (DataAccessException e) {
            response.put("message", "Error inserting into database");
            response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Employee created successfully");
        response.put("user", newUserDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
