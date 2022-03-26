package com.fms2.fms2.inboundDetails.controller;

import com.fms2.fms2.inboundDetails.domain.InboundDetails;
import com.fms2.fms2.inboundDetails.page.InboundDetailsPage;
import com.fms2.fms2.inboundDetails.service.InboundDetailsService;
import com.fms2.fms2.json.ReturnJSONObject;
import com.fms2.fms2.json.ReturnJSONPageObject;
import com.fms2.fms2.product.service.ProductService;
import com.fms2.fms2.util.ExcelToDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/inboundDetails")
public class InboundDetailsController {
    @Autowired
    private InboundDetailsService inboundDetailsService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/getInboundDetails")
    @ResponseBody
    public ReturnJSONObject getInboundDetails(
            InboundDetailsPage page, ReturnJSONPageObject returnJSON) {
        try {
            returnJSON.setData(inboundDetailsService.getInboundDetails(page));
            returnJSON.setTotalRows(inboundDetailsService.getRows(page));
            returnJSON.setSuccess(true);
//            ExcelToDB.getInboundsDetailFromExcel(inboundDetailsService);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/addInboundDetails")
    @ResponseBody
    public ReturnJSONObject addInboundDetails(
            InboundDetails inboundDetails, ReturnJSONObject returnJSON) {
        try {
            double oneProductWeight = productService.getProductWeight(inboundDetails.getProductID());
            double unitPrice = inboundDetails.getUnitPrice();
            int inboundQuantity = inboundDetails.getInboundQuantity();
            double amountOfThisPurchase = oneProductWeight * unitPrice * inboundQuantity;
            double actualPayment = amountOfThisPurchase + inboundDetails.getPurchaseFee();

            inboundDetails.setAmountOfThisPurchase(amountOfThisPurchase);
            inboundDetails.setActualPayment(actualPayment);
            if(inboundDetailsService.addInboundDetails(inboundDetails)){
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

    @RequestMapping("/updateInboundDetails")
    @ResponseBody
    public ReturnJSONObject updateInboundDetails(
            InboundDetails inboundDetails, ReturnJSONObject returnJSON) {
        try {
            double oneProductWeight = productService.getProductWeight(inboundDetails.getProductID());
            double unitPrice = inboundDetails.getUnitPrice();
            int inboundQuantity = inboundDetails.getInboundQuantity();
            double amountOfThisPurchase = oneProductWeight * unitPrice * inboundQuantity;
            double actualPayment = amountOfThisPurchase + inboundDetails.getPurchaseFee();

            inboundDetails.setAmountOfThisPurchase(amountOfThisPurchase);
            inboundDetails.setActualPayment(actualPayment);
            if(inboundDetailsService.updateInboundDetails(inboundDetails)){
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

    @RequestMapping("/deleteInboundDetails")
    @ResponseBody
    public ReturnJSONObject deleteInboundDetails(
            InboundDetails inboundDetails, ReturnJSONObject returnJSON) {
        try {
            if(inboundDetailsService.deleteInboundDetails(inboundDetails)){
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

    @RequestMapping("/generateInvoice")
    public void getInboundsDetailFromExcel(InboundDetailsPage page, HttpServletResponse response) {
        try {

            List<InboundDetails> allInboundDetails = inboundDetailsService.getAllInboundDetails(page);
            ExcelToDB.generateInvoice(allInboundDetails,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
