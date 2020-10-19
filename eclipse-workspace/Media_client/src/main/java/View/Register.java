package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.getdata;
import Model.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField n;
	private JTextField email;
	private JPasswordField pass;
	private JPasswordField repass;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 437);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		n = new JTextField();
		n.setBounds(12, 62, 214, 37);
		contentPane.add(n);
		n.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(12, 123, 214, 37);
		contentPane.add(email);
		
		JLabel lblTeen = new JLabel("Tên đăng nhập");
		lblTeen.setBounds(68, 50, 105, 14);
		contentPane.add(lblTeen);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(101, 111, 105, 14);
		contentPane.add(lblEmail);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu");
		lblMtKhu.setBounds(90, 180, 105, 14);
		contentPane.add(lblMtKhu);
		
		JLabel lblNhpLiMt = new JLabel("Nhập Lại Mật Khẩu");
		lblNhpLiMt.setBounds(68, 245, 105, 14);
		contentPane.add(lblNhpLiMt);
		
		JButton btnNewButton = new JButton("Đăng kí");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pass.getText().equals(repass.getText())) {
				User us = new User(n.getText(),pass.getText(),email.getText());
				try {
					new getdata().Register(us);
					JOptionPane.showMessageDialog(null, "Đăng kí thành cồng");

				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				
				} else {
					JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại không đúng");

				}
				
			}
		});
		btnNewButton.setBounds(12, 354, 198, 24);
		contentPane.add(btnNewButton);
		
		pass = new JPasswordField();
		pass.setBounds(12, 198, 213, 37);
		contentPane.add(pass);
		
		repass = new JPasswordField();
		repass.setBounds(13, 261, 213, 37);
		contentPane.add(repass);
	}
}
