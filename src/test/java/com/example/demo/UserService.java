package com.example.demo;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.Entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.imp.serviceInterface.EmployeeServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {

    @Mock
    private EmployeeRepo repo;

    @Mock
    private EmployeeMapper mapper;

    @InjectMocks
    private EmployeeServiceImp userServiceImp;

//    @Test
//    void createValidSalaryReturnsId() {
//        var dto = new EmployeeDto("Roman", BigDecimal.valueOf(500_000));
//        var entity = new Employee(dto);
//        UUID fakeId = UUID.randomUUID();
//        entity.setId(fakeId);
//
//        when(mapper.toEntity(dto)).thenReturn(entity);
//        when(repo.save(entity)).thenReturn(entity);
//
//        UUID result = userServiceImp.create(employee);
//        assertEquals(fakeId, result);
//        verify(repo).save(entity);
//    }

}
