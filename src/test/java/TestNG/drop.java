package TestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class drop {
	WebDriver driver;
	
	@BeforeMethod(alwaysRun= true)
	public void browserLaunch() {
			
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Resources\\Drivers\\chromedriver.exe");
		ChromeOptions cp = new ChromeOptions();
		cp.addArguments("incognito", "start-maximized");
		driver = new ChromeDriver(cp);
		driver.get("https://demoqa.com/");
		
	}
		
	@Test(description = "This test is for sorting Grid", groups = {"Sanity"})
	public void sortGridTest() throws InterruptedException {
	
	
	Actions act = new Actions(driver);

	act.scrollByAmount(0, 200).build().perform();

	WebElement element = driver.findElement(By.xpath("//*[text()='Elements']"));
	element.click();

	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,600)", "");

	WebElement interactiontab = driver.findElement(By.xpath("//*[text()='Interactions']"));
	interactiontab.click();

	Thread.sleep(2000);

	WebElement sort = driver.findElement(By.xpath("//*[text()='Sortable']"));
	sort.click();
	
	WebElement grid = driver.findElement(By.id("demo-tab-grid"));
	grid.click();
	
	
	String scrPoint= "Six";
	String destPoint= "One";

	WebElement scr= driver.findElement(By.xpath("//*[@class='grid-container mt-4']//*[text()='"+scrPoint+"']"));
	WebElement dest = driver.findElement(By.xpath("//*[@class='grid-container mt-4']//*[text()='"+destPoint+"']"));
	act.clickAndHold(scr).moveToElement(dest,20,20).release().build().perform();
	
	String scrPoint1= "Five";
	String destPoint1= "One";

	WebElement scr1= driver.findElement(By.xpath("//*[@class='grid-container mt-4']//*[text()='"+scrPoint1+"']"));
	WebElement dest1 = driver.findElement(By.xpath("//*[@class='grid-container mt-4']//*[text()='"+destPoint1+"']"));
	act.clickAndHold(scr1).moveToElement(dest1,20,20).release().build().perform();
	}
	
	@Test(description = "This test is for sorting list", groups= {"Sanity", "Integration"})
	public void sortListTest() throws InterruptedException {
				
		Actions act = new Actions(driver);

		act.scrollByAmount(0, 400).build().perform();

		WebElement element = driver.findElement(By.xpath("//*[text()='Elements']"));
		element.click();

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,600)", "");

		WebElement interactiontab = driver.findElement(By.xpath("//*[text()='Interactions']"));
		interactiontab.click();

		Thread.sleep(2000);

		WebElement sort = driver.findElement(By.xpath("//*[text()='Sortable']"));
		sort.click();
		
		WebElement list = driver.findElement(By.id("demo-tab-list"));
		list.click();
		
		
		String scrPoint= "Six";
		String destPoint= "One";

		WebElement scr= driver.findElement(By.xpath("//*[@id='demo-tabpane-list']//*[text()='"+scrPoint+"']"));
		WebElement dest = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']//*[text()='"+destPoint+"']"));
		act.clickAndHold(scr).moveToElement(dest,20,20).release().build().perform();
		
		String scrPoint1= "Five";
		String destPoint1= "One";

		WebElement scr1= driver.findElement(By.xpath("//*[@id='demo-tabpane-list']//*[text()='"+scrPoint1+"']"));
		WebElement dest1 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']//*[text()='"+destPoint1+"']"));
		act.clickAndHold(scr1).moveToElement(dest1,20,20).release().build().perform();
		
		String scrPoint2= "Four";
		String destPoint2= "One";
		
		WebElement scr2= driver.findElement(By.xpath("//*[@id='demo-tabpane-list']//*[text()='"+scrPoint2+"']"));
		WebElement dest2 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']//*[text()='"+destPoint2+"']"));
		act.clickAndHold(scr2).moveToElement(dest2,20,20).release().build().perform();
		
		
		String scrPoint3= "Three";
		String destPoint3= "One";
		
		WebElement scr3= driver.findElement(By.xpath("//*[@id='demo-tabpane-list']//*[text()='"+scrPoint3+"']"));
		WebElement dest3 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']//*[text()='"+destPoint3+"']"));
		act.clickAndHold(scr3).moveToElement(dest3,20,20).release().build().perform();
		
		
		String scrPoint4= "Two";
		String destPoint4= "One";
		
		WebElement scr4= driver.findElement(By.xpath("//*[@id='demo-tabpane-list']//*[text()='"+scrPoint4+"']"));
		WebElement dest4 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']//*[text()='"+destPoint4+"']"));
		act.clickAndHold(scr4).moveToElement(dest4,20,20).release().build().perform();
		
	}
	
	@AfterMethod(alwaysRun= true)
	public void browserClose() {
		driver.close();
		driver.quit();
		
		
	}
	
	
	
	
	
}
