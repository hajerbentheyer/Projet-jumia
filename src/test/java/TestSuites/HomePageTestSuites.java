package TestSuites;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import WikiTnPages.HomePage;

public class HomePageTestSuites {
	HomePage home;
	@Before
	public void init() {
		Config.confChrome();
		Config.driver=new ChromeDriver();
		Config.maximizeWindow();
		String url="https://www.jumia.ma/";
		Config.driver.get(url);
		home=new HomePage(Config.driver);
		
	}

	@Test
	public void clickOnMenuByName() throws Exception {
		
		home.clickOnMenuByName("Informatique");
		Config.driver.quit();
	}
	@Test
	public void MouseHover() throws Exception {
		home.mouseHoverOnMenuByName("Téléphone & Tablette","iPhones");

	Config.driver.quit();
	
	}
	@Test
	public void SearchItemByName() throws Exception {
		home.searchItem("dell");
		Config.driver.quit();
	}
}
	
	
