package chap15;

import java.util.List;
import java.util.Vector;

/*
 * Vector ���� : List ���� Ŭ����. 
 *              Collection �����ӿ�ũ ������ ���Ǵ� Ŭ����.
 *              List �������̽��� �޼���� ������ ���Ǵ� �޼��尡 ȥ�� �Ǿ� ����.
 */
public class ListEx2 {
	public static void main(String[] args) {
		List<Double> list = new Vector();
		list.add(0.3);
		list.add(Math.PI);
//		list.addElement(5.0);  //VectorŬ������ �����. List�� ����� �ƴ�
		list.add(5.0);
		System.out.println(list);
		double num = 5.0;
		int index = list.indexOf(num);
		if(index<0) System.out.println(num + "�� list�� ���� ����Դϴ�.");
		else System.out.println(num+"�� ��ġ�� "+ index + "�Դϴ�.");
		if(list.contains(num)) {
//			list.removeElement(num); //VectorŬ������ �����. List�� ����� �ƴ�
			list.remove(num); //VectorŬ������ �����. List�� ����� �ƴ�
			                  //num ��Ҹ� ����
			System.out.println(num+"������.");
		}
		list.remove(0); //0�� �ε����� ��Ҹ� ����
		System.out.println(list);
		System.out.println(list.get(0));
		List<Integer> list2 = new Vector<Integer>();
		for(int i=1;i<=5;i++) {
			list2.add(i*10);
		}
		System.out.println(list2.remove(0));
		System.out.println(list2.remove(new Integer(30)));
		System.out.println(list2.remove(30));
	}
}
