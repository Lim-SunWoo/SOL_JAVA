package ex1;
import java.util.*;

public class ����_�� {
	public static void main(String[] args) {
		
		// �������� �־����� �װ� �̿��ؼ� ���� ����/�ѷ��� ���Ѵ�.
		// ��ü��: 4/3*����*������^3
		
		final double PI= 3.14;
		// (Math.PI)
		
		double r;
		double l;
		double s;
		double v;
		
		System.out.println("���� �������� �Է��Ͻÿ�.");
		Scanner scan = new Scanner(System.in);
		r= scan.nextDouble();
		l= 2*r*PI;
		s= r*r*PI;
		v= r*r*r*PI*4/3;
		
		
		System.out.println("�������� "+r+"�� ���� �ѷ��� "+l+", ���̴� "+s+"�̸� ���� ���Ǵ� "+v+"�Դϴ�.");
		
		System.out.println(4/3);
		System.out.println(4.0/3);
		
	}
}
