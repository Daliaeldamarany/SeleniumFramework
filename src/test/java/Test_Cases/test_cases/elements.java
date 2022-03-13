package Test_Cases.test_cases;

import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class elements {
	public  static void getUrl(ChromeDriver driver,String url)
	{
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
public  static void search(ChromeDriver driver,String item) {
		
		WebElement Search = driver.findElement(By.id("search_query_top"));
		Search.clear();
		Search.sendKeys(item);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Option = driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[6]"));
		Option.click();

}
public  static void Set_Quantity(ChromeDriver driver)
{
	WebElement add_button= driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]"));
	add_button.click();
}
public  static void Set_Size(ChromeDriver driver,String size)
{
	WebElement select_size= driver.findElement(By.id("group_1"));
	Select select = new Select(select_size);
	select.selectByValue(size);
}


public  static void Set_color(ChromeDriver driver) {
		WebElement select_color = driver.findElement(By.id("color_14"));
		select_color.click();
}
public  static void proceed_checkOut(ChromeDriver driver) {
		WebElement add_cart=driver.findElement(By.name("Submit"));
		add_cart.click();
		WebElement Procced=driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
		Procced.click();
}


public  static void Validate_description(ChromeDriver driver, String expected_description) {
		
		WebElement description=driver.findElement(By.xpath("//*[@id=\"product_1_6_0_0\"]/td[2]/p/a"));
		assertTrue(description.getText().contains(expected_description));
}	
	
public  static void Validate_availability(ChromeDriver driver,String Stock) {
		WebElement avail = driver.findElement(By.xpath("//*[@id=\"product_1_6_0_0\"]/td[3]/span"));
		assertTrue(avail.getText().contains(Stock));
}		
		
public  static void Validate_UnitPrice(ChromeDriver driver,String price) {
		WebElement Unit_price=driver.findElement(By.xpath("//*[@id=\"product_price_1_6_0\"]/span"));
		String unitPrice=Unit_price.getText();
		assertTrue(unitPrice.contains(price));
}

public  static void Validate_Quantity(ChromeDriver driver,String Quantity)
{
		WebElement qty= driver.findElement(By.name("quantity_1_6_0_0"));
		String qty1 = qty.getAttribute("value");
		assertTrue(qty1.contains(Quantity));
}
public  static void add_quantity(ChromeDriver driver,String add_qty) {
	
	
	        WebElement test= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/input[2]"));
			test.clear();
			test.sendKeys(add_qty);
				

	
}
public static  void validate_prices(ChromeDriver driver,String totall , String TotalProduct,String Total_shipping,String totalAll,String totalPrice) {
	WebDriverWait wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[6]/span"), totall));

	WebElement Total= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[6]/span"));
	String st= Total.getText();
	double total;
	total= 3 * 16.51;
	String s=String.valueOf(total);
	assertTrue(st.contains(s));

	WebElement total_product=driver.findElement(By.xpath("//*[@id=\"total_product\"]"));
	assertTrue(total_product.getText().contains(TotalProduct));
	
	WebElement total_shipping=driver.findElement(By.id("total_shipping"));
	assertTrue(total_shipping.getText().contains(Total_shipping));
	
	WebElement total_all=driver.findElement(By.id("total_price_without_tax"));
	assertTrue(total_all.getText().contains(totalAll));
	
	WebElement total_price=driver.findElement(By.id("total_price"));
	assertTrue(total_price.getText().contains(totalPrice));

}
public  static void CheckOut(ChromeDriver driver) {
		WebElement checkout= driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
		checkout.click();
}
public  static void VALIDATE_Error(ChromeDriver driver,String error_message) {
		
		WebElement Signin = driver.findElement(By.id("SubmitLogin"));
		Signin.click();
		WebElement error=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p"));
		String s1= (error.getText());
		WebElement error1=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
		String s2=(error1.getText());
		String s3 = s1 + s2;
		assertTrue(s3.contains(error_message));
}		

public  static void SignIn(ChromeDriver driver)

{
		WebElement email= driver.findElement(By.id("email_create"));
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		email.sendKeys("username"+ randomInt +"@gmail.com"); 
		
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]"));
		btn.click();
}

