package myutil; // 계속 오류남. 확인바람.

public class MabangJin {
	int chasu;
	int[][] mabang_array;

	public void setChasu(int chasu) {
		this.chasu = chasu;

		// 마방진 만들기
		make_mabangjin();
	}

	private void make_mabangjin() {
		// TODO Auto-generated method stub
		mabang_array = new int[chasu][chasu];

		////// 공식대로 채우기
		// 시작
		int row = 0, col = chasu / 2; // 처음 위치 상단 중앙
		int su = 1; // 1로 채우기

		for (int i = 0; i < chasu * chasu - 1; i++) { // 이미 하나를 채워서 -1
			// 오른쪽 위로
			row--;
			col++;
			// row < 0이면 위로 튀어나옴
			// row > chasu 밑으로 튀어나옴
			// col < 0 왼쪽 옆으로 튀어나옴
			// col > chasu 오른 쪽 옆으로 튀어나옴.

			if (row < 0 && col <= chasu) { // 위만
				row = chasu - 1;
			} else if (row < 0 && col > chasu) { // 위, 오른쪽
				row += 2;
				col--;
			} else if (row > 0 && col > chasu) { // 오른쪽만
				col = 0;
			}

			if (mabang_array[row][col] != 0) { // 이전 위치 아래로
				row += 2;
				col--;
				
				mabang_array[row][col] = i + 2;
			} 

			
		}

	}

	// 마방진 출력하기
	public void display() {
		for (int i = 0; i < chasu; i++) {
			for (int k = 0; k < chasu; k++) {
				System.out.printf("%4d", mabang_array[i][k]);
			}
			System.out.println();
		}
	}

}
