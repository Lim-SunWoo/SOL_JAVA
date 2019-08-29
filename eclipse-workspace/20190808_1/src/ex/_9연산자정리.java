package ex;

public class _9연산자정리 {

	public static void main(String[] args) {
	
		boolean bOK = !!!(3>2);
		int n = -(-(-10));
		
		int  a, b, c;
		
		a= b= c= 0;
		
		int x = 1, y = 2;
		boolean z;
		
		z= --x > 0 && ++y>0;
		
		System.out.println("x="+x+", y="+y+", z="+z);
		// 일반논리 연산은 &&연산일 때 앞의 조건이 부정이면 
		//남은 조건을 확인 할 필요가 없으므로 실행하지 않음. >> y=2로 나옴
		// x=0, y=2, z=false
		
		z= ++x > 0 || ++y>0;
		System.out.println("x="+x+", y="+y+", z="+z);
		// x=1, y=2, z=true
		
		z= --x > 0 || ++y>0; System.out.println("x="+x+", y="+y+", z="+z); // x=-1,
		// x=0, y=3, z=true
		 
	}
}
