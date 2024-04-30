package homePage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.LoadState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import SelectorsAndURLs.HomePageSelectors;

import java.awt.Window.Type;

import org.testng.annotations.Test;

public class HomePageLogin {

	@Test
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		
		Browser browser = playwright.chromium().launch(
				new LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		// page.navigate(HomePageSelectors.MOBPREURL);
		 page.navigate(HomePageSelectors.PRODURL);
		 page.click(HomePageSelectors.ONEWAY);  //OneWay
		 page.click(HomePageSelectors.DEPARTURE);  //Departure
		 page.type(HomePageSelectors.DEPARTURE, "RUH"); //Departure
		 page.keyboard().press("Enter");
		 page.type(HomePageSelectors.ARRIVAL, "DXB");  //Arrival
		 page.keyboard().press("Enter");
		 page.click(HomePageSelectors.DEPART_DATE);  //DepartDate
		 page.click(HomePageSelectors.SEARCH_BUTTON); //searchButton
		 page.waitForTimeout(5000);
		 page.click(HomePageSelectors.FIRST_FLIGHT_PRICE);   //FirstFlightPrice
		 page.locator(HomePageSelectors.VALUE_BUNDLE).click(); //Value
		 page.click(HomePageSelectors.ADD_PAX_BUTTON);	//addpaxbtn
		 page.waitForTimeout(10000);
		 try {
			    ElementHandle element = page.querySelector(HomePageSelectors.SKIP_BUTTON);
			    element.click(); // Click Skip button
			} catch (PlaywrightException e) {
			    System.out.println("Pop-Up not displayed after PAX Page");
			}
		 //page.click(HomePageSelectors.SKIP_BUTTON);	//skip
		 page.click(HomePageSelectors.PAX_TITTLE);	//tittle
		 page.click(HomePageSelectors.PAX_TITTLE_MR);	//MRtittle
		 page.type(HomePageSelectors.PAX_NAME, "papa");	//FirstName
		 page.type(HomePageSelectors.PAX_LASTNAME, "rao");		//LastName
		 page.click(HomePageSelectors.PAX_DD);	//DD
		 page.click(HomePageSelectors.PAX_DD_23);	//23
		 page.click(HomePageSelectors.PAX_MM);	//MM
		 page.click(HomePageSelectors.PAX_MM_MARCH);	//March
		 page.click(HomePageSelectors.PAX_YY);	//YY
		 page.click(HomePageSelectors.PAX_YY_92);	//1992
		 page.waitForTimeout(3000);
		 ElementHandle idelement = page.querySelector(HomePageSelectors.PAX_DOC);
		 idelement.evaluate("idelement => idelement.scrollIntoView()");
		/* ElementHandle numelement = page.querySelector(HomePageSelectors.PAX_PHNUM);
		 numelement.evaluate("numelement => numelement.scrollIntoView()");*/
		 page.click(HomePageSelectors.PAX_DOC);	//Document
		 page.click(HomePageSelectors.PAX_DOC_NATIONALID);	//NationalID
		 page.type(HomePageSelectors.PAX_DOC_NUMBER, "1245789670");
		 page.waitForTimeout(3000);
		 ElementHandle numelement = page.querySelector(HomePageSelectors.PAX_PHNUM);
		 numelement.evaluate("numelement => numelement.scrollIntoView()");
		 page.type(HomePageSelectors.PAX_PHNUM, "9876543215");	//phno
		 page.type(HomePageSelectors.PAX_MAIL, "samtest@yopmail.com");	//email
		 page.click(HomePageSelectors.PAX_CONTINUE);	//ContinueinPAX
		 page.click(HomePageSelectors.PAX_ALERT_OK);	//PaxAlertOK
		 page.waitForTimeout(5000);
		 page.click(HomePageSelectors.ADDON_PB);	//PriorityBoarding
		 page.waitForTimeout(5000);
		 page.click(HomePageSelectors.ADDON_BG20KG);	//20KG Baggage
		 page.waitForTimeout(5000);
		 page.click(HomePageSelectors.ADDON_2ndMEAL);	//2nd Meal
		 page.waitForTimeout(5000);
		 page.click(HomePageSelectors.ADDON_NOINSURANCE);	//NoInsurance
		/* 
		 String priorityBoarding = page.textContent(HomePageSelectors.ADDON_PB);
         String baggage20kg = page.textContent(HomePageSelectors.ADDON_BG20KG);
         String meals = page.textContent(HomePageSelectors.ADDON_2ndMEAL);
         String noinsurance = page.textContent(HomePageSelectors.ADDON_NOINSURANCE);
         
         String pbprice = page.textContent(HomePageSelectors.ADDON_PBPRICE);
         String baggage20kgPrice = page.textContent(HomePageSelectors.ADDON_BAGGAGEPRICE);
         String mealPrice2nd = page.textContent(HomePageSelectors.ADDON_MEALPRICE);
         
         // Print captured titles and prices
         System.out.println("Priority Boarding: " + priorityBoarding + ", Priority Price: " + pbprice);
         System.out.println("baggage 20kg: " + baggage20kg + ", Baggage20KG Price: " + baggage20kgPrice);
         System.out.println("Meals: " + meals + ", MealPrice2nd: " + mealPrice2nd);
		 page.click(HomePageSelectors.ADDON_BOTTOMARROW);	//BottomArrow
		 page.click(HomePageSelectors.ADDON_PLSPRICEBREAKDOWN);	//PlusInPriceBreakDown*/
		 page.click(HomePageSelectors.PAX_CONTINUE);	//CONTINUE
         String seatpagelocator = HomePageSelectors.SEATPAGETEXTLOCATOR;
         String expectedText = " Select your seat";
         String actualText = page.textContent(seatpagelocator);
         if (expectedText.equals(actualText)) {			         // Seat Section page text validation
             System.out.println("Seat page text validation passed: Expected text found.");
         } else {
             System.out.println("Seat page text validation failed: Expected text not found.");
         }        
		 page.click(HomePageSelectors.PAX_CONTINUE);	//CONTINUEinSeatPage
		 /*page.click(HomePageSelectors.PAYMENT_CREDITCARD);	//SelectCC
		 page.type(HomePageSelectors.PAYMENT_CREDITNUMENTRY, "4000000000001000");	//CARDNUMENTRY
		 page.type(HomePageSelectors.PAYMENT_CREDITNAME, "Test");	//CARDNAME
		 page.type(HomePageSelectors.PAYMENT_CREDITEXP, "0627");	//CARDEXP
		 page.type(HomePageSelectors.PAYMENT_CREDITCVV, "123");	//CARDCVV*/
		 String paymentSadad = HomePageSelectors.PAYMENT_SADAD2;
		 page.hover(paymentSadad);
		 page.click(paymentSadad);	//ClickSADAD
		 page.click(HomePageSelectors.PAYMENT_PAYBUTTON);	//PAYBUTTON	
		 page.waitForLoadState(LoadState.LOAD);
		 page.waitForSelector(HomePageSelectors.CROSSINCNFRMPAGE);
		 page.click(HomePageSelectors.CROSSINCNFRMPAGE);
		 try {
			    ElementHandle element = page.querySelector(HomePageSelectors.CROSSINCNFRMPAGE5);
			    element.click();
			} catch (PlaywrightException e) {
			    try {
			        ElementHandle element = page.querySelector(HomePageSelectors.CROSSINCNFRMPAGE6);
			        element.click(); 
			    } catch (PlaywrightException ex) {
			        System.out.println("Unable to close Pop-Up");
			        ex.printStackTrace();
			    }
			}		//payment page cross button options
		 String pnrLocator = HomePageSelectors.PNRLOCATOR;
         String pnrID = page.textContent(pnrLocator);
         System.out.println("Copied Text: " + pnrID);
         String bookingStatus = HomePageSelectors.BOOKINGSTATUS;
         String bkgStatus = page.textContent(bookingStatus);
         System.out.println("Copied Text: " + bkgStatus);
         browser.close();
	}

}
