package com.fms2.fms2.receivableAndPayable.controller;

import com.fms2.fms2.buyer.domain.Buyer;
import com.fms2.fms2.buyer.service.BuyerService;
import com.fms2.fms2.json.ReturnJSONObject;
import com.fms2.fms2.outboundDetails.domain.OutboundDetail;
import com.fms2.fms2.outboundDetails.page.OutboundDetailPage;
import com.fms2.fms2.outboundDetails.service.OutboundDetailService;
import com.fms2.fms2.receivableAndPayable.domain.AccountPayable;
import com.fms2.fms2.receivableAndPayable.domain.AccountReceivable;
import com.fms2.fms2.receivableAndPayable.domain.PayableStatistics;
import com.fms2.fms2.receivableAndPayable.domain.ReceivableStatistics;
import com.fms2.fms2.receivableAndPayable.page.AccountPayablePage;
import com.fms2.fms2.receivableAndPayable.page.AccountReceivablePage;
import com.fms2.fms2.receivableAndPayable.service.AccountPayableService;
import com.fms2.fms2.receivableAndPayable.service.AccountReceivableService;
import com.fms2.fms2.inventoryStatistics.domain.InboundDetailStatistics;
import com.fms2.fms2.inventoryStatistics.service.InboundDetailStatisticsService;
import com.fms2.fms2.supplier.domain.Supplier;
import com.fms2.fms2.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("receivableAndPayableStatistics")
public class ReceivableAndPayableStatisticsController {
    @Autowired
    private InboundDetailStatisticsService inboundService;

    @Autowired
    private OutboundDetailService outboundDetailService;

    @Autowired
    private AccountPayableService accountPayableService;

    @Autowired
    private AccountReceivableService accountReceivableService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private BuyerService buyerService;

