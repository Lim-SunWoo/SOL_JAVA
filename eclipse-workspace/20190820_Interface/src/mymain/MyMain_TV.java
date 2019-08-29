package mymain;

import myutil.Channel;
import myutil.RemoteCon;
import myutil.TV;
import myutil.TVFactory;
import myutil.Volume;

// https://yaboong.github.io/java/2018/09/25/interface-vs-abstract-in-java8/ 
// �߻�Ŭ���� VS �������̽�
// �߻�Ŭ����(abstract class)�� �ݵ�� �߻� �޼ҵ带 �������� �ʾƵ� ��.
// �� �߻�޼ҵ带 ������ Ŭ������ �ݵ�� �߻� Ŭ�������� ��.
// �ν��Ͻ�ȭ �Ұ� -> ��ü ���� �Ұ�

abstract class AbstractTest{}

public class MyMain_TV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Volume v = new Volume();
		// AbstractTest test = new AbstractTest();
		// ���߻�Ŭ������ �̿ϼ��� Ŭ�����̱� ������ ��ü������ �Ұ��� ��.
		
		// RemoteCon remoteCon = new TV(); // Ƽ�� ������� Ƽ�� ������ �� �ִ� �������� ����. �����ܿ����� ����.
		// ��TVFactory����� ���� �ּ�.
		TVFactory factory = TVFactory.getInstance();
		RemoteCon remoteCon = factory.createTV();
		// ��������� ����

		remoteCon.onOff();// �ѱ�
		remoteCon.onOff();// ����
		remoteCon.onOff(); // �ѱ�

		remoteCon.setChannel(56);

		Volume volume_interface = remoteCon;
		
		for (int i = 0; i < 10; i++) {
			volume_interface.volumeUp();
		}

		// �����ܿ��� Volume�� ������ �� �ִ� interface����
		volume_interface.VolumeZero(); // ���Ұ�
		volume_interface.VolumeZero(); // ���Ұ� ����

		// �����ܿ��� Channel�� ������ �� �ִ� interface����
		Channel channel_interace = remoteCon;
		channel_interace.setChannel(99);

		channel_interace.setChannel(999); // ��ȿ�� üũ�� �ɷ��� �ȳ��;���. = ü�� ����

	}

}
