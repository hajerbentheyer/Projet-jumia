package WikiTnPages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.Config;

public class HomePage {
	@FindBy(xpath="/html/body/div[1]/main/div[1]/div[1]/div[1]/div/a/span")
	List<WebElement>menus;
	@FindBy(xpath="/html/body/div[1]/main/div[1]/div[1]/div[1]/div/div[1]/div/div[1]/div[1]/a")
	List<WebElement>submenus;
	@FindBy(xpath="/html/body/div[1]/main/div[1]/div[1]/a[2]")
	WebElement verifPage;
	@FindBy(xpath="/html/body/div[1]/div[4]/div/section/button")
	WebElement close;
	@FindBy(xpath="/html/body/div[1]/main/div[1]/div[1]/span")
	WebElement verifSubMenu;
	@FindBy(id="fi-q")
	WebElement searchItem;
	@FindBy(xpath="/html/body/div[1]/main/div[1]/div[1]/span")
	WebElement verifSearch;

	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	public void clickOnMenuByName(String menuTitle) throws Exception {
		close.click();
		Thread.sleep(3000);
		try {
	for(WebElement menu:menus) {
		if(menu.getText().contains(menuTitle)) {
			menu.click();
			String ActualText=verifPage.getText();
			Assert.assertEquals(menuTitle, ActualText);	
	}
	}
	}catch (Exception e) {
		// TODO: handle exception
	}
}
	public void mouseHoverOnMenuByName(String menuTitle,String subMenuTitle) throws Exception {
		close.click();
		Thread.sleep(3000);
		try {
		for(WebElement menu:menus) {
			if(menu.getText().contains(menuTitle)) {
				Config.actions= new Actions(Config.driver);
				Config.actions.moveToElement(menu).perform();
				for(WebElement submenu:submenus) {
					if(submenu.getText().contains(subMenuTitle)) {
						Thread.sleep(3000);
						submenu.click();
						Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						String ActualText=verifSubMenu.getText();
						Assert.assertEquals(subMenuTitle, ActualText);
					}
				}
			}
		}				
}catch (Exception e) {
	// TODO: handle exception
}
	}
	public void searchItem(String item) throws Exception {
		close.click();
		Thread.sleep(3000);
		searchItem.sendKeys(item+Keys.ENTER);
		Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String ActualText=verifSearch.getText();
		Assert.assertEquals(item, ActualText);
}
}
