package com.demo.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStream {

	// Here is what we will do :
	// Create a very large list of Strings
	// Then sort that using Sequential stream. Compare the time.
	// Then perform sort using Parallel stream
	
	private final static int MAX = 1000000;
	
	public static void main(String[] args) {
		ParallelStream streamDemo = new ParallelStream();
		List<String> list = streamDemo.generateData();
		streamDemo.sortSequentialStream(list);
		streamDemo.sortParallelStream(list);
	}

	private void sortParallelStream(List<String> values) {
		long t0 = System.nanoTime();

		long count = values.parallelStream()
								.sorted()
								.count();
		long t1 = System.nanoTime();

		printTimeDifference(t0, t1, "Parallel");
	}

	private void sortSequentialStream(List<String> values) {
		long t0 = System.nanoTime();

		long count = values.stream()
							.sorted()
							.count();
		long t1 = System.nanoTime();
		printTimeDifference(t0, t1, "Sequential");
	}

	private List<String> generateData() {
		List<String> values = new ArrayList<>(MAX);
		for (int i = 0; i < MAX; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		return values;
	}
	
	private void printTimeDifference(long t0, long t1, String method) {
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format(method + " sort took: %d ms", millis));
	}
}
