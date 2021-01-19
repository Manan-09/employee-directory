package com.manan.tracker.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manan.tracker.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

	public List<Employee> findAllByOrderByFirstNameAsc();
	
	@org.springframework.data.jpa.repository.Query("from Employee where lower(firstName) like %?1% or lower(lastName) like %?1% " )
	public List<Employee> findAllBYText(String theText);
}
