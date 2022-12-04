package org.baseclass;



	import java.awt.AWTException;


	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Element;
import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		public static WebDriver driver;
		static Robot r;
		static Actions a;
		static JavascriptExecutor js;
		static TakesScreenshot tk;
		static Alert al;
		static Select s;
		
		public static void getDateTime()
		{
			Date d = new Date();
			System.out.println(d);
		}
		
		public static void applyImplicitWait()
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		public static void openChromeBrowser()
		{
			WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		}
		public static void openEdgeBrowser()
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			
		}
		public static void openFirefoxBrowser()
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		public static void maxWindow()
		{
			driver.manage().window().maximize();
		}
		public static void toLaunchUrl(String urlName)
		{
			driver.get(urlName);
		}
	public static String toFetchUrl()
	{
		String url= driver.getCurrentUrl();
		System.out.println(url);
		return url;
	}
	public static void toFetchTitle()
	{
		String title= driver.getTitle();
		System.out.println(title);
		
	}
	public static void closeBrowser()
	{
		driver.quit();
		
	}
	public static void closeCurrentTab()
	{
		driver.close();
	}
	public static void fillTextBox(WebElement element,String input)
	{
		element.sendKeys(input);
	}
	public static void toClickButton(WebElement element)
	{
		element.click();
	}
	public static void toHoldProg(int time) throws InterruptedException
	{
		Thread.sleep(time);
	}
	public static void fetchText(WebElement element)
	{
		String text= element.getText();
		System.out.println(text);
	}
	public static void fetchAttributeValue(WebElement element,String value) 
	{
	String attributeValue=element.getAttribute(value);
	System.out.println(attributeValue);
	}
	public static void copy() throws AWTException
	{
		 r = new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_C);
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_C);	
		 
	}
	public static void keyboardActionCut() throws AWTException
	{
		r = new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_X);
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_X);	
	}


	public static void paste()throws AWTException
	{
	 r= new Robot();
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_V);

	}
	public static void keyboardActionSelectAll() throws AWTException
	{
		r = new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_A);
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_A);	
		
	}
	public static void dragDrop(WebElement e1,WebElement e2)
	{
	 a = new Actions(driver);
	a.dragAndDrop(e1,e2).perform();

	}
	public static void mouseOver(WebElement target)
	{
		a=new Actions(driver);
		a.moveToElement(target).perform();
	}
	public static void doubleClick(WebElement ele)
	{
		a= new Actions(driver);
		a.doubleClick(ele).perform();
	}
	public static void contextClick(WebElement ele)
	{
		a= new Actions(driver);
		a.contextClick(ele).perform();
	}
	
	public static void scrollDown(WebElement element)
	{
		 js= (JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].scrollIntoView(true)",element);
	}
	public static void scrollUp(WebElement element)
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)",element);
	}
	public static void snapShot(String page1) throws IOException
	{
		 tk=(TakesScreenshot)driver;
		File sr= tk.getScreenshotAs(OutputType.FILE);
		 File des = new File("C:\\Users\\venka\\eclipse-workspace\\Maven2.30pm\\screenshot\\" +page1+".png");
		 FileUtils.copyFile(sr,des);
		
	}
	public static void alertAccept()
	{
		al= driver.switchTo().alert();
		al.accept();
		
	}
	
	public static void alertDismiss()
	{
		al= driver.switchTo().alert();
		al.dismiss();
	}
	public static void alertTextBox(String input)
	{
		al= driver.switchTo().alert();
		al.sendKeys(input);
		
	}
	public static void alertTextPrint(String input)
	{
	al=driver.switchTo().alert();
	al.sendKeys(input);
	String t= al.getText();
	System.out.println(t);
	}
	public static void selectByIndexDropdown(WebElement element)
	{
		 s= new Select(element);
		s.selectByIndex(0);
		}
	public static void selectByValueDropdown(WebElement element,String value)
	{
		s = new Select(element);
		s.selectByValue(value);
	}
	public static void selectByVisibleText(WebElement element,String text)
	{
	s=new Select(element);
	s.selectByVisibleText(text);
	}
	public static void isMultipleDropdown(WebElement element)
	{
		s = new Select(element);
		if(s.isMultiple())
		{
			System.out.println("multiple dropdown");
		}
		else
		{
			System.out.println("single dropdown");
		}
	}
	public static void allDropdownOptionPrint(WebElement element)
	{
		s= new Select(element);
		List<WebElement> allOptions=s.getOptions();
		int count=allOptions.size();
		System.out.println("no of options :" +count);
		
		for (WebElement eachOption : allOptions) {
			
		System.out.println("all options are :" +eachOption.getText());
			
		}
	}
	public static void allSelectedOptionDropDown()
	{
		List<WebElement> allSelectedOption=s.getAllSelectedOptions();
		System.out.println("No of selected option :" +allSelectedOption);
		for(int i=0;i<allSelectedOption.size();i++) {
			WebElement eachSelected=allSelectedOption.get(i);
			System.out.println(eachSelected.getText());
		}
		
	}
	public static void firstSelectedDropdown(WebElement element)
	{
		s= new Select(element);
		WebElement firstSelected = s.getFirstSelectedOption();
		System.out.println("First selected dropdown :" +firstSelected);
	}
		public static void deselectByIndexDropdown(WebElement element)
		{
			s= new Select(element);
			s.deselectByIndex(0);
		}
		public static void deselectByVisibleTextDropDown(WebElement element,String value)
		{
			s= new Select(element);
			s.deselectByValue(value);
		}
		public static void deselectByValue(WebElement element,String text)
		{
			s= new Select(element);
			s.deselectByVisibleText(text);
		}
		public static void deselectAllDropdown(WebElement element)
		{
			
		s=new Select(element);
		s.deselectAll();
		}
		public static void parentId(String t)
		{
		driver.getWindowHandle();
			System.out.println(t);
		
		}
		public static void allWindow()
		{
			Set<String> allWindowId= driver.getWindowHandles();
			System.out.println(allWindowId);
		}
		public static void childWindow(int i)
		{
			Set<String> allWindowId= driver.getWindowHandles();
		List<String> li= new ArrayList<>(allWindowId);
		driver.switchTo().window(li.get(i));
			
		}
		public static String readDataFromExcel(String sheetName,int rowNo,int cellNo ) throws IOException {
			File f = new File("C:\\Users\\venka\\eclipse-workspace\\CucumberSample11\\ExcelSheet\\Facebook.xlsx");
			FileInputStream fin= new FileInputStream(f);
			Workbook b= new XSSFWorkbook(fin);
			Sheet s= b.getSheet(sheetName);
			Row r= s.getRow(rowNo);
			Cell c=r.getCell(cellNo);
			int type=c.getCellType();
			String input;
			if (type==1) {
				 input=c.getStringCellValue();
			}
				else if(DateUtil.isCellDateFormatted(c))
				{
					Date d=c.getDateCellValue();
					SimpleDateFormat sim= new SimpleDateFormat("MMMM dd,yyyy");
					 input=sim.format(d);
				}
					else
					{
						double dou=c.getNumericCellValue();
						long l=(long)dou;
						input=String.valueOf(l);
						
					}	
			return input;
		
		
			}}



