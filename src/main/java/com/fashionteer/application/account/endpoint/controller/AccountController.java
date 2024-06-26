package com.fashionteer.application.account.endpoint.controller;

import com.fashionteer.application.account.endpoint.controller.form.SignUpForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
        model.addAttribute(new SignUpForm());
        return "account/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUpSubmit(
            @Valid @ModelAttribute SignUpForm signUpForm,
            Errors errors)
    {
        if (errors.hasErrors()) {
            return "account/sign-up";
        }
        return "redirect:/";
    }

}
