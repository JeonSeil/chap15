package chap15;

import java.util.TreeMap;

/*
 * TreeMap ���� : Key������ ����.
 */
public class MapEx2 {
	public static void main(String[] args) {
		TreeMap<Integer,String> scores = new TreeMap<Integer,String>();
		scores.put(87,"ȫ�浿");		scores.put(98,"�̸���");
		scores.put(75,"�Ӳ���");		scores.put(94,"���");
		scores.put(80,"������");		scores.put(88,"�����");
		System.out.println(scores);
		System.out.println("ù��° key :" + scores.firstKey());
		System.out.println("ù��° entry (������) :" 
             + scores.firstEntry().getKey() + "=" + scores.firstEntry().getValue());
		System.out.println("������ entry (�ְ���):" 
             + scores.lastEntry().getKey() + "=" + scores.lastEntry().getValue());
		System.out.println("95�� �Ʒ� ����:" 
             + scores.lowerEntry(95).getKey() + "=" + scores.lowerEntry(95).getValue());
		System.out.println("95�� �� ����:" 
             + scores.higherEntry(95).getKey() + "=" + scores.higherEntry(95).getValue());
		System.out.println("95�� �ٷ� �Ʒ� ����(95�� ����):" 
             + scores.floorEntry(95).getKey() + "=" + scores.floorEntry(95).getValue());
		System.out.println("95�� �ٷ� �� ����(95�� ����):" 
             + scores.ceilingEntry(95).getKey() + "=" + scores.ceilingEntry(95).getValue());
	}
}
