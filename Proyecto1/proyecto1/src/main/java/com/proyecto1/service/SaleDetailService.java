package com.proyecto1.service;

import com.proyecto1.dto.productDTO.response.ProductDTO;
import com.proyecto1.dto.saleDTO.response.SaleDTO;
import com.proyecto1.dto.saleDetailDTO.request.NewSaleDetailDTO;
import com.proyecto1.dto.saleDetailDTO.response.SaleDetailDTO;
import com.proyecto1.repository.crud.SaleDetailCrud;
import com.proyecto1.repository.entity.ProductBranch;
import com.proyecto1.repository.entity.SaleDetail;
import com.proyecto1.utils.SaleDetailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SaleDetailService {

    @Autowired
    SaleDetailCrud saleDetailCrud;

    @Autowired
    SaleService saleService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductBranchService productBranchService;

    @Autowired
    BranchService branchService;

    public SaleDetailDTO addSaleDetail(NewSaleDetailDTO newSaleDetail, int branchId){

        int productPrice = productService.getPrice(newSaleDetail.getProduct());
        int amount = newSaleDetail.getAmount();
        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setSale(newSaleDetail.getSale());
        saleDetail.setProduct(newSaleDetail.getProduct());
        saleDetail.setAmount(newSaleDetail.getAmount());
        saleDetail.setTotal(productPrice*amount);
        saleDetail =saleDetailCrud.save(saleDetail);

        //update sale total
        Integer actualTotal = saleService.getSaleTotal(saleDetail.getSale());
        saleService.modifyTotal(saleDetail.getSale(), saleDetail.getTotal()+actualTotal);

        //reduce stock product branch
        String productBranchId = saleDetail.getProduct()+"-"+branchId;
        productBranchService.reduceStock(productBranchId,saleDetail.getAmount());

        //reduce branch product stock
        branchService.reduceStock(branchId,saleDetail.getAmount());

        SaleDTO saleDTO = saleService.getById(saleDetail.getSale());
        ProductDTO productDTO = productService.getById(saleDetail.getProduct());
        SaleDetailDTO saleDetailDTO = SaleDetailUtils.SaleDetailToSaleDetailDTO(saleDetail,saleDTO,productDTO);

        return saleDetailDTO;
    }

    public ArrayList<SaleDetailDTO> getAll(){
        ArrayList<SaleDetail> sales = (ArrayList<SaleDetail>) saleDetailCrud.findAll();
        ArrayList<SaleDetailDTO> salesDTO = new ArrayList<>();

        for(SaleDetail sale : sales){
            SaleDTO saleDTO = saleService.getById(sale.getSale());
            ProductDTO productDTO = productService.getById(sale.getProduct());
            SaleDetailDTO saleDetailDTO = SaleDetailUtils.SaleDetailToSaleDetailDTO(sale,saleDTO,productDTO);
            salesDTO.add(saleDetailDTO);
        }
        return salesDTO;
    }

}
