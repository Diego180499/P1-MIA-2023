package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrud extends CrudRepository<User,String> {
}
