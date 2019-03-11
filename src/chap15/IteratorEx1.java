package chap15;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/*
 * Iterator 인터페이스 : 조회 전용 객체. 반복자.
 *    Collection 객체는 Iterator 객체로 변환이 가능하다.=> iterator() 메서드를 이용
 *    메서드
 *      boolean hasNext() : 조회 대상 객체 존재?
 *      Object next()     : 조회하여 객체 리턴
 *      void remove()   : 조회된 객체를 제거. next() 이후에 사용 가능함.
 *      
 *  Enumeration 인터페이스 : Iterator의 구버전. Collection 프레임워크 이전에 사용되던 반복자.
 *      Vector, Hashtable 클래스에서만 사용이 가능함.
 *  메서드
 *     boolean hasMoreElement() :조회 대상 객체 존재?
 *     Object nextElement()    : 조회하여 객체 리턴.           
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
		System.out.println("Enumeration 반복자 연습");
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
