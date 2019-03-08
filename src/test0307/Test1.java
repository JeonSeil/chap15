package test0307;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 SutdaCard 20������ �̷���� SutdaDeck Ŭ���� �����ϱ�
  1. ��� ����
      SutdaCard 20���� ������ �ִ�. 
      SutdaCard�� ���� ���� ī�带 2�徿 �� 20������ �̷���� �ִ�.
      ���� 1,3,8��ȣ�� ī��� ���� �� ������ ���� ī���.
  2. ������
      �Ű������� ����, SutdaCard 20���� �����Ͽ� ��� ������ List�� �����ϱ�
  3. �޼���
    a. void shuffle() 
       ��� : ī���� ��ġ�� �ڼ��´�.
    b. SutdaCard pick(int index)
       ��� : index�� �ش��ϴ� ī�� ������ ��ȯ�Ѵ�.          
    c. SutdaCard pick()
       ��� : ������ ī�� ������ ��ȯ�Ѵ�.          

  ���� Ŭ������ �����Ҷ� ���
1:1K,2,3K,4,5,6,7,8K,9,10,1,2,3,4,5,6,7,8,9,10
2:5,6,6,8K,4,2,8,3K,3,9,10,7,9,1,5,1K,4,10,2,7
3:5
4:4

�� 2,3,4 ���� �����ϰ� ��µȴ�.
*/
class SutdaDeck {
	List<SutdaCard> cards;
	SutdaDeck() {
		cards =  new ArrayList<SutdaCard>();
		for(int i=0;i < 20;i++) {
			cards.add(new SutdaCard(i%10+1,(i==0||i==2||i==7)?true:false));
		}
	}
	void shuffle() {
		Collections.shuffle(cards);
	}
	public String toString() {
		String s = "";
		for(int i=0;i<cards.size();i++) {
			s += cards.get(i) + ((i==cards.size()-1)?"":",");
		}
		return s;
	}
	SutdaCard pick(int index) {
		return cards.get(index);
	}
	SutdaCard pick() {
		return cards.get((int)(Math.random()*cards.size()));
	}
}
class SutdaCard {
	int number;
	boolean isKwang;
	SutdaCard(int number,boolean isKwang) {
		this.number = number;
		this.isKwang = isKwang;
	}
	public String toString() {
		 return number + (isKwang?"K":"");	
	}
}
public class Test1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		System.out.println("1:" + deck);
		deck.shuffle();
		System.out.println("2:" + deck);
		System.out.println("3:" + deck.pick(0));
		System.out.println("4:" + deck.pick());
	}
}