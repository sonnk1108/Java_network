package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 390);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Icon thoitiet= new ImageIcon("img/weather-icon.png");
		JButton thoi_tiet = new JButton(thoitiet);
		thoi_tiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Thong_tin_thoi_tiet viewthoitiet= new Thong_tin_thoi_tiet();
					viewthoitiet.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		thoi_tiet.setBounds(37, 37, 130, 110);
		contentPane.add(thoi_tiet);
		JLabel lblKieerm = new JLabel("Thời Tiết Trong Tuần");
		lblKieerm.setBounds(37, 154, 162, 14);
		contentPane.add(lblKieerm);
		Icon gia_vang= new ImageIcon("img/gold_icon .png");
		JButton gia_vang_b = new JButton(gia_vang);
		gia_vang_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Thong_tin_gia_vang view_gia_vang= new Thong_tin_gia_vang();
					view_gia_vang.setVisible(true);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		gia_vang_b.setBounds(236, 37, 138, 110);
		contentPane.add(gia_vang_b);
		
		JLabel lblGiVng = new JLabel("Giá vàng thế giới");
		lblGiVng.setBounds(260, 154, 120, 14);
		contentPane.add(lblGiVng);
		Icon dichbenh= new ImageIcon("img/Bo_y_te.png");
		JButton dich_bech = new JButton(dichbenh);
		dich_bech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thong_tin_covid19 view_covid19;
				try {
					view_covid19 = new Thong_tin_covid19();
					view_covid19.setVisible(true);

				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		dich_bech.setBounds(450, 37, 143, 110);
		contentPane.add(dich_bech);
		JLabel lblNewLabel = new JLabel("Tình hình dịch bệnh");
		lblNewLabel.setBounds(471, 154, 120, 14);
		contentPane.add(lblNewLabel);
		Icon diem_chuan= new ImageIcon("img/search.png");
		JButton btn_diem_chuan = new JButton(diem_chuan);
		btn_diem_chuan.setBounds(37, 202, 130, 120);
		contentPane.add(btn_diem_chuan);
		JLabel lblimThi = new JLabel("Điểm chuẩn các trường đại học");
		lblimThi.setBounds(22, 334, 202, 14);
		contentPane.add(lblimThi);
		Icon xs_mb= new ImageIcon("img/xsmb.png");
		JButton xsmb = new JButton(xs_mb);
		xsmb.setBounds(236, 202, 138, 120);
		contentPane.add(xsmb);
		Icon Exit= new ImageIcon("img/EXIT.png");
		JButton exit = new JButton(Exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		exit.setBounds(455, 202, 138, 120);
		contentPane.add(exit);
		JLabel lblKtQuS = new JLabel("Kết quả sổ xố miền bắc");
		lblKtQuS.setBounds(236, 334, 162, 14);
		contentPane.add(lblKtQuS);
		JLabel lblTh = new JLabel("Thoát");
		lblTh.setBounds(494, 334, 55, 14);
		contentPane.add(lblTh);
	}
}
