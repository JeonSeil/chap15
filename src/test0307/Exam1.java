package test0307;

import java.util.ArrayList;
import java.util.List;

/*
생산자 스레드, 소비자 스레드 문제
   CarMarket 클래스 : 자동차 판매소
     멤버 변수 : List<String> carList;
     멤버메서드 :
        String getCar() : 임의의 자동차를 선택 리턴
        synchronized String push() : getCar() 메서드에서 리턴된 자동차를 carList에 저장하는 기능
        synchronized String pop() : carList변수에서 첫번째 자동차 제거하여 리턴 기능
  
   Seller 클래스 : 판매원. Thread 클래스 상속
      멤버메서드 : run()
          carList에 객체가 존재하면 pop 메서드 호출하기.
          carList에 객체가 없으면 wait()
          0 ~ 2000밀리초를 임의로 sleep()
   Producer 클래스 : 자동차 공급자. Thread 클래스 상속       
      멤버메서드 : run()
          push() 메서드 호출하여 carList에 객체를 add함.
          carList 객체가 존재하면 notifyAll() 함.
          0 ~ 5000밀리초를 임의로 sleep()
 */
class CarMarket {
	List<String> carList = new ArrayList<String>();
	String getCar() {
		String[] car = {"소나타","아반떼","그랜저","산타페","제네시스"};
		return car[(int)(Math.random() * car.length)];
	}
	synchronized String push() {
		String car = getCar();
		carList.add(car);
		notifyAll();
		System.out.println
		   (Thread.currentThread().getName() + ":" + car + "입고됨");
		return car;
	}
	synchronized String pop() {
		while(carList.size() == 0) {
			System.out.println("판매할 자동차가 없음." 
		               + Thread.currentThread().getName() + "wait 상태!");
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		System.out.println(Thread.currentThread().getName() + ":" 
		+ carList.get(0) + "자동차가 판매됨");
		return carList.remove(0);
	}
}
class Seller extends Thread {
	CarMarket market;
	Seller(CarMarket market){
		super("판매원 스레드");
		this.market = market;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			market.pop();
			try {
				sleep((int)(Math.random() * 2000));
			} catch(InterruptedException e) {}
		}
	}
}
class Producer extends Thread{
	CarMarket market;
	Producer(CarMarket market){
		super("생산자 스레드");
		this.market = market;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			market.push();
			try {
				sleep((int)(Math.random() * 5000));
			} catch(InterruptedException e) {}
		}
	}
}
public class Exam1 {
	public static void main(String[] args) {
		CarMarket m = new CarMarket();
		Thread t1 = new Seller(m);
		Thread t2 = new Producer(m);
		t1.start(); t2.start();
	}
}

