package Danh_ba_dien_thoai;

import java.util.Scanner;

public class Client_danhba_view {
	Scanner scan;
	public void Messageg(String msg) {
		System.out.println(""+msg);
	}
	public Client_danhba_view() {
	scan = new Scanner(System.in);

	}
	
	public int menu() {
		System.out.println("Them danh ba");
		System.out.println("tim kiem sdt theo ten");
		System.out.println("hien thi tat ca");
		System.out.println("Tim nguoi");
	
		int choice = 0;
		choice = scan.nextInt();
		return choice;
	}
	public Person person() {
		Person p;
		System.out.println("Ten nguoi");
		String name =scan.next();
		System.out.println("sdt");
		String sdt =scan.next();
		System.out.println("diachi");
		String diachi =scan.next();
		p=new Person(name,sdt,diachi);
		

		
		return p;
		
	}
	public String getName() {
		System.out.println("Nhap ten :");
		String name=scan.next();
		return name;
		
	}
}
