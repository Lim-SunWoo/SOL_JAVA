package ex;

public class _5������������ {
	public static void main(String[] args) {
	
		int birth=0x19901225;
		int year;
		int month;
		int day;
		
		// ����⵵
		year = birth >>> 16 /*16���� 4���� �̷���ϳ� ��Ʈ �����̹Ƿ� *4*/;
		System.out.printf("��: %x\n", year); // ��¿� ����, &�� �ȵǴ� ������ �ڿ� 0�� ��� �ٱ� ����
		month = (birth >>8) & 0xff; // 000000ff,&�� �̿��ϸ� ���� �����ִ� f(1111)�κи� ����. ������ ���� &,^,|�̿�
		System.out.printf("��: %x\n", month); // ��¿� ����
		day = birth & 0xff;
		System.out.printf("��: %x\n", day); // ��¿� ����
		// �����
		birth = birth ^ 0x00001200;
		System.out.printf("%x\n", birth);
		// ä���
		birth = birth | 0x00000800;
		System.out.printf("%x\n", birth);
	}
	
}
