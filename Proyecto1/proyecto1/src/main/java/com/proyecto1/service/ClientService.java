package com.proyecto1.service;


import com.proyecto1.dto.clientDTO.request.ClientIdDTO;
import com.proyecto1.dto.clientDTO.request.NewClientDTO;
import com.proyecto1.dto.clientDTO.response.ClientDTO;
import com.proyecto1.repository.crud.ClientCrud;
import com.proyecto1.repository.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void saveClient(NewClientDTO newClient){
        Client client = new Client();

        client.setNit(newClient.getNit());
        client.setName(newClient.getName());
        client.setLastName(newClient.getLastName());
        client.setAddress(newClient.getAddress());
        client.setPhone(newClient.getPhone());

        clientCrud.save(client);
    }


    public ClientDTO getClientByNit(ClientIdDTO clientNit){
        Client client = clientCrud.findById(clientNit.getNit()).get();
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNit(client.getNit());
        clientDTO.setName(client.getName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setPhone(client.getPhone());

        return clientDTO;
    }

    public ClientDTO getClientById(String clientNit){
        Client client = clientCrud.findById(clientNit).get();
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNit(client.getNit());
        clientDTO.setName(client.getName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setPhone(client.getPhone());

        return clientDTO;
    }

    public NewClientDTO modifyClient(NewClientDTO newClient, String nit){
        Client client = clientCrud.findById(nit).get();
        client.setName(newClient.getName());
        client.setLastName(newClient.getLastName());
        client.setAddress(newClient.getAddress());
        client.setPhone(newClient.getPhone());

        clientCrud.save(client);
        return newClient;
    }









}