    @RequestMapping("getPayableStatistics")
    @ResponseBody
    private ReturnJSONObject getPayableStatistic(PayableStatistics payableStatistics,ReturnJSONObject returnJSON) {
        try {
            String startDate = payableStatistics.getStartDate();
            String endDate = payableStatistics.getEndDate();
            String supplier = payableStatistics.getSupplier();
            double totalPurchaseAmount = 0;
            double totalActualPayment = 0;
            double totalBalance = 0;
            List<PayableStatistics> payableStatisticsList = new ArrayList<>();
            if(supplier == null || supplier.trim().equals("")){
                List<Supplier> suppliers = supplierService.getSuppliers();
                for (Supplier supplierO : suppliers) {
                    PayableStatistics temp = new PayableStatistics();
                    supplier = supplierO.getSupplierID();
                    //通过入库记录，获得时间段内，总进货金额
                    InboundDetailStatistics inboundDetailsStatistic = new InboundDetailStatistics();
                    inboundDetailsStatistic.setInboundStartDate(startDate);
                    inboundDetailsStatistic.setInboundEndDate(endDate);
                    inboundDetailsStatistic.setSupplier(supplier);
                    List<InboundDetailStatistics> allInboundDetailStatistics =
                            inboundService.getAllInboundDetailStatistics(inboundDetailsStatistic);
                    double purchaseAmount = 0;
                    if(!allInboundDetailStatistics.isEmpty()){
                        inboundDetailsStatistic = allInboundDetailStatistics.get(0);
                        purchaseAmount = inboundDetailsStatistic.getAmountOfThisPurchase();
                    }

                    //通过支付记录，获得时间段内的实际支付金额
                    AccountPayablePage accountPayablePage = new AccountPayablePage();
                    accountPayablePage.setPayStartDate(startDate);
                    accountPayablePage.setPayEndDate(endDate);
                    accountPayablePage.setSupplier(supplier);
                    List<AccountPayable> allAccountsPayableStatistics =
                            accountPayableService.getAllAccountsPayableStatistics(accountPayablePage);
                    double actualPayment = 0;
                    if(!allAccountsPayableStatistics.isEmpty()){
                        AccountPayable accountPayable = allAccountsPayableStatistics.get(0);
                        actualPayment = accountPayable.getAmountOfThisPurchase();
                    }

                    double balance = purchaseAmount - actualPayment;
                    totalPurchaseAmount += purchaseAmount;
                    totalActualPayment += actualPayment;
                    totalBalance += balance;

                    temp.setSupplier(supplier);
                    temp.setStartDate(startDate);
                    temp.setEndDate(endDate);
                    temp.setPurchaseAmount(purchaseAmount);
                    temp.setActualPayment(actualPayment);
                    temp.setBalance(balance);
                    payableStatisticsList.add(temp);
                }

                PayableStatistics temp = new PayableStatistics();
                temp.setSupplier("总计：");
                temp.setStartDate(startDate);
                temp.setEndDate(endDate);
                temp.setPurchaseAmount(totalPurchaseAmount);
                temp.setActualPayment(totalActualPayment);
                temp.setBalance(totalBalance);
                payableStatisticsList.add(temp);
            }else {
                PayableStatistics temp = new PayableStatistics();
                //通过入库记录，获得时间段内，总进货金额
                InboundDetailStatistics inboundDetailsStatistic = new InboundDetailStatistics();
                inboundDetailsStatistic.setInboundStartDate(startDate);
                inboundDetailsStatistic.setInboundEndDate(endDate);
                inboundDetailsStatistic.setSupplier(supplier);
                List<InboundDetailStatistics> allInboundDetailStatistics =
                        inboundService.getAllInboundDetailStatistics(inboundDetailsStatistic);
                double purchaseAmount = 0;
                if(!allInboundDetailStatistics.isEmpty()){
                    inboundDetailsStatistic = allInboundDetailStatistics.get(0);
                    purchaseAmount = inboundDetailsStatistic.getAmountOfThisPurchase();
                }

                //通过支付记录，获得时间段内的实际支付金额
                AccountPayablePage accountPayablePage = new AccountPayablePage();
                accountPayablePage.setPayStartDate(startDate);
                accountPayablePage.setPayEndDate(endDate);
                accountPayablePage.setSupplier(supplier);
                List<AccountPayable> allAccountsPayableStatistics =
                        accountPayableService.getAllAccountsPayableStatistics(accountPayablePage);
                double actualPayment = 0;
                if(!allAccountsPayableStatistics.isEmpty()){
                    AccountPayable accountPayable = allAccountsPayableStatistics.get(0);
                    actualPayment = accountPayable.getAmountOfThisPurchase();
                }

                double balance = purchaseAmount - actualPayment;
                temp.setSupplier(supplier);
                temp.setStartDate(startDate);
                temp.setEndDate(endDate);
                temp.setPurchaseAmount(purchaseAmount);
                temp.setActualPayment(actualPayment);
                temp.setBalance(balance);
                payableStatisticsList.add(temp);
            }

            returnJSON.setSuccess(true);
            returnJSON.setData(payableStatisticsList);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("getReceivableStatistics")
    @ResponseBody
    private ReturnJSONObject getReceivableStatistics(ReceivableStatistics receivableStatistics, ReturnJSONObject returnJSON) {
        try {
            String startDate = receivableStatistics.getStartDate();
            String endDate = receivableStatistics.getEndDate();
            String warehouse = receivableStatistics.getWarehouse();
            double totalActualSales = 0;
            double totalActualReceive = 0;
            double totalBalance = 0;
            List<ReceivableStatistics> receivableStatisticsList = new ArrayList<>();
            if(warehouse == null || warehouse.trim().equals("")){
                List<String> buyerNameList = buyerService.getBuyerNameList();
                for (String buyerName : buyerNameList) {
                    double totalActualSalesForBuyer = 0;
                    double totalActualReceiveForBuyer = 0;
                    double totalBalanceForBuyer = 0;
                    Buyer buyer = new Buyer();
                    buyer.setBuyerName(buyerName);
                    List<Buyer> buyers = buyerService.getBuyers(buyer);

                    for (Buyer buyerO : buyers) {
                        ReceivableStatistics temp = new ReceivableStatistics();
                        warehouse = buyerO.getWarehouse();
                        //通过出库记录，获得时间段内，总售货金额
                        OutboundDetailPage outboundDetailpage = new OutboundDetailPage();
                        OutboundDetail outboundDetail = new OutboundDetail();
                        outboundDetailpage.setOutboundStartDate(startDate);
                        outboundDetailpage.setOutboundEndDate(endDate);
                        outboundDetailpage.setWarehouse(warehouse);
                        List<OutboundDetail> allOutboundDetailStatistics
                                = outboundDetailService.getAllOutboundDetailStatistics(outboundDetailpage);

                        double actualSales = 0;
                        if(!allOutboundDetailStatistics .isEmpty()){
                            outboundDetail = allOutboundDetailStatistics .get(0);
                            actualSales = outboundDetail.getActualSales();
                        }

                        //通过收款记录，获得时间段内的实际收款金额
                        AccountReceivablePage accountReceivablePage = new AccountReceivablePage();
                        accountReceivablePage.setReceiveStartDate(startDate);
                        accountReceivablePage.setReceiveEndDate(endDate);
                        accountReceivablePage.setWarehouse(warehouse);
                        List<AccountReceivable> allAccountsReceivableStatistics =
                                accountReceivableService.getAllAccountsReceivableStatistics(accountReceivablePage);
                        double actualReceive = 0;
                        if(!allAccountsReceivableStatistics.isEmpty()){
                            AccountReceivable accountReceivable = allAccountsReceivableStatistics.get(0);
                            actualReceive = accountReceivable.getActualSales();
                        }

                        double balance = actualSales - actualReceive;
                        totalActualSalesForBuyer += actualSales;
                        totalActualReceiveForBuyer += actualReceive;
                        totalBalanceForBuyer += balance;

                        temp.setWarehouse(warehouse);
                        temp.setStartDate(startDate);
                        temp.setEndDate(endDate);
                        temp.setActualSales(actualSales);
                        temp.setActualReceive(actualReceive);
                        temp.setBalance(balance);
                        receivableStatisticsList.add(temp);
                    }

                    ReceivableStatistics temp = new ReceivableStatistics();
                    temp.setWarehouse(buyerName + "  总计：");
                    temp.setStartDate(startDate);
                    temp.setEndDate(endDate);
                    temp.setActualSales(totalActualSalesForBuyer);
                    temp.setActualReceive(totalActualReceiveForBuyer);
                    temp.setBalance(totalBalanceForBuyer);
                    receivableStatisticsList.add(temp);

                    ReceivableStatistics temp1 = new ReceivableStatistics();
                    temp1.setWarehouse("=============");
                    temp1.setStartDate(null);
                    temp1.setEndDate(null);
                    temp1.setActualSales(null);
                    temp1.setActualReceive(null);
                    temp1.setBalance(null);
                    receivableStatisticsList.add(temp1);

                    totalActualSales += totalActualSalesForBuyer;
                    totalActualReceive += totalActualReceiveForBuyer;
                    totalBalance += totalBalanceForBuyer;
                }
                ReceivableStatistics temp = new ReceivableStatistics();
                temp.setWarehouse("总计全部采购商：");
                temp.setStartDate(startDate);
                temp.setEndDate(endDate);
                temp.setActualSales(totalActualSales);
                temp.setActualReceive(totalActualReceive);
                temp.setBalance(totalBalance);
                receivableStatisticsList.add(temp);

            }else {
                ReceivableStatistics temp = new ReceivableStatistics();
                //通过出库记录，获得时间段内，总售货金额
                OutboundDetailPage outboundDetailpage = new OutboundDetailPage();
                OutboundDetail outboundDetail = new OutboundDetail();
                outboundDetailpage.setOutboundStartDate(startDate);
                outboundDetailpage.setOutboundEndDate(endDate);
                outboundDetailpage.setWarehouse(warehouse);
                List<OutboundDetail> allOutboundDetailStatistics
                        = outboundDetailService.getAllOutboundDetailStatistics(outboundDetailpage);

                double actualSales = 0;
                if(!allOutboundDetailStatistics .isEmpty()){
                    outboundDetail = allOutboundDetailStatistics .get(0);
                    actualSales = outboundDetail.getActualSales();
                }

                //通过收款记录，获得时间段内的实际收款金额
                AccountReceivablePage accountReceivablePage = new AccountReceivablePage();
                accountReceivablePage.setReceiveStartDate(startDate);
                accountReceivablePage.setReceiveEndDate(endDate);
                accountReceivablePage.setWarehouse(warehouse);
                List<AccountReceivable> allAccountsReceivableStatistics =
                        accountReceivableService.getAllAccountsReceivableStatistics(accountReceivablePage);
                double actualReceive = 0;
                if(!allAccountsReceivableStatistics.isEmpty()){
                    AccountReceivable accountReceivable = allAccountsReceivableStatistics.get(0);
                    actualReceive = accountReceivable.getActualSales();
                }

                double balance = actualSales - actualReceive;
                totalActualSales += actualSales;
                totalActualReceive += actualReceive;
                totalBalance += balance;

                temp.setWarehouse(warehouse);
                temp.setStartDate(startDate);
                temp.setEndDate(endDate);
                temp.setActualSales(actualSales);
                temp.setActualReceive(actualReceive);
                temp.setBalance(balance);
                receivableStatisticsList.add(temp);

                ReceivableStatistics temp1 = new ReceivableStatistics();
                temp1.setWarehouse("总计：");
                temp1.setStartDate(startDate);
                temp1.setEndDate(endDate);
                temp1.setActualSales(totalActualSales);
                temp1.setActualReceive(totalActualReceive);
                temp1.setBalance(totalBalance);
                receivableStatisticsList.add(temp1);
            }

            returnJSON.setSuccess(true);
            returnJSON.setData(receivableStatisticsList);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }
}
