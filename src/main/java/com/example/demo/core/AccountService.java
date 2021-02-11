package com.example.demo.core;

import com.example.demo.web.dto.AccountDto;

import java.io.IOException;

public interface AccountService {
    boolean saveAndReturnStatus(AccountDto accountDto);
    AccountDto findAccountByUsername(AccountDto accountDto);
    AccountDto saveAndReturn(AccountDto accountDto);
    void update(AccountDto accountDto);
    void save(AccountDto accountDto) throws IOException;
}
