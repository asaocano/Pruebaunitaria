import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/asahel/Descargas/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://lastpass.com/families/trial");

        submitForm(driver);
        waitForAlertBanner(driver);
        assertEquals("LastPass: Free Password Manager", getAlertTextBanner(driver));
        //driver.quit();
    }
    public static void submitForm(WebDriver driver){
        driver.findElement(By.id("email")).sendKeys("manuelocano3@gmail.com");
        driver.findElement(By.id("masterpassword")).sendKeys("Admin123456!");
        driver.findElement(By.id("confirmmpw")).sendKeys("Admin123456!");
        driver.findElement(By.id("passwordreminder")).sendKeys("La mas comun");
        driver.findElement(By.id("createaccountbtn")).click();
    }
    public static void waitForAlertBanner(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("e-f-w")));
    }

    public static String getAlertTextBanner(WebDriver driver){
        return driver.findElement(By.className("e-f-w")).getText();
    }
}
