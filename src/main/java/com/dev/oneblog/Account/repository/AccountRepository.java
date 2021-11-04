package com.dev.oneblog.Account.repository;

import com.dev.oneblog.Account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kyeongmin ku
 */

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    AccountEntity findByUserNm(String userNm);
}
