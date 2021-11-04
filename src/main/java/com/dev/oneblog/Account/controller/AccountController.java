package com.dev.oneblog.Account.controller;

import com.dev.oneblog.Account.entity.AccountEntity;
import com.dev.oneblog.Account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyeongmin ku
 *
 * 임시 클래스입니다. 삭제 에정
 * 저장을 위한 임시용
 */

@RestController
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/account/{role}/{usename}/{password}")
    public AccountEntity createAccount(@ModelAttribute AccountEntity accountEntity) {
        return accountRepository.save(accountEntity);
    }
}
