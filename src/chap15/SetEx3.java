package chap15;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * TreeSet : 중복불가. 정렬 순서를 가지고 있는 Set
 * 
 * Set 인터페이스의 구현클래스. > SortedSet 인터페이스의 구현 클래스
 *  
 */
public class SetEx3 {
	public static void main(String[] args) {
//		TreeSet<String> set = new TreeSet<String>();
		SortedSet<String> set = new TreeSet<String>();
		String from = "bat";
		String to = "d";
		set.add("abc");set.add("bat");set.add("azz");
		set.add("car");set.add("Car");set.add("disc");
		set.add("dance");set.add("dZZZZ");set.add("dzzzz");
		set.add("fan");
		System.out.println(set);
		System.out.println("from:"+from + ",to:" + to);
		System.out.println(set.subSet(from, to));
		System.out.println("from:"+from + ",to:" + to+"zzzz");
		System.out.println(set.subSet(from, to+"zzzz"));
		//대소문자 구분없이 오름 차순 정렬하기.
		//Comparator 인터페이스 객체 : compare 추상메서드.
		// 기본정렬방식 변경할 때 사용되는 객체
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareToIgnoreCase(s2);
			}
		};
		Set<String> set2 = new TreeSet<String>(c);
		set2.add("car");set2.add("Care");set2.add("abc");
		System.out.println("set2="+set2);
		//대소문자 구분없이 내림 차순정렬하기.
		Set<String> set3 = new TreeSet<String>(c.reversed());//jdk 8.0 이후에 가능함
		set3.add("car");set3.add("Care");set3.add("abc");
		System.out.println("set3="+set3);
		//내림 차순정렬하기.
		Set<String> set4 = new TreeSet<String>(Comparator.reverseOrder());//jdk 8.0 이후에 가능함
		set4.add("car");set4.add("Care");set4.add("abc");
		System.out.println("set4="+set4);
	}
}
