package myutil;

public class MabangJin {

	int chasu;

	int [][] mabang_array;
	
	public void setChasu(int chasu) {
		this.chasu = chasu;
		
		//마방진 생성
		make_mabangjin();
	}

	private void make_mabangjin() {
		// TODO Auto-generated method stub
		mabang_array = new int[chasu][chasu];
		
		int row=0,col=chasu/2;//처음위치 상단중앙
		int su=1;
		//첫번째칸 1로 채우기
		mabang_array[row][col]=su++;
		
		//공식대로 채우기
		for(int i=0;i<chasu*chasu-1;i++) {
			
			//오른쪽 상단으로 이동
			row--;
			col++;
			
			//위+오른쪽 모두 벗어났냐?
			if(row<0 && col>=chasu) {
				row+=2;
				col--;
			}else if(row <0) {
			  //위로 벗어났냐?      => 맨 아래로
			  row=chasu-1;	
			}else if(col>=chasu) {
			  //오른쪽으로 벗어났냐? =>맨 앞으로
			  col = 0;
			}
			
			//값이 이미 채워져 있냐?  =>이전위치 아래로
			if(mabang_array[row][col]!=0) {
				row+=2; 
				col--;
			}
			
			//첨자이동위치에 값넣기
			mabang_array[row][col]=su++;
			
		}
		
		
	}
	
    public void display() {
    	
    	//열의합 누적할 변수
    	int [] col_sum = new int[chasu];
    	int    diagonal2_sum = 0;//역대각의합    	
    	for(int i=0;i<chasu;i++) {
    		int row_sum = 0;//행의합 누적할 변수
    		for(int k=0;k<chasu;k++) {
    			
    			System.out.printf("%4d",mabang_array[i][k]);
    			//행의값 누적(가로1줄)
    			row_sum += mabang_array[i][k];
    			//열의값 누적(세로1줄)
    			col_sum[k] += mabang_array[i][k];
    			//역대각합 누적
    			if(i==k)
    				diagonal2_sum += mabang_array[i][k];
    		}
    		//행의합
    		System.out.printf("%4d",row_sum);
    		
    		System.out.println();
    	}
        //열의 합계출력
    	for(int i=0;i<chasu;i++) {
    		System.out.printf("%4d",col_sum[i]);
    	}
    	//역대각 합출력
    	System.out.printf("%4d",diagonal2_sum);
    	
    	System.out.println();
    	
    	
    	
    }
	
	
	
	
}
