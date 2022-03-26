package com.fms2.fms2.outboundDetails.controller;

import com.fms2.fms2.json.ReturnJSONObject;
import com.fms2.fms2.json.ReturnJSONPageObject;
import com.fms2.fms2.outboundDetails.domain.OutboundDetail;
import com.fms2.fms2.outboundDetails.page.OutboundDetailPage;
import com.fms2.fms2.outboundDetails.service.OutboundDetailService;
import com.fms2.fms2.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("outboundDetail")
public class OutboundDetailController {
    @Autowired
    private OutboundDetailService outboundDetailsService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/getOutboundDetails")
    @ResponseBody
    public ReturnJSONPageObject getOutboundDetails(
            OutboundDetailPage page, ReturnJSONPageObject returnJSON) {
        try {
            returnJSON.setData(outboundDetailsService.getOutboundDetails(page));
            returnJSON.setTotalRows(outboundDetailsService.getRows(page));
            returnJSON.setSuccess(true);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/addOutboundDetail")
    @ResponseBody
    public ReturnJSONObject addOutboundDetail(
            OutboundDetail outboundDetail, ReturnJSONObject returnJSON) {
        try {
            double oneProductWeight = productService.getProductWeight(outboundDetail.getProductID());
            double unitSalePrice = outboundDetail.getUnitSalePrice();
            int outboundQuantity = outboundDetail.getOutboundQuantity();
            double amountOfThisSale = oneProductWeight * unitSalePrice * outboundQuantity;
            double actualSales = amountOfThisSale - outboundDetail.getSaleFee();

            outboundDetail.setAmountOfThisSale(amountOfThisSale);
            outboundDetail.setActualSales(actualSales);
            if (outboundDetailsService.addOutboundDetail(outboundDetail)) {
                returnJSON.setSuccess(true);
                returnJSON.setData("添加成功，棒棒的~~");
            } else {
                returnJSON.setData("添加失败了，我也不知道咋回事儿，可以等会儿再试试");
            }
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/updateOutboundDetail")
    @ResponseBody
    public ReturnJSONObject updateOutboundDetail(
            OutboundDetail outboundDetail, ReturnJSONObject returnJSON) {
        try {

            double oneProductWeight = productService.getProductWeight(outboundDetail.getProductID());
            double unitSalePrice = outboundDetail.getUnitSalePrice();
            int outboundQuantity = outboundDetail.getOutboundQuantity();
            double amountOfThisSale = oneProductWeight * unitSalePrice * outboundQuantity;
            double actualSales = amountOfThisSale - outboundDetail.getSaleFee();

            outboundDetail.setAmountOfThisSale(amountOfThisSale);
            outboundDetail.setActualSales(actualSales);
            if (outboundDetailsService.updateOutboundDetail(outboundDetail)) {
                returnJSON.setSuccess(true);
                returnJSON.setData("更新成功，棒棒的~~");
            } else {
                returnJSON.setData("更新失败了，我也不知道咋回事儿，可以等会儿再试试");
            }
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/deleteOutboundDetail")
    @ResponseBody
    public ReturnJSONObject deleteOutboundDetail(
            OutboundDetail outboundDetail, ReturnJSONObject returnJSON) {
        try {
            if (outboundDetailsService.deleteOutboundDetail(outboundDetail)) {
                returnJSON.setSuccess(true);
                returnJSON.setData("删除成功，棒棒的~~");
            } else {
                returnJSON.setData("删除失败了，我也不知道咋回事儿，可以等会儿再试试");
            }
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/getAllOutboundDetailStatistics")
    @ResponseBody
    public ReturnJSONObject getAllOutboundDetailStatistics(
            OutboundDetailPage page, ReturnJSONObject returnJSON) {
        try {
            List<OutboundDetail> returnList = new ArrayList<>();
            OutboundDetail listHeader = new OutboundDetail();
            listHeader.setWarehouse("统计结果如下：");
            returnList.add(listHeader);
            List<OutboundDetail> outboundDetails
                    = outboundDetailsService.getAllOutboundDetailStatistics(page);
            int totalOutboundQuantity = 0;
            double totalAmountOfThisSale = 0;
            double totalSaleFee = 0;
            double totalActualSales = 0;

            for (OutboundDetail outboundDetail : outboundDetails) {
                totalOutboundQuantity += outboundDetail.getOutboundQuantity();
                totalAmountOfThisSale += outboundDetail.getAmountOfThisSale();
                totalSaleFee += outboundDetail.getSaleFee();
                totalActualSales += outboundDetail.getActualSales();
                returnList.add(outboundDetail);
            }

            OutboundDetail listEnd = new OutboundDetail();
            listEnd.setWarehouse("总计:");
            listEnd.setOutboundQuantity(totalOutboundQuantity);
            listEnd.setAmountOfThisSale(totalAmountOfThisSale);
            listEnd.setSaleFee(totalSaleFee);
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
