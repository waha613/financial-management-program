package com.fms2.fms2.receivableAndPayable.mapper;

import com.fms2.fms2.receivableAndPayable.domain.AccountReceivable;
import com.fms2.fms2.receivableAndPayable.page.AccountReceivablePage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface AccountReceivableMapper {
    List<AccountReceivable> getAccountsReceivable(AccountReceivablePage page);
    int getRows(AccountReceivablePage page);

    int addAccountReceivable(AccountReceivable accountReceivable);
    int updateAccountReceivable(AccountReceivable accountReceivable);
    int deleteAccountReceivable(AccountReceivable accountReceivable);

    List<AccountReceivable> getAllAccountsReceivable(AccountReceivable accountReceivable);
    List<AccountReceivable> getAllAccountsReceivableStatistics(AccountReceivablePage page);
}
