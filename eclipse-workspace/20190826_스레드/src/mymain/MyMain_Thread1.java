package mymain;

// 스레드 생성방법 1

// 상속 받는다.
// 

class MyThread1 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run(); // 오버라이딩
		// 런메소드가 끝나는 순간 스레드는 소멸 됨.
		// 현재 수행되는 스레드 이름.
		String name = Thread.currentThread().getName();
		System.out.printf("run수행중: %s\n", name);

	}

}

public class MyMain_Thread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자바가 처음 시작될 때 주 쓰레듣 (Primary Thread)를 할당한다.
		String name = Thread.currentThread().getName();
		System.out.printf("쓰래드 생성 및 구동한 쓰레드: %s\n", name);
		
		Thread t1 = new MyThread1();
		t1.setName("첫번째");
		t1.start(); // runable 대기방 진입
		
		try {
			t1.join(); // 시간으로 잡아놓을 수 있음.
			// 현재 스레드가 소면될 때까지 타 쓰레드는 대기상태.
			// t1이라는 스레드가 죽자마자 락이 풀림.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("---main  thread dead---");
				
		
	}

}
