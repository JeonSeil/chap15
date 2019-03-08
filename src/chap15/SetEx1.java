package chap15;

import java.util.HashSet;
import java.util.Set;

/*
 * Set : Collection 인터페이스의 하위 인터페이스
 *     => 중복불가
 *     구현클래스 : HashSet : 순서모름 
 *               TreeSet : 정렬됨.
 *  객체 추가 : boolean add(Object)
 *        true : 추가 성공
 *        false : 추가 실패             
 *  순서유지가 안되므로 인덱스를 통해 객체를 꺼낼 수 없다. => 개선된 for 구문 사용은 가능함      
 */
public class SetEx1 {
	public static void main(String[] args) {
		Object[] arr = {"1",1,"2","3","3","4","4","2","4"};
		Set<Object> set1 = new HashSet<Object>();
		Set<Object> set2 = new HashSet<Object>();
		Set<Object> set3 = new HashSet<Object>();
		for(int i=0;i<arr.length;i++) {
			if(!set1.add(arr[i])) {
				if(!set2.add(arr[i])) {
					set3.add(arr[i]);
				}
			}
		}
		System.out.println(set1);
		System.out.println(set2);
		System.out.println(set3);
		for(Object o : set1) {
			System.out.println(o);
		}
	}
}
