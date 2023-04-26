package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {


public static JsonPath RawTojson(String getResponce) {
	JsonPath js1=new JsonPath(getResponce);
	return js1;

}




}
