package payloads;

import java.util.ArrayList;
import cucumber.api.Scenario;

public class TestData {
	public static Pojo p = new Pojo();
	public static Scenario step;

	public static Pojo addplace() {
		
		try {

			p.setAccuracy(50);
			p.setAddress("xds");
			p.setLanguage("eng");
			Location l = new Location();
			l.setLat(1234);
			l.setLng(-567.09);
			p.setLocation(l);
			p.setName("gopi");
			p.setPhone_number(123456789);
			ArrayList<String> al = new ArrayList<String>();
			al.add("abc");
			al.add("def");
			p.setTypes(al);
			p.setWebsite("www.google.com");
		} catch (Exception e) {
			step.write("exception occured:" + e.toString());
		}
		return p;
	}

}
