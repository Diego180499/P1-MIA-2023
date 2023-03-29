package com.proyecto1.utils;

import com.proyecto1.dto.userDTO.response.UserReportDTO;
import com.proyecto1.repository.entity.User;

import java.util.ArrayList;

public class UserUtils {


    public static ArrayList<UserReportDTO> getUsers(ArrayList<String> users){
        ArrayList<UserReportDTO> usersDTO = new ArrayList<>();

        for(int i=0; i<users.size(); i++){
            String data [] = users.get(i).split(",");
            UserReportDTO user = new UserReportDTO();
            user.setNombre(data[0]);
            user.setApellido(data[1]);
            user.setUsuario(data[2]);
            user.setPassword(data[3]);
            user.setSucursal(data[4]);
            user.setCargo(data[5]);
            usersDTO.add(user);
        }
        return usersDTO;
    }


}
