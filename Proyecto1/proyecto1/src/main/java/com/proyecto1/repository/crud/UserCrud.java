package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface UserCrud extends CrudRepository<User,String> {

    @Query(value = "SELECT * FROM reporte_usuarios;",nativeQuery = true)
    ArrayList<String> getUsers();
}
