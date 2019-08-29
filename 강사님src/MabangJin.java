package myutil;

public class MabangJin {

	int chasu;

	int [][] mabang_array;
	
	public void setChasu(int chasu) {
		this.chasu = chasu;
		
		//������ ����
		make_mabangjin();
	}

	private void make_mabangjin() {
		// TODO Auto-generated method stub
		mabang_array = new int[chasu][chasu];
		
		int row=0,col=chasu/2;//ó����ġ ����߾�
		int su=1;
		//ù��°ĭ 1�� ä���
		mabang_array[row][col]=su++;
		
		//���Ĵ�� ä���
		for(int i=0;i<chasu*chasu-1;i++) {
			
			//������ ������� �̵�
			row--;
			col++;
			
			//��+������ ��� �����?
			if(row<0 && col>=chasu) {
				row+=2;
				col--;
			}else if(row <0) {
			  //���� �����?      => �� �Ʒ���
			  row=chasu-1;	
			}else if(col>=chasu) {
			  //���������� �����? =>�� ������
			  col = 0;
			}
			
			//���� �̹� ä���� �ֳ�?  =>������ġ �Ʒ���
			if(mabang_array[row][col]!=0) {
				row+=2; 
				col--;
			}
			
			//÷���̵���ġ�� ���ֱ�
			mabang_array[row][col]=su++;
			
		}
		
		
	}
	
    public void display() {
    	
    	//������ ������ ����
    	int [] col_sum = new int[chasu];
    	int    diagonal2_sum = 0;//���밢����    	
    	for(int i=0;i<chasu;i++) {
    		int row_sum = 0;//������ ������ ����
    		for(int k=0;k<chasu;k++) {
    			
    			System.out.printf("%4d",mabang_array[i][k]);
    			//���ǰ� ����(����1��)
    			row_sum += mabang_array[i][k];
    			//���ǰ� ����(����1��)
    			col_sum[k] += mabang_array[i][k];
    			//���밢�� ����
    			if(i==k)
    				diagonal2_sum += mabang_array[i][k];
    		}
    		//������
    		System.out.printf("%4d",row_sum);
    		
    		System.out.println();
    	}
        //���� �հ����
    	for(int i=0;i<chasu;i++) {
    		System.out.printf("%4d",col_sum[i]);
    	}
    	//���밢 �����
    	System.out.printf("%4d",diagonal2_sum);
    	
    	System.out.println();
    	
    	
    	
    }
	
	
	
	
}
