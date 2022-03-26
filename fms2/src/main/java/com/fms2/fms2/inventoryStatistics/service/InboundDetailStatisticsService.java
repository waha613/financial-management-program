package com.fms2.fms2.inventoryStatistics.service;

import com.fms2.fms2.inventoryStatistics.domain.InboundDetailStatistics;
import com.fms2.fms2.inventoryStatistics.mapper.InboundDetailStatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InboundDetailStatisticsService {
    @Autowired
    private InboundDetailStatisticsMapper inboundDetailStatisticsMapper;

    public List<InboundDetailStatistics> getAllInboundDetailStatistics(InboundDetailStatistics statistics){
       return inboundDetailStatisticsMapper.getAllInboundDetailStatistics(statistics);
    }
}
