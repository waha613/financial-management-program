package com.fms2.fms2.inventoryStatistics.controller;

import com.fms2.fms2.json.ReturnJSONPageObject;
import com.fms2.fms2.inventoryStatistics.domain.InboundDetailStatistics;
import com.fms2.fms2.inventoryStatistics.service.InboundDetailStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("inboundDetailStatistics")
public class InboundDetailStatisticsController {
    @Autowired
    private InboundDetailStatisticsService inboundDetailStatisticsService;

    @RequestMapping("getAllInboundDetailStatistics")
    @ResponseBody
    public ReturnJSONPageObject getAllInboundDetailStatistics(
            InboundDetailStatistics statistics,ReturnJSONPageObject returnJSON){

        try {
            List<InboundDetailStatistics> returnList = new ArrayList<>();
            InboundDetailStatistics listHeader = new InboundDetailStatistics();
            listHeader.setSupplier("统计结果如下：");
            returnList.add(listHeader);
            List<InboundDetailStatistics> inboundDetailStatistics
                    = inboundDetailStatisticsService.getAllInboundDetailStatistics(statistics);
            int totalInboundQuantity = 0;
            double totalAmountOfThisPurchase = 0;
            double totalPurchaseFee = 0;
            double totalActualPayment = 0;

            for (InboundDetailStatistics inboundDetailStatistic : inboundDetailStatistics) {
                totalInboundQuantity += inboundDetailStatistic.getInboundQuantity();
                totalAmountOfThisPurchase += inboundDetailStatistic.getAmountOfThisPurchase();
                totalPurchaseFee += inboundDetailStatistic.getPurchaseFee();
                totalActualPayment += inboundDetailStatistic.getActualPayment();
                returnList.add(inboundDetailStatistic);
            }

            InboundDetailStatistics listEnd = new InboundDetailStatistics();
            listEnd.setSupplier("总计:");
            listEnd.setInboundQuantity(totalInboundQuantity);
            listEnd.setAmountOfThisPurchase(totalAmountOfThisPurchase);
            listEnd.setPurchaseFee(totalPurchaseFee);
            listEnd.setActualPayment(totalActualPayment);
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
