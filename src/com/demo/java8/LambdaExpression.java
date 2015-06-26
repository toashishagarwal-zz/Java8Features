package com.demo.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}


public class LambdaExpression {
	public static void main(String[] args) {
		sortingBeforeJava8();
		sortingWithJava8();
	}

	private static void sortingWithJava8() {
		List<Person> persons = createPersons();
		System.out.println("Using Java 8 : Before sorting");
		printList(persons);
		
		Collections.sort(persons, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		System.out.println("\nUsing Java 8 : After sorting");
		printList(persons);
	}

	private static void sortingBeforeJava8() {
		List<Person> persons = createPersons();
		
		System.out.println("Before sorting");
		printList(persons);
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println("\nAfter sorting");
		printList(persons);
	}

	private static List<Person> createPersons() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Rakesh"));
		persons.add(new Person("Suresh"));
		persons.add(new Person("Mahesh"));
		persons.add(new Person("Dinesh"));
		return persons;
	}

	private static void printList(List<Person> persons) {
		for (Person p: persons) {
			System.out.println(p.getName());
		}
	}
}
