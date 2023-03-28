package com.proyecto1.utils;

import com.proyecto1.dto.reportsDTO.branchReportDTO.BranchWithMostIncomeDTO;
import com.proyecto1.dto.reportsDTO.branchReportDTO.BranchWithMostSalesDTO;

import java.util.ArrayList;

public class BranchReportUtils {

    public static ArrayList<BranchWithMostSalesDTO> branchWithMostSales(ArrayList<String> branchs){
        ArrayList<BranchWithMostSalesDTO> branchsDTO = new ArrayList<>();

        for(int i=0; i<branchs.size(); i++){
            String data [] = branchs.get(i).split(",");
            BranchWithMostSalesDTO branch = new BranchWithMostSalesDTO();
            branch.setBranchName(data[0]);
            branch.setSalesAmount(Integer.parseInt(data[1]));
            branchsDTO.add(branch);
        }

        return branchsDTO;
    }


    public static ArrayList<BranchWithMostIncomeDTO> branchWithMostIncome(ArrayList<String> branchs) {
        ArrayList<BranchWithMostIncomeDTO> branchsDTO = new ArrayList<>();

        for (int i = 0; i < branchs.size(); i++) {
            String data[] = branchs.get(i).split(",");
            BranchWithMostIncomeDTO branch = new BranchWithMostIncomeDTO();
            branch.setBranchName(data[0]);
            branch.setIncome(Integer.parseInt(data[1]));
            branchsDTO.add(branch);
        }
        return branchsDTO;
    }
}
