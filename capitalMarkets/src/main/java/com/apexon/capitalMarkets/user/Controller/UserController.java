package com.apexon.capitalMarkets.user.Controller;

import com.apexon.capitalMarkets.user.Entity.User;
import com.apexon.capitalMarkets.user.Repository.UserRepository;
import com.apexon.capitalMarkets.user.Service.UserService;
import com.apexon.capitalMarkets.user.userDTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get a user by ID
    @GetMapping("/getUserByName/{uname}")
    public Optional<User> getUser(@PathVariable String uname)
    {
        return userRepo.findByUsername(uname);
    }
    @GetMapping("/getUserById/{id}")
    public UserAdminDto getUserById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }

    // Create a new user
    @PostMapping("/registerUser")
    public User registerUser(@RequestBody UserRegisterDto user)
    {
        return userService.createUser(user);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UpdateUserDto userDTO) {
        User updatedUser = userService.updateUser(id, userDTO);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a user by ID
    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @PutMapping("/updatePassword/{id}")
    public ResponseEntity<String> updateUserPassword(@RequestBody UpdatePasswordDto updatePasswordDto, @PathVariable Long id){
        userService.updateUserPassword(id,updatePasswordDto);
        return new ResponseEntity<>("Password updated Successfully", HttpStatus.OK);
    }

    @GetMapping("/getAllUsers/{adminId}")
    public List<UserAdminDto> fetchAllUsersByAdminId(@PathVariable Long adminId){
        return userService.fetchAllUsersByAdminId(adminId);
    }
    @PutMapping("/updateUserAccountDetails/{adminId}")
    public UserAdminDto updateUserAccountDetails(@PathVariable Long adminId,@RequestBody ManageUserAccountDto manageUserAccountDto){
        return userService.updateUserAccountDetails(adminId,manageUserAccountDto);
    }
    @PutMapping("/assignRoles/{id}")
    public ResponseEntity<String> assignRoles(@RequestBody AssignRolesDto assignRolesDto, @PathVariable Long id) {
        try {
            userService.assignRolesToUser(assignRolesDto.getUserId(), assignRolesDto.getRoles(), id);
            return ResponseEntity.ok("Roles updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}
