package Suporte;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor {

    public void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver ;
        jse.executeScript("arguments[0].setAttribute('style', 'background: withe; border: 1px solid black;');", element);
    }

}
