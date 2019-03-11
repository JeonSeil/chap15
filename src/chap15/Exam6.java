package chap15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 1. HashMap ��ü�� (�����̸�,������)������ �����ϱ�.
 *    (���ѹα�,����),(ĳ����,��Ÿ��),(����,����),(������,����) ��ü�� �����ϴ� ���α׷� �ۼ��ϱ�.
 * 2. ȭ�鿡�� �����̸��� �Է¹޾Ƽ�, �Է¹��� ������ ������ ����ϱ�.
 *    => �Էµ��� ���� ���� "������ ��ϵ� ���� �ƴմϴ�." ����ϱ�.  
 * 3. ��ϵ� ���� �ƴ� ���  map ��ü�� ����� ������ ����ϱ�.
 *    �ٽ� ���� ��ȸ�� �� �� �ֵ��� �ݺ������� ó���ϱ�.
 *    ���� �����̸��� "��" ���� �ԷµǸ� 
 *    �������� ���� ��ϵ� ������ ������ for ������ �̿��Ͽ� ����ϰ� ���α׷� �����ϱ�.     
 */
public class Exam6 {
	public static void main(String[] args) {
		//1.
		Map<String,String> map = new HashMap<String,String>();
		map.put("���ѹα�","����");
		map.put("ĳ����","��Ÿ��");
		map.put("����","����");
		map.put("������","����");
		System.out.println(map);
		//2.
//		String s = new Scanner(System.in).next();
//		System.out.println((map.get(s)==null)?"������ ��ϵ� ���� �ƴմϴ�.":map.get(s));
		//3.
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("�����̸��� �Է��ϼ���");
			String input = scan.nextLine();
			if(input.equals("��")) {
				break;
			}
			String value = map.get(input); //������
			if(value == null) {
				System.out.println("��ϵ� ���� �ƴմϴ�. ������ ����ϼ���");
				String cap = scan.nextLine(); //�����̸�
				map.put(input, cap);
			} else {
				System.out.println(input + "�� ����:" + value);
				System.out.println("��ϵ� ���� �����Ǵ»����ϰڽ��ϱ�(����(U)/����(D))");
				String ud = scan.nextLine();
				if(ud.equalsIgnoreCase("U")) {
					System.out.println("������ �����̸��� ����ϼ���");
					String cap = scan.nextLine(); //�����̸�
					map.put(input, cap);
				} else if(ud.equalsIgnoreCase("D")) {
					map.remove(input);
					System.out.println(input + "���� ����� ���� �߽��ϴ�.");
				}
			}
		}
		for(String k : map.keySet()) {
			System.out.println(k + "�� ����:" + map.get(k));
		}
		for(Map.Entry<String, String> m : map.entrySet()) {
			System.out.println(m.getKey() + "�� ����:" + m.getValue());
		}
	}
}
