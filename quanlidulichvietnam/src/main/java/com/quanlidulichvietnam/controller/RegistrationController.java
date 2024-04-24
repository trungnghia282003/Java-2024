/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quanlidulichvietnam.controller;

import com.quanlidulichvietnam.dto.RegisterDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import com.quanlidulichvietnam.service.IUserService;

@Controller
@RequestMapping("/account")
public class RegistrationController {

    @Autowired
    private IUserService userService;

    @GetMapping("/register")
    public String register(WebRequest request, Model model) {
        RegisterDTO registerDTO = new RegisterDTO();
        model.addAttribute("registerDTO", registerDTO);
        return "account/registration";
    }

    @PostMapping("/register")
    public String userRegistration(
            @ModelAttribute("registerDTO") @Valid RegisterDTO registerDTO,
            HttpServletRequest request, Errors errors) {
        userService.register(registerDTO);
        return "redirect:/login";
    }
}
