package com.fms2.fms2.financialManageTrees.service;

import com.fms2.fms2.financialManageTrees.domain.FinancialManageTrees;
import com.fms2.fms2.financialManageTrees.mapper.FinancialManageTreesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FinancialManageTreesService {
    @Autowired
    private FinancialManageTreesMapper treesMapper;

    public List<FinancialManageTrees> getFinancialManageTrees() {
        List<FinancialManageTrees> trees = treesMapper.getFinancialManageTrees();

        Map<String, FinancialManageTrees> map = new HashMap<>();
        for (FinancialManageTrees tree : trees) {
            map.put(tree.getId(), tree);
        }

        List<FinancialManageTrees> jsonTrees = new ArrayList<FinancialManageTrees>();
        int i = -1;
        FinancialManageTrees temp;
        while (trees.size() > 0) {
            FinancialManageTrees tree;
            FinancialManageTrees[] record = new FinancialManageTrees[trees.size()];
            if (i == -1) {
                for (int j = trees.size() - 1; j >= 0; j--) {
                    tree = trees.get(j);
                    if (tree.getLeaf() != null && tree.getLeaf()) {
                        temp = map.get(tree.getParentId());
                        temp.getChildren().add(tree);
                        record[j] = tree;
                    }
                }
                for (int j = 0; j < record.length; j++) {
                    trees.remove(record[j]);
                    record[j] = null;
                }
            }
            i++;
            record = new FinancialManageTrees[trees.size()];
            for (int j = 0; j < trees.size(); j++) {
                tree = trees.get(j);
                if (!tree.getParentId().equals("root")) {
                    temp = map.get(tree.getParentId());
                    temp.getChildren().add(tree);
                    record[j] = tree;
                } else if (tree.getParentId().equals("root")) {
                    jsonTrees.add(tree);
                    record[j] = tree;
                }
            }
            for (int j = 0; j < record.length; j++) {
                trees.remove(record[j]);
                record[j] = null;
            }
        }
        return jsonTrees;
    }
}
