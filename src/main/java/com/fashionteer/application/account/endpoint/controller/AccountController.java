package com.fashionteer.application.account.endpoint.controller;

import com.fashionteer.application.account.application.AccountService;
import com.fashionteer.application.account.endpoint.controller.form.SignUpForm;
import com.fashionteer.application.account.endpoint.controller.validator.SignUpFormValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final SignUpFormValidator signUpFormValidator;
    private final AccountService accountService;

    @InitBinder("signUpForm")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpFormValidator);
    }

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
        accountService.signUp(signUpForm);
        return "redirect:/";
    }

}
