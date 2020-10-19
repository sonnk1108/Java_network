package LoginClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtpassword;
	JButton btnNewButton = new JButton("Login");

	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 */
	public ClienView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(50, 75, 232, 37);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(50, 138, 232, 37);
		contentPane.add(txtpassword);
		
		JLabel lblngNhp = new JLabel("Đăng Nhập");
		lblngNhp.setBounds(314, 86, 87, 14);
		contentPane.add(lblngNhp);
		
		JLabel M = new JLabel("Mật Khẩu");
		M.setBounds(314, 137, 55, 14);
		contentPane.add(M);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnNewButton.setBounds(87, 212, 98, 24);
		contentPane.add(btnNewButton);
	}
	public User getUser() {
		User model= new User(txtUserName.getText(),txtpassword.getText());
		return model;
	}
	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void addLoginListener(ActionListener log) {
		btnNewButton.addActionListener(log);
	}
	
}
