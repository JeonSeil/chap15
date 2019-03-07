package chap15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
 * 화면에서 5명의 점수를 입력받아서 평균과 중간값을 출력하고, 최고점을 받은 학생의 인덱스를 출력하기
 * 
 * 50 60 60 40 70  4번인덱스가 최고점임  
 * 40 50 60 60 70  중간값: 60점
 * 
 * ArrayList 객체를 이용하기. 차기환, 정찬웅
 */
public class Exam1 {
	public static void main(String[] args) {
		int sum =0;
		List<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.println("학생 5명의 점수를 입력하세요.");
		for(int i=0; i<5; i++) {
			list.add(scan.nextInt());
		}
		System.out.println("최대값의 인덱스: " + list.indexOf(Collections.max(list)));
		Collections.sort(list);
		for(Integer i : list) {
			System.out.print(i+" ");
			sum += i;
		}
		System.out.println("\n중간값: "+list.get(2)+"평균값 :"+(double)sum/list.size());
	}
}
