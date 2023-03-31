package com.proyecto1.service;

import com.proyecto1.dto.productDTO.response.ProductDTO;
import com.proyecto1.dto.saleDTO.response.SaleDTO;
import com.proyecto1.dto.saleDetailDTO.request.NewSaleDetailDTO;
import com.proyecto1.dto.saleDetailDTO.response.SaleDetailCreatedDTO;
import com.proyecto1.dto.saleDetailDTO.response.SaleDetailDTO;
import com.proyecto1.exception.MarketException;
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


    public SaleDetailCreatedDTO addSaleDetail(NewSaleDetailDTO newSaleDetail, int branchId) throws MarketException {

        validateData(newSaleDetail,branchId);

        int productPrice = productService.getPrice(newSaleDetail.getProduct());
        int amount = newSaleDetail.getAmount();
        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setSale(newSaleDetail.getSale());
        saleDetail.setProduct(newSaleDetail.getProduct());
        saleDetail.setAmount(newSaleDetail.getAmount());
        saleDetail.setTotal(productPrice*amount);

        //reduce stock product branch
        String productBranchId = saleDetail.getProduct()+"-"+branchId;
        productBranchService.reduceStock(productBranchId,saleDetail.getAmount());

        //reduce branch product stock
        branchService.reduceStock(branchId,saleDetail.getAmount());

        SaleDTO saleDTO = saleService.getById(saleDetail.getSale());

        //update sale total
        String mensaje = "Producto agregado a la venta";
        int lastSaleValue = saleService.getLastSaleCustomer(saleDTO.getClient().getNit());
        Integer actualTotal = saleService.getSaleTotal(saleDetail.getSale());
        //verificamos precio anterior para hacer descuento
        if(lastSaleValue >= 1000){
            int newTotal = addDiscount(saleDetail, lastSaleValue);
            saleService.modifyTotal(saleDetail.getSale(), newTotal+actualTotal);
            saleDetail.setTotal(newTotal);
            mensaje = "Producto agregado a la venta con descuento, Q"+newTotal;
        }
        saleDetail =saleDetailCrud.save(saleDetail);
        saleService.modifyTotal(saleDetail.getSale(), saleDetail.getTotal()+actualTotal);
        ProductDTO productDTO = productService.getById(saleDetail.getProduct());
        saleDTO = saleService.getById(saleDetail.getSale());
        SaleDetailDTO saleDetailDTO = SaleDetailUtils.SaleDetailToSaleDetailDTO(saleDetail,saleDTO,productDTO);

        SaleDetailCreatedDTO saleDetailCreatedDTO = new SaleDetailCreatedDTO();
        saleDetailCreatedDTO.setSale(saleDetailDTO);
        saleDetailCreatedDTO.setMessage(mensaje);
        saleDetailCreatedDTO.setStatus(201);
        return saleDetailCreatedDTO;
    }

    public Integer addDiscount(SaleDetail saleDetail, int amount){
        int totalWithDiscount = 0;
        if(amount >= 1000 &&  amount < 5000){
            totalWithDiscount = (int) (saleDetail.getTotal()*0.98);
        }else if(amount >= 5000 &&  amount < 10000){
            totalWithDiscount = (int) (saleDetail.getTotal()*0.95);
        }else if(amount >= 10000){
            totalWithDiscount = (int) (saleDetail.getTotal()*0.90);
        }

        return totalWithDiscount;
    }

    public ArrayList<SaleDetailDTO> getAll() throws MarketException {
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

    //private  methods
    private void validateData(NewSaleDetailDTO newSaleDetail, int branchId) throws MarketException {
        String idProductBranch = newSaleDetail.getProduct()+"-"+branchId;

        if(!productBranchService.isAvailable(idProductBranch,newSaleDetail.getAmount())){
            throw new MarketException("No hay suficiente producto",400);
        }

        if(!saleService.exist(newSaleDetail.getSale())){
            throw new MarketException("La venta a detallar no existe",404);
        }

        if(!productService.exist(newSaleDetail.getProduct())){
            throw new MarketException("El producto no existe",404);
        }

        if(newSaleDetail.getAmount()<0){
            throw new MarketException("La cantidad a comprar debe ser mayor a 0",400);
        }

        String productBranchId = newSaleDetail.getProduct()+"-"+branchId;

        if(!productBranchService.exist(productBranchId)){
            throw new MarketException("El producto no se encuentra registrado en la sucursal",404);
        }

        if(!productBranchService.isAvailable(productBranchId, newSaleDetail.getAmount())){
            throw new MarketException("No hay productos suficientes en la sucursal",404);
        }


    }

}
