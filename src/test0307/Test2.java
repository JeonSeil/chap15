package test0307;

import java.util.Scanner;
import java.util.Vector;

/*
 * WordGame 클래스 기능 추가하기.
 * 1. 단계 추가하기 : 1 단계: 5초마다 추가 ... 5단계 : 1초마다 단어 추가하기
 * 2. 영문, 한글 선택하도록 추가하기.  
 */
public class Test2 {
	Vector<String> words;
	public static void main(String args[]) {
		Test2 game = new Test2();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("원하는 단계를 선택하세요.(1~5)");
			System.out.println("\t1단계:5초마다 단어 추가");
			System.out.println("\t2단계:4초마다 단어 추가");
			System.out.println("\t3단계:3초마다 단어 추가");
			System.out.println("\t4단계:2초마다 단어 추가");
			System.out.println("\t5단계:1초마다 단어 추가");
			int level = scan.nextInt();
			System.out.println("한글연습을 하시겠습니까?(한글:Y)");
			String kbn = scan.next();
			game.play(level, kbn);
			System.out.println("게임을 계속 하시겠습니까?(Y)");
			String yn = scan.next();
			if (yn.equalsIgnoreCase("y"))
				continue;
			else
				break;
		}
		System.out.println("프로그램 종료");
	}

	private void play(int level, String kbn) {
		words= new Vector<String>();
		WordGenerator wg = new WordGenerator(level, kbn.equalsIgnoreCase("y")); // Thread 생성
		wg.start();
		words.add(wg.data[(int) (Math.random() * wg.data.length)]);
		while (true) {
			System.out.println(words);
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();
			int index = words.indexOf(input);
			if (index != -1) {
				words.remove(index);
			}
			if (words.size() == 0)
				break;
		}
		wg.stopable = false;
	}

	class WordGenerator extends Thread {
		final int interval;
		final String[] engs = { "java", "sql", "jsp", "mybatis", "sitemesh", "mariadb", "xml", "json", "html", "spring",
				"jquery", "css", "hadoop" };
		final String[] hans = { "자바", "에스큐엘", "제이에스피", "마이바티스", "사이트메쉬", "마리아디비", "엑스엠엘", "제이손", "에이취엠엘", "스프링", "제이쿼리",
				"씨에스에스", "하둡" };
		String[] data;
		boolean stopable = true;
		String haneng = "한글";
		WordGenerator(int level, boolean kbn) {
			interval = (5-level+1) * 1000;
			System.out.println(interval);
			if (kbn) {
				data = hans;
			}else {
				haneng = "영어";
				data = engs;
			}
			setDaemon(true); // 데몬 스레드
		}
		public void run() {
			while (stopable) {
				try {
					sleep(interval);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				words.add(data[(int) (Math.random() * data.length)]);
			}
			words.clear();
			System.out.println(haneng + "스레드 종료");
		}
	}
}