package myutil;

public class TV implements RemoteCon {

	// 인터페이스는 상수만 되지만 클래스는 변수 가능.
	int volume = 10;
	boolean bVolumeZero = false;

	int channel = 9;
	boolean bOnOff = false; // TV전원

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		volume++;
		if (volume > MAX_VOLUME)
			volume = MAX_VOLUME; // Volume.MAX_VOLUME
		display();
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		volume--;
		if (volume < MIN_VOLUME)
			volume = MIN_VOLUME;
		display();
	}

	@Override
	public void VolumeZero() { // 토글방식 -> 온오프변경
		// TODO Auto-generated method stub
		bVolumeZero = !bVolumeZero;
		display();
	}

	@Override
	public void channelUp() {
		// TODO Auto-generated method stub
		channel++;
		if (volume > MAX_CHANNEL)
			volume = MAX_CHANNEL;
		display();
	}

	@Override
	public void channelDown() {
		// TODO Auto-generated method stub
		channel--;
		if (volume < MIN_CHANNEL)
			volume = MIN_CHANNEL;
		display();
	}

	@Override
	public void setChannel(int ch) {
		// TODO Auto-generated method stub
		if (ch >= MIN_CHANNEL && ch <= MAX_CHANNEL)
			channel = ch;
		display();
	}

	@Override
	public void onOff() {
		// TODO Auto-generated method stub
		bOnOff = !bOnOff;
		display();
	}

	public void display() {
		// TODO Auto-generated method stub
		if (bOnOff == false) {
			System.out.println("---TV꺼짐---");
			System.out.println();
			return;
		}

		System.out.println("---TV상태---");

		System.out.println("채널: " + channel);
		if (bVolumeZero)
			System.out.println("볼륨: 음소거");
		else
			System.out.println("볼륨: " + volume);
		System.out.println("------------");
		System.out.println();
	}

}
