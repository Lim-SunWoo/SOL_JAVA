package myUtil;

public class MyArray22 {
	
	public static void fill_row(int [][] mm,int row,int val) {
		
		for(int i=0;i<mm[row].length;i++)
			mm[row][i] = val;
	}
	
	// fill_col(mm,1,3);
	public static void fill_col(int [][] mm,int col,int val) {
		for(int i=0;i<mm.length;i++)
			mm[i][col] = val;
	}
}
