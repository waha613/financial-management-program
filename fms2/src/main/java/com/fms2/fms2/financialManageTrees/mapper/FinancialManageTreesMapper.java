package com.fms2.fms2.financialManageTrees.mapper;

import com.fms2.fms2.financialManageTrees.domain.FinancialManageTrees;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface FinancialManageTreesMapper {
    List<FinancialManageTrees> getFinancialManageTrees();
}
