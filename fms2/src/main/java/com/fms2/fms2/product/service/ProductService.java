package com.fms2.fms2.product.service;

import com.fms2.fms2.product.domain.Product;
import com.fms2.fms2.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductMapper productMapper;

    public List<Product> getProducts(Product product){
        return productMapper.getProducts(product);
    }

    public Integer getRows(Product product){
        return productMapper.getRows(product);
    }

    public boolean addProduct(Product Product){
        return productMapper.addProduct(Product) == 1;
    }

    public boolean contains(Product product){return productMapper.contains(product) == 1;}
    public boolean updateProduct(Product Product){
        return productMapper.updateProduct(Product) == 1;
    }

    public boolean deleteProduct(Product Product){
        return productMapper.deleteProduct(Product) == 1;
    }
    public Double getProductWeight(String productID){
        return productMapper.getProductWeight(productID);
    }
}
