package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Utilities;

import java.util.List;

public class HomePage extends Utilities {

    @FindBy(css = "[id=\"menu-item-844\"]")
    public WebElement myAccountButton;

    @FindBy(css = "[id=\"menu-item-834\"]")
    public WebElement shopButton;

    @FindBy(css = "[name=\"email\"]")
    public WebElement emailRegBox;

    @FindBy(css = "[name=\"register\"]")
    public WebElement regButton;

    @FindBy(css = "[name=\"username\"]")
    public WebElement userBox;

    @FindBy(css = "[name=\"password\"]")
    public WebElement passwordBox;

    @FindBy(css = "[class=\"show-password-input\"]")
    public WebElement hidePassword;

    @FindBy(css = "[name=\"rememberme\"]")
    public WebElement rememberButton;

    @FindBy(css = "[name=\"login\"]")
    public WebElement logInButton;

    @FindBy(css = "p [href=\"https://training.qastorming.com/my-account/edit-account/\"]")
    public WebElement editAccount;

    @FindBy(css = "[name=\"account_first_name\"]")
    public WebElement firstNameBox;

    @FindBy(css = "[name=\"account_last_name\"]")
    public WebElement lastNameBox;

    @FindBy(css = "[name=\"account_display_name\"]")
    public WebElement displayNameBox;

    @FindBy(css = "[name=\"password_current\"]")
    public WebElement currentPasswordBox;

    @FindBy(css = "[name=\"password_1\"]")
    public WebElement newPasswordBox;

    @FindBy(css = "[name=\"password_2\"]")
    public WebElement confirmPasswordBox;

    @FindBy(xpath = "//*[@id=\"post-92\"]/div/div/div/form/fieldset/p[1]/span/span")
    public WebElement currentPassHide;

    @FindBy(xpath = "//*[@id=\"post-92\"]/div/div/div/form/fieldset/p[2]/span/span")
    public WebElement newPassHide;

    @FindBy(xpath = "//*[@id=\"post-92\"]/div/div/div/form/fieldset/p[3]/span/span")
    public WebElement confirmPassHide;

    @FindBy(css = "[name=\"save_account_details\"]")
    public WebElement saveChangesButton;

    @FindBy(css = "[class=\"products columns-3\"] li")
    public List<WebElement> productList;

    @FindBy(css = "[class=\"summary entry-summary\"] ins bdi")
    public WebElement productOffPrice;

    @FindBy(css = "[class=\"summary entry-summary\"] bdi")
    public WebElement productPrice;

    @FindBy(css = "[class=\"woocommerce-product-details__short-description\"]")
    public WebElement productInfo;

    @FindBy(css = "[role=\"presentation\"]")
    public WebElement productPhoto;

    @FindBy(css = "[name=\"add-to-cart\"]")
    public WebElement addCart;

    @FindBy(css = "[id=\"site-navigation\"] [class=\"tg-icon tg-icon-shopping-cart\"]")
    public WebElement cartButton;

    @FindBy(css = "tbody [class=\"product-subtotal\"]")
    public List<WebElement> subTotal;

    @FindBy(css = "[data-title=\"Total\"]")
    public WebElement cartTotal;

    @FindBy(css = "[class=\"wc-proceed-to-checkout\"] a")
    public WebElement proceedButton;

    @FindBy(css = "[name=\"billing_first_name\"]")
    public WebElement billingFirstNameBox;

    @FindBy(css = "[name=\"billing_last_name\"]")
    public WebElement billingLastNameBox;

    @FindBy(css = "[name=\"billing_company\"]")
    public WebElement companyBox;

    @FindBy(css = "[id=\"select2-billing_country-container\"]")
    public WebElement countryMenu;

    @FindBy(css = "[class=\"select2-results__option\"]")
    public List<WebElement> countryList;

    @FindBy(css = "[name=\"billing_address_1\"]")
    public WebElement addressBox;

    @FindBy(css = "[name=\"billing_address_2\"]")
    public WebElement adressBoxTo;

