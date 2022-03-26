package com.fms2.fms2.product.mapper;

import com.fms2.fms2.product.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getProducts(Product product);
    int getRows(Product product);

    int addProduct(Product product);
    int contains(Product product);
    int updateProduct(Product product);
    int deleteProduct(Product product);

    Double getProductWeight(String productID);
}
