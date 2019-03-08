package chap15;

import java.util.TreeSet;

/*
 * TreeSet�� �̿��Ͽ� Lotto ��ȣ 6�� �����ϱ�
 * 1 ~ 45�� �� 6���� �����Ͽ� TreeSet�� �����ϰ� ����ϱ�
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
