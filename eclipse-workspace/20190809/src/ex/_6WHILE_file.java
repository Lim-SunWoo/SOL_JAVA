package ex;

import java.io.FileReader;
import java.lang.Character.UnicodeBlock;

public class _6WHILE_file {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("src/ex/_6WHILE_file.java");
		; // C:\Users\Soldesk\eclipse-workspace\20190809\src\ex\_while1.java"

		int count = 0;// ���ڼ� ����
		int alpha_upper_count = 0;// �빮�ڰ���
		int alpha_lower_count = 0;// �ҹ��ڰ���
		int number_count = 0; // ���ڰ���
		int hangul_count = 0; // �ѱ۰���

		while (true) {
			int readChar = fr.read(); // fr��ġ�� ���� 1���� �о�´�.
			// break: ����ݺ����� Ż���ض�
			// ȭ���� ���������� fr.read()�� -1�� ��ȯ
			if (readChar == -1)
				break; // ���ڴ� ������ ���� ���� ��� break���� Ȱ�� ���� read�ϸ�(=������ ���̸�) -1�� �Ѱ���.

			System.out.printf("%c", readChar);

			count++; // ����

			// �빮������ �˾ƺ��� ��� 0:48 / A:65 / Z:90
			if (readChar >= 'A' && readChar <= 'Z')
				alpha_upper_count++;

			if (readChar >= 'a' && readChar <= 'z')
				alpha_lower_count++;

			if (readChar >= '0' && readChar <= '9')
				number_count++;

			// �ѱ�üũ
			Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(readChar);
			if (UnicodeBlock.HANGUL_SYLLABLES.equals(unicodeBlock)
					|| UnicodeBlock.HANGUL_COMPATIBILITY_JAMO.equals(unicodeBlock)
					|| UnicodeBlock.HANGUL_JAMO.equals(unicodeBlock)) {
				hangul_count++;
			}

			// Thread.sleep(100);
		}
		System.out.printf("�� ���ڼ�: %d��\n", count);
		System.out.printf("�빮�� ����: %d��\n", count);
		System.out.printf("�ҹ��� ����: %d��\n", count);
		System.out.printf("���� ����: %d��\n", count);
		System.out.printf("�ѱ� ����: %d��\n", count);

		fr.close(); // ���� �ݱ�
	}
}
