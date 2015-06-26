package com.demo.java8;

interface Formula {
	double calculate(int a);
	
	default double sqrt(int a) { 
		return Math.sqrt(a);
	}
}

public class ExtensionMethods {
	public static void main(String[] args) {
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a);
			}
		};

		System.out.println("using calculate --> " + formula.calculate(25));
		System.out.println("using default --> " + formula.sqrt(81));
	}
}
