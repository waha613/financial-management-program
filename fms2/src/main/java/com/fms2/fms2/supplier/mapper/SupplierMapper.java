package com.fms2.fms2.supplier.mapper;

import com.fms2.fms2.supplier.domain.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface SupplierMapper {
    List<Supplier> getSuppliers();
    int getRows(Supplier supplier);

    int addSupplier(Supplier supplier);
    int contains(Supplier supplier);
    int updateSupplier(Supplier supplier);
    int deleteSupplier(Supplier supplier);
}
