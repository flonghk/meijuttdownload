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

import java.util.Date;
import java.util.Calendar; 
import java.text.SimpleDateFormat;

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
		
		Calendar calendar = Calendar.getInstance();//可以对每个时间域单独修改

		int year = calendar.get(Calendar.YEAR); 
		int month = calendar.get(Calendar.MONTH); 
		int date = calendar.get(Calendar.DATE); 
		int hour = calendar.get(Calendar.HOUR_OF_DAY); 
		int minute = calendar.get(Calendar.MINUTE); 
		int second = calendar.get(Calendar.SECOND); 
		
		String time = "启动时间：" + year + "年" + month + "月" + date + "日" + hour + "时" + minute + "分" + second + "秒";
				
		System.out.println(time);
		
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
			
			String fileName = tvName.getText()+".txt";
			
			File file = new File(fileName);
			
		    if(!file.exists())   
		    {   
		        try {   
		            file.createNewFile();   
		        } catch (IOException e) {   
		            // TODO Auto-generated catch block   
		            e.printStackTrace();   
		        }   
		    } 
		    
			//FileWriter fw = null;
	        //BufferedWriter writer = null;
	        //fw = new FileWriter(file);
            //writer = new BufferedWriter(fw);
			List<WebElement> listElement = dr.findElements(By.xpath("//*[@id='jishu']/div/ul/li"));
		
			List<WebElement> listElement1 = dr.findElements(By.xpath("//*[@id='jishu']/div/ul/li/div[1]/div/span"));
		
			List<WebElement> listElement2 = dr.findElements(By.xpath("//*[@id='jishu']/div/ul/li/div[1]/div/input"));
			//writer.write(listElement1.get(0).getText().toString() + "-" + listElement1.get(listElement.size()-1).getText().toString());
            //writer.newLine();
			//从第几集到第几集
			String beginToEnd = listElement1.get(0).getText().toString() + "-" + listElement1.get(listElement.size()-1).getText().toString();
			appendMethod(fileName,time);
			appendMethod(fileName,beginToEnd);
			for (int i = 0; i < listElement.size(); i++)
			{
				System.out.println(listElement1.get(i).getText());
				System.out.println(listElement2.get(i).getAttribute("value"));
				
				String downloadHref = listElement2.get(i).getAttribute("value").toString();
				
				appendMethod(fileName,downloadHref);
				//writer.write(listElement2.get(i).getAttribute("value").toString());
                //writer.newLine();
				//System.out.println(listElement.get(i).findElement(arg0));
				//System.out.println(listElement.get(i).findElement(By.xpath("/div[@class='adds']/div/span")).getText() 
				//		+ listElement.get(i).findElement(By.xpath("/div/input[@type = 'text']")).getAttribute("value"));
			}
			//writer.flush();
			//writer.close();
            //fw.close();
			System.out.println();
		
			Thread.sleep(1000);
				
		}
		
		dr.quit();
		
		System.out.println("浏览器已关闭");
	}
	
    /** 
     * 追加文件：使用FileWriter 
     *  
     * @param fileName 
     * @param content 
     */  
    public static void appendMethod(String fileName, String content) {  
        try {  
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件  
			//FileWriter fw = null;
	        //BufferedWriter writer = null;
	        //fw = new FileWriter(file);
            //writer = new BufferedWriter(fw);
            FileWriter fw = new FileWriter(fileName, true); 
            BufferedWriter writer = new BufferedWriter(fw);
            writer = new BufferedWriter(fw);
            writer.write(content);  
            writer.newLine();
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  

}
