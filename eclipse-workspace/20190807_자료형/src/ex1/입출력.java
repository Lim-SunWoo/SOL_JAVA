package ex1;
import java.util.*;

public class ����� {
	public static void main(String[] args) {
		//�̸� ���� ��ȥ ���� Ű �ּ�
		String name;
		int age;
		boolean bMarried;
		double ki;
		String adr;
		Scanner scan = new Scanner(System.in);
		
		//�̸��Է¹ޱ� 
		System.out.println("�̸��� �Է��Ͻÿ�. >> ");
		name = scan.nextLine();
		System.out.println("���̸� �Է��Ͻÿ�. >> ");
		age = scan.nextInt();
		System.out.println("��ȥ ���� true/false >> ");
		bMarried = scan.nextBoolean();
		System.out.println("Ű�� �Է��Ͻÿ�. >> ");
		ki = scan.nextDouble();
		
		scan.nextLine(); // ���ۿ� �����ִ� ��������
		
		System.out.println("�ּҸ� �Է��Ͻÿ�. >> ");
		adr= scan.nextLine();

		
		System.out.println("--��������--");
		System.out.printf("�̸�: %s\n", name);
		System.out.printf("����: %d\n", age);
		System.out.printf("��ȥ: %b\n", bMarried);
		System.out.printf("   Ű: %.1f\n", ki);
		System.out.printf("�ּ�: % s", adr);

		
	}
}