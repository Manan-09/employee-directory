package com.manan.tracker.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.catalina.valves.rewrite.InternalRewriteMap.LowerCase;
import org.hibernate.query.criteria.internal.expression.function.LowerFunction;
import org.springframework.*; 

import com.manan.tracker.Dao.EmployeeRepository;
import com.manan.tracker.Entity.Employee;


@Service
public class EmployeeService 
{
	@Autowired
	public EmployeeRepository employeeRepository;
	
	
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}

	
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}


	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
	
	
	public List<Employee> findAllBYText(String theText)
	{
		return employeeRepository.findAllBYText(theText);
	}
	
}
