package chap15;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * TreeSet : �ߺ��Ұ�. ���� ������ ������ �ִ� Set
 * 
 * Set �������̽��� ����Ŭ����. > SortedSet �������̽��� ���� Ŭ����
 *  
 */
public class SetEx3 {
	public static void main(String[] args) {
//		TreeSet<String> set = new TreeSet<String>();
		SortedSet<String> set = new TreeSet<String>();
		String from = "bat";
		String to = "d";
		set.add("abc");set.add("bat");set.add("azz");
		set.add("car");set.add("Car");set.add("disc");
		set.add("dance");set.add("dZZZZ");set.add("dzzzz");
		set.add("fan");
		System.out.println(set);
		System.out.println("from:"+from + ",to:" + to);
		System.out.println(set.subSet(from, to));
		System.out.println("from:"+from + ",to:" + to+"zzzz");
		System.out.println(set.subSet(from, to+"zzzz"));
		//��ҹ��� ���о��� ���� ���� �����ϱ�.
		//Comparator �������̽� ��ü : compare �߻�޼���.
		// �⺻���Ĺ�� ������ �� ���Ǵ� ��ü
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareToIgnoreCase(s2);
			}
		};
		Set<String> set2 = new TreeSet<String>(c);
		set2.add("car");set2.add("Care");set2.add("abc");
		System.out.println("set2="+set2);
		//��ҹ��� ���о��� ���� ���������ϱ�.
		Set<String> set3 = new TreeSet<String>(c.reversed());//jdk 8.0 ���Ŀ� ������
		set3.add("car");set3.add("Care");set3.add("abc");
		System.out.println("set3="+set3);
		//���� ���������ϱ�.
		Set<String> set4 = new TreeSet<String>(Comparator.reverseOrder());//jdk 8.0 ���Ŀ� ������
		set4.add("car");set4.add("Care");set4.add("abc");
		System.out.println("set4="+set4);
	}
}
