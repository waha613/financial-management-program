package com.fms2.fms2.product.controller;

import com.fms2.fms2.json.ReturnJSONObject;
import com.fms2.fms2.json.ReturnJSONPageObject;
import com.fms2.fms2.product.domain.Product;
import com.fms2.fms2.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/getProducts")
    @ResponseBody
    public ReturnJSONObject getProducts(
            Product product, ReturnJSONPageObject returnJSON) {
        try {
            returnJSON.setData(productService.getProducts(product));
            returnJSON.setTotalRows(productService.getRows(product));
            returnJSON.setSuccess(true);
        } catch (Exception e) {
            returnJSON.setData("系统不好使了，快联系我:)");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }

    @RequestMapping("/addProduct")
    @ResponseBody
    public ReturnJSONObject addInboundDetails(
            Product product, ReturnJSONObject returnJSON) {
        try {
            if(productService.contains(product)) {
                returnJSON.setData("产品编号重复！");
            } else if (productService.addProduct(product)){
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

    @RequestMapping("/updateProduct")
    @ResponseBody
    public ReturnJSONObject updateInboundDetails(
            Product product, ReturnJSONObject returnJSON) {
        try {
            if(productService.updateProduct(product)){
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

    @RequestMapping("/deleteProduct")
    @ResponseBody
    public ReturnJSONObject deleteInboundDetails(
            Product product, ReturnJSONObject returnJSON) {
        try {
            if(productService.deleteProduct(product)){
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
