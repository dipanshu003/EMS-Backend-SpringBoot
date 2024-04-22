package com.om.backend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.om.backend.dao.OMSDao;
import com.om.backend.model.Address;
import com.om.backend.model.Employee;

@Service
public class OMSService {

	@Autowired
	OMSDao dao;

	// 1.Add Adddress Service
	public String addAddress(Address address) {

		String msg = null;
		boolean isAdded = dao.addAddress(address);

		if (isAdded) {
			msg = "Address Added Successfully....";
		}
		return msg;

	}

	// 2.Add Employee Service

	public String addEmployee(Employee emp) {

		String msg = null;
		boolean isAdded = dao.addEmployee(emp);

		if (isAdded) {
			msg = "Employee Added Successfully....";
		}
		return msg;

	}

	// 3.Update Address Service

	public String updateAddress(int id, Address address) {

		String msg = null;

		boolean isUpdated = dao.updateAddress(id, address);

		if (isUpdated) {
			msg = "Updated Successfully...";
		}
		return msg;

	}

	// 4.Update Employee Service

	public String updateEmployee(Employee emp) {

		String msg = null;

		boolean isUpdated = dao.updateEmployee(emp);

		if (isUpdated) {
			msg = "Employee Updated Successfully...";
		}
		return msg;

	}

	// 5.Delete Address Service
	public String deleteAddress(int id) {
		String msg = null;

		boolean isDeleted = dao.deleteAddress(id);

		if (isDeleted) {
			msg = "Deleted Successfully...";
		}
		return msg;
	}

	// 6.Delete Employee Service

	public String deleteEmployee(int id) {
		String msg = null;

		boolean isDeleted = dao.deleteEmployee(id);

		if (isDeleted) {
			msg = "Employee Deleted Successfully...";
		}
		return msg;
	}

	// 7.Delete Address Service

	public List<Address> getAddresses() {

		List<Address> list = null;

		list = dao.getAddresses();
		return list;

	}

	// 8.Delete Employee Service

	public List<Employee> getEmployees() {

		List<Employee> list = null;

		list = dao.getEmployees();
		return list;

	}

	// 9.Delete Address Service

	public Address getAddress(int id) {

		Address address = null;
		address = dao.getAddress(id);
		return address;

	}

	// 10.Delete Employee Service

	public Employee getEmployee(int id) {

		Employee emp = null;
		emp = dao.getEmployee(id);
		return emp;

	}

	// 11.Get By Id Employee Service

	public List<Employee> getEmployeeByName(String name) {

		List<Employee> list = dao.getEmployeeByName(name);
		return list;

	}

	// 12.Get By Status Employee Service

	public List<Employee> getEmployeeByStatus(String status) {

		List<Employee> list = dao.getEmployeeByStatus(status);
		return list;

	}

	// 13.Get By Designation Employee Service

	public List<Employee> getEmployeeByDesg(String desg) {

		List<Employee> list = dao.getEmployeeByDesg(desg);
		return list;

	}
	
	// 14.Login Employee

	public Map loginEmployee(Employee emp) {
		
		Map map = new HashMap();
		
		Employee employee=dao.loginEmployee(emp);
		
		if (Objects.isNull(employee)) {
			
			map.put("msg", "Invalid User");
			map.put("user", employee);
			return map;
			
		}
		
		map.put("msg", "Valid User");
		map.put("user", employee);
		return map;
		
	}

	// 15.Get Employee by Country

	
	public List<Employee> getEmployeesByCountry(String country) {
		
		List<Employee> list=dao.getEmployeesByCountry(country);
		
		return list;
	}

}
