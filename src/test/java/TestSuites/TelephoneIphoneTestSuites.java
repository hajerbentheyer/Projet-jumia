package TestSuites;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import WikiTnPages.TelephoneIphone;

public class TelephoneIphoneTestSuites {
	TelephoneIphone iphone;
	@Before
	public void init() {
		Config.confChrome();
		Config.driver=new ChromeDriver();
		Config.maximizeWindow();
		String url="https://www.jumia.ma/iphone/";
		Config.driver.get(url);
		iphone=new TelephoneIphone(Config.driver);	
	}
	@Test
    public void ajoutIphonePanier() throws Exception {
		
		iphone.selectionneProduit("Apple iPhone 15 128GB Noir 6,1\" Black Dynamic Island A16 Bionic iOS 48 Mpx 6Gb RAM");	
}
}

