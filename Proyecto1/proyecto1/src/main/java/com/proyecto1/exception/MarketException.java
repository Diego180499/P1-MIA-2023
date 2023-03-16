package com.proyecto1.exception;

import com.proyecto1.dto.exceptionDTO.MarketExceptionDTO;

public class MarketException extends Exception{

    private MarketExceptionDTO marketExceptionDTO;

    public MarketException(MarketExceptionDTO marketExceptionDTO){
        this.marketExceptionDTO = marketExceptionDTO;
    }

    public MarketException(String message, int status){
        marketExceptionDTO = new MarketExceptionDTO();
        marketExceptionDTO.setMessage(message);
        marketExceptionDTO.setStatus(status);
    }

    public MarketExceptionDTO getMarketExceptionDTO() {
        return marketExceptionDTO;
    }
}
