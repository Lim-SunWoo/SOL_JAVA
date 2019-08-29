package mymain.tcp.multichat.serial;

import java.io.Serializable;
import java.util.List;

//직렬화 가능한 객체
public class Data implements Serializable{

	public static final int  NONE   = 0;
	public static final int  IN   = 1;
	public static final int  OUT  = 2;
	public static final int  MSG  = 3;
	public static final int  LIST = 4;
	public static final int  DRAW = 5;
	
	public int protocol = NONE;//데이터 구분
	public String nick_name;   //대화명
	public String message;     //채팅내용
	
	public List<String> userList;//접속자 목록
	
	//그리기 데이터
	public int thick;
	public int x;
	public int y;
	public int line_color;
	
	
}
