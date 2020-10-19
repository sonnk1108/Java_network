package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.JsonResult;


import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.border.LineBorder;

import Controller.ControlRmi;
import Controller.getdata;

import java.awt.Color;

public class Thong_tin_thoi_tiet extends JFrame {
	public static JsonResult result;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Thong_tin_thoi_tiet() throws IOException {
		result= new getdata().getData();
		int numberDay=result.getList().length;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GREEN, 2));
		panel.setBounds(12, 260, 785, 207);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbng = new JLabel("Ngày :");
		lbng.setBounds(65, 12, 55, 14);
		panel.add(lbng);
		
		JLabel lbng_1 = new JLabel("Ngày :");
		lbng_1.setBounds(228, 12, 55, 14);
		panel.add(lbng_1);
		
		JLabel lbng_2 = new JLabel("Ngày :");
		lbng_2.setBounds(368, 12, 55, 14);
		panel.add(lbng_2);
		
		JLabel lbng_3 = new JLabel("Ngày :");
		lbng_3.setBounds(502, 12, 55, 14);
		panel.add(lbng_3);
		
		JLabel lbng_4 = new JLabel("Ngày :");
		lbng_4.setBounds(646, 12, 55, 14);
		panel.add(lbng_4);
		
		JPanel day1 = new JPanel();
		day1.setBounds(51, 29, 105, 107);
		

		panel.add(day1);
		
		JPanel day2 = new JPanel();
		day2.setBounds(208, 29, 105, 107);
		panel.add(day2);
		
		JLabel picLabel_1 = new JLabel((Icon) null);
		day2.add(picLabel_1);
		
		JPanel day3 = new JPanel();
		day3.setBounds(348, 29, 105, 107);
		panel.add(day3);
		
		JLabel picLabel_2 = new JLabel((Icon) null);
		day3.add(picLabel_2);
		
		JPanel day4 = new JPanel();
		day4.setBounds(491, 29, 105, 107);
		panel.add(day4);
		
		JLabel picLabel_3 = new JLabel((Icon) null);
		day4.add(picLabel_3);
		
		JPanel day5 = new JPanel();
		day5.setBounds(631, 29, 105, 107);
		panel.add(day5);
		
		JLabel picLabel_4 = new JLabel((Icon) null);
		day5.add(picLabel_4);
		
		JLabel lbdoam = new JLabel("Độ ẩm            :");
		lbdoam.setBounds(476, 175, 82, 14);
		contentPane.add(lbdoam);
		
		JLabel lblTcGi = new JLabel("Tốc độ gió      :");
		lblTcGi.setBounds(476, 213, 95, 14);
		contentPane.add(lblTcGi);
		
		JLabel do_am = new JLabel("--");
		do_am.setBounds(612, 175, 55, 14);
		contentPane.add(do_am);
		
		JLabel toc_do_gio = new JLabel("--");
		toc_do_gio.setBounds(612, 213, 55, 14);
		contentPane.add(toc_do_gio);
		//them icon thoi tiet
		JLabel lbtoday=lbweather(result.getList()[0].getWeather()[0].getDescription());
		JLabel lbday1=lbweather(result.getList()[0].getWeather()[0].getDescription());
		day1.add(lbday1);
		JLabel lbday2=lbweather(result.getList()[4].getWeather()[0].getDescription());
		day2.add(lbday2);
		JLabel lbday3=lbweather(result.getList()[13].getWeather()[0].getDescription());
		day3.add(lbday3);
		JLabel lbday4=lbweather(result.getList()[22].getWeather()[0].getDescription());
		day4.add(lbday4);
		JLabel lbday5=lbweather(result.getList()[31].getWeather()[0].getDescription());
		day5.add(lbday5);
		//them ngay
		JLabel date1 = new JLabel("..");
		date1.setBounds(111, 12, 55, 14);
		date1.setText(getday(result.getList()[0].getDt_txt()));
		panel.add(date1);
		
		JLabel date2 = new JLabel("..");
		date2.setBounds(268, 12, 55, 14);
		date2.setText(getday(result.getList()[4].getDt_txt()));

		panel.add(date2);
		
		JLabel date3 = new JLabel("..");
		date3.setText(getday(result.getList()[13].getDt_txt()));

		date3.setBounds(398, 12, 55, 14);
		panel.add(date3);
		
		JLabel date4 = new JLabel("..");
		date4.setBounds(541, 12, 55, 14);
		date4.setText(getday(result.getList()[22].getDt_txt()));

		panel.add(date4);
		
		JLabel date5 = new JLabel("..");
		date5.setBounds(688, 12, 55, 14);
		date5.setText(getday(result.getList()[31].getDt_txt()));

		panel.add(date5);
		
		JLabel temp1 = new JLabel("Nhiệt Độ :");
		temp1.setBounds(51, 152, 55, 14);
		panel.add(temp1);
		
		JLabel temp1_1 = new JLabel("Nhiệt Độ :");
		temp1_1.setBounds(208, 152, 55, 14);
		panel.add(temp1_1);
		
		JLabel temp1_2 = new JLabel("Nhiệt Độ :");
		temp1_2.setBounds(348, 152, 55, 14);
		panel.add(temp1_2);
		
		JLabel temp1_3 = new JLabel("Nhiệt Độ :");
		temp1_3.setBounds(491, 152, 55, 14);
		panel.add(temp1_3);
		
		JLabel temp1_4 = new JLabel("Nhiệt Độ :");
		temp1_4.setBounds(631, 148, 55, 14);
		panel.add(temp1_4);
		
		JLabel nhiet1 = new JLabel("..");
		nhiet1.setBounds(111, 152, 55, 14);
		panel.add(nhiet1);
		
		JLabel nhiet2 = new JLabel("..");
		nhiet2.setBounds(268, 152, 55, 14);
		panel.add(nhiet2);
		
		JLabel nhiet3 = new JLabel("..");
		nhiet3.setBounds(415, 152, 55, 14);
		panel.add(nhiet3);
		
		JLabel nhiet4 = new JLabel("..");
		nhiet4.setBounds(564, 152, 55, 14);
		panel.add(nhiet4);
		
		JLabel nhiet5 = new JLabel("..");
		nhiet5.setBounds(698, 148, 55, 14);
		panel.add(nhiet5);
		//Them nhiet do trong ngay 
		nhiet1.setText(result.getList()[0].getMain().getTemp()+" *C");
		nhiet2.setText(result.getList()[4].getMain().getTemp()+" *C");
		nhiet3.setText(result.getList()[13].getMain().getTemp()+" *C");
		nhiet4.setText(result.getList()[22].getMain().getTemp()+" *C");
		nhiet5.setText(result.getList()[31].getMain().getTemp()+" *C");
		
		JLabel lblTmNhnXa = new JLabel("Tầm nhìn xa :");
		lblTmNhnXa.setBounds(477, 134, 106, 14);
		contentPane.add(lblTmNhnXa);
		
		JLabel Tam_nhin_x = new JLabel("...");
		Tam_nhin_x.setBounds(612, 134, 55, 14);
		contentPane.add(Tam_nhin_x);
		
		JLabel lblHmNay = new JLabel("Hôm Nay : ");
		lblHmNay.setBounds(27, 84, 67, 14);
		contentPane.add(lblHmNay);
		
		JLabel Today_date = new JLabel("..");
		Today_date.setBounds(168, 87, 165, 14);
		contentPane.add(Today_date);
		
		JPanel today_panel = new JPanel();
		today_panel.setBounds(27, 110, 124, 117);
		today_panel.add(lbtoday);
		contentPane.add(today_panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(168, 113, 165, 114);
		contentPane.add(panel_3);
		
		JLabel nhiet_today = new JLabel("New label");
		panel_3.add(nhiet_today);
		nhiet_today.setFont(new Font("Serif", Font.BOLD, 30));
		nhiet_today.setText(result.getList()[0].getMain().getTemp()+"*C");
		//Today update 
		toc_do_gio.setText(result.getList()[0].getWind().getSpeed()+"Km/h");
		do_am.setText(result.getList()[0].getMain().getHumidity()+"%");
		Tam_nhin_x.setText(result.getList()[0].getVisibility()+"M");
		Today_date.setText(result.getList()[0].getDt_txt());
	}
	public JLabel lbweather(String weather) throws IOException {
		JLabel picLabel = null;
		String scattered_clouds="/home/nguyekhanhson/eclipse-workspace/dubaothoitietdemop/img/scattered_clouds.png";
		String clear_sky="/home/nguyekhanhson/eclipse-workspace/dubaothoitietdemop/img/clear_sky.png";
		String overcast_clouds="/home/nguyekhanhson/eclipse-workspace/dubaothoitietdemop/img/overcast_clouds";
		String broken_clouds="/home/nguyekhanhson/eclipse-workspace/dubaothoitietdemop/img/broken_clouds.png";
		String few_clouds="/home/nguyekhanhson/eclipse-workspace/dubaothoitietdemop/img/few_clouds.png";
		String light_rain="/home/nguyekhanhson/eclipse-workspace/dubaothoitietdemop/img/light _rain.png";
		String moderate_rain="/home/nguyekhanhson/eclipse-workspace/dubaothoitietdemop/img/moderate_rain.png";
		String heavy_intensity_rain="/home/nguyekhanhson/eclipse-workspace/dubaothoitietdemop/img/heavy_intensity_rain.png";
		
		if(weather.equals("scattered clouds") ) {
			BufferedImage myPicture = ImageIO.read(new File(scattered_clouds));
			 picLabel = new JLabel(new ImageIcon(myPicture));
		} else if(weather.equals("clear sky")) {
			BufferedImage myPicture = ImageIO.read(new File(clear_sky));
			 picLabel = new JLabel(new ImageIcon(myPicture));
		} else if(weather.equals("overcast clouds")) {
			BufferedImage myPicture = ImageIO.read(new File(overcast_clouds));
			picLabel = new JLabel(new ImageIcon(myPicture));
		} else if( weather.equals("broken clouds")) {
			BufferedImage myPicture = ImageIO.read(new File(broken_clouds));
			 picLabel = new JLabel(new ImageIcon(myPicture));
		} else if( weather.equals("few clouds")) {
			BufferedImage myPicture = ImageIO.read(new File(few_clouds));
			 picLabel = new JLabel(new ImageIcon(myPicture));
		} else if( weather.equals("light rain")) {
			BufferedImage myPicture = ImageIO.read(new File(light_rain));
			 picLabel = new JLabel(new ImageIcon(myPicture));
		} else if( weather.equals("moderate rain")) {
			BufferedImage myPicture = ImageIO.read(new File(moderate_rain));
			 picLabel = new JLabel(new ImageIcon(myPicture));
		} else if( weather.equals("heavy_intensity_rain")) {
			BufferedImage myPicture = ImageIO.read(new File(heavy_intensity_rain));
			 picLabel = new JLabel(new ImageIcon(myPicture));
		} 
		return picLabel;
		
	}
	public String getday(String day) {
		 Date date2 = new Date();
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    
		    	try {
					date2 =formatter.parse(day);
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
		        SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM");
		        String strDate = formatter2.format(date2);
		return strDate;
		
	}
	
}
