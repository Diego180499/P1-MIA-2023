package com.proyecto1.service;


import com.proyecto1.dto.employeeDTO.response.EmployeeDTO;
import com.proyecto1.dto.userDTO.request.NewUserDTO;
import com.proyecto1.dto.userDTO.response.UserCreatedDTO;
import com.proyecto1.dto.userDTO.response.UserDTO;
import com.proyecto1.exception.MarketException;
import com.proyecto1.repository.crud.UserCrud;
import com.proyecto1.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserCrud userCrud;

    @Autowired
    private EmployeeService employeeService;


    public UserCreatedDTO createUser(NewUserDTO newUser) throws MarketException {
        if(!employeeService.exist(newUser.getUser())){
            throw new MarketException("El empleado con el dpi "+newUser.getUser()+", no existe",400);
        }

        if(userCrud.existsById(newUser.getUser())){
            throw new MarketException("Este usuario ya ha sido creado",400);
        }
        User user = new User();
        user.setUser(newUser.getUser());
        user.setPassword(newUser.getPassword());

        userCrud.save(user);

        UserCreatedDTO userCreated = new UserCreatedDTO();
        userCreated.setUser(newUser);
        userCreated.setStatus(201);
        return userCreated;
    }



    public UserDTO getById(String id) throws MarketException {
            if(!userCrud.existsById(id)){
                throw new MarketException("El usuario no existe",404);
            }

            User user = userCrud.findById(id).get();
            UserDTO userDTO = new UserDTO();
            userDTO.setUser(user.getUser());
            userDTO.setPassword(user.getPassword());

            EmployeeDTO employeeDTO = employeeService.getByDpi(id);
            userDTO.setEmployee(employeeDTO);
            return userDTO;
    }
}
