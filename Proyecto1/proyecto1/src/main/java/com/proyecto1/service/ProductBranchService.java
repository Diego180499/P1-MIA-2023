package com.proyecto1.service;

import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.dto.productBranchDTO.request.NewProductBranchDTO;
import com.proyecto1.dto.productBranchDTO.request.SendProductDTO;
import com.proyecto1.dto.productBranchDTO.response.ProductBranchDTO;
import com.proyecto1.dto.productBranchDTO.response.ProductSendedDTO;
import com.proyecto1.dto.productDTO.response.ProductDTO;
import com.proyecto1.exception.MarketException;
import com.proyecto1.repository.crud.ProductBranchCrud;
import com.proyecto1.repository.entity.ProductBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

import java.util.ArrayList;

@Service
public class ProductBranchService {

    @Autowired
    ProductBranchCrud productBranchCrud;

    @Autowired
    ProductService productService;

    @Autowired
    BranchService branchService;

    public ProductSendedDTO addProductBranch(NewProductBranchDTO newProductBranch) throws MarketException {
        //validamos que la sucursal y producto existan
        validateData(newProductBranch);

        String productBranchId = newProductBranch.getProduct()+"-"+newProductBranch.getBranch();
        ProductBranch productBranch;

        if(!productBranchCrud.existsById(productBranchId)){
            productBranch = createNewProductBranch(productBranchId, newProductBranch);
        }else{
            productBranch = productBranchCrud.findById(productBranchId).get();
            Integer actualStock = this.getStock(productBranchId);
            productBranch.setStockAmount(actualStock+newProductBranch.getStockAmount());
        }

        branchService.incrementStock(productBranch.getBranch(),newProductBranch.getStockAmount());
        productBranchCrud.save(productBranch);
        ProductSendedDTO productSendedDTO = new ProductSendedDTO();
        productSendedDTO.setMessage("Se ha ingresado el producto");
        productSendedDTO.setStatus(200);
        return productSendedDTO;
    }


    public ProductBranchDTO getProductBranch(String id) throws MarketException {
        if(!productBranchCrud.existsById(id)){
            throw new MarketException("El producto no existe en la sucursal",404);
        }
        ProductBranch productBranch = productBranchCrud.findById(id).get();
        ProductDTO productDTO = productService.getById(productBranch.getProduct());
        BranchDTO branchDTO = branchService.getById(productBranch.getBranch());

        ProductBranchDTO productBranchDTO = new ProductBranchDTO();
        productBranchDTO.setProductBranchId(productBranch.getProductBranchId());
        productBranchDTO.setProduct(productDTO);
        productBranchDTO.setBranch(branchDTO);
        productBranchDTO.setStockAmount(productBranch.getStockAmount());

        return productBranchDTO;
    }

    public Integer getStock(String id){
        return  productBranchCrud.getStock(id);
    }

    public void reduceStock(String id, int amount){
        int actualStock = getStock(id);
        ProductBranch productBranch = productBranchCrud.findById(id).get();
        productBranch.setStockAmount(actualStock-amount);
        productBranchCrud.save(productBranch);
    }

    public void addStock(String id, int amount){
        int actualStock = getStock(id);
        ProductBranch productBranch = productBranchCrud.findById(id).get();
        productBranch.setStockAmount(actualStock+amount);
        productBranchCrud.save(productBranch);
    }

    public ProductSendedDTO sendProduct(SendProductDTO sendProduct) throws MarketException {
            String originProductBranchId = sendProduct.getOriginBranch();
            ProductBranchDTO productBranch = this.getProductBranch(originProductBranchId);
            Integer productId = productBranch.getProduct().getProductId();
            String destinationProductBranchId = productId+"-"+sendProduct.getDestinationBranch();
            validateDataSend(originProductBranchId,destinationProductBranchId,sendProduct.getAmount());
            this.reduceStock(originProductBranchId,sendProduct.getAmount());
            this.addStock(destinationProductBranchId,sendProduct.getAmount());
        ProductSendedDTO productSendedDTO = new ProductSendedDTO();
        productSendedDTO.setMessage("Se ha enviado el producto");
        productSendedDTO.setStatus(200);
        return productSendedDTO;
    }

    public void validateDataSend(String originProducto, String destinationProduct, Integer amount) throws MarketException {
        if(!productBranchCrud.existsById(destinationProduct)){
            throw new MarketException("El producto no se encuentra en la sucursal indicada",400);
        }
        ProductBranchDTO productBranchDTO = this.getProductBranch(originProducto);
        if(productBranchDTO.getStockAmount()< amount){
            throw new MarketException("Ya no hay suficientes productos para enviar",400);
        }
    }

    //Private methods******
    private ProductBranch createNewProductBranch(String id, NewProductBranchDTO newProductBranch){
        ProductBranch productBranch = new ProductBranch();
        productBranch.setProductBranchId(id);
        productBranch.setProduct(newProductBranch.getProduct());
        productBranch.setBranch(newProductBranch.getBranch());
        productBranch.setStockAmount(newProductBranch.getStockAmount());
        return productBranch;
    }

    private void validateData(NewProductBranchDTO newProductBranch) throws MarketException {
        if(!productService.exist(newProductBranch.getProduct())){
            throw new MarketException("El producto no existe",404);
        }

        if(!branchService.exist(newProductBranch.getBranch())){
            throw new MarketException("La sucursal no existe",404);
        }
    }


    public Boolean exist(String id){
        return productBranchCrud.existsById(id);
    }

    public Boolean isAvailable(String productBranchdId, int amount) throws MarketException {
        ProductBranchDTO productBranch = getProductBranch(productBranchdId);
        if(productBranch.getStockAmount()< amount){
            return false;
        }
        return true;
    }


    public ArrayList<ProductBranchDTO> getBySucursal(int idSucursal) throws MarketException {
        if(!branchService.exist(idSucursal)){
            throw new MarketException("La sucursal no existe",404);
        }

        ArrayList<ProductBranch> products = productBranchCrud.getBySucursal(idSucursal);
        ArrayList<ProductBranchDTO> productsDTO = new ArrayList<>();

        for(ProductBranch productBranch : products){
            ProductDTO productDTO = productService.getById(productBranch.getProduct());
            BranchDTO branchDTO = branchService.getById(productBranch.getBranch());

            ProductBranchDTO productBranchDTO = new ProductBranchDTO();
            productBranchDTO.setProductBranchId(productBranch.getProductBranchId());
            productBranchDTO.setProduct(productDTO);
            productBranchDTO.setBranch(branchDTO);
            productBranchDTO.setStockAmount(productBranch.getStockAmount());
            productsDTO.add(productBranchDTO);
        }
        return productsDTO;
    }

}
