package com.apexon.capitalMarkets.user.Service;
import com.apexon.capitalMarkets.user.Entity.User;
import com.apexon.capitalMarkets.user.Mapper.UserMapper;
import com.apexon.capitalMarkets.user.Repository.RolesRepository;
import com.apexon.capitalMarkets.user.Repository.UserRepository;
import com.apexon.capitalMarkets.user.userDTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.apexon.capitalMarkets.user.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
    public class UserService {

        @Autowired
        private UserRepository userRepository;
        @Autowired
        PasswordEncoder passwordEncoder;
        @Autowired
        UserMapper userMapper;

        @Autowired
        BCryptPasswordEncoder bCryptPasswordEncoder;
        @Autowired
        RolesRepository rolesRepo;

        // For getting all users from DB
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        // For creating a user
        public User createUser(UserRegisterDto user) {
            if (userRepository.existsByEmail(user.getEmail()))
                throw new RuntimeException("Email already exists");
            System.out.println("User pass bfr encoding is " + user.getPassword());
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            System.out.println("User pass after encdeing is " + user.getPassword());
            User u=new User();
            u.setPassword(user.getPassword());
            u.setUsername(user.getUsername());
            u.setEmail(user.getEmail());
            u.setRole(user.getRole());


            return userMapper.convertUserToUserDto(userRepository .save(u)).toEntity();
        }

        // For updating an existing user
        public User updateUser(Long id, UpdateUserDto user) {
            if (userRepository.existsByEmailAndIdNot(user.getEmail(), id)) {
                throw new RuntimeException("Email already exists");
            }
            Optional<User> optionalUser = userRepository.findById(id);
            if (!optionalUser.isPresent()) {
                throw new RuntimeException("user not found with " + id);
            }
            User exisitngUser = optionalUser.get();
            if(user.getUsername()!=null)
            {
                exisitngUser.setUsername(user.getUsername());
            }
            if(user.getEmail()!=null)
                exisitngUser.setEmail(user.getEmail());
            return (userMapper.convertUserToUserDto(userRepository.save(exisitngUser))).toEntity();
        }

        public UserAdminDto getUserById(Long id) {
            Optional<User> user = userRepository.findById(id);
            if (user.isEmpty()) {
                throw new RuntimeException("User not found with " + id);
            }
            User exisitngUser = user.get();

            return userMapper.convertUserToUserAdminDto(exisitngUser);

        }

        public void updateUserPassword(Long id, UpdatePasswordDto updatePasswordDto) {
            Optional<User>user=userRepository.findById(id);
            if(user.isEmpty()){
                throw new RuntimeException("User not found with "+ id);
            }
            User existingUser=user.get();
            if(bCryptPasswordEncoder.matches(updatePasswordDto.getPassword(),existingUser.getPassword()))
            {
                throw new RuntimeException("New password should not be same as old password,Try with different password");
            }
            existingUser.setPassword(bCryptPasswordEncoder.encode(updatePasswordDto.getPassword()));
            userRepository.save(existingUser);

        }

        public List<UserAdminDto> fetchAllUsersByAdminId(Long id) {
            Optional<User> user=userRepository.findById(id);
            if(user.isEmpty())
            {
                throw new RuntimeException("User not found with "+id);
            }
            if(user.get().getRole()!=Role.Admin)
            {
                throw new RuntimeException("you dont have enough permissions to access");
            }
       /*return userRepo.findAll().stream().filter(u->u.getRole()!= Roles.ADMIN).map(userMapper::convertUserToUserAdminDto)
               .collect(Collectors.toList());*/
            return userRepository.findAll().stream().map(userMapper::convertUserToUserAdminDto)
                    .collect(Collectors.toList());
        }

        public UserAdminDto updateUserAccountDetails(Long adminId, ManageUserAccountDto manageUserAccountDto) {
            Optional<User> adminUser=userRepository.findById(adminId);
            if(adminUser.isEmpty())
            {
                throw new RuntimeException("User not found with "+adminId);
            }
            if(adminUser.get().getRole()!=Role.Admin)
            {
                throw new RuntimeException("you dont have enough permissions to access");
            }
            Optional<User> normalUser=userRepository.findById(manageUserAccountDto.getId());
            if(normalUser.isEmpty())
            {
                throw new RuntimeException("User not found with "+normalUser);
            }
            User actualUser=normalUser.get();
            actualUser.setAccountExpired(manageUserAccountDto.isAccountExpired());
            actualUser.setAccountLocked(manageUserAccountDto.isAccountLocked());
            actualUser.setCredentialsExpired(manageUserAccountDto.isCredentialsExpired());
            return userMapper.convertUserToUserAdminDto(userRepository.save(actualUser));

        }

        public void assignRolesToUser(Long userId, Set<Role> roleTypes, Long id) {
            // Check if the user exists
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

            // Check if the admin has permission (only ADMIN can assign roles)
            Optional<User> isAdmin=userRepository.findById(id);
            if(isAdmin.isEmpty())
            {
                throw new RuntimeException("User nt found with "+id);
            }
            User adminUser=isAdmin.get();
            if (!adminUser.getRole().equals(Role.Admin)) {
                throw new RuntimeException("Access Denied: Only Admins can assign roles.");
            }

            // Fetch roles from database
            Set<Role> newRoles = rolesRepo.findByRole(roleTypes);

            // Replace existing roles with new ones
            user.setRole(Role.Admin);

            // Save the updated user
            userRepository.save(user);

        }
    }

