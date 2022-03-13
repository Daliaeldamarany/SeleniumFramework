package Test_Cases.test_cases;


import org.openqa.selenium.chrome.ChromeDriver;


public class calling {


	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\sources\\chromedriver.exe ");
	    ChromeDriver driver = new ChromeDriver();
		elements.getUrl(driver, "http://automationpractice.com/");
		elements.search(driver,"dress");
		elements.Set_Quantity(driver);
		elements.Set_Size(driver, "3");
		elements.Set_color(driver);
		elements.proceed_checkOut(driver);
		elements.Validate_description(driver,"Faded Short Sleeve T-shirts");
		elements.Validate_availability(driver,"In stock");
		elements.Validate_UnitPrice(driver,"$16.51");
		elements.Validate_Quantity(driver,"2");
		elements.add_quantity(driver,"3");
		elements.validate_prices(driver,"$49.53","$49.53","$2.00","$51.53","$51.53");
		elements.CheckOut(driver);
		elements.VALIDATE_Error(driver, "There is 1 errorAn email address required.");
        elements.SignIn(driver);
        elements.fillData(driver, "Dalia", "Ashraf", "12345678", "18", "5", "1998", "Nacita", "Haram,Giza", "Dokki,Giza", "Giza", "30", "54321", "additional informaton", "9876543210", "0123456789", "address");
	    elements.Delivery_address(driver, "Dalia Ashraf", "Nacita","Haram,Giza Dokki,Giza", "Giza, New Jersey 54321", "United States", "9876543210", "0123456789");
	    elements.Billing_address(driver, "Dalia Ashraf", "Nacita","Haram,Giza Dokki,Giza", "Giza, New Jersey 54321", "United States", "9876543210", "0123456789");
        elements.ProceedCheckout(driver);
        elements.Terms(driver,"TERMS AND CONDITIONS OF USE");
        elements.ProcessOfCheckOut(driver);
        elements.Validate_Order(driver, "$51.53", "pradeep", "xyz");
	}

}
