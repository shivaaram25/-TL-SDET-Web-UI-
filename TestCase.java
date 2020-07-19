package exam;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase {

	public static WebDriver driver;
	public static int Browser=2;//1-Chrome,2-FF,3-IE
	public static String sURL = "https://www.bestbuy.com/";

	public static void main(String[] args) {
		browserInvoke();
		changeBrowserSittings();
		navigateURL();
		webOperation();
		//closeBrowser();	
	}

	public static void browserInvoke(){
		switch (Browser) {
		case 1:
			System.out.println("User Option is 1, So Invoking Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User Option is 2, So Invoking FF Browser");
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case 3:
			System.out.println("User Option is 3, So Invoking IE Browser");
			System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("User Option is wrong, So Invoking default Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}}

	public static void changeBrowserSittings(){
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
	
	}


	public static void navigateURL(){
		driver.get(sURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void webOperation() throws InterruptedException{
        driver.findElement(By.linkText("United Sates")).click();	
        driver.findElement(By.id("Close_Cancel_Line")).click();
        driver.findElement(By.id("gh-search-input")).sendKeys("laptops computers");
        driver.findElement(By.xpath("//button[@class='header-search-button']")).click();
       WebElement coutNumber = driver.findElement(By.xpath("//span[@class='item-count']"));
       String text = coutNumber.getText();
       System.out.println("All over count="+text);
       WebElement eleCheckBox1 = driver.findElement(By.xpath("//i[@xpath='1']"));
       eleCheckBox1.isSelected();
       WebElement eleCheckBox2 = driver.findElement(By.xpath("//input[@id='brand_facet-Dell']/following-sibling::i[1]"));
       eleCheckBox2.isSelected();

       WebElement NewCoutnumber = driver.findElement(By.xpath("//span[@class='item-count']"));
       String text1 = NewCoutnumber.getText();
       System.out.println("All over count="+text1);
       int inum1 = Integer.parseInt(text);

       int inum2 = Integer.parseInt(text1);
       
       if (inum1<inum2) {
           System.out.println("count of items hasreducedfrom the previously displayed number ");
 
		
	}
       else {
       System.out.println("count is not changed");

       
       	}
	
	WebElement dropdown1 = driver.findElement(By.id("sort-by-select"));
	Select dd = new Select(dropdown1);
	dd.selectByIndex(3);
	
	List<WebElement> StarCoutnumber= driver.findElements(By.xpath("//i[contains(@class,'c-stars-v3 c-stars-v3-small')])"));
	int inum5= StarCoutnumber.size();
    System.out.println(inum5);
    
    WebElement eleCheckBox3 = driver.findElement(By.xpath("//input[@value='6421639']/following-sibling::i[1]"));
    eleCheckBox3.isSelected();
    

    WebElement eleCheckBox4 = driver.findElement(By.xpath("//input[@value='6333551']/following-sibling::i[1]"));
    eleCheckBox4.isSelected();
    
    driver.findElement(By.xpath("//a[contains(@class,'compare-button btn')]")).click(); 
    Thread.sleep(2000);
    
    WebElement Sizeone = driver.findElement(By.xpath("//td[contains(@class,'table-cell body-copy')]/following-sibling::td)[4]"));
    
    WebElement Sizetwo = driver.findElement(By.xpath("//td[contains(@class,'table-cell body-copy')]/following-sibling::td)[5]"));
    String text3 = Sizeone.getText();
    String text4 = Sizetwo.getText();
    int sizenumone = Integer.parseInt(text3);
    int sizenumtwo = Integer.parseInt(text4);

    if (sizenumone>sizenumtwo) {
    	
    	 driver.findElement(By.xpath("//button[text()='Add to Cart'])[1]")).click();
		
	}
    else {
   	 driver.findElement(By.xpath("//button[text()='Add to Cart'])[2]")).click();
    
    	}
	
   
	}

	public static void closeBrowser(){
		driver.close();
		driver.quit();
	}
}
