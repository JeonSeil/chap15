package chap15;

import java.util.Scanner;
import java.util.Vector;

/*
 *  텍스트기반의 타자연습게임 프로그램 작성하
 *  WordGenerator라는 스레드를 이용하여  2초마다 단어를  하나씩 추가함.
 *  사용자가 단어를 입력하면  Vector에서 일치하는 단어를  Vector에서 삭제하도록 함. 
 *  모든 데이터가 삭제되면 프로그램이 종료
 */
public class WordGame {
	Vector<String> words = new Vector<String>();
	public static void main(String args[]) {
		WordGame game = new WordGame();
		game.play();
		System.out.println("프로그램 종료");
	} 
	private void play() {
		WordGenerator wg = new WordGenerator(); //Thread 생성 
		wg.start();
	    words.add(wg.data[(int)(Math.random() * wg.data.length)]);
		while (true) {
			System.out.println(words);
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();
			int index = words.indexOf(input);
			if (index != -1) {
				words.remove(index);
			}
			if(words.size() == 0) break;
		}
	}
	class WordGenerator extends Thread {
		final int interval = 2 * 1000; // 2초
		String[] data = { "java", "sql", "jsp", "mybatis", "sitemesh", 
		          "mariadb", "xml", "json", "html" ,"spring",
		          "jquery","css","hadoop"};
		WordGenerator() {
			setDaemon(true); //데몬 스레드
		}
		public void run() {
			while(true) {
			  try {
				sleep(interval);
			  } catch (InterruptedException e) {
				e.printStackTrace();
			  }
			  words.add(data[(int)(Math.random() * data.length)]);
			}
		}
	}
}
