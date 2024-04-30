package homePage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ScreenSize;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.ITestNGListener;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import SelectorsAndURLs.HomePageSelectors;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window.Type;
//import static io.qameta.allure.SeverityLevel.*;


public class HomePageLoginSadad {

	public static void main(String[] args) {
		/*ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Create a new test in the report
        ExtentTest test = extent.createTest("Booking Report", "JED-AHB Report");*/
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();

		//page.navigate(HomePageSelectors.MOBPREURL);
		page.navigate(HomePageSelectors.PRODURL);
		
		 page.click(HomePageSelectors.ONEWAY);  //OneWay
		 page.click(HomePageSelectors.DEPARTURE);  //Departure
		 page.type(HomePageSelectors.DEPARTURE, "JED"); //Departure
		 page.keyboard().press("Enter");
		 page.type(HomePageSelectors.ARRIVAL, "RUH");  //Arrival
		 page.keyboard().press("Enter");
		 page.click(HomePageSelectors.DEPART_DATE);  //DepartDate
		 page.click(HomePageSelectors.SEARCH_BUTTON); //searchButton
		 page.click(HomePageSelectors.FIRST_FLIGHT_PRICE);   //FirstFlightPrice
		 page.locator(HomePageSelectors.VALUE_BUNDLE).click(); //Value
		 page.click(HomePageSelectors.ADD_PAX_BUTTON);	//addpaxbtn
		 page.click(HomePageSelectors.SKIP_BUTTON);	//skip
		 page.click(HomePageSelectors.PAX_TITTLE);	//tittle
		 page.click(HomePageSelectors.PAX_TITTLE_MR);	//MRtittle
		 page.type(HomePageSelectors.PAX_NAME, "samapth");	//FirstName
		 page.type(HomePageSelectors.PAX_LASTNAME, "sam");		//LastName
		 page.click(HomePageSelectors.PAX_DD);	//DD
		 page.click(HomePageSelectors.PAX_DD_23);	//23
		 page.click(HomePageSelectors.PAX_MM);	//MM
		 page.click(HomePageSelectors.PAX_MM_MARCH);	//March
		 page.click(HomePageSelectors.PAX_YY);	//YY
		 page.click(HomePageSelectors.PAX_YY_92);	//1992
		 ElementHandle idelement = page.querySelector(HomePageSelectors.PAX_DOC);
		 idelement.evaluate("idelement => idelement.scrollIntoView()");
		 page.click(HomePageSelectors.PAX_DOC);	//Document
		 page.click(HomePageSelectors.PAX_DOC_NATIONALID);	//NationalID
		 page.type(HomePageSelectors.PAX_DOC_NUMBER, "1245789630");
		 page.type(HomePageSelectors.PAX_PHNUM, "9876543210");	//phno
		 page.type(HomePageSelectors.PAX_MAIL, "samtest@yopmail.com");	//email
		 page.click(HomePageSelectors.PAX_CONTINUE);	//ContinueinPAX
		 page.click(HomePageSelectors.PAX_ALERT_OK);	//PaxAlertOK
		 page.waitForTimeout(10000);
		 page.click(HomePageSelectors.ADDON_PB);	//PriorityBoarding
		 page.waitForTimeout(5000);
		 page.click(HomePageSelectors.ADDON_BG20KG);	//20KG Baggage
		 page.waitForTimeout(5000);
		 page.click(HomePageSelectors.ADDON_2ndMEAL);	//2nd Meal
		 page.waitForTimeout(5000);
		 page.click(HomePageSelectors.ADDON_NOINSURANCE);	//NoInsurance 
		 page.click(HomePageSelectors.PAX_CONTINUE);	//CONTINUE
         String seatpagelocator = HomePageSelectors.SEATPAGETEXTLOCATOR;
         // Expected text to validate
         String expectedText = " Select your seat";
         // Get the text content of the element using the locator
         String actualText = page.textContent(seatpagelocator);
         if (expectedText.equals(actualText)) {
             System.out.println("Seat page text validation passed: Expected text found.");
         } else {
             System.out.println("Seat page text validation failed: Expected text not found.");
         }
		 page.click(HomePageSelectors.PAX_CONTINUE);	//CONTINUEinSeatPage
         String paymentpagelocator = HomePageSelectors.PAYMENTPAGELOCATOR;
         String expectedpaymentText = " Payment Information ";
         String paymentPageText = page.textContent(paymentpagelocator);
         if (expectedpaymentText.equals(paymentPageText)) {
             System.out.println("Payment page text validation passed: Expected text found.");
         } else {
             System.out.println("Payment page text validation failed: Expected text not found.");
         }
		 
		 String paymentSadad = HomePageSelectors.PAYMENT_SADAD2;
		 page.hover(paymentSadad);
		 page.click(paymentSadad);	//ClickSADAD
/*		 page.click(HomePageSelectors.PAYMENT_CREDITCARD);	//SelectCC
		 page.type(HomePageSelectors.PAYMENT_CREDITNUMENTRY, "4000000000001000");	//CARDNUMENTRY
		 page.type(HomePageSelectors.PAYMENT_CREDITNAME, "Test");	//CARDNAME
		 page.type(HomePageSelectors.PAYMENT_CREDITEXP, "0627");	//CARDEXP
		 page.type(HomePageSelectors.PAYMENT_CREDITCVV, "123");	//CARDCVV*/
		 page.click(HomePageSelectors.PAYMENT_PAYBUTTON);	//PAYBUTTON	
		 page.waitForTimeout(10000);
		 page.click(HomePageSelectors.CROSSINCNFRMPAGE);	//CROSSINCONFIRMPAGE

         String pnrLocator = HomePageSelectors.PNRLOCATOR;
         String pnrID = page.textContent(pnrLocator);
         System.out.println("Copied Text: " + pnrID);
         String bookingStatus = HomePageSelectors.BOOKINGSTATUS;
         String bkgStatus = page.textContent(bookingStatus);
         System.out.println("Copied Text: " + bkgStatus);
         browser.close();
	}

}
