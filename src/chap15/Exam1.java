package chap15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
 * ȭ�鿡�� 5���� ������ �Է¹޾Ƽ� ��հ� �߰����� ����ϰ�, �ְ����� ���� �л��� �ε����� ����ϱ�
 * 
 * 50 60 60 40 70  4���ε����� �ְ�����  
 * 40 50 60 60 70  �߰���: 60��
 * 
 * ArrayList ��ü�� �̿��ϱ�. ����ȯ, ������
 */
public class Exam1 {
	public static void main(String[] args) {
		int sum =0;
		List<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.println("�л� 5���� ������ �Է��ϼ���.");
		for(int i=0; i<5; i++) {
			list.add(scan.nextInt());
		}
		System.out.println("�ִ밪�� �ε���: " + list.indexOf(Collections.max(list)));
		Collections.sort(list);
		for(Integer i : list) {
			System.out.print(i+" ");
			sum += i;
		}
		System.out.println("\n�߰���: "+list.get(2)+"��հ� :"+(double)sum/list.size());
	}
}
