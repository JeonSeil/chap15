package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/*
 * Properties Ŭ���� => Map��ü
 *   1. Hashtable�� ���� Ŭ����
 *   2. ���׸� ǥ���� ����. => Ű,��ü �� ��� String�� Ŭ����.
 */
public class MapEx3 {
	public static void main(String[] args) throws IOException {
		Properties pr = new Properties();
		//a.properties ������ �б����� ����
		FileInputStream fis = new FileInputStream("a.properties");
		pr.load(fis);
		System.out.println(pr);
		pr.list(System.out);
		System.out.println("keySet()�� �̿��Ͽ� ��ȸ�ϱ�");
		//Ű�鸸 ��ȸ�Ͽ� ȭ�鿡 ����ϱ� : keySet()
		for(Object s : pr.keySet()) {
			System.out.println(s + "=" + pr.get(s));
		}
		//��ü�鸸 ��ȸ�Ͽ� ȭ�鿡 ����ϱ� : values()
		System.out.println("values()�� �̿��Ͽ� ��ȸ�ϱ�");
		for(Object o : pr.values()) {
			System.out.println(o);
		}
		//(Ű,��ü)���� ��ȸ�Ͽ� ȭ�鿡 ����ϱ� : entrySet()
		System.out.println("entrySet()�� �̿��Ͽ� ��ȸ�ϱ�");
		for(Object o : pr.entrySet()) {
			Map.Entry m = (Map.Entry)o;
			System.out.println(o);
		}
	}
}
