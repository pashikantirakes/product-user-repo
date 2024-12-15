package com.example.UserServiceWithGateWay;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")

public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/{id}")
        public ResponseEntity<User> findUserById(@PathVariable Long id){
      Optional<User> user = Optional.ofNullable(userRepository.findById(id).get());
        User user1 = new User();
        if(user.isPresent()) {
        user1 = user.get();
    }
        return ResponseEntity.ok(user1);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name){
        return ResponseEntity.ok(Optional.ofNullable(userRepository.findByName(name).get())
                .orElseThrow(()->new UserNameNotFoundExeption("Username not found")));
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsersList(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<String > userCreation(@RequestBody User user){
        userRepository.save(user);
        String result = "User creation success with name - " + user.getName();
        return ResponseEntity.ok(result);
    }


}
