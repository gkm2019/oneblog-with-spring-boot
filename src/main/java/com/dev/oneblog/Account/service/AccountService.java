package com.dev.oneblog.Account.service;

import com.dev.oneblog.Account.entity.AccountEntity;
import com.dev.oneblog.Account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by kyeongmin ku
 */

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String userNm) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountRepository.findByUserNm(userNm);

        if(accountEntity == null) {
            throw new UsernameNotFoundException(userNm);
        }

        return User.builder() //spring Security가 제공함
                .username(accountEntity.getUserNm())
                .password(accountEntity.getPassword())
                .roles(accountEntity.getRole())
                .build();
    }

}
