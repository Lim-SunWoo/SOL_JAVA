package mymain;

import java.io.FileReader;

public class MyMain_5_����ó������ {
	static void set(int[] mr, int i, int val) throws NullPointerException, ArrayIndexOutOfBoundsException {
		//
		try { // 1.���� ����
			
			if (mr == null) { // �ش�ޙ��� ó���ϴ� ������ ����ó���ض�
				throw new NullPointerException("---�迭����---");
			}
			
			String message = String.format("--÷�ڹ����� ������ϴ�.: 0~%d����--", mr.length - 1, i);
			if (mr == null || i < 0 || i >= mr.length)
				throw new ArrayIndexOutOfBoundsException(message); // �ݵ�� �ްԵǾ�����.������ �س��Ƽ� catch�϶� �̾߱��� ��.
			mr[i] = val; // ������ ����...?
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	// catch�ۼ� ����
	/*
	 * ���赵F4���� ū�� > ������ ������ �ۼ�
	 * 
	 */
	public static void main(String[] args) {
		int[] mr = new int[3];

		try {
			set(mr, 0, 10);
			set(mr, 1, 20);
			set(mr, 2, 30);
			// ������ ����
			set(mr, 3, 40);
		} catch (Exception e) { // 2.�̷� ������ �վ�
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Thread.sleep(1000); // static�޼ҵ�(��ü���� ���� ����� �� �ִ� �޼ҵ�, ������ ����Ǵ� ������ ���α׷��� ������ ����.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FileReader fr = new FileReader("ssss"); // �� ������ �ȿ��� throw��. ã�ٰ� ��ã���� throw�ؼ� �˷���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ������ĳġ�� �ϴ� ���ο� ������ �ϴ� �� �� �ϳ��� ����� ����.

	}
}
