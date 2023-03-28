package com.proyecto1.utils;

import com.proyecto1.dto.reportsDTO.clientReportDTO.ClientWithMoreIncomeDTO;

import java.util.ArrayList;

public class ClientReportsUtils {

    public static ArrayList<ClientWithMoreIncomeDTO> clientWithMoreIncome(ArrayList<String> clients){
        ArrayList<ClientWithMoreIncomeDTO> clientsDTO = new ArrayList<>();

        for(int i=0; i<clients.size(); i++){
            String data [] = clients.get(i).split(",");
            ClientWithMoreIncomeDTO clientWithMoreIncomeDTO = new ClientWithMoreIncomeDTO();
            clientWithMoreIncomeDTO.setNit(data[0]);
            clientWithMoreIncomeDTO.setName(data[1]);
            clientWithMoreIncomeDTO.setLastName(data[2]);
            clientWithMoreIncomeDTO.setIncome(Integer.parseInt(data[3]));

            clientsDTO.add(clientWithMoreIncomeDTO);
        }
        return clientsDTO;
    }

}
