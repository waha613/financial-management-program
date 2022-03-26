package com.fms2.fms2.supplier.controller;

import com.fms2.fms2.json.ReturnJSONObject;
import com.fms2.fms2.json.ReturnJSONPageObject;
import com.fms2.fms2.supplier.domain.Supplier;
import com.fms2.fms2.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/getSuppliers")
    @ResponseBody
    public ReturnJSONObject getSuppliers(
            Supplier supplier, ReturnJSONPageObject returnJSON) {
        try {
            returnJSON.setData(supplierService.getSuppliers());
            returnJSON.setTotalRows(supplierService.getRows(supplier));
            returnJSON.setSuccess(true);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/addSupplier")
    @ResponseBody
    public ReturnJSONObject addSupplier(
            Supplier supplier, ReturnJSONObject returnJSON) {
        try {
            if (supplierService.contains(supplier)){
                returnJSON.setData("供应商名称重复！");
            } else if(supplierService.addSupplier(supplier)){
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

    @RequestMapping("/updateSupplier")
    @ResponseBody
    public ReturnJSONObject updateSupplier(
            Supplier supplier, ReturnJSONObject returnJSON) {
        try {
            if(supplierService.updateSupplier(supplier)){
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

    @RequestMapping("/deleteSupplier")
    @ResponseBody
    public ReturnJSONObject deleteSupplier(
            Supplier supplier, ReturnJSONObject returnJSON) {
        try {
            if(supplierService.deleteSupplier(supplier)){
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
