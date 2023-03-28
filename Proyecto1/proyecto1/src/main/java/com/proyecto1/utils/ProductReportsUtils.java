package com.proyecto1.utils;

import com.proyecto1.dto.reportsDTO.productReportDTO.MostIncomeWithBranchDTO;
import com.proyecto1.dto.reportsDTO.productReportDTO.MostSelledByBranchDTO;
import com.proyecto1.dto.reportsDTO.productReportDTO.MostSelledProductDTO;
import com.proyecto1.dto.reportsDTO.productReportDTO.ProductsWithMostIncomeDTO;

import java.util.ArrayList;

public class ProductReportsUtils {

    public static ArrayList<MostSelledProductDTO> mostSelledProductDTO(ArrayList<String> products){
        ArrayList<MostSelledProductDTO> productsDTO = new ArrayList<>();

        for(int i=0; i<products.size(); i++){
            String data [] = products.get(i).split(",");
            MostSelledProductDTO mostSelledProductDTO = new MostSelledProductDTO();
            mostSelledProductDTO.setProductName(data[0]);
            mostSelledProductDTO.setSaleAmount(Integer.parseInt(data[1]));
            productsDTO.add(mostSelledProductDTO);
        }
        return productsDTO;
    }


    public static ArrayList<ProductsWithMostIncomeDTO> productsWithMostIncome(ArrayList<String> products){
        ArrayList<ProductsWithMostIncomeDTO> productsDTO = new ArrayList<>();

        for(int i=0; i<products.size(); i++){
            String data [] = products.get(i).split(",");
            ProductsWithMostIncomeDTO productsWithMostIncomeDTO = new ProductsWithMostIncomeDTO();
            productsWithMostIncomeDTO.setProductName(data[0]);
            productsWithMostIncomeDTO.setIncome(Integer.parseInt(data[1]));
            productsDTO.add(productsWithMostIncomeDTO);
        }
        return productsDTO;
    }


    public static ArrayList<MostSelledByBranchDTO> mostSelledByBranch(ArrayList<String> products){
        ArrayList<MostSelledByBranchDTO> productsDTO = new ArrayList<>();

        for(int i=0; i<products.size(); i++){
            MostSelledByBranchDTO mostSelledByBranchDTO = new MostSelledByBranchDTO();
            String data [] = products.get(i).split(",");
            mostSelledByBranchDTO.setBranchName(data[1]);
            mostSelledByBranchDTO.setProductName(data[2]);
            mostSelledByBranchDTO.setSalesAmount(Integer.parseInt(data[3]));
            productsDTO.add(mostSelledByBranchDTO);
        }

        return productsDTO;
    }

    public static ArrayList<MostIncomeWithBranchDTO> mostIncomeByBranch(ArrayList<String> products){
        ArrayList<MostIncomeWithBranchDTO> productsDTO = new ArrayList<>();

        for(int i=0; i<products.size(); i++){
            MostIncomeWithBranchDTO mostIncomeWithBranchDTO = new MostIncomeWithBranchDTO();
            String data [] = products.get(i).split(",");
            mostIncomeWithBranchDTO.setBranchName(data[1]);
            mostIncomeWithBranchDTO.setProductName(data[2]);
            mostIncomeWithBranchDTO.setIncome(Integer.parseInt(data[3]));
            productsDTO.add(mostIncomeWithBranchDTO);
        }

        return productsDTO;
    }


}