public  static void fillData(ChromeDriver driver,String firstName ,String lastName,String Password,String Day,String Month ,String Year,String Company,String Address1,String Address2,String city , String State , String PostCode,String Additional,String Phone,String PhoneMobile ,String Alias)
{
			WebElement radio1=driver.findElement(By.xpath("//*[@id=\"uniform-id_gender2\"]/span"));
			radio1.click();
			WebElement first_name=driver.findElement(By.id("customer_firstname"));
			first_name.sendKeys(firstName);
			WebElement last_name=driver.findElement(By.id("customer_lastname"));
			last_name.sendKeys(lastName);
			WebElement mail=driver.findElement(By.id("email"));
			mail.click();
			WebElement password=driver.findElement(By.id("passwd"));
			password.sendKeys(Password);
			WebElement day= driver.findElement(By.xpath("//*[@id=\"days\"]"));
			Select select1 = new Select(day);
			select1.selectByValue(Day);
			WebElement month= driver.findElement(By.id("months"));
			Select select2 = new Select(month);
			select2.selectByValue(Month);
			WebElement year= driver.findElement(By.id("years"));
			Select select3 = new Select(year);
			select3.selectByValue(Year);
			WebElement check1=driver.findElement(By.xpath("//*[@id=\"uniform-newsletter\"]"));
			check1.click();
			WebElement check2=driver.findElement(By.xpath("//*[@id=\"uniform-optin\"]"));
			check2.click();
			WebElement company=driver.findElement(By.id("company"));
			company.sendKeys(Company);
			WebElement address1=driver.findElement(By.id("address1"));
			address1.sendKeys(Address1);
			WebElement address2=driver.findElement(By.id("address2"));
			address2.sendKeys(Address2);
			WebElement City=driver.findElement(By.id("city"));
			City.sendKeys(city);
			WebElement state= driver.findElement(By.id("id_state"));
			Select select4 = new Select(state);
			select4.selectByValue(State);
			WebElement post_code=driver.findElement(By.id("postcode"));
			post_code.sendKeys(PostCode);
			WebElement additional=driver.findElement(By.id("other"));
			additional.sendKeys(Additional);
			WebElement phone=driver.findElement(By.id("phone"));
			phone.sendKeys(Phone);
			WebElement phone_mobile=driver.findElement(By.id("phone_mobile"));
			phone_mobile.sendKeys(PhoneMobile);
			WebElement alias=driver.findElement(By.id("alias"));
			alias.clear();
			alias.sendKeys(Alias);
			WebElement Submit=driver.findElement(By.id("submitAccount"));
			Submit.click();
}

public  static void Delivery_address(ChromeDriver driver,String Name,String Company,String Address1,String Address2,String Country ,String Phone,String Number) {
	WebElement name=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[2]"));
	assertTrue(name.getText().contains(Name));
	WebElement company=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[3]"));
	assertTrue(company.getText().contains(Company));
	WebElement addressv1=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[4]"));
	assertTrue(addressv1.getText().contains(Address1));
	WebElement addressv2=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[5]"));
	assertTrue(addressv2.getText().contains(Address2));
	WebElement country=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[6]"));
	assertTrue(country.getText().contains(Country));
	WebElement phone_num=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[7]"));
	assertTrue(phone_num.getText().contains(Phone));
	WebElement num2=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[8]"));
	assertTrue(num2.getText().contains(Number));
}
public  static void Billing_address(ChromeDriver driver,String Name,String Company,String Address1,String Address2,String Country ,String Phone,String Number) {
	WebElement name=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[2]"));
	assertTrue(name.getText().contains(Name));
	WebElement company=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[3]"));
	assertTrue(company.getText().contains(Company));
	WebElement addressv1=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[4]"));
	assertTrue(addressv1.getText().contains(Address1));
	WebElement addressv2=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[5]"));
	assertTrue(addressv2.getText().contains(Address2));
	WebElement country=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[6]"));
	assertTrue(country.getText().contains(Country));
	WebElement phone_num=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[7]"));
	assertTrue(phone_num.getText().contains(Phone));
	WebElement num2=driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[8]"));
	assertTrue(num2.getText().contains(Number));
}
//*continue*/
public  static void ProceedCheckout(ChromeDriver driver)
{
		
		WebElement ProceedToCheckOut = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button"));
		ProceedToCheckOut.click();
}
public  static void Terms(ChromeDriver driver,String terms)
{
		WebElement TermsServices = driver.findElement(By.xpath("//*[@id=\"form\"]/div/p[2]/a"));
		TermsServices.click();
		driver.switchTo().frame(0);
		WebElement element= driver.findElement(By.tagName("h1"));
		assertTrue(element.getText().contains(terms));
		driver.switchTo().defaultContent();
		WebElement exit=driver.findElement(By.xpath("//*[@id=\"order\"]/div[2]/div/div/a"));
		exit.click();
		WebElement CheckBox=driver.findElement(By.xpath("//*[@id=\"cgv\"]"));
		CheckBox.click();
}
public  static void ProcessOfCheckOut(ChromeDriver driver)
{
		WebElement ProceedToCheck_Out=driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
		ProceedToCheck_Out.click();
		WebElement Pay_byCheck=driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a"));
		Pay_byCheck.click();
		WebElement Confirm=driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
		Confirm.click();
}
public  static void Validate_Order(ChromeDriver driver,String Amount,String Payable,String email)
{
		WebElement payment_amunt=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/span/strong"));
		String string1=payment_amunt.getText();
		assertTrue(string1.contains(Amount));
		String s1= payment_amunt.getTagName();
		Assert.assertEquals(s1 , "strong");
		WebElement payable=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/strong[1]"));
		String string2=payable.getText();
		assertTrue(string2.contains(Payable));
		String s2= payable.getTagName();
		Assert.assertEquals(s2 , "strong");
		WebElement maill =driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/strong[2]"));
		String string3=maill.getText();
		assertTrue(string3.contains(email));
		String s3= maill.getTagName();
		Assert.assertEquals(s3 , "strong");
		

}



}