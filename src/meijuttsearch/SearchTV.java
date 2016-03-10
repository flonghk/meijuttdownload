package meijuttsearch;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;


public class SearchTV {

	public String search(String tvName) throws InterruptedException
	{
		String str = "";
		
		String strHref = "http://www.meijutt.com";
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\huang_k@ctrip.com\\workspace\\meijuttdownload\\chromedriver.exe");
		
		WebDriver dr = new ChromeDriver();
		
		//dr.get("http://www.baidu.com/");
		
		//System.out.println(" Page title is " + dr.getTitle());
		dr.get(strHref+"/");
		
		dr.findElement(By.id("keyword")).sendKeys(tvName);
		
		dr.findElement(By.id("keyword_bnt")).click();
		
		Thread.sleep(1000);
		
		str = dr.findElement(By.partialLinkText(tvName)).getAttribute("href");
		
		//System.out.println(str);
		
		return str;
	}
	
	public List<String> listsearch(List<String> listTVName) throws InterruptedException
	{
		List<String> listHref = new ArrayList<String>();
		
		String strHref = "http://www.meijutt.com";
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\huang_k@ctrip.com\\workspace\\meijuttdownload\\chromedriver.exe");
		
		WebDriver dr = new ChromeDriver();
		
		dr.get(strHref+"/");
		
		for(String list : listTVName)
		{
			
			
			dr.findElement(By.id("keyword")).sendKeys(list);
			
			dr.findElement(By.id("keyword_bnt")).click();
			
			Thread.sleep(1000);
			
			listHref.add( dr.findElement(By.partialLinkText(list)).getAttribute("href"));
			
			//System.out.println(listHref.g);
		}
		
		for(String list : listHref)
		{
			System.out.println(list);
		}
		
		dr.quit();
		
		return listHref;
		
	}
	
	
}
