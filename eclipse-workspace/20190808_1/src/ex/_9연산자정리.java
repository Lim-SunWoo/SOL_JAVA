package ex;

public class _9���������� {

	public static void main(String[] args) {
	
		boolean bOK = !!!(3>2);
		int n = -(-(-10));
		
		int  a, b, c;
		
		a= b= c= 0;
		
		int x = 1, y = 2;
		boolean z;
		
		z= --x > 0 && ++y>0;
		
		System.out.println("x="+x+", y="+y+", z="+z);
		// �Ϲݳ� ������ &&������ �� ���� ������ �����̸� 
		//���� ������ Ȯ�� �� �ʿ䰡 �����Ƿ� �������� ����. >> y=2�� ����
		// x=0, y=2, z=false
		
		z= ++x > 0 || ++y>0;
		System.out.println("x="+x+", y="+y+", z="+z);
		// x=1, y=2, z=true
		
		z= --x > 0 || ++y>0; System.out.println("x="+x+", y="+y+", z="+z); // x=-1,
		// x=0, y=3, z=true
		 
	}
}
