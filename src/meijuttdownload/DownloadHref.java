package meijuttdownload;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

import java.io.BufferedWriter;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.FileWriter;
import java.io.IOException;  
import java.io.InputStreamReader;  

import meijuttsearch.SearchTV;

public class DownloadHref {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		String str = "生活大爆炸第九季";
		
		SearchTV searchTV = new SearchTV();
		
		//String strHref = searchTV.search(str);
		
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\huang_k@ctrip.com\\workspace\\meijuttdownload\\chromedriver.exe");
		
		List<String> listTVName = new ArrayList<String>();
		
		listTVName.add("生活大爆炸第九季");
		listTVName.add("天蝎第二季");
		listTVName.add("海军罪案调查处第十三季");
		listTVName.add("谍网第一季");
		listTVName.add("犯罪现场调查：网络第二季");
		listTVName.add("犯罪现场调查：网络第一季");
		listTVName.add("灵书妙探第八季");
		listTVName.add("福尔摩斯：基本演绎法第四季");
		
		
		List<String> listTVHref = searchTV.listsearch(listTVName);
		
		WebDriver dr = new ChromeDriver();
		
		//System.out.println(" Page title is " + dr.getTitle());
		//dr.get("http://www.meijutt.com/content/meiju20294.html");
		for (String list : listTVHref)
		{
			dr.get(list);
		//WebElement txt = dr.findElement(By.linkText("迅雷下载"));
		
		//System.out.println(txt.getText());
		
		//WebElement txt1 = dr.findElement(By.xpath("/html/body/div[5]/div[5]/div[5]/div/span/h2"));
		
		//System.out.println(txt1.getText());
		////*[@id="redu"]/h1
			WebElement tvName = dr.findElement(By.xpath("//*[@id='redu']/h1"));
		
			System.out.println(tvName.getText());
			
			File file = new File(tvName.getText()+".txt");
			FileWriter fw = null;
	        BufferedWriter writer = null;
	        fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
			List<WebElement> listElement = dr.findElements(By.xpath("//*[@id='jishu']/div/ul/li"));
		
			List<WebElement> listElement1 = dr.findElements(By.xpath("//*[@id='jishu']/div/ul/li/div[1]/div/span"));
		
			List<WebElement> listElement2 = dr.findElements(By.xpath("//*[@id='jishu']/div/ul/li/div[1]/div/input"));
			writer.write(listElement1.get(0).getText().toString() + "-" + listElement1.get(listElement.size()-1).getText().toString());
            writer.newLine();
			for (int i = 0; i < listElement.size(); i++)
			{
				System.out.println(listElement1.get(i).getText());
				System.out.println(listElement2.get(i).getAttribute("value"));
				
				
				writer.write(listElement2.get(i).getAttribute("value").toString());
                writer.newLine();
				//System.out.println(listElement.get(i).findElement(arg0));
				//System.out.println(listElement.get(i).findElement(By.xpath("/div[@class='adds']/div/span")).getText() 
				//		+ listElement.get(i).findElement(By.xpath("/div/input[@type = 'text']")).getAttribute("value"));
			}
			writer.flush();
			writer.close();
            fw.close();
			System.out.println();
		
			Thread.sleep(1000);
				
		}
		
		dr.quit();
		
		System.out.println("浏览器已关闭");
	}

}
