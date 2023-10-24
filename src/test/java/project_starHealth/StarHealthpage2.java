package project_starHealth;

	

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;


		public class StarHealthpage2 {
  WebDriver driver;
		
		
		@Test(priority='1')
		public void print_link()
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.starhealth.in/");
					
		String link1=	driver.findElement(By.linkText("Glossary")).getText();
		System.out.println(link1);
		}
		@Test(priority='2')
		public void closebroswers() {
			driver.close();
		}
	}

