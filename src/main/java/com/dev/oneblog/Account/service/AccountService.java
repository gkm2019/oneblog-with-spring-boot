package com.dev.oneblog.Account.service;

import com.dev.oneblog.Account.entity.AccountEntity;
import com.dev.oneblog.Account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by kyeongmin ku
 */

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountRepository.findByUsername(username);

        if(accountEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        return User.builder() //spring Security가 제공함
                .username(accountEntity.getUsername())
                .password(accountEntity.getPassword())
                .roles(accountEntity.getRole())
                .build();
    }

    public AccountEntity createNew(AccountEntity accountEntity) {
        accountEntity.encodePassword(passwordEncoder);
        return this.accountRepository.save(accountEntity);
    }

}
