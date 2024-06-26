package com.fashionteer.application.account.application;

import com.fashionteer.application.account.domain.entity.Account;
import com.fashionteer.application.account.endpoint.controller.form.SignUpForm;
import com.fashionteer.application.account.infra.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignUpForm signUpForm) {
        Account account = Account.with(
                signUpForm.getEmail(),
                signUpForm.getNickname(),
                passwordEncoder.encode(signUpForm.getPassword())
        );
        accountRepository.save(account);
    }

}
