package ex;

import java.io.IOException;

public class _7while {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int count = 0;
		int white = 0;

		System.out.println("�����Ϸ��� Ctrl_Z�� ��������!");
		System.out.println("�ƹ��ų� �Է�");

		while (true) {
			int ch = System.in.read();
			if (ch == -1)
				break;

			System.out.printf("%c", ch);

			if (ch == 0 || ch == 9 || ch == 10 || ch == 13) { // \0 \t \n \r
				white++; // ���� ���ǿ� ��ü ! ����
			}
			count++;
			// ���⼸ else �ְ� else������ ī��Ʈ�ϴ� ����� ����.

		}
		count = count - white;
		System.out.printf("���� �� > %d\n", count);
		System.out.println("----END----");
	}

	// ���� ���̴� ���� ���� ���� �� -> count�δ� �Ұ���
	// ���� �Ⱥ��̴� ȭ��Ʈ ����: \n \r \t
	// ���� ���̴� ���� ���� ����ϱ� ���ؼ��� ȭ��Ʈ ���ڰ� �ƴϑm�� ī��Ʈ�ϴ� ����� ����.

}
