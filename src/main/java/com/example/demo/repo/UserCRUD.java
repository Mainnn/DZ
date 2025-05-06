package com.example.demo.repo;

import com.example.demo.Entity.Employr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserCRUD extends JpaRepository<Employr, UUID> {

}
