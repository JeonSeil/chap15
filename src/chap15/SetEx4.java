package chap15;

import java.util.Comparator;
import java.util.TreeSet;
/*
 * TreeSet ��ü�� ������ ���(��ü)�� �ݵ�� Comparable �������̽��� �����ؾ� �Ѵ�.
 * 
 * ���� ���� �������̽�     �߻�޼���
 * Comparable       compareTo(Object)   : ��ü�� �⺻ ���Ĺ���� ����
 * Comparator       compare(Object, Object) : ���Ĺ���� ���� ����     
 */
class Phone implements Comparable{
	int number;
	String model;
	Phone(int number,String model) {
		this.number = number;
		this.model = model;
	}
	@Override
	public String toString() {
		return "number=" + number + ", model=" + model;
	}
	//��ȭ��ȣ ������ ���� : 
	@Override
	public int compareTo(Object o) { //��� : ��� : this�� o��ü ���� ����, ���� : this o��ü ���� ����
		Phone p = (Phone)o;
		return number - p.number;
	}
}
public class SetEx4 {
	public static void main(String[] args) {
		TreeSet<Phone> set = new TreeSet<Phone>();
		set.add(new Phone(1234,"�Ｚ"));
		set.add(new Phone(5678,"LG"));
		set.add(new Phone(2345,"����"));
		for(Phone p : set)
		   System.out.println(p); 
		System.out.println("��ȭ��ȣ�� �������� �����ϱ�");
		TreeSet<Phone> set2 = new TreeSet<Phone>(Comparator.reverseOrder());
		set2.add(new Phone(1234,"�Ｚ"));
		set2.add(new Phone(5678,"����"));
		set2.add(new Phone(2345,"����"));
		for(Phone p : set2)
		   System.out.println(p); 
		System.out.println("model�� ������������ �����ϱ�");
//		TreeSet<Phone> set3 = new TreeSet<Phone>(new ModelAsc());
		TreeSet<Phone> set3 = new TreeSet<Phone>(new Comparator<Phone>() {
			@Override
			public int compare(Phone p1, Phone p2) {
				return p1.model.compareTo(p2.model);
			}
		});
		set3.add(new Phone(1234,"SAMSUNG"));
		set3.add(new Phone(5678,"LG"));
		set3.add(new Phone(2345,"APPLE"));
		for(Phone p : set3)
		   System.out.println(p); 
	}
}
class ModelAsc implements Comparator<Phone> {
	@Override
	public int compare(Phone p1, Phone p2) {
		return p1.model.compareTo(p2.model);
	}
}

