import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ConfirmationPage;
import pages.FormPage;

import static org.junit.Assert.assertEquals;

public class Form {
    public static void main(String[] args) {

        //String s = System.setProperty("webdriver.chrome.driver", "C:\\selenium drivers\\chromedriver-win64\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","C:\\selenium drivers\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        FormPage formPage = new FormPage();
        formPage.submitForm(driver);

        ConfirmationPage confirmationPage = new ConfirmationPage();
        confirmationPage.waitForAlertBanner(driver);

        assertEquals("The form was successfully submitted!", confirmationPage.getAlertBannerText(driver));

        //close the driver
        driver.quit();
    }
}
