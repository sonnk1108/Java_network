package Controller;

import java.io.IOException;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import Model.Covid19;

public class Handle_API_Covid19_implement implements Handle_API_Covid19 {
	public Covid19 getcoviddata(){
		//khoi tao doi tuong client
		OkHttpClient client = new OkHttpClient();
		Gson gson = new Gson();
		Covid19 cvid19= new Covid19();
		Request res = new Request.Builder().url("https://api.covid19api.com/summary").build();
		try {
			Response response = client.newCall(res).execute();
			ResponseBody body =response.body();
			cvid19=gson.fromJson(body.string(),Covid19.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cvid19;
		
		
	}

}
