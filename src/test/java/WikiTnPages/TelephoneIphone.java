package WikiTnPages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.Config;

public class TelephoneIphone {
	@FindBy(xpath="/html/body/div[1]/main/div[2]/div[3]/section/div[2]/article")
	List<WebElement>Listiphone;
	@FindBy(xpath="/html/body/div[1]/div[4]/div/section/button")
	WebElement close;
	@FindBy(xpath="/html/body/div[1]/main/div[1]/section/div/div[2]/div[1]/div/h1")
	WebElement verifNomProduit;
	@FindBy(xpath="/html/body/div[1]/main/div[1]/section/div/div[2]/div[3]/div/form/button")
	WebElement ajoutPanier;
	@FindBy(xpath="/html/body/div[1]/header/section/div[2]/a")
	WebElement listPanier;
	@FindBy(xpath="/html/body/div[1]/main/div/div[1]/article/article/a/div[2]/h3")
	WebElement verifProduitPanier;
	
public TelephoneIphone(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void selectionneProduit(String NameIphone) throws Exception {
	close.click();
	Thread.sleep(3000);
	try {
	for(WebElement iphone:Listiphone) {
		if(iphone.getText().contains(NameIphone)) {
			  // Créez une instance de JavascriptExecutor
	        JavascriptExecutor js = (JavascriptExecutor) Config.driver;

	        // Faites défiler la page vers le bas (par exemple, de 800 pixels)
	       js.executeScript("window.scrollBy(0,800)");
			Thread.sleep(3000);
			iphone.click();
			Config.attente(10);
			String ActualText=verifNomProduit.getText();
			Assert.assertEquals(NameIphone, ActualText);
			// Créez une instance de JavascriptExecutor
	        JavascriptExecutor js1 = (JavascriptExecutor) Config.driver;

	        // Faites défiler la page vers le bas (par exemple, de 800 pixels)
	       js1.executeScript("window.scrollBy(0,500)");
			ajoutPanier.click();
			Thread.sleep(3000);
			listPanier.click();
			String NomProduct=verifProduitPanier.getText();
			Assert.assertEquals(NomProduct, NameIphone);
		}
	}
	
}catch (Exception e) {
	// TODO: handle exception
}
}
}

