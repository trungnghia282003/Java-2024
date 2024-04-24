/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quanlidulichvietnam.service;

import com.quanlidulichvietnam.dto.RegisterDTO;
import com.quanlidulichvietnam.model.Role;
import com.quanlidulichvietnam.model.User;
import com.quanlidulichvietnam.model.UserDetail;
import com.quanlidulichvietnam.repository.UserDetailRepository;
import com.quanlidulichvietnam.repository.UserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterDTO registerDTO) {

        if (checkIfUserExist(registerDTO.getUsername())) {
            throw new RuntimeException("User already exists for this username" + registerDTO.getUsername());
        }

        User user = new User();
        UserDetail userDetail = new UserDetail(
                user.getId(),
                registerDTO.getFullName(),
                registerDTO.getEmail(),
                registerDTO.getPhone(),
                registerDTO.getAddress(),
                registerDTO.getDob(),
                registerDTO.getGender());
        Role role = new Role(3);

        user.setUsername(registerDTO.getUsername());
        encodePassword(user, registerDTO);
        user.setRole((Role) Arrays.asList("ROLE_USER"));
        user.setUserDetail(userDetail);

        userRepository.save(user);
    }

    @Override
    public boolean checkIfUserExist(String username) {
        return userRepository.findByUsername(username) != null ? true : false;
    }

    private void encodePassword(User user, RegisterDTO registerDTO) {
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
    }
}
