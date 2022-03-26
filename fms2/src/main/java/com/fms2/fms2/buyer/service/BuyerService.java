package com.fms2.fms2.buyer.service;

import com.fms2.fms2.buyer.domain.Buyer;
import com.fms2.fms2.buyer.mapper.BuyerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {
    @Autowired
    public BuyerMapper buyerMapper;

    public List<Buyer> getBuyers(Buyer buyer) {
        return buyerMapper.getBuyers(buyer);
    }

    public Integer getRows(Buyer buyer) {
        return buyerMapper.getRows(buyer);
    }

    public List<String> getBuyerNameList() {
        return buyerMapper.getBuyerNameList();
    }

    public List<String> getBuyerNameListForCombo(Buyer buyer) {
        return buyerMapper.getBuyerNameListForCombo(buyer);
    }

    public boolean addBuyer(Buyer buyer) {
        return buyerMapper.addBuyer(buyer) == 1;
    }

    public boolean contains(Buyer buyer) {
        return buyerMapper.contains(buyer) == 1;
    }

    public boolean updateBuyer(Buyer buyer) {
        return buyerMapper.updateBuyer(buyer) == 1;
    }

    public boolean deleteBuyer(Buyer buyer) {
        return buyerMapper.deleteBuyer(buyer) == 1;
    }
}
