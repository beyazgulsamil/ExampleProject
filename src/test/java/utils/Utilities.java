package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class Utilities extends Driver {

    public Utilities(){PageFactory.initElements(driver,this);}

    public void click(WebElement element){waitUntilClickable(scroll(element),System.currentTimeMillis()).click();}

    public void fillInput(WebElement inputBox, String inputText){
        clear(scroll(waitUntilVisible(inputBox,System.currentTimeMillis()))).sendKeys(inputText);}

    public WebElement clear(WebElement inputBox){
        inputBox.clear();
        for (int i = 0; i < inputBox.getAttribute("value").length(); i++) {
            inputBox.sendKeys(Keys.BACK_SPACE);
        }
        return inputBox;
    }

    public WebElement scroll(WebElement element){
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor)driver).executeScript(scrollElementIntoMiddle, element);
        pause(0.5);
        return element;
    }

    public void pause(double duration){
        try {Thread.sleep((long) (duration*1000));}
        catch (InterruptedException e) {e.printStackTrace();}
    }

    public WebElement waitUntilVisible(WebElement element, long initialTime){
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        if (System.currentTimeMillis()-initialTime>15000){
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            return null;
        }
        try {if (!element.isDisplayed()){waitUntilVisible(element, initialTime);}}
        catch (StaleElementReferenceException|NoSuchElementException|TimeoutException exception){
            waitUntilVisible(element, initialTime);
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return element;
    }

    public WebElement waitUntilClickable(WebElement element, long initialTime){
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        if (System.currentTimeMillis()-initialTime>15000){
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return null;
        }
        try {if (!element.isEnabled()){waitUntilClickable(element, initialTime);}}
        catch (StaleElementReferenceException|NoSuchElementException|TimeoutException exception){
            waitUntilClickable(element, initialTime);
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return element;
    }
}