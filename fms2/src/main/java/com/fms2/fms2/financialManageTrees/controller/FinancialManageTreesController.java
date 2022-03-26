package com.fms2.fms2.financialManageTrees.controller;

import com.fms2.fms2.financialManageTrees.service.FinancialManageTreesService;
import com.fms2.fms2.json.ReturnTreeJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FinancialManageTreesController {
    @Autowired
    private FinancialManageTreesService treesService;

    @RequestMapping("getFinancialManageTrees")
    @ResponseBody
    public ReturnTreeJSON getFinancialManageTrees(ReturnTreeJSON returnJSON){
        try {
            returnJSON.setChildren(treesService.getFinancialManageTrees());
            returnJSON.setSuccess(true);
        } catch (Exception e) {
            returnJSON.setData("系统异常，请联系管理员");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }
}
