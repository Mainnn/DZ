package com.example.demo.service.imp.serviceInterface;

import com.example.demo.DTO.UserDto;
import com.example.demo.Entity.Employr;
import com.example.demo.repo.UserCRUD;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceImp {

    private final UserCRUD userCRUD;

    public UserServiceImp(UserCRUD userCRUD) {
        this.userCRUD = userCRUD;
    }

    @Transactional
    public UUID create(UserDto userDto) {
        Employr user = new Employr(userDto);
        return userCRUD.save(user).getId();
    }

}
