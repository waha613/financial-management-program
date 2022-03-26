package com.fms2.fms2.inboundDetails.service;

import com.fms2.fms2.inboundDetails.domain.InboundDetails;
import com.fms2.fms2.inboundDetails.mapper.InboundDetailsMapper;
import com.fms2.fms2.inboundDetails.page.InboundDetailsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InboundDetailsService {
    @Autowired
    public InboundDetailsMapper inboundDetailsMapper;

    public List<InboundDetails> getInboundDetails(InboundDetailsPage page){
       return inboundDetailsMapper.getInboundDetails(page);
    }

    public Integer getRows(InboundDetailsPage page){
        return inboundDetailsMapper.getRows(page);
    }

    public boolean addInboundDetails(InboundDetails inboundDetails){
        return inboundDetailsMapper.addInboundDetails(inboundDetails) == 1;
    }

    public boolean updateInboundDetails(InboundDetails inboundDetails){
        return inboundDetailsMapper.updateInboundDetails(inboundDetails) == 1;
    }

    public boolean deleteInboundDetails(InboundDetails inboundDetails){
        return inboundDetailsMapper.deleteInboundDetails(inboundDetails) == 1;
    }

    public List<InboundDetails> getAllInboundDetails(InboundDetailsPage page){
        return inboundDetailsMapper.getAllInboundDetails(page);
    }
}
