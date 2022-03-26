package com.fms2.fms2.supplier.service;

import com.fms2.fms2.supplier.domain.Supplier;
import com.fms2.fms2.supplier.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    public SupplierMapper supplierMapper;

    public List<Supplier> getSuppliers(){
        return supplierMapper.getSuppliers();
    }

    public Integer getRows(Supplier supplier){
        return supplierMapper.getRows(supplier);
    }

    public boolean addSupplier(Supplier supplier){
        return supplierMapper.addSupplier(supplier) == 1;
    }

    public boolean contains(Supplier supplier){return supplierMapper.contains(supplier) == 1;}

    public boolean updateSupplier(Supplier supplier){
        return supplierMapper.updateSupplier(supplier) == 1;
    }

    public boolean deleteSupplier(Supplier supplier){
        return supplierMapper.deleteSupplier(supplier) == 1;
    }
}
