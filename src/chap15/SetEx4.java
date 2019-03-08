package chap15;

import java.util.Comparator;
import java.util.TreeSet;
/*
 * TreeSet 객체에 저장할 요소(객체)는 반드시 Comparable 인터페이스를 구현해야 한다.
 * 
 * 정렬 관련 인터페이스     추상메서드
 * Comparable       compareTo(Object)   : 객체별 기본 정렬방식을 지정
 * Comparator       compare(Object, Object) : 정렬방식을 따로 지정     
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
	//전화번호 순으로 정렬 : 
	@Override
	public int compareTo(Object o) { //결과 : 양수 : this가 o객체 보다 뒤쪽, 음수 : this o객체 보다 앞쪽
		Phone p = (Phone)o;
		return number - p.number;
	}
}
public class SetEx4 {
	public static void main(String[] args) {
		TreeSet<Phone> set = new TreeSet<Phone>();
		set.add(new Phone(1234,"삼성"));
		set.add(new Phone(5678,"LG"));
		set.add(new Phone(2345,"애플"));
		for(Phone p : set)
		   System.out.println(p); 
		System.out.println("전화번호의 역순으로 정렬하기");
		TreeSet<Phone> set2 = new TreeSet<Phone>(Comparator.reverseOrder());
		set2.add(new Phone(1234,"삼성"));
		set2.add(new Phone(5678,"엘쥐"));
		set2.add(new Phone(2345,"애플"));
		for(Phone p : set2)
		   System.out.println(p); 
		System.out.println("model의 오름차순으로 정렬하기");
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

