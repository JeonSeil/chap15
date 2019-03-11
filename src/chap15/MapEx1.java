package chap15;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Map �������̽� : (Key, ��ü)������ ���� ��ü���� ����
 *               �߰��� ����Ű�� �ԷµǸ�, ���� ������ ����ȴ�.=> Ű�� �ߺ� �Ұ�.
 * 
 * ���� Ŭ����
 *   HashMap, Hashtable, TreeMap
 *   Hashtable�� Collection ���� Ŭ������. ����ȭ �Ǿ� �ִ�. Thread�� safe �ϴ�.
 *   HashMap : ����ȭ �Ǿ� ���� �ʴ�. Thread�� unsafe�ϴ�. 
 */
public class MapEx1 {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		String[] names = {"ȫ�浿","���","�̸���","�Ӳ���","���"};
		int[] nums = {1234,4567,2350,9870,3456};
		for(int i=0;i<names.length;i++) {
			map.put(names[i],nums[i]);
		}
		System.out.println(map);
		//Ű���� �ְ� ��ü�� ���� : get
		System.out.println("��� =" + map.get("���"));
		System.out.println("ȫ�浿�� ��ȭ��ȣ:" + map.get("ȫ�浿"));
		System.out.println("�������� ��ȭ��ȣ:" + map.get("������")); // null
		//map���� key�鸸 ��ȸ�ϱ� : keySet()
		Set<String> keys = map.keySet();
		for(String k : keys) {
			System.out.println(k + "=" + map.get(k));
		}
		//map���� values(��ü) �鸸 ��ȸ�ϱ�
		Collection<Integer> values = map.values();
		for(Integer v : values ) {
			System.out.println(v);
		}
		//map ���� (key,value)�� ���� ��ü�� ��ȸ�ϱ�
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		for(Map.Entry<String, Integer> m : entry) {
			System.out.println(m.getKey() + "=" + m.getValue());
			System.out.println(m);
		}
	}
}
