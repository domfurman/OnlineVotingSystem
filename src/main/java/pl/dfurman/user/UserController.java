package pl.dfurman.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

//    @PostMapping
//    public void registerNewUser(@RequestBody User user) {
//        userService.addNewUser(user);
//    }
//
//    @DeleteMapping(path = "{userId}")
//    public void deleteUser(@PathVariable("userId") Long voterId) {
//        userService.deleteUser(voterId);
//    }
//
//    @PutMapping(path = "{userId}")
//    public void updateUser(@PathVariable("userId") Long voterId,
//                            @RequestParam(required = false) String firstName,
//                            @RequestParam(required = false) String lastName,
//                            @RequestParam(required = false) String email) {
//        userService.updateUser(voterId, firstName, lastName, email);
//    }
}
