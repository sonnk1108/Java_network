package Controller;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import Model.JsonResult;

 class Handle_Api_ThoiTiet_Implement  implements Handle_API_ThoiTiet{
	public JsonResult getJsonData(String city) {
		
		//Khoi tao doi tuong client
		OkHttpClient client= new OkHttpClient();
		Gson gson = new Gson();
		JsonResult data =null;
		//tao mot request den API
		Request res = new Request.Builder().url("http://api.openweathermap.org/data/2.5/forecast?q=Hanoi&APPID=bffca17bcb552b8c8e4f3b82f64cccd2&units=metric").build();
		try {
			//gui request den AI va nhan ve response
			Response response = client.newCall(res).execute();
			//chi lay phan body
			ResponseBody body= response.body();
			
			 String text=body.string().replace("3h","rx");
			//chuyen json thanh object
			data= gson.fromJson(text,JsonResult.class);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				return data;
	}
}
