package mymain;

public class MyMain_����ó������ {

	// if �����ڰ� ���ܰ��� catch �ڹٰ� ���ܰ��� //�ڵ����

	static int plus(int a, int b) {
		return a + b;
	}

	static double plus(double a, double b) {
		return a + b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		plus(1, 2);
		plus(1.0, 2.0);
		int a = 10, b = 0, res;
		String str = null;
		// Stirng str = "abc" -> �ڵ� ��ü���� �� null�� ����� . length�� �ȵ�.
		int[] mr = { 1, 2, 3 };

		int i = 1;
		mr[i] = 100;

		System.out.printf("%d", 10.5);

		// while (true) {
		try {
			// �������� �ڵ� ó������
			if (b == 0)
				throw new ArithmeticException();

			res = a / b;

			if (str == null)
				throw new NullPointerException();
			int len = str.length(); // lenght�� ������ ���̸� ����. -> instance�޼ҵ�
			// ststic �޼ҵ� ���α׷� �����ϸ�
			/// lengt���� �ν��Ͻ� -> ��ü ������ ����
			// Thread.sleep(10000);
		} catch (ArithmeticException e) {
			// ���ܹ߻��� �ڵ�ó��
			// e.printStackTrace();
			System.out.println("0���� ������ ���մϴ�.");
			b = 1;
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("��ü������ ���ֽʽÿ�.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("---����---");
		}
		// }

	}

}
