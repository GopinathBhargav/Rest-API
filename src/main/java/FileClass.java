import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class FileClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Properties p = new Properties();
		
//FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/configuration.properties");
//p.load(fis);
		
FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/src/test/java/resources/configuration.properties");
p.setProperty("testurl", "myname");
p.store(fos, "new file created");





	}

}
