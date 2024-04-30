package homePage;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

import SelectorsAndURLs.HomePageSelectors;

public class testingTestNG {
	
  @Test
  public void f() {
	  
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();

		//page.navigate(HomePageSelectors.MOBPREURL);
		page.navigate(HomePageSelectors.PRODURL);
  }
}
