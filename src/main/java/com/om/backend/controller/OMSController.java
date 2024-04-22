package com.om.backend.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.om.backend.model.Address;
import com.om.backend.model.Employee;
import com.om.backend.service.OMSService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OMSController {

	@Autowired
	OMSService service;

	// API 1 (Add Address)

	@PostMapping("/addAddress")
	public ResponseEntity<String> addAddress(@RequestBody Address address) {

		String msg = service.addAddress(address);

		if (msg != null) {

			return ResponseEntity.ok(msg);

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Added...");

	}

	// API 2 (Add Employee)

	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {

		String msg = service.addEmployee(emp);

		if (msg != null) {

			return ResponseEntity.ok(msg);

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not Added...");

	}

	// API 3 (Update Address)

	@PutMapping("/updateAddress/{id}")
	public ResponseEntity<String> updateAddress(@PathVariable int id, @RequestBody Address address) {

		String msg = service.updateAddress(id, address);
		if (msg != null) {

			return ResponseEntity.ok(msg);

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Updated...");

	}

	// API 4 (Update Employee)

	@PutMapping("/updateEmployee")
	public ResponseEntity<String> updateEmployee( @RequestBody Employee emp) {

		String msg = service.updateEmployee(emp);
		if (msg != null) {

			return ResponseEntity.ok(msg);

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not Updated...");

	}

	// API 5 (Delete Address)

	@DeleteMapping("/deleteAddress/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable int id) {

		String msg = service.deleteAddress(id);

		if (msg != null) {

			return ResponseEntity.ok(msg);

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Deleted...");

	}

	// API 6 (Delete Employee)

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {

		String msg = service.deleteEmployee(id);

		if (msg != null) {

			return ResponseEntity.ok(msg);

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" EmployeeNot Deleted...");

	}

	// API 7 (Get All Address)

	@GetMapping("/getAddresses")
	public ResponseEntity<List<Address>> getAddresses() {

		List<Address> list = null;

		list = service.getAddresses();

		if (Objects.isNull(list)) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		}
		return ResponseEntity.ok(list);

	}

	// API 8 (Get All Employees)

	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> getEmployees() {

		List<Employee> list = null;

		list = service.getEmployees();

		if (Objects.isNull(list)) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		}
		return ResponseEntity.ok(list);

	}

	// API 9 (Get Address)

	@GetMapping("/getAddress/{id}")
	public ResponseEntity<Address> getAddressByID(@PathVariable int id) {

		Address address = null;

		address = service.getAddress(id);

		if (address != null) {

			return ResponseEntity.ok(address);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	// API 10 (Get Employee)

	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {

		Employee emp = null;

		emp = service.getEmployee(id);

		if (emp != null) {

			return ResponseEntity.ok(emp);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	// API 11 (Get Employee By Id)

	@GetMapping("/getEmployeeByName/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String name) {

		List<Employee> list = service.getEmployeeByName(name);

		if (Objects.isNull(list)) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.ok(list);
	}

	// API 12 (Get Employee List By Status)

	@GetMapping("/getEmployeeByStatus/{status}")
	public ResponseEntity<List<Employee>> getEmployeeByStatus(@PathVariable String status) {

		List<Employee> list = service.getEmployeeByStatus(status);

		if (Objects.isNull(list)) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.ok(list);
	}

	// API 13 (Get Employee List By Designation)

	@GetMapping("/getEmployeeByDesg/{desg}")
	public ResponseEntity<List<Employee>> getEmployeeByDesg(@PathVariable String desg) {

		List<Employee> list = service.getEmployeeByDesg(desg);

		if (Objects.isNull(list)) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.ok(list);
	}
	
	// API 14 (Login validation)
	
	@PostMapping("/login")
	public Map loginEmployee(@RequestBody Employee emp) {
		
		Map map=service.loginEmployee(emp);
		return map;
		
	}
	
	//API 15 (Get By Country Name)
	@PostMapping("/getEmployeesByCountry/{country}")
	public List<Employee> getEmployeesByCountry(@PathVariable String country) {
		
		List<Employee> list=service.getEmployeesByCountry(country);
		
		if (Objects.isNull(list)) {
			
			return list;
			
		}
		
		return list;
	}


}
