package com.fms2.fms2.buyer.controller;

import com.fms2.fms2.buyer.domain.Buyer;
import com.fms2.fms2.buyer.service.BuyerService;
import com.fms2.fms2.json.ReturnJSONObject;
import com.fms2.fms2.json.ReturnJSONPageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("buyer")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @RequestMapping("/getBuyers")
    @ResponseBody
    public ReturnJSONObject getBuyers(
            Buyer buyer, ReturnJSONPageObject returnJSON) {
        try {
            returnJSON.setData(buyerService.getBuyers(buyer));
            returnJSON.setTotalRows(buyerService.getRows(buyer));
            returnJSON.setSuccess(true);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/getBuyerNameList")
    @ResponseBody
    public ReturnJSONObject getBuyerNameList(
            Buyer buyer, ReturnJSONPageObject returnJSON) {
        try {
            returnJSON.setData(buyerService.getBuyerNameList());
            returnJSON.setSuccess(true);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/getBuyerNameListForCombo")
    @ResponseBody
    public ReturnJSONObject getgetBuyerNameListForCombo(
            Buyer buyer, ReturnJSONPageObject returnJSON) {
        try {
            returnJSON.setData(buyerService.getBuyerNameListForCombo(buyer));
            returnJSON.setSuccess(true);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/addBuyer")
    @ResponseBody
    public ReturnJSONObject addBuyer(
            Buyer buyer, ReturnJSONObject returnJSON) {
        try {
            if(buyerService.contains(buyer) ){
                returnJSON.setData("供应商信息重复！");
            }else if (buyerService.addBuyer(buyer) ){
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

    @RequestMapping("/updateBuyer")
    @ResponseBody
    public ReturnJSONObject updateBuyer(
            Buyer buyer, ReturnJSONObject returnJSON) {
        try {
            if(buyerService.updateBuyer(buyer)){
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

    @RequestMapping("/deleteBuyer")
    @ResponseBody
    public ReturnJSONObject deleteBuyer(
            Buyer buyer, ReturnJSONObject returnJSON) {
        try {
            if(buyerService.deleteBuyer(buyer)){
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
}
