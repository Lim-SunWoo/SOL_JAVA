package mymain;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyPanel3 extends JPanel {

	public MyPanel3() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		// North
		JPanel p = new JPanel(new BorderLayout());
		JLabel jlb_title = new JLabel("제목:");
		JTextField jtf_title = new JTextField(20);

		p.add(jlb_title, "West");
		p.add(jtf_title, "Center");

		this.add(p, "North");

		// Center
		JPanel p1 = new JPanel(new BorderLayout());
		JLabel jlb_content = new JLabel("내용:");
		JTextArea jta_content = new JTextArea();

		p1.add(jlb_content, "West");
		p1.add(jta_content);

		this.add(p1, "Center");

		// North
		JPanel p3 = new JPanel();
		JButton jbt_write = new JButton("글쓰기");
		p3.add(jbt_write);
		this.add(p3, "South");

	}
}
