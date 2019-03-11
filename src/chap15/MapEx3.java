package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/*
 * Properties 클래스 => Map객체
 *   1. Hashtable의 하위 클래스
 *   2. 제네릭 표현을 안함. => 키,객체 가 모두 String인 클래스.
 */
public class MapEx3 {
	public static void main(String[] args) throws IOException {
		Properties pr = new Properties();
		//a.properties 파일을 읽기위한 설정
		FileInputStream fis = new FileInputStream("a.properties");
		pr.load(fis);
		System.out.println(pr);
		pr.list(System.out);
		System.out.println("keySet()를 이용하여 조회하기");
		//키들만 조회하여 화면에 출력하기 : keySet()
		for(Object s : pr.keySet()) {
			System.out.println(s + "=" + pr.get(s));
		}
		//객체들만 조회하여 화면에 출력하기 : values()
		System.out.println("values()를 이용하여 조회하기");
		for(Object o : pr.values()) {
			System.out.println(o);
		}
		//(키,객체)들을 조회하여 화면에 출력하기 : entrySet()
		System.out.println("entrySet()를 이용하여 조회하기");
		for(Object o : pr.entrySet()) {
			Map.Entry m = (Map.Entry)o;
			System.out.println(o);
		}
	}
}
