package chap15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Stack 클래스 : LiFo(Last in First Out). Vector의 하위 클래스
 *    push(Object) : 스택에 객체를 저장
 *    Object pop()        : 스택에 저장된 객체를 꺼내서 리턴 
 *    Object peek()       : 스택에 저장된 객체를 조회하여 리턴
 *   
 * Queue 인터페이스 : jdk5.0 이후에 Collection 프레임워크에 추가됨.
 *                 FiFo(First In First Out)
 * 구현클래스 : LinkedList
 *    offer(Object) : 큐에 객체를 저장
 *    Object poll() : 큐에 저장된 객체를 꺼내서 리턴
 *    Object peek() : 큐에 저장된 객체를 조회.   
 *    
 * LinkedList  클래스 : Queue, List 인터페이스를 다중 구현 클래스임.       
 */
public class StackQueueEx1 {
	public static void main(String[] args) {
		String cars[] = {"소나타","그랜저","SM5","K9"};
		Stack<String> stack = new Stack<String>();
		for(String s : cars)
			stack.push(s);
		System.out.println("스택에 저장된 객체의 갯수:" + stack.size());
		System.out.println(stack.peek());
		System.out.println("스택에 저장된 객체의 갯수:" + stack.size());
		System.out.println(stack.pop());
		System.out.println("스택에 저장된 객체의 갯수:" + stack.size());
		int cnt = stack.size();
		for(int i=0;i<cnt;i++) 
		   System.out.println(stack.pop());
		System.out.println("스택에 저장된 객체의 갯수:" + stack.size());

		Queue<String> queue = new LinkedList<String>();
		for(String s : cars)
			queue.offer(s);
		System.out.println("큐에 저장된 객체의 갯수:" + queue.size());
		System.out.println(queue.peek());
		System.out.println("큐에 저장된 객체의 갯수:" + queue.size());
		System.out.println(queue.poll());
		System.out.println("큐에 저장된 객체의 갯수:" + queue.size());
		cnt = queue.size();
		for(int i=0;i<cnt;i++) 
		   System.out.println(queue.poll());
		System.out.println("큐에 저장된 객체의 갯수:" + queue.size());
	}
}