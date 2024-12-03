package testData;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

public class Utilities {
	public static RequestSpecification req;
	
	public static String getbaseUrl(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Eclipse New\\NewWorkSpace\\ReviseTheFrameWork\\src\\test\\java\\testData\\global.properties");
		prop.load(fs);
		return prop.getProperty(key);
	}
	public static RequestSpecification RequestSpecification() throws IOException {
		if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
		req = new RequestSpecBuilder().setBaseUri(Utilities.getbaseUrl("baseurl")).addQueryParam("key", "qaclick123").addHeader("Content-Type", "application/json").addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return req;
		}
		return req;
	}
	
	public String JsonPath(Response response, String key) {
		  String res = response.asString();
		JsonPath js = new JsonPath(res);
		return js.get(key).toString();
		
	}
}
