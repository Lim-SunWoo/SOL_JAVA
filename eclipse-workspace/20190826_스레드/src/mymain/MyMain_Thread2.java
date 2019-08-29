package mymain;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		while (true) {
			System.out.printf("[%s] 스레드 수행\n", name);

			try {
				Thread.sleep(1000); // 현재 스레드뿐만이 아니라 다른 스레드도 영향을 받으므로 지양.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

public class MyMain_Thread2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 쓰레드 수행객체
		Runnable mr = new MyRunnable();

		// 관리객체
		Thread t1 = new Thread(mr, "첫번째");
		Thread t2 = new Thread(mr, "두번째");

		// 쓰레드 구동
		t1.start();
		t2.start();

	}
}