package com.boj.sliver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_10825_국영수 {
	static int N;
	static class Student implements Comparable<Student>{
		String name;
		int kor;
		int eng;
		int math;
		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}

		@Override
		public int compareTo(Student o) {
			if(this.kor == o.kor) {
				if(this.eng == o.eng) {
					if(this.math == o.math) {
						//다 같으면 사전 오름차순
						return this.name.compareTo(o.name);
					}
					//수학점수 내림차순
					return o.math - this.math;
				}
				//영어점수 오름차순 
				return this.eng - o.eng;
			}
			//국어점수 내림차순
			return o.kor - this.kor;
		}
	}
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		
		Student[] slist = new Student[N];
		
		for (int i = 0; i < N; i++) {
			String name = scann.next(); 
			int kor = scann.nextInt();
			int eng = scann.nextInt();
			int math = scann.nextInt();
			slist[i] = new Student(name, kor, eng, math);
		}//end input
		
		Arrays.sort(slist);
		StringBuilder sb = new StringBuilder();
		for(Student s : slist) {
			sb.append(s.name).append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
