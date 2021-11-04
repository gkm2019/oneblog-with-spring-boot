package com.dev.oneblog.Account.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by kyeongmin ku
 */

@Getter
@Setter //추후삭제
@Entity
public class AccountEntity {

    @Id
    @GeneratedValue
    private Integer accountId;

    @Column(unique = true)
    private String username;

    private String password;

    private String role;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

}
