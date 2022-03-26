package com.fms2.fms2.buyer.mapper;

import com.fms2.fms2.buyer.domain.Buyer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyerMapper {
    List<Buyer> getBuyers(Buyer buyer);
    int getRows(Buyer buyer);

    List<String> getBuyerNameList();
    int addBuyer(Buyer buyer);
    int contains(Buyer buyer);
    int updateBuyer(Buyer buyer);
    int deleteBuyer(Buyer buyer);

    List<String> getBuyerNameListForCombo(Buyer buyer);
}
