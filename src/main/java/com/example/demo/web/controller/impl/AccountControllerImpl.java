package com.example.demo.web.controller.impl;

import com.example.demo.core.AccountService;
import com.example.demo.core.account.impl.AccountServiceImpl;
import com.example.demo.web.controller.AccountController;
import com.example.demo.web.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(name = "/")
public class AccountControllerImpl implements AccountController {
    private AccountService accountService;

    @Autowired
    public AccountControllerImpl(AccountServiceImpl accountServiceImpl) {
        this.accountService = accountServiceImpl;
    }

    @Override
    @GetMapping(value = "/settings/account")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean saveAndReturnStatus(@RequestBody AccountDto accountDto) {
        return accountService.saveAndReturnStatus(accountDto);
    }

    @Override
    @GetMapping(value = "/find/account")///find/account/{username}
    public AccountDto findAccountByUsername(@RequestBody AccountDto accountDto) {
        return accountService.findAccountByUsername(accountDto);
    }

    @Override
    public AccountDto saveAndReturn(@RequestBody AccountDto accountDto) {
        return accountService.saveAndReturn(accountDto);
    }

    @Override
    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody AccountDto accountDto) {
        accountService.update(accountDto);
    }

    @Override
    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody AccountDto accountDto) throws IOException {
        accountService.save(accountDto);
    }
}
