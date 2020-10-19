package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Login_control;
import Controller.getdata;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField name_text;
	private JLabel lblMtKh;
	private JPasswordField pass_text;
	private JButton Dang_nhap;
	private JButton btnNewButton_1;
	private JLabel label_quen_mk;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBounds(100, 100, 343, 342);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name_text = new JTextField();
		name_text.setBounds(28, 114, 183, 27);
		contentPane.add(name_text);
		name_text.setColumns(10);
		
		JLabel lblngNhp = new JLabel("Tên đăng nhập");
		lblngNhp.setBounds(229, 120, 111, 14);
		contentPane.add(lblngNhp);
		
		lblMtKh = new JLabel("Mật Khẩu");
		lblMtKh.setBounds(229, 180, 91, 14);
		contentPane.add(lblMtKh);
		
		pass_text = new JPasswordField();
		pass_text.setBounds(29, 174, 183, 27);
		contentPane.add(pass_text);
		JLabel User=new JLabel(new ImageIcon("img/user.png"));
		JPanel usr = new JPanel();
		usr.add(User);
		usr.setBounds(101, 12, 96, 90);
		contentPane.add(usr);
		
		Dang_nhap = new JButton("Đăng nhập");
		Dang_nhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Model.User us=new Model.User(name_text.getText(),pass_text.getText());
				boolean login = false;
				try {
					login = new getdata().Login_check(us);

					if(login==true) {
						
						Menu view= new Menu();
						view.setVisible(true);
						contentPane.setVisible(false); //you can't see me!
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Nhập Sai Mật khẩu hoặc tên đăng nhập");

					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Dang_nhap.setBounds(32, 254, 129, 24);
		contentPane.add(Dang_nhap);
		
		btnNewButton_1 = new JButton("Đăng kí");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register regis= new Register();
				regis.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(173, 254, 98, 24);
		contentPane.add(btnNewButton_1);
		
		label_quen_mk = new JLabel("Quên mật khẩu");
		label_quen_mk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");

			}
		});
		label_quen_mk.setBounds(42, 228, 98, 14);
		
		contentPane.add(label_quen_mk);
		Icon user= new ImageIcon("img/user.png");
	}
}
