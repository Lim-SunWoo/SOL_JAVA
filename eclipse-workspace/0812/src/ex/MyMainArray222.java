package ex;

public class MyMainArray222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 2019;

		String[][] ganji = { { "경", "신", "임", "계", "갑", "을", "병", "정", "무", "기" },
				{ "신", "유", "술", "해", "자", "축", "인", "묘", "진", "사", "오", "미" } };

		System.out.printf("%d년은 %s%s년입니다. \n", year, ganji[0][year%10], ganji[1][year%12]);
		// 10간 year%10=0~9
		// 갑을 병정 무기 경신 임계
		// 12지 year%12= 0~11
		// 자축 인묘 진사 오미 신유 술해
		
		

	}

}
