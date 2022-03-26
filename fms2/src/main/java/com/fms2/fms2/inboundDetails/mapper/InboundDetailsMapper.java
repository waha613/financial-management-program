package com.fms2.fms2.inboundDetails.mapper;

import com.fms2.fms2.inboundDetails.domain.InboundDetails;
import com.fms2.fms2.inboundDetails.page.InboundDetailsPage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface InboundDetailsMapper {
    List<InboundDetails> getInboundDetails(InboundDetailsPage page);
    int getRows(InboundDetailsPage page);

    int addInboundDetails(InboundDetails inboundDetails);
    int updateInboundDetails(InboundDetails inboundDetails);
    int deleteInboundDetails(InboundDetails inboundDetails);

    List<InboundDetails> getAllInboundDetails(InboundDetailsPage page);
}
