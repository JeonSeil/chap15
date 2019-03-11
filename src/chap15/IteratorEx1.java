package chap15;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/*
 * Iterator �������̽� : ��ȸ ���� ��ü. �ݺ���.
 *    Collection ��ü�� Iterator ��ü�� ��ȯ�� �����ϴ�.=> iterator() �޼��带 �̿�
 *    �޼���
 *      boolean hasNext() : ��ȸ ��� ��ü ����?
 *      Object next()     : ��ȸ�Ͽ� ��ü ����
 *      void remove()   : ��ȸ�� ��ü�� ����. next() ���Ŀ� ��� ������.
 *      
 *  Enumeration �������̽� : Iterator�� ������. Collection �����ӿ�ũ ������ ���Ǵ� �ݺ���.
 *      Vector, Hashtable Ŭ���������� ����� ������.
 *  �޼���
 *     boolean hasMoreElement() :��ȸ ��� ��ü ����?
 *     Object nextElement()    : ��ȸ�Ͽ� ��ü ����.           
 */
public class IteratorEx1 {
	public static void main(String[] args) {
		Iterator it = null;
		List list = new ArrayList();
		Set set = new HashSet();
		for(int i=1;i<=5;i++) {
			list.add(i*10);
			set.add(i*100);
		}
		it = list.iterator();
		print(it);
		it = set.iterator();
		print(it);
		System.out.println(list);
		System.out.println(set);
		Vector vlist = new Vector();
		for(int i=1;i<=5;i++) {
			vlist.add(i*10);
		}
		//vlist = 10,20,30,40,50 
		System.out.println("Enumeration �ݺ��� ����");
		Enumeration e = vlist.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		e = vlist.elements();
		System.out.println(e.nextElement());
		it = vlist.iterator();
	}
	private static void print(Iterator it) {
		while(it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}
	}
}
