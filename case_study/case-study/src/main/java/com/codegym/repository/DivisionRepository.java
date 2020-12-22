package com.codegym.repository;

import com.codegym.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface DivisionRepository extends JpaRepository<Division,Integer> {
}