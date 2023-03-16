package com.proyecto1.controllers;

import com.proyecto1.dto.clientDTO.request.ClientIdDTO;
import com.proyecto1.dto.clientDTO.request.NewClientDTO;
import com.proyecto1.dto.clientDTO.response.ClientDTO;
import com.proyecto1.exception.MarketException;
import com.proyecto1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<ArrayList<ClientDTO>> getAllClients(){
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity saveClient(@RequestBody NewClientDTO client){
        try {
            clientService.saveClient(client);
            return new ResponseEntity<>("Creado",HttpStatus.CREATED);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find/{nit}")
    public ResponseEntity<ClientDTO> getClientByNit(@PathVariable String nit){
        try {
            return new ResponseEntity<>(clientService.getClientByNit(nit),HttpStatus.OK);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(),HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/modify/{nit}")
    public ResponseEntity<NewClientDTO> modifyClient(@RequestBody NewClientDTO client, @PathVariable String nit){
        try {
            return new ResponseEntity<>( clientService.modifyClient(client,nit),HttpStatus.OK);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(),HttpStatus.NOT_FOUND);
        }
    }

}
