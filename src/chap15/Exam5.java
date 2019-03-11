package chap15;

import java.util.Comparator;
import java.util.TreeSet;
/*
 * Student2 클래스 구현하기
 * 멤버변수 : 이름,국어, 영어, 수학
 * 멤버메서드 :String toString() : 각멤버변수값,총점,평균 출력
 *          int getTotal() : 점수의 합 리턴
 *          int compareTo() : 이름의 오름차순으로 정렬되도록 구현
 */
class Student2 implements Comparable<Student2>{
	String name;
	int kor,eng,math;
	Student2(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public int getTotal() {
		return kor+eng+math;
	}
	public String toString() {
		return "이름:"+name + ",국어:"+kor + ",영어:"+eng + ",수학:"+math 
			 + ",총점:"+getTotal() + ",평균:" + getTotal()/3.0;
	}
	@Override
	public int compareTo(Student2 s) {
		return name.compareTo(s.name);
	}
}
public class Exam5 {
	public static void main(String[] args) {
		Student2[] arr = {
				new Student2("홍길동",90,80,70),
				new Student2("김삿갓",95,85,75),
				new Student2("이몽룡",80,95,95),
				new Student2("임꺽정",60,75,100)
		};
		System.out.println("기본정렬방식");
		TreeSet<Student2> set1 = makeTreeSet(arr,null);   //기본정렬방식(이름)
		System.out.println("총점기준 내림차순 정렬");
//		TreeSet<Student2> set2 = makeTreeSet(arr,new Comparator<Student2>() {
//			@Override
//			public int compare(Student2 o1, Student2 o2) {
//				return o2.getTotal() - o1.getTotal();
//			}
//		});
		//람다방식
		TreeSet<Student2> set2 = makeTreeSet(arr,(o1,o2)->o2.getTotal()-o1.getTotal());
		System.out.println("국어 점수내림차순 정렬");
		TreeSet<Student2> set3 = makeTreeSet(arr,new Comparator<Student2>() {
			@Override
			public int compare(Student2 o1, Student2 o2) {
				return o2.kor - o1.kor;
			}
		});
		System.out.println("영어 점수내림차순 정렬");
		TreeSet<Student2> set4 = makeTreeSet(arr,new Comparator<Student2>() {
			@Override
			public int compare(Student2 o1, Student2 o2) {
				return o2.eng - o1.eng;
			}
		});
		System.out.println("수학 점수내림차순 정렬");
		TreeSet<Student2> set5 = makeTreeSet(arr,new Comparator<Student2>() {
			@Override
			public int compare(Student2 o1, Student2 o2) {
				return o2.math - o1.math;
			}
		});
	}
	private static TreeSet<Student2> makeTreeSet(Student2[] arr, Comparator<Student2> c) {
		TreeSet<Student2> set;
		if(c == null)
		    set= new TreeSet<Student2>(); //Student2 클래스에 정의된 정렬 방식
		else
		    set = new TreeSet<Student2>(c);
		for(Student2 s : arr) {
			set.add(s);
		}
		for(Student2 s : set) {
			System.out.println(s); 
		}
		return set;
	}
	
}
