package ex;

public class _1���׿����� {
	public static void main (String args[]) {
		//���׿�����: ~!, ++, -- (csat), -(��ȣ)
		
		// ~:  ������ Not ������ (tilde)
		// 		 1�� ������ ���Ѵ�. 
		//		 ~11110000 >> 00001111
		
		int n = 0x0f0f0f0f;
		System.out.printf("n=%08x\n", n);
		int m = ~n;
		System.out.printf("n=%08x\n", m);
		
		boolean b0k = !(3>2);
		System.out.println(b0k);
		
		// ���� ��ɰ� ����
		b0k = !("�ĸ�" == "��");
		System.out.println(b0k);
		
		System.out.println(!true);
		System.out.println(!false);
		
		int res;
		int b=10;
		int c=20;
		res = ++b + c--;
		System.out.println(res);
		
		
	}
}
