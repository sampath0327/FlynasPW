package bookingdomestic;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import SelectorsAndURLs.HomePageSelectors;

public class BookingOneWay002 {
	public static void main (String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				.setHeadless(false)
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
		
		page.close();
		browser.close();
		playwright.close();
	}

}
