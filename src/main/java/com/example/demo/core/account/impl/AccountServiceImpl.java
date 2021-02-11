package com.example.demo.core.account.impl;

import com.example.demo.core.AccountService;
import com.example.demo.core.account.Account;
import com.example.demo.core.account.Profile;
import com.example.demo.core.account.User;
import com.example.demo.core.logger.Logger;
import com.example.demo.core.repository.AccountRepository;
import com.example.demo.core.repository.RoleRepository;
import com.example.demo.web.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    RoleRepository roleRepository;
    Logger logger;

    @Override
    public boolean saveAndReturnStatus(AccountDto accountDto) {
        try {
            Account account = new Account(accountDto.getId(),
                    accountDto.getUsername());
            account.getUser().setUsername(accountDto.getUsername());
            accountRepository.save(account);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public AccountDto findAccountByUsername(AccountDto accountDto) {
        Account account = accountRepository.getAccountByUsername(accountDto.getUsername());
        logger.save(account);
        return new AccountDto(account.getId(), account.getUsername());
    }

    @Override
    public AccountDto saveAndReturn(AccountDto accountDto) {
        Account account = new Account(accountDto.getId(), accountDto.getUsername());
        accountRepository.save(account);
        return accountDto;
    }

    @Override
    public void update(AccountDto accountDto) {
        if (accountRepository.findById(accountDto.getId()).isPresent()) {
            Account account = accountRepository.getAccountById(accountDto.getId());
            account.setUsername(accountDto.getUsername());
            accountRepository.save(account);
        }
    }

    @Override
    public void save(AccountDto accountDto) {
        try {
            if (accountRepository.findAccountByUsername(accountDto.getUsername()) == null) {
                Account account = new Account(accountDto.getId(),
                        accountDto.getUsername());
                userInit(account, accountDto);
                profileInit(account, accountDto);
                roleInit(account);
                accountRepository.save(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userInit(Account account, AccountDto accountDto) {
        account.setUser(new User());
        account.getUser().setUsername(accountDto.getUsername());
    }

    public void profileInit(Account account, AccountDto accountDto){
        account.getUser().setProfile(new Profile());
        account.getUser().getProfile().setUsername(accountDto.getUsername());
    }

    public void roleInit(Account account) {
        account.getUser().setRole(roleRepository.getRoleByName("user").getName());
    }
}