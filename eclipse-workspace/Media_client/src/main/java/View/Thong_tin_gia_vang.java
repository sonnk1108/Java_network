package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import Controller.getdata;
import Model.Gold;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Thong_tin_gia_vang extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Gold> gold = new ArrayList<>();
	
	String  col[]= {"Ngày","Giá","Đơn Vị"};
	DefaultTableModel tableModel = new DefaultTableModel(col,0);
	/**
	 * Launch the application.
	 */
	
	 public static JFreeChart createChart() throws RemoteException {
	        JFreeChart barChart = ChartFactory.createBarChart(
	                "Tình hình giá vàng thế giới ",
	                "Ngày", "Giá",
	                createDataset(), PlotOrientation.VERTICAL, false, false, false);
	        return barChart;
	    }


	private static CategoryDataset createDataset() throws RemoteException {
		ArrayList<Gold> golD = new ArrayList<>();

		golD=new getdata().getxau();
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Gold go: golD) {
        	String pattern = "######";
			double number = Double.parseDouble(go.getPrice());
			DecimalFormat decimalFormat = new DecimalFormat(pattern);
			String format = decimalFormat.format(number);
        	dataset.addValue(Double.parseDouble(format),"Giá",go.getDate());
        }

		// TODO Auto-generated method stub
		return dataset;
	}
	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public Thong_tin_gia_vang() throws RemoteException {
		gold=new getdata().getxau();
		ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 350));

		setBounds(100, 100, 901, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 12, 831, 137);
		contentPane.add(scrollPane);
		Object rowdata[] = new Object[3];
		for(Gold g: gold) {
			rowdata[0]=g.getDate();
			rowdata[1]=g.getPrice();
			rowdata[2]="ounce";
			tableModel.addRow(rowdata);
		}
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 167, 829, 321);
		panel.add(chartPanel);
		contentPane.add(panel);
	}
}
