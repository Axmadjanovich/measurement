package com.gcSpring.web.rest;

import com.gcSpring.domain.Users;
import com.gcSpring.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService service){
        this.userService = service;
    }
    @PostMapping("/user")
    public ResponseEntity<Users> add(@RequestBody Users user){
        Users users = userService.save(user);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/user")
    public ResponseEntity getAll(){
        List<Users> usersList = userService.findAll();
        return ResponseEntity.ok(usersList);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Users user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/user")
    public ResponseEntity update(@RequestBody Users user){
        Users users = userService.save(user);
        return ResponseEntity.ok(users);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
