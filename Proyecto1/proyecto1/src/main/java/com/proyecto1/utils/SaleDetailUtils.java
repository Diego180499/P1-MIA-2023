package com.proyecto1.utils;

import com.proyecto1.dto.productDTO.response.ProductDTO;
import com.proyecto1.dto.saleDTO.response.SaleDTO;
import com.proyecto1.dto.saleDetailDTO.response.SaleDetailDTO;
import com.proyecto1.repository.entity.SaleDetail;

public class SaleDetailUtils {

    public static SaleDetailDTO SaleDetailToSaleDetailDTO(SaleDetail saleDetail, SaleDTO saleDTO, ProductDTO productDTO){
        SaleDetailDTO saleDetailDTO = new SaleDetailDTO();
        saleDetailDTO.setDetailId(saleDetail.getDetailId());
        saleDetailDTO.setSale(saleDTO);
        saleDetailDTO.setProduct(productDTO);
        saleDetailDTO.setAmount(saleDetail.getAmount());
        saleDetailDTO.setTotal(saleDetail.getTotal());
        return saleDetailDTO;
    }
}
