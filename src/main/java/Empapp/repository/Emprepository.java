package Empapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Empapp.model.Emp;

public interface Emprepository extends JpaRepository<Emp, Long> {

}
