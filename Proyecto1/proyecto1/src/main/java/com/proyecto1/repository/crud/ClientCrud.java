package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrud extends CrudRepository<Client,String> {
}
