package com.example.springdatajpa.learnspringdatajpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springdatajpa.learnspringdatajpa.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
