package mymain;

import myutil.Channel;
import myutil.RemoteCon;
import myutil.TV;
import myutil.TVFactory;
import myutil.Volume;

// https://yaboong.github.io/java/2018/09/25/interface-vs-abstract-in-java8/ 
// 추상클래스 VS 인터페이스
// 추상클래스(abstract class)는 반드시 추상 메소드를 포함하지 않아도 됨.
// 단 추상메소드를 포함한 클래스는 반드시 추상 클래스여야 함.
// 인스턴스화 불가 -> 객체 생성 불가

abstract class AbstractTest{}

public class MyMain_TV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Volume v = new Volume();
		// AbstractTest test = new AbstractTest();
		// ㄴ추상클래스는 미완성된 클래스이기 때문에 객체생성이 불가능 함.
		
		// RemoteCon remoteCon = new TV(); // 티비를 만든다음 티비를 조작할 수 있는 리모콘은 받음. 리모콘에서만 동작.
		// ㄴTVFactory만들고 나서 주석.
		TVFactory factory = TVFactory.getInstance();
		RemoteCon remoteCon = factory.createTV();
		// 여기까지로 변경

		remoteCon.onOff();// 켜기
		remoteCon.onOff();// 끄기
		remoteCon.onOff(); // 켜기

		remoteCon.setChannel(56);

		Volume volume_interface = remoteCon;
		
		for (int i = 0; i < 10; i++) {
			volume_interface.volumeUp();
		}

		// 리모콘에서 Volume만 제어할 수 있는 interface추출
		volume_interface.VolumeZero(); // 음소거
		volume_interface.VolumeZero(); // 음소거 해제

		// 리모콘에서 Channel만 제어할 수 있는 interface추출
		Channel channel_interace = remoteCon;
		channel_interace.setChannel(99);

		channel_interace.setChannel(999); // 유효성 체크에 걸려서 안나와야함. = 체널 유지

	}

}
