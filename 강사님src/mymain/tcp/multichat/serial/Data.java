package mymain.tcp.multichat.serial;

import java.io.Serializable;
import java.util.List;

//����ȭ ������ ��ü
public class Data implements Serializable{

	public static final int  NONE   = 0;
	public static final int  IN   = 1;
	public static final int  OUT  = 2;
	public static final int  MSG  = 3;
	public static final int  LIST = 4;
	public static final int  DRAW = 5;
	
	public int protocol = NONE;//������ ����
	public String nick_name;   //��ȭ��
	public String message;     //ä�ó���
	
	public List<String> userList;//������ ���
	
	//�׸��� ������
	public int thick;
	public int x;
	public int y;
	public int line_color;
	
	
}
