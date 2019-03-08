package test0307;

import java.util.ArrayList;
import java.util.List;

/*
������ ������, �Һ��� ������ ����
   CarMarket Ŭ���� : �ڵ��� �Ǹż�
     ��� ���� : List<String> carList;
     ����޼��� :
        String getCar() : ������ �ڵ����� ���� ����
        synchronized String push() : getCar() �޼��忡�� ���ϵ� �ڵ����� carList�� �����ϴ� ���
        synchronized String pop() : carList�������� ù��° �ڵ��� �����Ͽ� ���� ���
  
   Seller Ŭ���� : �Ǹſ�. Thread Ŭ���� ���
      ����޼��� : run()
          carList�� ��ü�� �����ϸ� pop �޼��� ȣ���ϱ�.
          carList�� ��ü�� ������ wait()
          0 ~ 2000�и��ʸ� ���Ƿ� sleep()
   Producer Ŭ���� : �ڵ��� ������. Thread Ŭ���� ���       
      ����޼��� : run()
          push() �޼��� ȣ���Ͽ� carList�� ��ü�� add��.
          carList ��ü�� �����ϸ� notifyAll() ��.
          0 ~ 5000�и��ʸ� ���Ƿ� sleep()
 */
class CarMarket {
	List<String> carList = new ArrayList<String>();
	String getCar() {
		String[] car = {"�ҳ�Ÿ","�ƹݶ�","�׷���","��Ÿ��","���׽ý�"};
		return car[(int)(Math.random() * car.length)];
	}
	synchronized String push() {
		String car = getCar();
		carList.add(car);
		notifyAll();
		System.out.println
		   (Thread.currentThread().getName() + ":" + car + "�԰��");
		return car;
	}
	synchronized String pop() {
		while(carList.size() == 0) {
			System.out.println("�Ǹ��� �ڵ����� ����." 
		               + Thread.currentThread().getName() + "wait ����!");
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		System.out.println(Thread.currentThread().getName() + ":" 
		+ carList.get(0) + "�ڵ����� �Ǹŵ�");
		return carList.remove(0);
	}
}
class Seller extends Thread {
	CarMarket market;
	Seller(CarMarket market){
		super("�Ǹſ� ������");
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
		super("������ ������");
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

