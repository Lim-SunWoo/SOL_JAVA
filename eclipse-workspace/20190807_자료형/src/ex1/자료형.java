package ex1;

public class �ڷ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� �ڷ��� : boolean
		// True or false
		// ����: boolean bOK; nNumber
		// �⺻���� false
		// cnffur tjtlr: %b, %B >> ��� ��� ��ҹ��� ����
		
		// ��¹�� 
		System.out.print("���븸 ���");
		System.out.println("��� �� �ٹٲ�"); // line next
		System.out.printf("���ϴ� ���˰� ���Ĵ�� ���\n"); // 
		
		System.out.printf("%b\n", 3>2); // true
		
		int n= 100;
		System.out.printf("10�� %d\n", n); // 
		System.out.printf("  8�� 0%o\n", n); // 
		System.out.printf("16�� 0x%h\n", n); // 

		// 10������ 8������ ���
		System.out.printf("0%o >> %d", 0144, 0144);
		
		// ���� �ڸ��� ���� ��� (�鿩���� ���� ��)
		System.out.printf("[%10d]\n", 123); // ������ ����
		System.out.printf("[%-10d]\n", 123); // ���� ����
		System.out.printf("%010d", 123); // �� ������ 0����
		
		double pi = 3.14;
		System.out.printf("������: %f\n", pi); // 
		System.out.printf("������: %g\n", pi); // 
		System.out.printf("������: %e\n", pi); // 
		System.out.printf("������: %e\n", pi*100); // 
		
		System.out.printf("������: [%10.2f]\n", pi); // 
		System.out.printf("������: [%3.5f]\n", 3.141592); // 
		System.out.printf("�ݿø�: [%3.5f]\n", 3.1498754);
		
		char ch= 'A';
		System.out.printf("%c�� �ƽ�Ű �ڵ�= %d\n", ch, (int)ch);
		
		ch= '��';
		System.out.printf("%c�� �ƽ�Ű �ڵ�= %d\n", ch, (int)ch);
		System.out.printf("44032�� ���� = %c\n", 44032);
		
		
		System.out.printf("A\r\nB\n");
		System.out.printf("A\tB\tC\n");
		System.out.printf("ABC\b\bx\n");
		
		System.out.println("\\");
		System.out.println("\"���� ���ְ� �弼��.\"��� ���ߴ�.");
		
		double rate= 0.3;
		System.out.printf("������: %.0f(%%)\n", 0.3*100);

		String name="ȫ�浿";
		System.out.printf("�� �̸��� [%s]\n", name);
		String str="�츮������ѹα�";
		System.out.printf("%.2s\n",str);
		
		System.out.println("--�� �ڷ����� ������--");
		System.out.printf("byte: %d ~ %d \n", Byte.MIN_VALUE, Byte.MAX_VALUE);
		System.out.printf("int: %d ~ %d \n", Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.printf("short: %d ~ %d \n", Short.MIN_VALUE, Short.MAX_VALUE);
		
	}
	

}
