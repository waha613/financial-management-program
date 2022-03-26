package com.fms2.fms2.outboundDetails.mapper;

import com.fms2.fms2.outboundDetails.domain.OutboundDetail;
import com.fms2.fms2.outboundDetails.page.OutboundDetailPage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface OutboundDetailMapper {
    List<OutboundDetail> getOutboundDetails(OutboundDetailPage page);
    int getRows(OutboundDetailPage page);

    int addOutboundDetail(OutboundDetail outboundDetail);
    int updateOutboundDetail(OutboundDetail outboundDetail);
    int deleteOutboundDetail(OutboundDetail outboundDetail);

    List<OutboundDetail> getAllOutboundDetailStatistics(OutboundDetailPage page);
}
