package chap15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/*
 * List 예제 : 객체를 추가한 순서를 유지함.
 *           인덱스 사용가능함. 가변배열이라고 함.
 *   구현 클래스 
 *      ArrayList : List 의 대표 클래스임. 모든 메서드가 동기화 되어 있지 않음 
 *      Vector    : ArrayList와 같은 기능의 클래스. 모든 메서드가 동기화 되어 있음
 *      LinkedList : FiFO를 구현한 클래스.         
 */
public class ListEx1 {
	public static void main(String[] args) {
		//<Integer> : 제넥릭 표현. Integer 객체들만의 모임.
//		List<Integer> list = new ArrayList<Integer>();
//		List<Integer> list = new Vector<Integer>();
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);	list.add(2);		list.add(5);
		list.add(4);	list.add(3);		list.add(1);
		System.out.println(list);
		for(int i=0;i<list.size();i++) {
			System.out.println(i + "번째 객체:" + list.get(i));
		}
		//개선된 for 구문 사용가능
		for(Integer i : list) {
			System.out.println(i);
		}
		//subList(1,4) :1번인덱스부터 3번인덱스까지 부분 List 객체 구하기. 1,2,3번 인덱스에 해당하는 객체만 저장 
		List<Integer> list2 = new ArrayList<Integer>(list.subList(1, 4));
//		List<Integer> list2 = list.subList(1, 4);
		System.out.println("sort 이전 list2 :"+list2);
		
		//Collections : 클래스 : Collection 객체들을 여러 기능을 저장하고 있는 클래스
		//Collection : 인터페이스
		Collections.sort(list); //list 객체 정렬하기
		System.out.println("sort 이후 list :"+list);
		System.out.println("sort 이후 list2 :"+list2);
		System.out.println("list 객체 중 최대값:" + Collections.max(list));
		System.out.println("list 객체 중 최소값:" + Collections.min(list));
		
		System.out.println("list2 객체 중 최대값:" + Collections.max(list2));
		System.out.println("list2 객체 중 최대값의 인덱스:" 
		                       + list2.indexOf(Collections.max(list2)));
		System.out.println(list2.indexOf(6));//-1 : 해당 객체 없는 경우 -1 리턴
	}
}

