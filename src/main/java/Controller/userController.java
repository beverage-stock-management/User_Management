package Controller;

import Model.User;
import UserRepository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/user") //read all
    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    @GetMapping(value = "/user/{uId}") //read by Id
    public User getUserById(@PathVariable String uId){
        return userRepo.findUserByUserId(uId);
    }

    @PostMapping(value = "/user") //create
    public User addUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @PutMapping(value = "/user/{uId}") //update
    public User updateUser(@PathVariable int uId,@RequestBody User user){
        userRepo.deleteById(uId);
        return userRepo.save(user);
    }

    @DeleteMapping(value = "/user/{uId}") //delete
    public void deleteUser(@PathVariable int uId){
        userRepo.deleteById(uId);
    }
}
