package chap15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/*
 * List ���� : ��ü�� �߰��� ������ ������.
 *           �ε��� ��밡����. �����迭�̶�� ��.
 *   ���� Ŭ���� 
 *      ArrayList : List �� ��ǥ Ŭ������. ��� �޼��尡 ����ȭ �Ǿ� ���� ���� 
 *      Vector    : ArrayList�� ���� ����� Ŭ����. ��� �޼��尡 ����ȭ �Ǿ� ����
 *      LinkedList : FiFO�� ������ Ŭ����.         
 */
public class ListEx1 {
	public static void main(String[] args) {
		//<Integer> : ���ظ� ǥ��. Integer ��ü�鸸�� ����.
//		List<Integer> list = new ArrayList<Integer>();
//		List<Integer> list = new Vector<Integer>();
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);	list.add(2);		list.add(5);
		list.add(4);	list.add(3);		list.add(1);
		System.out.println(list);
		for(int i=0;i<list.size();i++) {
			System.out.println(i + "��° ��ü:" + list.get(i));
		}
		//������ for ���� ��밡��
		for(Integer i : list) {
			System.out.println(i);
		}
		//subList(1,4) :1���ε������� 3���ε������� �κ� List ��ü ���ϱ�. 1,2,3�� �ε����� �ش��ϴ� ��ü�� ���� 
		List<Integer> list2 = new ArrayList<Integer>(list.subList(1, 4));
//		List<Integer> list2 = list.subList(1, 4);
		System.out.println("sort ���� list2 :"+list2);
		
		//Collections : Ŭ���� : Collection ��ü���� ���� ����� �����ϰ� �ִ� Ŭ����
		//Collection : �������̽�
		Collections.sort(list); //list ��ü �����ϱ�
		System.out.println("sort ���� list :"+list);
		System.out.println("sort ���� list2 :"+list2);
		System.out.println("list ��ü �� �ִ밪:" + Collections.max(list));
		System.out.println("list ��ü �� �ּҰ�:" + Collections.min(list));
		
		System.out.println("list2 ��ü �� �ִ밪:" + Collections.max(list2));
		System.out.println("list2 ��ü �� �ִ밪�� �ε���:" 
		                       + list2.indexOf(Collections.max(list2)));
		System.out.println(list2.indexOf(6));//-1 : �ش� ��ü ���� ��� -1 ����
	}
}

