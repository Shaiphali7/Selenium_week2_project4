package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    @Before
    public void setUp()
    {
        openBrowser();
    }
    @Test
    public void userSholdLoginSuccessfullyWithValid()
    {
        //Entering the user name
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Entering password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on Login button
        driver.findElement(By.id("login-button")).click();
        //verifying the text "PRODUCTS"
        String actualHeaderName=driver.findElement(By.xpath("//div[@class='header_secondary_container']//span[@class='title']")).getText();
        String expectedHeaderName="Products";
        //verifying the text is Products
        Assert.assertEquals("Not the same header name",actualHeaderName,expectedHeaderName);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage()
    {
        //Entering the user name
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Entering password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on Login button
        driver.findElement(By.id("login-button")).click();
        //Verifying that six products are displayed
        int elementNumber=driver.findElements(By.xpath("//div[@class='inventory_item_name']")).size();
        System.out.println("Number of element are displayed are "+elementNumber);
    }
    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
