package mymain;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		while (true) {
			System.out.printf("[%s] ������ ����\n", name);

			try {
				Thread.sleep(1000); // ���� ������Ӹ��� �ƴ϶� �ٸ� �����嵵 ������ �����Ƿ� ����.
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

		// ������ ���ఴü
		Runnable mr = new MyRunnable();

		// ������ü
		Thread t1 = new Thread(mr, "ù��°");
		Thread t2 = new Thread(mr, "�ι�°");

		// ������ ����
		t1.start();
		t2.start();

	}
}