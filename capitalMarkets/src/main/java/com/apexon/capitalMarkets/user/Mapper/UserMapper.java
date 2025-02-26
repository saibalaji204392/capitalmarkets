package com.apexon.capitalMarkets.user.Mapper;

import com.apexon.capitalMarkets.user.userDTO.UserAdminDto;
import com.apexon.capitalMarkets.user.userDTO.UserDTO;
import com.apexon.capitalMarkets.user.userDTO.UserRegisterDto;
import com.apexon.capitalMarkets.user.Entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    public UserDTO convertUserToUserDto(User user){
        UserDTO userDto=new UserDTO();
        userDto.setUsername(user.getUsername());
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
       /* userDto.setAccountLocked(user.isAccountLocked());
        userDto.setAccountExpired(user.isAccountExpired());
        userDto.setCredentialsExpired(user.isCredentialsExpired());*/
        return userDto;

    }
    public UserRegisterDto convertUserToUserRegisterDto(User user)
    {
        UserRegisterDto userRegisterDto=new UserRegisterDto();
        userRegisterDto.setPassword(user.getPassword());
        userRegisterDto.setUsername(user.getUsername());
        userRegisterDto.setEmail(user.getEmail());
        return userRegisterDto;
    }


    public UserAdminDto convertUserToUserAdminDto(User user) {
        UserAdminDto userAdminDto=new UserAdminDto();
        userAdminDto.setUsername(user.getUsername());
        userAdminDto.setId(user.getId());
        userAdminDto.setEmail(user.getEmail());
        userAdminDto.setRole(user.getRole());
        userAdminDto.setAccountLocked(user.isAccountLocked());
        userAdminDto.setAccountExpired(user.isAccountExpired());
        userAdminDto.setCredentialsExpired(user.isCredentialsExpired());
        return userAdminDto;
    }
}
