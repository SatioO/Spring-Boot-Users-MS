package com.learn.users;

import com.learn.users.entities.Department;
import com.learn.users.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

@Repository
interface DepartmentRepository extends JpaRepository<Department, Long> {

}

@RestController
@RequestMapping("employees")
class Employees {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
}

@RestController
@RequestMapping("departments")
class Departments {
	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping
	public List<Department> getDepartments() {
		List<Department> departments =departmentRepository.findAll();
		System.out.println("Fetched Departments size:" + departments.size());
		for (Department department : departments) {
			System.out.println("Department ID:"+department.getId());
			System.out.println("Employees count:" + department.getEmployees().size());
		}
		return departments;
	}
}

@SpringBootApplication
public class DemoApplication {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	void CommandLineRunner() {
		/** CREATING EMPLOYEES s**/
		Employee employee1 = new Employee();
		employee1.setName("Sean Murphy");

		Employee employee2 = new Employee();
		employee2.setName("Barry Johnson");

		Employee employee3 = new Employee();
		employee3.setName("Janet Warren");

		Employee employee4 = new Employee();
		employee4.setName("Pamela Smith");

		Employee employee5 = new Employee();
		employee5.setName("Eric Miller");

		/** CREATING DEPARTMENTS **/
		Department department1 = new Department();
		department1.setName("IT");

		Department department2 = new Department();
		department2.setName("Finance");

		Department department3 = new Department();
		department3.setName("HR");

		/** ADDING EMPLOYESS TO DEPARTMENT **/
//		department1.getEmployees().add(employee1);
		employee1.setDepartment(department1);
//		department1.getEmployees().add(employee2);
		employee2.setDepartment(department1);

//		department2.getEmployees().add(employee3);
		employee3.setDepartment(department2);
//		department2.getEmployees().add(employee4);
		employee4.setDepartment(department2);

//		department3.getEmployees().add(employee5);
		employee5.setDepartment(department3);

		departmentRepository.save(department1);
		departmentRepository.save(department2);
		departmentRepository.save(department3);

		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
		employeeRepository.save(employee4);
		employeeRepository.save(employee5);

	}
}
