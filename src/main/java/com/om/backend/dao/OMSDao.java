package com.om.backend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.om.backend.model.Address;
import com.om.backend.model.Employee;

@Repository
public class OMSDao {

	@Autowired
	SessionFactory factory;

	// 1.add address

	public boolean addAddress(Address address) {

		Session session = null;
		Transaction tr = null;
		boolean isAdded = false;

		try {

			session = factory.openSession();
			tr = session.beginTransaction();

			session.persist(address);
			session.clear();
			tr.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tr != null) {
				tr.rollback();
			}
			if (session != null) {

				session.close();

			}
		}
		return isAdded;

	}

	// 2.add employee

	public boolean addEmployee(Employee emp) {

		Session session = null;
		Transaction tr = null;
		boolean isAdded = false;

		try {

			session = factory.openSession();
			tr = session.beginTransaction();

			session.persist(emp);
			tr.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tr != null) {
				tr.rollback();
			}
			if (session != null) {

				session.close();

			}
		}
		return isAdded;

	}

	// 3.update address

	public boolean updateAddress(int id, Address address) {

		Session session = null;
		Transaction tr = null;
		boolean isUpdated = false;
		try {

			session = factory.openSession();
			tr = session.beginTransaction();

			Address oldAddress = session.get(Address.class, id);

			oldAddress.setCity(address.getCity());
			oldAddress.setCountry(address.getCountry());
			oldAddress.setState(address.getState());

			session.merge(oldAddress);

			tr.commit();

			isUpdated = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			if (tr != null) {

				tr.rollback();

			}
			if (session != null) {

				session.close();

			}

		}
		return isUpdated;

	}

	// 4.update employee

	public boolean updateEmployee(Employee emp) {

		Session session = null;
		Transaction tr = null;
		boolean isUpdated = false;
		try {

			session = factory.openSession();
			tr = session.beginTransaction();

			Employee oldEmp = session.get(Employee.class, emp.getId());

			oldEmp.setName(emp.getName());
			oldEmp.setDesg(emp.getDesg());
			oldEmp.setStatus(emp.getStatus());
			oldEmp.setAddress(emp.getAddress());
			oldEmp.setEmail(emp.getEmail());
			oldEmp.setPassword(emp.getPassword());

			session.merge(oldEmp);

			tr.commit();

			isUpdated = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			if (tr != null) {

				tr.rollback();

			}
			if (session != null) {

				session.close();

			}

		}
		return isUpdated;

	}

	// 5.delete Address

	public boolean deleteAddress(int id) {

		Session session = null;
		Transaction tr = null;
		boolean isDeleted = false;
		try {

			session = factory.openSession();
			tr = session.beginTransaction();

			Address address = session.get(Address.class, id);

			session.remove(address);

			tr.commit();

			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			if (tr != null) {

				tr.rollback();

			}
			if (session != null) {

				session.close();

			}

		}
		return isDeleted;

	}

	// 6.delete Employee

	public boolean deleteEmployee(int id) {

		Session session = null;
		Transaction tr = null;
		boolean isDeleted = false;
		try {

			session = factory.openSession();
			tr = session.beginTransaction();

			Employee emp = session.get(Employee.class, id);

			session.remove(emp);

			tr.commit();

			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			if (tr != null) {

				tr.rollback();

			}
			if (session != null) {

				session.close();

			}

		}
		return isDeleted;

	}

	// 7.Get All Addresses

	public List<Address> getAddresses() {

		Session session = null;
		Transaction tr = null;
		List<Address> list = null;
		String hqlQuery = "from Address";
		try {

			session = factory.openSession();
			tr = session.beginTransaction();

			Query<Address> query = session.createQuery(hqlQuery, Address.class);

			list = query.list();

			tr.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			if (tr != null) {

				tr.rollback();

			}
			if (session != null) {

				session.close();

			}

		}
		return list;

	}

	// 8.Get All Employees

	public List<Employee> getEmployees() {

		Session session = null;
		Transaction tr = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee";
		try {

			session = factory.openSession();
			tr = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);

			list = query.list();

			tr.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			if (tr != null) {

				tr.rollback();

			}
			if (session != null) {

				session.close();

			}

		}
		return list;

	}

	// 9.Get Address

	public Address getAddress(int id) {

		Session session = null;
		Transaction tr = null;
		Address address = null;
		try {

			session = factory.openSession();
			tr = session.beginTransaction();

			address = session.get(Address.class, id);

			tr.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			if (tr != null) {

				tr.rollback();

			}
			if (session != null) {

				session.close();

			}

		}
		return address;

	}

	// 10.Get Employee

	public Employee getEmployee(int id) {

		Session session = null;
		Transaction tr = null;
		Employee emp = null;
		try {

			session = factory.openSession();
			tr = session.beginTransaction();

			emp = session.get(Employee.class, id);

			tr.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			if (tr != null) {

				tr.rollback();

			}
			if (session != null) {

				session.close();

			}

		}
		return emp;

	}

	// 11.Get Employee By Id

	public List<Employee> getEmployeeByName(String name) {

		Session session = null;
		Transaction tr = null;
		List<Employee> list = null;

		String hqlQuery = "from Employee where name=:name";

		try {

			session = factory.openSession();
			tr = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("name", name);
			list = query.list();
			tr.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}

		finally {
			if (tr != null) {
				tr.rollback();
			}
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	// 12.Get Employee By Status

	public List<Employee> getEmployeeByStatus(String status) {

		Session session = null;
		Transaction tr = null;
		List<Employee> list = null;

		String hqlQuery = "from Employee where status=:status";

		try {

			session = factory.openSession();
			tr = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("status", status);
			list = query.list();
			tr.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}

		finally {
			if (tr != null) {
				tr.rollback();
			}
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	// 13.Get Employee By Designation

	public List<Employee> getEmployeeByDesg(String desg) {

		Session session = null;
		Transaction tr = null;
		List<Employee> list = null;

		String hqlQuery = "from Employee where desg = :desg";

		try {

			session = factory.openSession();
			tr = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("desg", desg);
			list = query.list();
			tr.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}

		finally {
			if (tr != null) {
				tr.rollback();
			}
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public Employee loginEmployee(Employee emp) {

		Session session = null;
		Transaction tr = null;
		Employee employee = null;

		String hqlQuery = "from Employee where email = :email and password = :password";

		try {

			session = factory.openSession();
			tr = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("email", emp.getEmail());
			query.setParameter("password", emp.getPassword());

			emp = query.uniqueResult();

			tr.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tr != null) {
				tr.rollback();
			}
			if (session != null) {
				session.close();
			}
		}
		return emp;

	}

	public List<Employee> getEmployeesByCountry(String country) {
		
		
		Session session = null;
		Transaction tr = null;
		List<Employee> list= null;

		String hqlQuery = "SELECT e FROM Employee e JOIN FETCH e.address a WHERE a.country = :country";

		try {

			session = factory.openSession();
			tr = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("country",country);

			list = query.list();

			tr.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tr != null) {
				tr.rollback();
			}
			if (session != null) {
				session.close();
			}
		}
		return list;
		
		
	}

}
