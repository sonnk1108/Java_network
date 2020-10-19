package View;

import java.io.IOException;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import Controller.MediaServer;
import Model.JsonResult;

public class RunServer {
	public static void main(String [] args) {
		new MediaServer().run();;
	}
}
