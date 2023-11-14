import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Project_2_HeroUApp {
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;
    static String browser = "Chrome";

    //using if else statement so that user can choose browser to use
    public static void main(String[] args) throws InterruptedException {
        if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("Internet Explorer")) {
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Enter correct browser name.");
        }
        driver.get(baseUrl); //opening the Url
        Thread.sleep(2000);
        driver.manage().window().maximize(); //maximizing the browser
        System.out.println("Title of the page is: " + driver.getTitle()); //printing the title of the page
        System.out.println("Current page Url is: " + driver.getCurrentUrl()); //printing the current page url
        Thread.sleep(2000);
        WebElement usernameField = driver.findElement(By.name("username"));
        System.out.println("Page source is: " + driver.getPageSource());
        usernameField.sendKeys("Admin");
        Thread.sleep(2000);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("admin123");
        Thread.sleep(2000);
        WebElement loginClick = driver.findElement(By.name("login"));
        loginClick.click();

        System.out.println("Current url of page is: " + driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.close();
    }
}
