package chap15;

import java.util.HashSet;
import java.util.Set;

/*
 * 객체의 중복을 판단하는 기준.
 *   equals(Object) : 두객체의 equals 결과가 true 이고
 *   hashCode       : hashCode()의 리턴값이 같은 경우 
 *   => 두개의 객체를 동일한 것으로 간주함.
 */
class Person {
	String name;
	int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person)obj;
			return name.equals(p.name) && age == p.age;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}	
}
public class SetEx2 {
	public static void main(String[] args) {
		Set<Object> set = new HashSet<Object>();
		set.add(new String("홍길동"));
		set.add(new String("홍길동"));
		set.add(new Person("김삿갓",30));
		set.add(new Person("김삿갓",30));
		System.out.println(set);
	}
}