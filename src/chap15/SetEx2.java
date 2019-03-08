package chap15;

import java.util.HashSet;
import java.util.Set;

/*
 * ��ü�� �ߺ��� �Ǵ��ϴ� ����.
 *   equals(Object) : �ΰ�ü�� equals ����� true �̰�
 *   hashCode       : hashCode()�� ���ϰ��� ���� ��� 
 *   => �ΰ��� ��ü�� ������ ������ ������.
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
		set.add(new String("ȫ�浿"));
		set.add(new String("ȫ�浿"));
		set.add(new Person("���",30));
		set.add(new Person("���",30));
		System.out.println(set);
	}
}