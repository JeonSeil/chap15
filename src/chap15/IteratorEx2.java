package chap15;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
 * ListIterator  �������̽� ����
 *   1. Iterator �������̽�(next �ܹ��⸸ ����)�� ���� �������̽�
 *   2. ����� ��ȸ ����.(next, previous ����)
 */
public class IteratorEx2 {
	public static void main(String[] args) {
		List list = new ArrayList();
		for(int i=1;i<=5;i++) list.add(i*10);
		ListIterator lit = list.listIterator();
		//list = 10,20,30,40,50
		while(lit.hasNext())
			System.out.println(lit.next());
		while(lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
	}
}
