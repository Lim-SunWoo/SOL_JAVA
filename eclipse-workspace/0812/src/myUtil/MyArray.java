package myUtil;

public class MyArray {
	public static void setArray(int[] mr2) {
		for (int i = 0; i < mr2.length; i++) {
			mr2[i] = i + 1;
		}
	}

	public static void displayArray(int[] mr2) {
		System.out.print("[");
		for (int i = 0; i < mr2.length; i++) {
			System.out.printf("%3d", mr2[i]);
		}
		System.out.print("   ]");
	}

	public static void fill(int[] mr2, int val) {
		for (int i = 0; i < mr2.length; i++) {
			mr2[i] = val;
		}
	}

	// 0, 1, 2, 3, 4가 있다면 (mr, 1 , 2 , 5) >>> [ 0, 0, 0, 0, 0 ] >>> [ 0, 5, 5, 0, 0
	// ]
	public static void fill(int[] mr2, int start, int count, int val) {
		for (int i = start; i < start + count; i++) {
			mr2[i] = val;
		}
	}
}
