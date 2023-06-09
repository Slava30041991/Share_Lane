import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SingUpZipCodeTest extends BaseTest {

    String zipCodeInputLocator = "zip_code";
    String continueButtonLocator = "[value=\"Continue\"]";
    String errorMessageLocator = "[class=\"error_message\"]";

    @Test
    public void zipCodeShould5Digits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        boolean isDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Нужная страница не найдена ");
    }

    @Test
    public void UserEnters4DigitsZipCodeField() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("1234");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        Assert.assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не отображается");
    }

    @Test
    public void userRegistrationWithoutEnteringZipCode() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.cssSelector(continueButtonLocator)).sendKeys("");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        Assert.assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не отображается");
    }

    @Test
    public void userRegistration5LatinLettersEnteringZipCode() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.cssSelector(continueButtonLocator)).sendKeys("AbCdi");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        Assert.assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не отображается");
    }

    @Test
    public void userRegistration5CurillicLettersEnteringZipCode() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.cssSelector(continueButtonLocator)).sendKeys("АбВгД");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        Assert.assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не отображается");
    }

    @Test
    public void registeringUserEntersMore5DigitsZipCode() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.cssSelector(continueButtonLocator)).sendKeys("123456");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        Assert.assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не отображается");
    }

    @Test
    public void UserPressesSpaceBarZipCodeField() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.cssSelector(continueButtonLocator)).sendKeys(" ");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        Assert.assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не отображается");
    }

    @Test
    public void userPressesspaceButtonZipCodeFieldEnters4Digits() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.cssSelector(continueButtonLocator)).sendKeys(" 1234");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        Assert.assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не отображается");
    }
    @Test
    public void UserEnters5SpecialCharactersZipCode() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.cssSelector(continueButtonLocator)).sendKeys("@#$%^");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        Assert.assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits", "Сообщение не отображается");
    }
}
