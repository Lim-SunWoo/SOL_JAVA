package ex;

import java.io.FileReader;
import java.lang.Character.UnicodeBlock;

public class _6WHILE_file {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("src/ex/_6WHILE_file.java");
		; // C:\Users\Soldesk\eclipse-workspace\20190809\src\ex\_while1.java"

		int count = 0;// 글자수 누적
		int alpha_upper_count = 0;// 대문자갯수
		int alpha_lower_count = 0;// 소문자갯수
		int number_count = 0; // 숫자갯수
		int hangul_count = 0; // 한글갯수

		while (true) {
			int readChar = fr.read(); // fr위치의 문자 1개를 읽어온다.
			// break: 현재반복문을 탈출해라
			// 화일의 끝을만나면 fr.read()시 -1을 반환
			if (readChar == -1)
				break; // 문자는 음수가 나올 수가 없어서 break문에 활용 전부 read하면(=파일의 끝이면) -1을 넘겨줌.

			System.out.printf("%c", readChar);

			count++; // 증가

			// 대문자인지 알아보는 방법 0:48 / A:65 / Z:90
			if (readChar >= 'A' && readChar <= 'Z')
				alpha_upper_count++;

			if (readChar >= 'a' && readChar <= 'z')
				alpha_lower_count++;

			if (readChar >= '0' && readChar <= '9')
				number_count++;

			// 한글체크
			Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(readChar);
			if (UnicodeBlock.HANGUL_SYLLABLES.equals(unicodeBlock)
					|| UnicodeBlock.HANGUL_COMPATIBILITY_JAMO.equals(unicodeBlock)
					|| UnicodeBlock.HANGUL_JAMO.equals(unicodeBlock)) {
				hangul_count++;
			}

			// Thread.sleep(100);
		}
		System.out.printf("총 글자수: %d개\n", count);
		System.out.printf("대문자 개수: %d개\n", count);
		System.out.printf("소문자 개수: %d개\n", count);
		System.out.printf("숫자 개수: %d개\n", count);
		System.out.printf("한글 개수: %d개\n", count);

		fr.close(); // 파일 닫기
	}
}
