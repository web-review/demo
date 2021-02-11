package com.example.demo.core.repository;

import com.example.demo.core.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account getAccountById(Long id);
    Account getAccountByUsername(String username);
    Boolean findAccountByUsername(String username);
    Account findAccountByUserId(String userId);
}
