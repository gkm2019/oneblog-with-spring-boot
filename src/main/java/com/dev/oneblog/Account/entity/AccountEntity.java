package com.dev.oneblog.Account.entity;

import lombok.Getter;
import lombok.Setter;

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
    private Integer accoutId;

    @Column(unique = true)
    private String userNm;

    private String password;

    private String role;

}
