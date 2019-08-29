package myutil; // ��� ������. Ȯ�ιٶ�.

public class MabangJin {
	int chasu;
	int[][] mabang_array;

	public void setChasu(int chasu) {
		this.chasu = chasu;

		// ������ �����
		make_mabangjin();
	}

	private void make_mabangjin() {
		// TODO Auto-generated method stub
		mabang_array = new int[chasu][chasu];

		////// ���Ĵ�� ä���
		// ����
		int row = 0, col = chasu / 2; // ó�� ��ġ ��� �߾�
		int su = 1; // 1�� ä���

		for (int i = 0; i < chasu * chasu - 1; i++) { // �̹� �ϳ��� ä���� -1
			// ������ ����
			row--;
			col++;
			// row < 0�̸� ���� Ƣ���
			// row > chasu ������ Ƣ���
			// col < 0 ���� ������ Ƣ���
			// col > chasu ���� �� ������ Ƣ���.

			if (row < 0 && col <= chasu) { // ����
				row = chasu - 1;
			} else if (row < 0 && col > chasu) { // ��, ������
				row += 2;
				col--;
			} else if (row > 0 && col > chasu) { // �����ʸ�
				col = 0;
			}

			if (mabang_array[row][col] != 0) { // ���� ��ġ �Ʒ���
				row += 2;
				col--;
				
				mabang_array[row][col] = i + 2;
			} 

			
		}

	}

	// ������ ����ϱ�
	public void display() {
		for (int i = 0; i < chasu; i++) {
			for (int k = 0; k < chasu; k++) {
				System.out.printf("%4d", mabang_array[i][k]);
			}
			System.out.println();
		}
	}

}
