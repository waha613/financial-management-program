package com.fms2.fms2.receivableAndPayable.controller;

import com.fms2.fms2.json.ReturnJSONObject;
import com.fms2.fms2.json.ReturnJSONPageObject;
import com.fms2.fms2.receivableAndPayable.domain.AccountReceivable;
import com.fms2.fms2.receivableAndPayable.page.AccountReceivablePage;
import com.fms2.fms2.receivableAndPayable.service.AccountReceivableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("accountReceivable")
public class AccountReceivableController {
    @Autowired
    private AccountReceivableService accountReceivableService;

    @RequestMapping("/getAccountsReceivable")
    @ResponseBody
    public ReturnJSONObject getAccountsReceivable(
            AccountReceivablePage page, ReturnJSONPageObject returnJSON) {
        try {
            returnJSON.setData(accountReceivableService.getAccountsReceivable(page));
            returnJSON.setTotalRows(accountReceivableService.getRows(page));
            returnJSON.setSuccess(true);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/addAccountReceivable")
    @ResponseBody
    public ReturnJSONObject addAccountReceivable(
            AccountReceivable accountReceivable, ReturnJSONObject returnJSON) {
        try {
            if(accountReceivableService.addAccountReceivable(accountReceivable)){
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

    @RequestMapping("/updateAccountReceivable")
    @ResponseBody
    public ReturnJSONObject updateAccountPayable(
            AccountReceivable accountReceivable, ReturnJSONObject returnJSON) {
        try {
            if(accountReceivableService.updateAccountReceivable(accountReceivable)){
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

    @RequestMapping("/deleteAccountReceivable")
    @ResponseBody
    public ReturnJSONObject deleteAccountPayable(
            AccountReceivable accountReceivable, ReturnJSONObject returnJSON) {
        try {
            if(accountReceivableService.deleteAccountReceivable(accountReceivable)){
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

    @RequestMapping("getAllAccountsReceivable")
    @ResponseBody
    public ReturnJSONObject getAllAccountsReceivable(
            AccountReceivable accountReceivable, ReturnJSONPageObject returnJSON) {
        try {
            returnJSON.setData(accountReceivableService.getAllAccountsReceivable(accountReceivable));
            returnJSON.setSuccess(true);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }
    @RequestMapping("getAllAccountsReceivableStatistics")
    @ResponseBody
    public ReturnJSONPageObject getAllAccountsReceivableStatistics(
            AccountReceivablePage page, ReturnJSONPageObject returnJSON){
        try {
            List<AccountReceivable> returnList = new ArrayList<>();
            AccountReceivable listHeader = new AccountReceivable();
            listHeader.setWarehouse("统计结果如下：");
            listHeader.setActualSales(null);
            returnList.add(listHeader);
            List<AccountReceivable> accountsReceivable
                    = accountReceivableService.getAllAccountsReceivableStatistics(page);

            double totalActualSales = 0;

            for (AccountReceivable accountReceivable : accountsReceivable) {

                totalActualSales += accountReceivable.getActualSales();

                returnList.add(accountReceivable);
            }

            AccountReceivable listEnd = new AccountReceivable();
            listEnd.setWarehouse("总计:");
            listEnd.setActualSales(totalActualSales);
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
