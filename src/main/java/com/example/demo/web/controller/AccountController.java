package com.example.demo.web.controller;

import com.example.demo.web.dto.AccountDto;

import java.io.IOException;

public interface AccountController {
    boolean saveAndReturnStatus(AccountDto accountDto);
    AccountDto findAccountByUsername(AccountDto accountDto);
    AccountDto saveAndReturn(AccountDto accountDto);
    void save(AccountDto accountDto) throws IOException;
    public void update(AccountDto accountDto);
}
