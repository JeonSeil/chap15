package chap15;

import java.util.TreeSet;

/*
 * TreeSet을 이용하여 Lotto 번호 6개 생성하기
 * 1 ~ 45번 중 6개를 선택하여 TreeSet에 저장하고 출력하기
 */
public class Exam3 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		while(set.size() < 6) {
			set.add((int)(Math.random()*45)+1);
		}
		System.out.println(set);
	}
}
