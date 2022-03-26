package com.fms2.fms2.receivableAndPayable.controller;

import com.fms2.fms2.json.ReturnJSONObject;
import com.fms2.fms2.json.ReturnJSONPageObject;
import com.fms2.fms2.receivableAndPayable.domain.AccountPayable;
import com.fms2.fms2.receivableAndPayable.page.AccountPayablePage;
import com.fms2.fms2.receivableAndPayable.service.AccountPayableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("accountPayable")
public class AccountPayableController {
    @Autowired
    private AccountPayableService accountPayableService;

    @RequestMapping("/getAccountsPayable")
    @ResponseBody
    public ReturnJSONObject getAccountsPayable(
            AccountPayablePage page, ReturnJSONPageObject returnJSON) {
        try {
            returnJSON.setData(accountPayableService.getAccountsPayable(page));
            returnJSON.setTotalRows(accountPayableService.getRows(page));
            returnJSON.setSuccess(true);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/addAccountPayable")
    @ResponseBody
    public ReturnJSONObject addAccountPayable(
            AccountPayable accountPayable, ReturnJSONObject returnJSON) {
        try {
            if(accountPayableService.addAccountPayable(accountPayable)){
                returnJSON.setSuccess(true);
                returnJSON.setData("添加成功，棒棒的~~");
            }else {
                returnJSON.setData("添加失败了，我也不知道咋回事儿，可以等会儿再试试");
            }
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/updateAccountPayable")
    @ResponseBody
    public ReturnJSONObject updateAccountPayable(
            AccountPayable accountPayable, ReturnJSONObject returnJSON) {
        try {
            if(accountPayableService.updateAccountPayable(accountPayable)){
                returnJSON.setSuccess(true);
                returnJSON.setData("更新成功，棒棒的~~");
            }else {
                returnJSON.setData("更新失败了，我也不知道咋回事儿，可以等会儿再试试");
            }
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/deleteAccountPayable")
    @ResponseBody
    public ReturnJSONObject deleteAccountPayable(
            AccountPayable accountPayable, ReturnJSONObject returnJSON) {
        try {
            if(accountPayableService.deleteAccountPayable(accountPayable)){
                returnJSON.setSuccess(true);
                returnJSON.setData("删除成功，棒棒的~~");
            }else {
                returnJSON.setData("删除失败了，我也不知道咋回事儿，可以等会儿再试试");
            }
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("getAllAccountsPayable")
    @ResponseBody
    public ReturnJSONObject getAllAccountsPayable(
            AccountPayable accountPayable, ReturnJSONPageObject returnJSON) {
        try {
            returnJSON.setData(accountPayableService.getAllAccountsPayable(accountPayable));
            returnJSON.setSuccess(true);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("getAllAccountsPayableStatistics")
    @ResponseBody
    public ReturnJSONPageObject getAllAccountsPayableStatistics(
            AccountPayablePage page, ReturnJSONPageObject returnJSON){
        try {
            List<AccountPayable> returnList = new ArrayList<>();
            AccountPayable listHeader = new AccountPayable();
            listHeader.setSupplier("统计结果如下：");
            returnList.add(listHeader);
            List<AccountPayable> accountsPayable
                    = accountPayableService.getAllAccountsPayableStatistics(page);

            double totalAmountOfThisPurchase = 0;

            for (AccountPayable accountPayable : accountsPayable) {

                totalAmountOfThisPurchase += accountPayable.getAmountOfThisPurchase();

                returnList.add(accountPayable);
            }

            AccountPayable listEnd = new AccountPayable();
            listEnd.setSupplier("总计:");
            listEnd.setAmountOfThisPurchase(totalAmountOfThisPurchase);
            returnList.add(listEnd);

            returnJSON.setData(returnList);
            returnJSON.setSuccess(true);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }
}
