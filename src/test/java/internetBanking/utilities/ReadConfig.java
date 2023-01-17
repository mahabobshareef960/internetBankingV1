package internetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	//then create the constructor
	public ReadConfig()
	{
		//this for open the file
	  File src = new  File("./Configurations/config.properties");
	  //then this is after to read this file
	  try {
		  FileInputStream fis = new FileInputStream(src);
		  //whole pro object is initiating here
		  pro = new Properties();
		  //after initiating  the file then we can load this complete file
		  pro.load(fis);
     }
	  //if the file is not available in location there is a chance to get exception
	  //for this reason entire statement of code is put in try catch Exception
	   catch (Exception e) {
		   System.out.println("Exception is" + e.getMessage());
	   }
	  }
	//then we create the methods to perform actions  as like in pageObjectModel
	  public String getApplicationUrl() {
		  String url = pro.getProperty("baseUrl");
		return url;
   }
	  public String getUsername() {
		  String user_name = pro.getProperty("username");
		return user_name;
   }
	  public String getPassword() {
		  String Pass_word = pro.getProperty("password");
		return Pass_word;
   }
	  public String getchromepath() {
		  String chromepath = pro.getProperty("chromepath");
		return chromepath;
   }
	  public String getfirefox() {
		  String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
   }
	  public String getEdge() {
		  String edgepath = pro.getProperty("edgepath");
		return edgepath ;
	  }
	  
}
