package mymain;

// ������ ������� 1

// ��� �޴´�.
// 

class MyThread1 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run(); // �������̵�
		// ���޼ҵ尡 ������ ���� ������� �Ҹ� ��.
		// ���� ����Ǵ� ������ �̸�.
		String name = Thread.currentThread().getName();
		System.out.printf("run������: %s\n", name);

	}

}

public class MyMain_Thread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �ڹٰ� ó�� ���۵� �� �� ������ (Primary Thread)�� �Ҵ��Ѵ�.
		String name = Thread.currentThread().getName();
		System.out.printf("������ ���� �� ������ ������: %s\n", name);
		
		Thread t1 = new MyThread1();
		t1.setName("ù��°");
		t1.start(); // runable ���� ����
		
		try {
			t1.join(); // �ð����� ��Ƴ��� �� ����.
			// ���� �����尡 �Ҹ�� ������ Ÿ ������� ������.
			// t1�̶�� �����尡 ���ڸ��� ���� Ǯ��.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("---main  thread dead---");
				
		
	}

}
