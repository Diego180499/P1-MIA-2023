package com.proyecto1.service;


import com.proyecto1.dto.clientDTO.request.ClientIdDTO;
import com.proyecto1.dto.clientDTO.request.NewClientDTO;
import com.proyecto1.dto.clientDTO.response.ClientDTO;
import com.proyecto1.dto.exceptionDTO.MarketExceptionDTO;
import com.proyecto1.exception.MarketException;
import com.proyecto1.repository.crud.ClientCrud;
import com.proyecto1.repository.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClientService {

    @Autowired
    private ClientCrud clientCrud;


    public ArrayList<ClientDTO> getAllClients(){
        ArrayList<ClientDTO> clients = (ArrayList) clientCrud.findAll();
        return clients;
    }

    public ClientDTO saveClient(NewClientDTO newClient) throws MarketException {
        if(clientCrud.existsById(newClient.getNit())){
            throw new MarketException("El cliente con el nit "+newClient.getNit()+" ya ha sido registrado",400);
        }
        Client client = new Client();

        client.setNit(newClient.getNit());
        client.setName(newClient.getName());
        client.setLastName(newClient.getLastName());
        client.setAddress(newClient.getAddress());
        client.setPhone(newClient.getPhone());

        client = clientCrud.save(client);
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNit(client.getNit());
        clientDTO.setName(client.getName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setPhone(client.getPhone());
        return clientDTO;
    }


    public ClientDTO getClientByNit(String nit) throws MarketException {
        if(!clientCrud.existsById(nit)){
            throw new MarketException("El cliente con el nit "+nit+" no existe",404);
        }
        Client client = clientCrud.findById(nit).get();
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNit(client.getNit());
        clientDTO.setName(client.getName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setPhone(client.getPhone());

        return clientDTO;
    }

    public ClientDTO getClientById(String clientNit) throws MarketException {
        if(!clientCrud.existsById(clientNit)){
            throw new MarketException("El cliente con el nit "+clientNit+" no existe",404);
        }

        Client client = clientCrud.findById(clientNit).get();
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNit(client.getNit());
        clientDTO.setName(client.getName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setPhone(client.getPhone());

        return clientDTO;
    }

    public NewClientDTO modifyClient(NewClientDTO newClient, String nit) throws MarketException {
        if(!clientCrud.existsById(nit)){
            throw new MarketException("El cliente con el nit "+nit+" no existe",404);
        }

        Client client = clientCrud.findById(nit).get();
        client.setName(newClient.getName());
        client.setLastName(newClient.getLastName());
        client.setAddress(newClient.getAddress());
        client.setPhone(newClient.getPhone());

        clientCrud.save(client);
        return newClient;
    }


    public Boolean exist(String nit){
        return clientCrud.existsById(nit);
    }






}
