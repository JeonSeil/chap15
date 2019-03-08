package chap15;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * 1 ~ 99������ ������ �Է¹޾Ƽ� TreeSet�� �����ϰ�, 0�� �Է��ϸ� �Է��� �����Ѵ�. �� �ߺ��� ���ڴ� �����ϱ�.
 * �Էµ� ���� �����Ͽ� ����ϱ�
 * 
 * set1 �������� ���ĵǵ��� ���.
 * set2 �������� ���ĵǵ��� ����ϱ�. 
 */
public class Exam4 {
	public static void main(String[] args) {
		System.out.println("1���� 99������ ������ �Է��ϼ���");
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
