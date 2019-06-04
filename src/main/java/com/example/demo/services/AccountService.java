package com.example.demo.services;

import com.example.demo.AccountRepository;
import com.example.demo.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    public List<Account> getAllAccounts(){
        return repository.findAll();
    }

    //Проверяет, есть ли аккаунт с таким никнеймом, если нет, то возвращает true и регистрирует новый аккаунт
    //приложение, получая false будет уведомлять пользователя о том, что такой никнейм уже зарегистрирован
    public boolean addAccount(Account p){
        List<Account> list = repository.findAll();
        for (int i=0; i<list.size(); i++){
            System.out.println(p.getNickname());
            if(list.get(i).getNickname().equals(p.getNickname()))
                return false;
        }
        repository.saveAndFlush(p);
        return true;
    }

    public Optional<Account> getAccountById(long id){
        return repository.findById(id);
    }

    //проверяет соотвествие никнейма и пароля, если всё ок, возвращает объект класса аккаунт, иначе - null
    public Optional<Account> login(String nickname, String password){
        List<Account> list = repository.findAll();
        for (int i=0; i<list.size(); i++){
            if(list.get(i).getNickname()==nickname && list.get(i).getPassword()==password)
                return repository.findById(list.get(i).getId());
        }
        return null;
    }

    //обновляет данные об аккаунте
    public void updateData(Account acc){
        getAccountById(acc.getId()).orElse(null).setData(acc);
    }

    public void deleteAccountById(long id){
        repository.delete(getAccountById(id).get());
    }
}
