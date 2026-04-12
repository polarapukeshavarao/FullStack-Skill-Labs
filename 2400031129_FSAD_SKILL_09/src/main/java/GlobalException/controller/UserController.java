package GlobalException.controller;

import org.springframework.web.bind.annotation.*;
import GlobalException.exception.UserNotFoundException;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {

        if (id != 1) {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }

        return "User found!";
    }
}
 
