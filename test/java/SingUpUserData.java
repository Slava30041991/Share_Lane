import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingUpUserData extends BaseTest {
    String zipCodeInputLocator = "zip_code";
    String continueButtonLocator = "[value=Continue]";
    String userNameLocator = "[name=first_name ]";
    String userLastMameLocator = "[name=last_name ]";
    String userMailLocator = "[ name=email ]";
    String userPassword1Locator = "[ name=password1 ]";
    String userPassword2Locator = "[ name=password2 ]";
    String registerButtonLocator = "[value=Register]";
    String messageAccountCreatedLocator = "[class=\"confirmation_message\"]";
    String errorMessageLocator = "[class=\"error_message\"]";


    @Test
    public void userRegistrationWithValidData(){
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("Slava");
        driver.findElement(By.cssSelector(userLastMameLocator)).sendKeys("Петров");
        driver.findElement(By.cssSelector(userMailLocator)).sendKeys("lenin133@mail.ru");
        driver.findElement(By.cssSelector(userPassword1Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(userPassword2Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(messageAccountCreatedLocator)).getText();
        Assert.assertEquals(text, "Account is created!","Сообщение Account is created не отображается");
    }
    @Test
    public void UserLeftFieldsBlank() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("");
        driver.findElement(By.cssSelector(userLastMameLocator)).sendKeys("");
        driver.findElement(By.cssSelector(userMailLocator)).sendKeys("");
        driver.findElement(By.cssSelector(userPassword1Locator)).sendKeys("");
        driver.findElement(By.cssSelector(userPassword2Locator)).sendKeys("");
        driver.findElement(By.cssSelector(registerButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Сообщение Account is created не отображается");
    }
    @Test
    public void userEnteredOnlyFirstName() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("Вася");
        driver.findElement(By.cssSelector(userLastMameLocator)).sendKeys("");
        driver.findElement(By.cssSelector(userMailLocator)).sendKeys("");
        driver.findElement(By.cssSelector(userPassword1Locator)).sendKeys("");
        driver.findElement(By.cssSelector(userPassword2Locator)).sendKeys("");
        driver.findElement(By.cssSelector(registerButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Сообщение Account is created не отображается");
    }
    @Test
    public void userEnteredOnlyLastName() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("");
        driver.findElement(By.cssSelector(userLastMameLocator)).sendKeys("Васильев");
        driver.findElement(By.cssSelector(userMailLocator)).sendKeys("");
        driver.findElement(By.cssSelector(userPassword1Locator)).sendKeys("");
        driver.findElement(By.cssSelector(userPassword2Locator)).sendKeys("");
        driver.findElement(By.cssSelector(registerButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Сообщение Account is created не отображается");
    }
    @Test
    public void userEnteredEmailWithoutSpecialCharacter() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("Misha");
        driver.findElement(By.cssSelector(userLastMameLocator)).sendKeys("Васильев");
        driver.findElement(By.cssSelector(userMailLocator)).sendKeys("lenin133mail.ru");
        driver.findElement(By.cssSelector(userPassword1Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(userPassword2Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Сообщение Account is created не отображается");
    }
    @Test
    public void UserEntersDifferentPasswords() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("Misha");
        driver.findElement(By.cssSelector(userLastMameLocator)).sendKeys("Васильев");
        driver.findElement(By.cssSelector(userMailLocator)).sendKeys("lenin133@mail.ru");
        driver.findElement(By.cssSelector(userPassword1Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(userPassword2Locator)).sendKeys("12345622222222222");
        driver.findElement(By.cssSelector(registerButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Сообщение Account is created не отображается");
    }

    @Test
    public void userDoesNotConfirmPassword () {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("Misha");
        driver.findElement(By.cssSelector(userLastMameLocator)).sendKeys("Васильев");
        driver.findElement(By.cssSelector(userMailLocator)).sendKeys("lenin133@mail.ru");
        driver.findElement(By.cssSelector(userPassword1Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(userPassword2Locator)).sendKeys("");
        driver.findElement(By.cssSelector(registerButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Сообщение Account is created не отображается");
    }
    @Test
    public void userConfirmsPasswordWith5Spaces() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("Misha");
        driver.findElement(By.cssSelector(userLastMameLocator)).sendKeys("Васильев");
        driver.findElement(By.cssSelector(userMailLocator)).sendKeys("lenin133@mail.ru");
        driver.findElement(By.cssSelector(userPassword1Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(userPassword2Locator)).sendKeys("     ");
        driver.findElement(By.cssSelector(registerButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Сообщение Account is created не отображается");
    }
    @Test
    public void userDoesNoEnterFirstName() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("");
        driver.findElement(By.cssSelector(userLastMameLocator)).sendKeys("Васильев");
        driver.findElement(By.cssSelector(userMailLocator)).sendKeys("lenin133@mail.ru");
        driver.findElement(By.cssSelector(userPassword1Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(userPassword2Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Сообщение Account is created не отображается");
    }

    @Test
    public void userEntersNumbersFirstLastName() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(userLastMameLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(userMailLocator)).sendKeys("lenin133@mail.ru");
        driver.findElement(By.cssSelector(userPassword1Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(userPassword2Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Сообщение Account is created не отображается");
    }
    @Test
    public void userEntered5SpecialCharactersPassword() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("Vova");
        driver.findElement(By.cssSelector(userLastMameLocator)).sendKeys("Vovin");
        driver.findElement(By.cssSelector(userMailLocator)).sendKeys("lenin133@mail.ru");
        driver.findElement(By.cssSelector(userPassword1Locator)).sendKeys("@#$%^");
        driver.findElement(By.cssSelector(userPassword2Locator)).sendKeys("@#$%^");
        driver.findElement(By.cssSelector(registerButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Сообщение Account is created не отображается");
    }
    @Test
    public void userEntered5SpecialCharactersFirstName() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("@@@@");
        driver.findElement(By.cssSelector(userLastMameLocator)).sendKeys("Vovin");
        driver.findElement(By.cssSelector(userMailLocator)).sendKeys("lenin133@mail.ru");
        driver.findElement(By.cssSelector(userPassword1Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(userPassword2Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Сообщение Account is created не отображается");
    }

    @Test
    public void userEntersNameCyrillic() {
        driver.get(BASE_URL + "/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("Миша");
        driver.findElement(By.cssSelector(userLastMameLocator)).sendKeys("");
        driver.findElement(By.cssSelector(userMailLocator)).sendKeys("lenin133@mail.ru");
        driver.findElement(By.cssSelector(userPassword1Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(userPassword2Locator)).sendKeys("12345");
        driver.findElement(By.cssSelector(registerButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();
        Assert.assertEquals(text, "Oops, error on page. Some of your fields have invalid data or email was previously used", "Сообщение Account is created не отображается");

    }
        @Test
    public void loginToSiteRegisteredUser(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        WebElement firstNameInter = driver.findElement(By.cssSelector("[name=first_name ]"));
        firstNameInter.sendKeys("Slava");
        WebElement lastNameInter = driver.findElement(By.cssSelector("[name=last_name ]"));
        lastNameInter.sendKeys("Boloshenko");
        WebElement emailInter = driver.findElement(By.cssSelector("[ name=email ]"));
        emailInter.sendKeys("lenin133@mail.ru");
        WebElement passwordInter = driver.findElement(By.cssSelector("[ name=password1 ]"));
        passwordInter.sendKeys("12345");
        WebElement passwordConfirmInter = driver.findElement(By.cssSelector("[ name=password2 ]"));
        passwordConfirmInter.sendKeys("12345");
       driver.findElement(By.cssSelector("[value=Register]")).click();
        WebElement sharelane = driver.findElement(By.cssSelector("[border]"));
        sharelane.click();
        WebElement emailLogin = driver.findElement(By.cssSelector("[ name=email ]"));
        emailLogin.sendKeys("ven_fuente@712.06.sharelane.com");
        WebElement passwordLogin = driver.findElement(By.cssSelector("[ name=password ]"));
        passwordLogin.sendKeys("1111");
        WebElement sharelaneLogin = driver.findElement(By.cssSelector("[value=Login]"));
        sharelaneLogin.click();

    }

}
