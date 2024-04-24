/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quanlidulichvietnam.service;

import com.quanlidulichvietnam.dto.RegisterDTO;
import com.quanlidulichvietnam.model.User;

public interface IUserService {

    void register(RegisterDTO registerDTO);

    boolean checkIfUserExist(String username);

}
