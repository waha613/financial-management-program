package com.fms2.fms2.receivableAndPayable.service;

import com.fms2.fms2.receivableAndPayable.domain.AccountReceivable;
import com.fms2.fms2.receivableAndPayable.mapper.AccountReceivableMapper;
import com.fms2.fms2.receivableAndPayable.page.AccountReceivablePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountReceivableService {
    @Autowired
    private AccountReceivableMapper accountReceivableMapper;

    public List<AccountReceivable> getAccountsReceivable(AccountReceivablePage page){
        return accountReceivableMapper.getAccountsReceivable(page);
    }

    public Integer getRows(AccountReceivablePage page){
        return accountReceivableMapper.getRows(page);
    }

    public boolean addAccountReceivable(AccountReceivable accountReceivable){
        return accountReceivableMapper.addAccountReceivable(accountReceivable) == 1;
    }

    public boolean updateAccountReceivable(AccountReceivable accountReceivable){
        return accountReceivableMapper.updateAccountReceivable(accountReceivable) == 1;
    }

    public boolean deleteAccountReceivable(AccountReceivable accountReceivable){
        return accountReceivableMapper.deleteAccountReceivable(accountReceivable) == 1;
    }

    public List<AccountReceivable> getAllAccountsReceivable(AccountReceivable accountReceivable){
        return accountReceivableMapper.getAllAccountsReceivable(accountReceivable);
    }

    public List<AccountReceivable> getAllAccountsReceivableStatistics(AccountReceivablePage page){
        return accountReceivableMapper.getAllAccountsReceivableStatistics(page);
    }
}
