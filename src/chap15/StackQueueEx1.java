package chap15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Stack Ŭ���� : LiFo(Last in First Out). Vector�� ���� Ŭ����
 *    push(Object) : ���ÿ� ��ü�� ����
 *    Object pop()        : ���ÿ� ����� ��ü�� ������ ���� 
 *    Object peek()       : ���ÿ� ����� ��ü�� ��ȸ�Ͽ� ����
 *   
 * Queue �������̽� : jdk5.0 ���Ŀ� Collection �����ӿ�ũ�� �߰���.
 *                 FiFo(First In First Out)
 * ����Ŭ���� : LinkedList
 *    offer(Object) : ť�� ��ü�� ����
 *    Object poll() : ť�� ����� ��ü�� ������ ����
 *    Object peek() : ť�� ����� ��ü�� ��ȸ.   
 *    
 * LinkedList  Ŭ���� : Queue, List �������̽��� ���� ���� Ŭ������.       
 */
public class StackQueueEx1 {
	public static void main(String[] args) {
		String cars[] = {"�ҳ�Ÿ","�׷���","SM5","K9"};
		Stack<String> stack = new Stack<String>();
		for(String s : cars)
			stack.push(s);
		System.out.println("���ÿ� ����� ��ü�� ����:" + stack.size());
		System.out.println(stack.peek());
		System.out.println("���ÿ� ����� ��ü�� ����:" + stack.size());
		System.out.println(stack.pop());
		System.out.println("���ÿ� ����� ��ü�� ����:" + stack.size());
		int cnt = stack.size();
		for(int i=0;i<cnt;i++) 
		   System.out.println(stack.pop());
		System.out.println("���ÿ� ����� ��ü�� ����:" + stack.size());

		Queue<String> queue = new LinkedList<String>();
		for(String s : cars)
			queue.offer(s);
		System.out.println("ť�� ����� ��ü�� ����:" + queue.size());
		System.out.println(queue.peek());
		System.out.println("ť�� ����� ��ü�� ����:" + queue.size());
		System.out.println(queue.poll());
		System.out.println("ť�� ����� ��ü�� ����:" + queue.size());
		cnt = queue.size();
		for(int i=0;i<cnt;i++) 
		   System.out.println(queue.poll());
		System.out.println("ť�� ����� ��ü�� ����:" + queue.size());
	}
}