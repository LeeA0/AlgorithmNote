package com.boj.sliver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_BOJ_10814_나이순정렬 {
	static class Person implements Comparable<Person> {
		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			return this.age - o.age; //오름차순
		}
	}

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N = scann.nextInt();

		Person[] p = new Person[N];
		
		for (int i = 0; i < N; i++) {
			int age = scann.nextInt();
			String name = scann.next();
			p[i] = new Person(age, name);
		}

		Arrays.sort(p);
		StringBuilder sb = new StringBuilder();
		for (Person person : p) {
			sb.append(person.age).append(" ").append(person.name).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
