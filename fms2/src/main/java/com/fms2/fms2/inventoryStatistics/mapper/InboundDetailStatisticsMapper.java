package com.fms2.fms2.inventoryStatistics.mapper;

import com.fms2.fms2.inventoryStatistics.domain.InboundDetailStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface InboundDetailStatisticsMapper {
    List<InboundDetailStatistics> getAllInboundDetailStatistics(InboundDetailStatistics statistics);
}
