package chap15;

import java.util.TreeMap;

/*
 * TreeMap 예제 : Key값으로 정렬.
 */
public class MapEx2 {
	public static void main(String[] args) {
		TreeMap<Integer,String> scores = new TreeMap<Integer,String>();
		scores.put(87,"홍길동");		scores.put(98,"이몽룡");
		scores.put(75,"임꺽정");		scores.put(94,"김삿갓");
		scores.put(80,"성춘향");		scores.put(88,"향단이");
		System.out.println(scores);
		System.out.println("첫번째 key :" + scores.firstKey());
		System.out.println("첫번째 entry (최저점) :" 
             + scores.firstEntry().getKey() + "=" + scores.firstEntry().getValue());
		System.out.println("마지막 entry (최고점):" 
             + scores.lastEntry().getKey() + "=" + scores.lastEntry().getValue());
		System.out.println("95점 아래 점수:" 
             + scores.lowerEntry(95).getKey() + "=" + scores.lowerEntry(95).getValue());
		System.out.println("95점 위 점수:" 
             + scores.higherEntry(95).getKey() + "=" + scores.higherEntry(95).getValue());
		System.out.println("95점 바로 아래 점수(95점 포함):" 
             + scores.floorEntry(95).getKey() + "=" + scores.floorEntry(95).getValue());
		System.out.println("95점 바로 위 점수(95점 포함):" 
             + scores.ceilingEntry(95).getKey() + "=" + scores.ceilingEntry(95).getValue());
	}
}
