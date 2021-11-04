package com.dev.oneblog.Account.controller;

import com.dev.oneblog.Account.entity.AccountEntity;
import com.dev.oneblog.Account.repository.AccountRepository;
import com.dev.oneblog.Account.service.AccountService;
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
    AccountService accountService;

    @GetMapping("/account/{role}/{username}/{password}")
    public AccountEntity createAccount(@ModelAttribute AccountEntity accountEntity) {
        return accountService.createNew(accountEntity);
    }
}
