package com.fms2.fms2.receivableAndPayable.service;

import com.fms2.fms2.receivableAndPayable.domain.AccountPayable;
import com.fms2.fms2.receivableAndPayable.mapper.AccountPayableMapper;
import com.fms2.fms2.receivableAndPayable.page.AccountPayablePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountPayableService {
    @Autowired
    private AccountPayableMapper accountPayableMapper;

    public List<AccountPayable> getAccountsPayable(AccountPayablePage page){
        return accountPayableMapper.getAccountsPayable(page);
    }

    public Integer getRows(AccountPayablePage page){
        return accountPayableMapper.getRows(page);
    }

    public boolean addAccountPayable(AccountPayable accountPayable){
        return accountPayableMapper.addAccountPayable(accountPayable) == 1;
    }

    public boolean updateAccountPayable(AccountPayable accountPayable){
        return accountPayableMapper.updateAccountPayable(accountPayable) == 1;
    }

    public boolean deleteAccountPayable(AccountPayable accountPayable){
        return accountPayableMapper.deleteAccountPayable(accountPayable) == 1;
    }

    public List<AccountPayable> getAllAccountsPayable(AccountPayable accountPayable){
        return accountPayableMapper.getAllAccountsPayable(accountPayable);
    }

    public List<AccountPayable> getAllAccountsPayableStatistics(AccountPayablePage page){
        return accountPayableMapper.getAllAccountsPayableStatistics(page);
    }
}
