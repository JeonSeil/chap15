package chap15;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * 1 ~ 99까지의 정수를 입력받아서 TreeSet에 저장하고, 0을 입력하면 입력을 종료한다. 단 중복된 숫자는 무시하기.
 * 입력된 값을 정렬하여 출력하기
 * 
 * set1 오름차순 정렬되도록 출력.
 * set2 내림차순 정렬되도록 출력하기. 
 */
public class Exam4 {
	public static void main(String[] args) {
		System.out.println("1부터 99까지의 정수를 입력하세요");
		Scanner sc = new Scanner(System.in);
		int input;
		TreeSet<Integer> set1 = new TreeSet<Integer>();
		TreeSet<Integer> set2 = new TreeSet<Integer>(Comparator.reverseOrder());
		while((input = sc.nextInt())!=0) {
			set1.add(input);
			set2.add(input);
		}
		System.out.println("set1=" + set1);
		System.out.println("set2=" + set2);		
	}
}
