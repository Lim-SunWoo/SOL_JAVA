package mymain;

import myutil.MyMath;

public class MyMain_Math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10, y = 5, res;

		MyMath mm = new MyMath(); // ��ü ������ �ν���Ʈ �ޙ��� ������� -> ��밡������.

		// res = _2MyMath.plus(x,y); >> ����
		res = mm.plus(x, y);

		// minus�� static �޼ҵ�� ����������� -> ��ü������ ��ġ�� �ʰ��� ����� ������.
		res = MyMath.minus(x, y);
		res = mm.minus(x, y); // ��ü �����Ŀ��� ����� �����ϱ� �ϳ� �������� ����.

		// �⺻ API�м�
		
		// Math m = new Math();
		res = Math.max(x, y);  // MathŬ������ ������ ���� -> private(�ܺο��� ���� �Ұ� = ��ü ������ �ʿ䰡 ����.)

	}

}
