package chap15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 1. HashMap 객체에 (나라이름,수도명)쌍으로 저장하기.
 *    (대한민국,서울),(캐나다,오타와),(영국,런던),(스위스,베른) 객체를 저장하는 프로그램 작성하기.
 * 2. 화면에서 나라이름을 입력받아서, 입력받은 나라의 수도를 출력하기.
 *    => 입력되지 않은 경우는 "수도가 등록된 나라가 아닙니다." 출력하기.  
 * 3. 등록된 나라가 아닌 경우  map 객체에 나라와 수도를 등록하기.
 *    다시 수도 조회를 할 수 있도록 반복문으로 처리하기.
 *    만약 나라이름에 "끝" 내용 입력되면 
 *    종료전에 현재 등록된 내용을 개선된 for 구문을 이용하여 출력하고 프로그램 종료하기.     
 */
public class Exam6 {
	public static void main(String[] args) {
		//1.
		Map<String,String> map = new HashMap<String,String>();
		map.put("대한민국","서울");
		map.put("캐나다","오타와");
		map.put("영국","런던");
		map.put("스위스","베른");
		System.out.println(map);
		//2.
//		String s = new Scanner(System.in).next();
//		System.out.println((map.get(s)==null)?"수도가 등록된 나라가 아닙니다.":map.get(s));
		//3.
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("나라이름을 입력하세요");
			String input = scan.nextLine();
			if(input.equals("끝")) {
				break;
			}
			String value = map.get(input); //수도명
			if(value == null) {
				System.out.println("등록된 나라가 아닙니다. 수도를 등록하세요");
				String cap = scan.nextLine(); //수도이름
				map.put(input, cap);
			} else {
				System.out.println(input + "의 수도:" + value);
				System.out.println("등록된 나라를 수정또는삭제하겠습니까(수정(U)/삭제(D))");
				String ud = scan.nextLine();
				if(ud.equalsIgnoreCase("U")) {
					System.out.println("수정할 수도이름을 등록하세요");
					String cap = scan.nextLine(); //수도이름
					map.put(input, cap);
				} else if(ud.equalsIgnoreCase("D")) {
					map.remove(input);
					System.out.println(input + "나라 등록을 삭제 했습니다.");
				}
			}
		}
		for(String k : map.keySet()) {
			System.out.println(k + "의 수도:" + map.get(k));
		}
		for(Map.Entry<String, String> m : map.entrySet()) {
			System.out.println(m.getKey() + "의 수도:" + m.getValue());
		}
	}
}
