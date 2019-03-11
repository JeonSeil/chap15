package chap15;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
 * ListIterator  인터페이스 예제
 *   1. Iterator 인터페이스(next 단방향만 가능)의 하위 인터페이스
 *   2. 양방향 조회 가능.(next, previous 가능)
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
