package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';
	static Socket sk =null;
	public static void main(String[]args) {
		try {
			sk= new Socket("192.168.0.103",11001);
			String hovaten="Nguyễn Khánh Sơn";
			String maSV= "B17DCAT157";

			int nhom=3;

			DataInputStream ins= new DataInputStream(sk.getInputStream());
			DataOutputStream ous = new DataOutputStream(sk.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(sk.getInputStream());
			ous.writeUTF(maSV); ous.flush();
			ous.writeUTF(hovaten); ous.flush();
			ous.writeInt(nhom);ous.flush();
			int choice =ins.readInt();
			System.out.println(choice);
			if(choice==0) {
				System.out.println("Choice : 0");
				
				String xau1=ins.readUTF();
				System.out.print(xau1);
				String re_xau1=daoxau(xau1);
				ous.writeUTF(re_xau1);
				String xau2=ins.readUTF();
				String xau3=ins.readUTF();
				int count=countFreq(xau3,xau2);
				ous.writeInt(count);
				ous.flush();
				
			}
			else if (choice ==1){
				System.out.println("Choice : 1");
				String xau2=ins.readUTF();
				System.out.println(xau2);
				String xau3=ins.readUTF();
				int count=countFreq(xau3,xau2);
				ous.writeInt(count);
				ous.flush();
				String xau1=ins.readUTF();
				String re_xau1=daoxau(xau1);
				ous.writeUTF(re_xau1);
				ous.flush();
				
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String daoxau(String input) {
		  String reverse = new StringBuffer(input).
		  reverse().toString();
		return reverse;
	}
	
	static int countFreq(String pat, String txt) {        
        int M = pat.length();        
        int N = txt.length();        
        int res = 0;
 
        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) {
            /* For current index i, check for 
        pattern match */
            int j;            
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
 
            // if pat[0...M-1] = txt[i, i+1, ...i+M-1] 
            if (j == M) {                
                res++;                
                j = 0;                
            }            
        }        
        return res;        
    }
	

}
