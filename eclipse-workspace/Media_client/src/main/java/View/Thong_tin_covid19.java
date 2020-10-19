package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.getdata;
import Model.Covid19;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Thong_tin_covid19 extends JFrame {

	private JPanel contentPane;
	private JTextField tim_kiem;
	private Covid19 cvd19;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public Thong_tin_covid19() throws RemoteException {
		 cvd19 = new getdata().getCovid19();
		int countVN=0;
		for(int i=0;i <cvd19.getCountries().length;i++) {
			if(cvd19.getCountries()[i].getSlug().equals("vietnam")) {
				countVN=i;
			}
		}
		
		setBounds(100, 100, 773, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(12, 273, 749, 212);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 12, 174, 27);
		panel.add(panel_2);
		
		JLabel lblThGii = new JLabel("Thế giới");
		panel_2.add(lblThGii);
		
		JLabel lblTngSCa_1 = new JLabel("Tổng số ca nhiễm");
		lblTngSCa_1.setForeground(Color.WHITE);
		lblTngSCa_1.setBounds(35, 186, 111, 14);
		panel.add(lblTngSCa_1);
		
		JLabel lblNewLabel_2 = new JLabel("Đang điều trị");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(236, 186, 92, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblKhi_2 = new JLabel("Tử vong");
		lblKhi_2.setForeground(Color.WHITE);
		lblKhi_2.setBounds(426, 186, 55, 14);
		panel.add(lblKhi_2);
		
		JLabel lblKhi_1_1 = new JLabel("Khỏi");
		lblKhi_1_1.setForeground(Color.WHITE);
		lblKhi_1_1.setBounds(608, 186, 55, 14);
		panel.add(lblKhi_1_1);
		
		JLabel global_canhiem = new JLabel("New label");
		global_canhiem.setForeground(Color.WHITE);
		global_canhiem.setBounds(35, 93, 140, 47);
		global_canhiem.setText(String.valueOf(cvd19.getGlobal().getTotalConfirmed()));
		global_canhiem.setFont(new Font("Serif", Font.BOLD, 20));
		
		panel.add(global_canhiem);
		
		JLabel global_dieutri = new JLabel("New label");
		global_dieutri.setForeground(Color.WHITE);
		global_dieutri.setBounds(219, 99, 164, 34);
		global_dieutri.setText(String.valueOf(cvd19.getGlobal().getNewRecovered()));
		global_dieutri.setFont(new Font("Serif", Font.BOLD, 20));
		panel.add(global_dieutri);
		
		JLabel global_tuvong = new JLabel("New label");
		global_tuvong.setForeground(Color.WHITE);
		global_tuvong.setFont(new Font("Serif", Font.BOLD, 20));
		global_tuvong.setBounds(395, 96, 164, 40);
		global_tuvong.setText(String.valueOf(cvd19.getGlobal().getTotalDeaths()));
		panel.add(global_tuvong);
		
		JLabel global_khoi = new JLabel("New label");
		global_khoi.setForeground(Color.WHITE);
		global_khoi.setBounds(561, 99, 148, 35);
		global_khoi.setFont(new Font("Serif", Font.BOLD, 20));
		global_khoi.setText(String.valueOf(cvd19.getGlobal().getTotalRecovered()));
		panel.add(global_khoi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(12, 59, 749, 192);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTngSCa = new JLabel("Tổng số ca nhiễm");
		lblTngSCa.setForeground(Color.WHITE);
		lblTngSCa.setBounds(28, 166, 111, 14);
		panel_1.add(lblTngSCa);
		
		JLabel lblNewLabel = new JLabel("Đang điều trị");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(232, 166, 92, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblKhi = new JLabel("Tử vong");
		lblKhi.setForeground(Color.WHITE);
		lblKhi.setBounds(416, 166, 55, 14);
		panel_1.add(lblKhi);
		
		JLabel lblKhi_1 = new JLabel("Khỏi");
		lblKhi_1.setForeground(Color.WHITE);
		lblKhi_1.setBounds(583, 166, 55, 14);
		panel_1.add(lblKhi_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 12, 164, 30);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblKhuVc = new JLabel("Khu Vực:");
		lblKhuVc.setBounds(0, 0, 151, 30);
		panel_3.add(lblKhuVc);
		lblKhuVc.setForeground(Color.BLACK);
		lblKhuVc.setBackground(Color.WHITE);
		
		final JLabel khu_vuc = new JLabel(".");
		khu_vuc.setBounds(65, 0, 138, 30);
		khu_vuc.setText(cvd19.getCountries()[countVN].getCountry());
		panel_3.add(khu_vuc);
		
		final JLabel s = new JLabel("tongsocanhiem");
		s.setForeground(Color.WHITE);
		s.setBounds(28, 91, 111, 22);
		s.setText(String.valueOf(cvd19.getCountries()[countVN].getTotalConfirmed()));
		s.setFont(new Font("Serif", Font.BOLD, 20));
		panel_1.add(s);
		
		final JLabel dangdieutri = new JLabel("New label");
		dangdieutri.setForeground(Color.WHITE);
		dangdieutri.setBounds(230, 91, 109, 22);
		dangdieutri.setText(String.valueOf(cvd19.getCountries()[countVN].getNewRecovered()));
		dangdieutri.setFont(new Font("Serif", Font.BOLD, 20));
		panel_1.add(dangdieutri);
		
		final JLabel tuvong = new JLabel("New label");
		tuvong.setForeground(Color.WHITE);
		tuvong.setBounds(416, 79, 116, 42);
		tuvong.setText(String.valueOf(cvd19.getCountries()[countVN].getTotalDeaths()));
		tuvong.setFont(new Font("Serif", Font.BOLD, 20));
		panel_1.add(tuvong);
		
		final JLabel kh_oi = new JLabel("New label");
		kh_oi.setForeground(Color.WHITE);
		kh_oi.setBounds(569, 91, 128, 30);
		kh_oi.setText(String.valueOf(cvd19.getCountries()[countVN].getTotalRecovered()));
		kh_oi.setFont(new Font("Serif", Font.BOLD, 20));
		panel_1.add(kh_oi);
		
		tim_kiem = new JTextField();
		tim_kiem.setBounds(12, 29, 556, 18);
		contentPane.add(tim_kiem);
		tim_kiem.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm Kiếm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int countSearch=0;
				String tim_Kiem= tim_kiem.getText();
				for(int i=0;i <cvd19.getCountries().length;i++) {
					if(cvd19.getCountries()[i].getSlug().equals(tim_Kiem)) {
						khu_vuc.setText(cvd19.getCountries()[i].getCountry());
						s.setText(String.valueOf(cvd19.getCountries()[i].getTotalConfirmed()));
						dangdieutri.setText(String.valueOf(cvd19.getCountries()[i].getNewRecovered()));
						kh_oi.setText(String.valueOf(cvd19.getCountries()[i].getTotalRecovered()));

						tuvong.setText(String.valueOf(cvd19.getCountries()[i].getTotalDeaths()));

					}
					
				}
			

			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(595, 26, 166, 24);
		contentPane.add(btnNewButton);
		
	}
}
