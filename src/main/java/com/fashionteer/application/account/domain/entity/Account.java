package com.fashionteer.application.account.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Account extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    private String email;

    private String nickname;

    private String password;

    private String emailToken;

    private LocalDateTime joinedAt;

    @Embedded
    private Profile profile;

    @Embeddable
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @ToString
    public static class Profile {
        private String name;
        private String phone;
        private String instagram;
        @Lob @Basic(fetch = FetchType.EAGER)
        private String image;
    }

    public static Account with(String email, String nickname, String password) {
        Account account = new Account();
        account.email = email;
        account.nickname = nickname;
        account.password = password;
        return account;
    }
}
