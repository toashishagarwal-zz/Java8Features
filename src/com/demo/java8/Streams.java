package com.demo.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Worker {
	private String firstName;
	private String lastName;
	private int age;
	
	public Worker(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return " firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + "";
	}
}

public class Streams {
	public static void main(String[] args) {
		List<Worker> workers = new ArrayList<Worker>();
		workers.add(new Worker("Mukesh", "Rana", 14));
		workers.add(new Worker("Randeep", "Huda", 16));
		workers.add(new Worker("Zaid", "Khan", 10));
		workers.add(new Worker("Jimmy", "Shergill", 11));
		workers.add(new Worker("Nikhil", "Dwivedi", 18));
		workers.add(new Worker("Rahul", "Bose", 21));
		
		// Get all child workers. Display their names alphabetically
		// A child worker is the one whose age is less than or equal to 14 years
		workers.stream()
			.filter(w -> (w.getAge() <= 14))
			.sorted(Comparator.comparing(Worker::getFirstName))
			.forEach(System.out::println);
		
		// Count the number of child workers
		long numberOfChildWorkers = workers.stream()
										.filter(w -> (w.getAge() <= 14))
										.count();
		System.out.println("\nNumber of Child workers are --> " + numberOfChildWorkers);
		
		// Get all child workers. Display their names alphabetically in Uppercase
		System.out.println("\nTheir names in Capital letters are ");
		workers.stream()
			.filter(w -> (w.getAge() <= 14))
			.sorted(Comparator.comparing(Worker::getFirstName))
			.map(w -> w.getFirstName().toUpperCase())
			.forEach(System.out::println);
		
		// Who will give me the min and max ages of those minor workers?
		Worker minAgeWorker = workers.stream()
									.filter(w -> w.getAge() <= 14)
									.min(Comparator.comparing(Worker::getAge))
									.get();
		
		System.out.println("Minimum age worker is --> " + minAgeWorker);
		
		Worker maxAgeWorker = workers.stream()
									.filter(w -> w.getAge() <= 14)
									.max(Comparator.comparing(Worker::getAge))
									.get();
				
		System.out.println("Max age worker is --> " + maxAgeWorker);		
	}
}
