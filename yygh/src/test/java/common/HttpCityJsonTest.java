package common;


import java.util.List;

import com.ijoy.common.comutil.HttpCity;
import com.ijoy.common.domain.City;

public class HttpCityJsonTest {
	public static void main(String[] args) {
		try {
			List<City> cities = HttpCity.getList("chineseCities");
		   System.out.println(cities);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
