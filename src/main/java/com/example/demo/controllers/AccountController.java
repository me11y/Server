package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.entities.Monster;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    AccountService service;

    @RequestMapping(value = "/addacc", method = RequestMethod.POST)
    public boolean addAccount(@RequestParam(name = "login", required = true) String login, @RequestParam(name = "password", required = true) String password){
        return service.addAccount(new Account(login, password));
    }

    @RequestMapping("/accounts")
    public List<Account> getAllAccounts(){
        return service.getAllAccounts();
    }

    @RequestMapping("/accounts/{id}")
    public Account getAccountByPathVariableId(@PathVariable(name = "id") long id){
        Optional<Account> account = service.getAccountById(id);
        return account.orElse(null);
    }

    @RequestMapping("/monster/{id}")
    public Monster getMonster(@PathVariable(name = "id") long id){
        Optional<Account> account = service.getAccountById(id);
        return account.orElse(null).getMonster();
    }

    @RequestMapping(value = "/deleteacc/{id}", method = RequestMethod.POST)
    public void deleteAccountById(@PathVariable(name = "id") long id){
        service.deleteAccountById(id);
    }

    @RequestMapping("/login")
    public Account login(@RequestParam(name = "nickname", required = true) String nickname, @RequestParam(name = "password", required = true) String password){
        Optional<Account> account = service.login(nickname, password);
        return account.orElse(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody Account acc){
        service.updateData(acc);
    }
}
