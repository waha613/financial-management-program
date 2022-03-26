package com.fms2.fms2.outboundDetails.service;

import com.fms2.fms2.outboundDetails.domain.OutboundDetail;
import com.fms2.fms2.outboundDetails.mapper.OutboundDetailMapper;
import com.fms2.fms2.outboundDetails.page.OutboundDetailPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutboundDetailService {
    @Autowired
    public OutboundDetailMapper outboundDetailMapper;

    public List<OutboundDetail> getOutboundDetails(OutboundDetailPage page){
        return outboundDetailMapper.getOutboundDetails(page);
    }

    public Integer getRows(OutboundDetailPage page){
        return outboundDetailMapper.getRows(page);
    }

    public boolean addOutboundDetail(OutboundDetail outboundDetail){
        return outboundDetailMapper.addOutboundDetail(outboundDetail) == 1;
    }

    public boolean updateOutboundDetail(OutboundDetail outboundDetail){
        return outboundDetailMapper.updateOutboundDetail(outboundDetail) == 1;
    }

    public boolean deleteOutboundDetail(OutboundDetail outboundDetail){
        return outboundDetailMapper.deleteOutboundDetail(outboundDetail) == 1;
    }

    public List<OutboundDetail> getAllOutboundDetailStatistics(OutboundDetailPage page){
        return outboundDetailMapper.getAllOutboundDetailStatistics(page);
    }
}
