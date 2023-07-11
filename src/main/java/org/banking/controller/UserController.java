package org.banking.controller;

import org.banking.entities.user.UserApproveRequest;
import org.banking.entities.user.UserRequest;
import org.banking.entities.user.UserResponse;
import org.banking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    ResponseEntity <String>  post(@Valid @RequestBody UserRequest user) {
        service.post(user);
        return ResponseEntity.ok("ok");
    }

    @GetMapping
   ResponseEntity <List<UserResponse>> getAll(){
        List<UserResponse> response = service.getAll();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    void approve(@PathVariable("id") Long id, @RequestBody UserApproveRequest body){
        service.approve(id,body.getApproveEnum());

    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id){
        service.delete(id);

    }
}
