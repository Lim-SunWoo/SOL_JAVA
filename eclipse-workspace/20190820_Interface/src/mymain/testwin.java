package mymain;

import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class testwin extends JFrame {

	public testwin() {
		super("Ÿ��Ʋ"); // JFrame("Ÿ��Ʋ") ȣ��� ���� ����� ��.

		// ��ġ�� ������
		super.setLocation(400, 200);
		setSize(300, 300);

		// ���̱�
		setVisible(true);

		// ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ������ �̺�Ʈ ��� 
		// this �̺�Ʈ �ҽ�
		// ó����ü:: �߻��� �̺�Ʈ�� ó���� ��ü
		// Delegation Model ���� �̺�Ʈ �� 
		// MyWindowEventListener listener = new MyWindowEventListener(); // ~�� ������ �̺�Ʈ�� ���� �� �ֵ��� �غ��ؾ���.
		/*���� ��밡��*/ WindowListener listener = new MyWindowEventListener();
		this.addWindowListener(listener); // �̺�Ʈ ��ü / ó����ü
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	}

}

/*
 * �̺�Ʈ�� �߻�: �ü���� ���� ���� ���� 
 * �̺�Ʈ > OS���� > JVM�� ������ > ó��
 * �̺�Ʈ �߻� > ó���� ��ü�� ���� > ó��
 * 
 */