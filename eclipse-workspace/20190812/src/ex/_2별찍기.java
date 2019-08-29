package ex;

public class _2º°Âï±â {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--ÀüÃ¼ Âï±â--");
		for (int i = 0; i < 5; i++) { // ÇàÃ·ÀÚ 0, 1, 2, 3, 4,
			for (int k = 0; k < 5; k++) { // ¿­Ã·ÀÚ 0, 1, 2, 3, 4,
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("--»ï°¢Çü Âï±â--");
		for (int i = 0; i < 5; i++) { // ÇàÃ·ÀÚ 0, 1, 2, 3, 4,
			for (int k = 0; k < 5; k++) { // ¿­Ã·ÀÚ 0, 1, 2, 3, 4,
				if (k < i)
					System.out.print("*");
				else
					System.out.print("^");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("--»ï°¢Çü Âï±â2--");
		for (int i = 0; i < 5; i++) { // ÇàÃ·ÀÚ 0, 1, 2, 3, 4,
			for (int k = 5; k >= 0; k--) {
				if (k < i)
					System.out.print("*");
				else
					System.out.print("^");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("--¿ª»ï°¢Çü Âï±â--");
		for (int i = 0; i < 5; i++) { // ÇàÃ·ÀÚ 0, 1, 2, 3, 4,
			for (int k = 0; k < 5; k++) { // ¿­Ã·ÀÚ 0, 1, 2, 3, 4,
				if (k > i)
					System.out.print("*");
				else
					System.out.print("^");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("--¿ª»ï°¢Çü Âï±â2--");
		for (int i = 0; i < 5; i++) { // ÇàÃ·ÀÚ 0, 1, 2, 3, 4,
			for (int k = 5; k >= 0; k--) {
				if (k > i)
					System.out.print("*");
				else
					System.out.print("^");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("--¸¶¸§¸ğ Âï±â--");
		int n = 5;
		int center = n / 2;
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				if (i <= center) { // »ó´Ü
					if (k >= center - i && k <= center + i) {
						System.out.print("*");
					} else
						System.out.print("-");
				}else {
					int a=n-i-1;
					if(k>=center-a&&k<=center+a) System.out.print("*");
					else System.out.print("-");
				}
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("--¹Ù¶÷°³ºñ Âï±â--");
		for (int i = 0; i < 5; i++) { // ÇàÃ·ÀÚ 0, 1, 2, 3, 4,
			for (int k = 0; k < 5; k++) { // ¿­Ã·ÀÚ 0, 1, 2, 3, 4,
				if (i == k || i == 4 - k) // °ø¹éÁ¶°Ç
					System.out.print("   ");
				else
					System.out.print("*");
			}
			System.out.println();
		}

	}

}
