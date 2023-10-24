package project_starHealth;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class StarHealthPage {
	WebDriver driver;
	@BeforeClass
	public void OpenBrowser()
	{
		driver=new ChromeDriver();
		  driver.manage().window().maximize();
		driver.get("https://www.starhealth.in/");
		
			}
    @Test(priority='1')
    public void Validate_title()
    {
    	String title=driver.getTitle();
    	System.out.println("The title of the page"+title);
    	String ExpectedTitle="Star Health Insurance: Medical, Accident and Travel insurance policies";
    	String ActualTitle=title;
    	assertEquals(ActualTitle,ExpectedTitle,"the title is valid");
     }
    @Test(priority='2')
    public void Test_Header_plan() throws InterruptedException
    {
    	WebElement e1 =driver.findElement(By.xpath("(//div[@class='flex cursor-pointer pr-30 cursor-pointer nav-link flex'])[1]"));
 		Actions a = new Actions(driver);
		a.moveToElement(e1).perform();
	    driver.findElement(By.xpath("(//a[@class='font-500 text-capitalize text-14'])[2]")).click();
	    Thread.sleep(1000);
	    driver.navigate().to("https://www.starhealth.in/health-insurance/comprehensive/");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//input[@id='name'])[1]")).sendKeys("vana");
	    driver.findElement(By.xpath("(//input[@id='phoneNumber'])[1]")).sendKeys("2587156454");
	    driver.findElement(By.xpath("(//input[@id='pinCode'])[1]")).sendKeys("504251");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//div[@class=\"primaryButton_primary__lQkYH \"])[2]")).click();
       
    }
    @Parameters({"username","mobile","email"}) 
    @Test(priority='3')
    public void send_data(String username,String mobile,String email ) throws InterruptedException
    {
        driver.navigate().to("https://web.starhealth.in/comprehensive-health-insurance-plan?name=vana&mobile=2587156454&pincode=504251");
       Thread.sleep(1000);
       driver.findElement(By.xpath("//input[@id='name']")).clear();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='mobile']")).clear();
        driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(mobile);
        driver.findElement(By.xpath("//input[@inputmode='email']")).clear();
        driver.findElement(By.xpath("//input[@inputmode='email']")).sendKeys(email);
       Boolean Value=driver.findElement(By.xpath("//input[@id='dndConsent']")).isSelected();
       Assert.assertTrue(Value);
    }
    @Test(priority='4')
    public void twitter() throws AWTException
    {
    	WebElement e2=driver.findElement(By.xpath("(//a[@class='mr-4 mr-10-xs'])[4]"));
    	Actions a= new Actions(driver);
    	a.moveToElement(e2).perform();
    	driver.findElement(By.xpath("(//a[@class='mr-4 mr-10-xs'])[4]")).getAttribute("href");
       	driver.findElement(By.xpath("(//a[@class='mr-4 mr-10-xs'])[4]")).click();
       
    	System.out.println(	driver.getTitle());
    
    	//Robot r = new Robot();
    	//r.keyPress(KeyEvent.VK_CONTROL);
    	//r.keyPress(KeyEvent.VK_T);  
    	//r.keyRelease(KeyEvent.VK_CONTROL);                                                    
    	//r.keyRelease(KeyEvent.VK_T); 
     driver.close();
    	
    	
    			
    
    }
    @Test(priority='5', dataProvider ="testdata1")
    public void vallidateFromExecel()
    {
    	WebElement e3=driver.findElement(By.xpath("(//a[@class='mr-4 mr-10-xs'])[1]"));
    	Actions a= new Actions(driver);
    	a.moveToElement(e3).perform();
    	String Actual_youtube_Detail =driver.findElement(By.xpath("(//a[@class='mr-4 mr-10-xs'])[1]")).getAttribute("href");
    	String Expected_youtube_Details="inputdata";
        Assert.assertNotEquals(Actual_youtube_Detail,Expected_youtube_Details);
    }
    @DataProvider(name="testdata1")
	public Object[][] datasupplier() throws EncryptedDocumentException, IOException
	{
		
		Object[][] inputdata = XLS_DataProvider.getTestData("Sheet2");
		
		return inputdata;
	}
    @Test(priority='6')
    public void closeBrowser() {
    	driver.quit();
    }
}
