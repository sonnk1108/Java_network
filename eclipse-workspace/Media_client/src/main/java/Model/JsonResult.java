package Model;

import java.io.Serializable;

public class JsonResult  implements Serializable {
 private DailyWeather[] list;

public DailyWeather[] getList() {
	return list;
}
 
}