    @FindBy(css = "[name=\"billing_postcode\"]")
    public WebElement postcodeBox;

    @FindBy(css = "[name=\"billing_city\"]")
    public WebElement cityBox;

    @FindBy(css = "[id=\"select2-billing_state-container\"]")
    public WebElement provinceMenu;

    @FindBy(css = "[class=\"select2-results__option\"]")
    public List<WebElement> provinceList;

    @FindBy(css = "[name=\"billing_phone\"]")
    public WebElement phoneBox;

    @FindBy(css = "[name=\"billing_email\"]")
    public WebElement mailBox;

    @FindBy(css = "[id=\"place_order\"]")
    public WebElement placeOrderButton;

    @FindBy(css = "[class=\"woocommerce-error\"]")
    public WebElement invalidOrder;

    public void verifyTotal(){
        pause(0.5);
        Double additionPrice = null;
        Double totalPrice = null;
        for (WebElement productPrice:subTotal) {
            String stringPrice = productPrice.getText().replaceAll("₺","").replaceAll(",",".");
            try{
                Double intNumber = Double.parseDouble(stringPrice);
                additionPrice =+intNumber;
                System.out.println("subTotal price "+intNumber);
            }
            catch (NumberFormatException ex){ex.printStackTrace();
            }
        }
        try{
            String totalString =cartTotal.getText().replaceAll("₺","").replaceAll(",",".");
            Double intNumber = Double.parseDouble(totalString);
            totalPrice=intNumber;
            System.out.println("total price is "+intNumber);
        }
        catch (NumberFormatException ex){ex.printStackTrace();
        }
        try {
            Assert.assertEquals(additionPrice,totalPrice);
            System.out.println("Price check Succesfull");
        }catch (NoSuchElementException ignored){
            System.out.println("This element not found");
        }
        pause(0.5);
    }

    public void existPrice(WebElement element, WebElement elementTo) {
        pause(0.5);
        try {
            Assert.assertNotNull("This product is not on a sale",waitUntilVisible(element,System.currentTimeMillis()));
            System.out.println("This product offer price " + element.getText());
        } catch (NoSuchElementException e) {
            try {
                Assert.assertNotNull("This product price not found",waitUntilVisible(elementTo,System.currentTimeMillis()));
                System.out.println("This product price " + elementTo.getText());
            } catch (NoSuchElementException a){
                System.out.println("This element not found");
            }
            pause(0.5);
        }
    }

    public void existInvalid(){
        pause(0.5);
        try {
            Assert.assertTrue(invalidOrder.getText().contains("Invalid payment method."));
            System.out.println("This Invalid Payment Method.");
        }catch (NoSuchElementException ignored){
            System.out.println("This element not found");
        }
        pause(0.5);
    }

    public void existInfo (WebElement element){
        pause(0.5);
        boolean info;
        try {
            Assert.assertNotNull("This element info not found",waitUntilVisible(element,System.currentTimeMillis()));
            info = true;
            System.out.println("This element info is exist");
        } catch (AssertionError a) {
            info = false;
        }
        pause(0.5);
    }

    public void existPhoto (WebElement element){
        pause(0.5);
        boolean info;
        try {
            Assert.assertNotNull("This product photo not found",waitUntilVisible(element,System.currentTimeMillis()));
            info = true;
            System.out.println("This product photo is exist");
        } catch (AssertionError a) {
            info = false;
        }
        pause(0.5);
    }

    public void display(String shape,WebElement off){
        switch (shape.toLowerCase()){
            case "on":
                return;
            case "off":
                click(off);
                return;
            default:
                System.out.println("SHOULD BE ENTRY ON/OFF");
        }
    }

    public void loopAndClick(List<WebElement> list,String buttonName){
        for (WebElement item:list) {
            if (item.getText().contains(buttonName)){
                click(item);
                return;
            }
        }
        Assert.fail("No such element was found...");
    }



}
