package com.demo.java8;

import java.util.Arrays;
import java.util.List;

class Employee {
    String firstName;
    String lastName;

    Employee() {}

    Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
}

@FunctionalInterface
interface EmployeeFactory<E extends Employee> {
    E create(String firstName, String lastName);
}

public class MethodAndConstructorReferences {

	public static void main(String[] args) {
		
		// Method Referencing example
		List<String> personNames = Arrays.asList("Suresh", "Dharmesh", "Kamesh","Mahesh");
		personNames.forEach(System.out::println);
		
		// Constructor referencing example
		EmployeeFactory<Employee> factory = Employee::new;
		Employee e = factory.create("Anand", "Modi");
	
		System.out.println(e);
	}
}
