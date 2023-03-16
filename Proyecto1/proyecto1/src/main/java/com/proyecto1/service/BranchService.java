package com.proyecto1.service;

import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.dto.exceptionDTO.MarketExceptionDTO;
import com.proyecto1.exception.MarketException;
import com.proyecto1.repository.crud.BranchCrud;
import com.proyecto1.repository.entity.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BranchService {

    @Autowired
    private BranchCrud branchCrud;



    public ArrayList<BranchDTO> getAll(){
        ArrayList<BranchDTO> branchs = (ArrayList) branchCrud.findAll();
        return branchs;
    }

    public BranchDTO getById(int id) throws MarketException {
        if(branchCrud.existsById(id)){
            Branch branch = branchCrud.findById(id).get();
            BranchDTO branchDTO = new BranchDTO();
            branchDTO.setBranchId(branch.getBranchId());
            branchDTO.setName(branch.getName());
            branchDTO.setProductsAmount(branch.getProductsAmount());
            return branchDTO;
        }
        throw new MarketException("La sucursal no existe",404);
    }

    public void incrementStock(int id, int amount){
        Integer actualStock = branchCrud.getStock(id);
        Branch branch = branchCrud.findById(id).get();
        branch.setProductsAmount(actualStock+amount);
        branchCrud.save(branch);
    }

    public void reduceStock(int id, int amount){
        Integer actualStock = branchCrud.getStock(id);
        Branch branch = branchCrud.findById(id).get();
        branch.setProductsAmount(actualStock-amount);
        branchCrud.save(branch);
    }

    public Boolean exist(int id){
        return branchCrud.existsById(id);
    }

}
