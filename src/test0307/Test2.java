package test0307;

import java.util.Scanner;
import java.util.Vector;

/*
 * WordGame Ŭ���� ��� �߰��ϱ�.
 * 1. �ܰ� �߰��ϱ� : 1 �ܰ�: 5�ʸ��� �߰� ... 5�ܰ� : 1�ʸ��� �ܾ� �߰��ϱ�
 * 2. ����, �ѱ� �����ϵ��� �߰��ϱ�.  
 */
public class Test2 {
	Vector<String> words;
	public static void main(String args[]) {
		Test2 game = new Test2();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("���ϴ� �ܰ踦 �����ϼ���.(1~5)");
			System.out.println("\t1�ܰ�:5�ʸ��� �ܾ� �߰�");
			System.out.println("\t2�ܰ�:4�ʸ��� �ܾ� �߰�");
			System.out.println("\t3�ܰ�:3�ʸ��� �ܾ� �߰�");
			System.out.println("\t4�ܰ�:2�ʸ��� �ܾ� �߰�");
			System.out.println("\t5�ܰ�:1�ʸ��� �ܾ� �߰�");
			int level = scan.nextInt();
			System.out.println("�ѱۿ����� �Ͻðڽ��ϱ�?(�ѱ�:Y)");
			String kbn = scan.next();
			game.play(level, kbn);
			System.out.println("������ ��� �Ͻðڽ��ϱ�?(Y)");
			String yn = scan.next();
			if (yn.equalsIgnoreCase("y"))
				continue;
			else
				break;
		}
		System.out.println("���α׷� ����");
	}

	private void play(int level, String kbn) {
		words= new Vector<String>();
		WordGenerator wg = new WordGenerator(level, kbn.equalsIgnoreCase("y")); // Thread ����
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
		final String[] hans = { "�ڹ�", "����ť��", "���̿�����", "���̹�Ƽ��", "����Ʈ�޽�", "�����Ƶ��", "��������", "���̼�", "�����뿥��", "������", "��������",
				"����������", "�ϵ�" };
		String[] data;
		boolean stopable = true;
		String haneng = "�ѱ�";
		WordGenerator(int level, boolean kbn) {
			interval = (5-level+1) * 1000;
			System.out.println(interval);
			if (kbn) {
				data = hans;
			}else {
				haneng = "����";
				data = engs;
			}
			setDaemon(true); // ���� ������
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
			System.out.println(haneng + "������ ����");
		}
	}
}