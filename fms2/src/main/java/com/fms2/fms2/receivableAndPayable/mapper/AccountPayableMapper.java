package com.fms2.fms2.receivableAndPayable.mapper;

import com.fms2.fms2.receivableAndPayable.domain.AccountPayable;
import com.fms2.fms2.receivableAndPayable.page.AccountPayablePage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface AccountPayableMapper {
    List<AccountPayable> getAccountsPayable(AccountPayablePage page);
    int getRows(AccountPayablePage page);

    int addAccountPayable(AccountPayable accountPayable);
    int updateAccountPayable(AccountPayable accountPayable);
    int deleteAccountPayable(AccountPayable accountPayable);

    List<AccountPayable> getAllAccountsPayable(AccountPayable accountPayable);

    List<AccountPayable> getAllAccountsPayableStatistics(AccountPayablePage page);

}
