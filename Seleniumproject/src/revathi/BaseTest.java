package revathi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties e;
	public static Properties envprop;
	
	public static void init() throws Exception
	{
		System.out.println("properties is loading.....");
		fis=new FileInputStream(projectPath+"//data.properties");
		p=new Properties();
		p.load(fis);
		
		fis=new FileInputStream(projectPath+"//environment.properties");
		e=new Properties();
		e.load(fis);
		String str = e.getProperty("env");
		System.out.println(str);
		
		fis=new FileInputStream(projectPath+"//"+str+".properties");
		envprop=new Properties();
		envprop.load(fis);
		System.out.println(envprop.getProperty("amazomurl"));
		
	}
	
	
	
public static void launch(String browser)
	{
	if(p.getProperty(browser).equals("chrome"))
	{
	//System.setProperty("webdriver.chrome.driver", "D:\\New folder (3)\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		
		driver= new ChromeDriver();
	}
	else if(p.getProperty(browser).equals("firefox"))
	{
	//System.setProperty("webdriver.gecko.driver","D:\\New folder (3)\\Seleniumproject\\drivers\\geckodriver.exe" );
	
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver.exe" );
		driver= new FirefoxDriver();
	}

	}


	public static void navigateUrl(String url) throws Exception
	{
		
		driver.get(envprop.getProperty(url));
	
	
	}
	}

	
	


