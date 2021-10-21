package steps;

import io.cucumber.java.en.Then;
import pages.HomePage;

import java.util.Random;

public class HomePageSteps {
    HomePage homePage = new HomePage();

    @Then("I click My account")
    public void myAccount(){homePage.click(homePage.myAccountButton);}

    @Then("I click Shop")
    public void shop(){homePage.click(homePage.shopButton);}

    @Then("I Register in email {}")
    public void mailReg(String mail){homePage.fillInput(homePage.emailRegBox,mail);}

    @Then("I click Register")
    public void register(){homePage.click(homePage.regButton);}

    @Then("I Log in email or Username {}")
    public void logIn(String mailorName){homePage.fillInput(homePage.userBox,mailorName);}

    @Then("I Log in password {} and Hide {}")
    public void logPassword(String password,String shape){
        homePage.fillInput(homePage.passwordBox,password);
        homePage.display(shape,homePage.hidePassword);
    }

    @Then("I remember me")
    public void clickRemember(){homePage.click(homePage.rememberButton);}

    @Then("I click Log in")
    public void clickLog(){homePage.click(homePage.logInButton);}

    @Then("I Edit Account")
    public void clickEdit(){homePage.click(homePage.editAccount);}

    @Then("I entry First name {} and Last name {}")
    public void names(String firstName,String lastName){
        homePage.fillInput(homePage.firstNameBox,firstName);
        homePage.fillInput(homePage.lastNameBox,lastName);
    }

    @Then("I entry display name {}")
    public void displayName(String displayName){homePage.fillInput(homePage.displayNameBox,displayName);}

    @Then("Enter current password {} Hide {}")
    public void currentPassword(String password,String shape){
        homePage.fillInput(homePage.currentPasswordBox,password);
        homePage.display(shape,homePage.currentPassHide);
    }

    @Then("Enter new password and confirm {} Hide {}")
    public void newPassword(String password,String shape){
        homePage.fillInput(homePage.newPasswordBox,password);
        homePage.fillInput(homePage.confirmPasswordBox,password);
        homePage.display(shape,homePage.newPassHide);
        homePage.display(shape,homePage.confirmPassHide);
    }

    @Then("I click Save Changes")
    public void saveChanges(){homePage.click(homePage.saveChangesButton);}

    @Then("I click random product")
    public void randomProduct(){homePage.click(homePage.productList.get(new Random().nextInt(homePage.productList.size())));}

    @Then("I Check this existing to product description, price, and photo existence")
    public void exist(){
        homePage.existPrice(homePage.productOffPrice, homePage.productPrice);
        homePage.existInfo(homePage.productInfo);
        homePage.existPhoto(homePage.productPhoto);
    }

    @Then("This product add to cart")
    public void addProduct(){homePage.click(homePage.addCart);}

    @Then("I go to cart")
    public void cart(){homePage.click(homePage.cartButton);}

    @Then("Verify check price")
    public void verify(){homePage.verifyTotal();}

    @Then("I Proceed to checkout")
    public void checkout(){homePage.click(homePage.proceedButton);}

    @Then("I entry first name {}")
    public void firstName(String input){homePage.fillInput(homePage.billingFirstNameBox,input);}

    @Then("I entry last name {}")
    public void lastName(String input){homePage.fillInput(homePage.billingLastNameBox,input);}

    @Then("I entry company {}")
    public void company(String input){homePage.fillInput(homePage.companyBox,input);}

    @Then("I select country {}")
    public void country(String input){
        homePage.click(homePage.countryMenu);
        homePage.loopAndClick(homePage.countryList,input);
    }

    @Then("I entry street name {}")
    public void street(String input){homePage.fillInput(homePage.addressBox,input);}

    @Then("I entry apartment name {}")
    public void apartment(String input){homePage.fillInput(homePage.adressBoxTo,input);}

    @Then("I entry post code {}")
    public void post(String input){homePage.fillInput(homePage.postcodeBox,input);}

    @Then("I entry town name {}")
    public void town(String input){homePage.fillInput(homePage.cityBox,input);}

    @Then("I select city {}")
    public void city(String input){
        homePage.click(homePage.provinceMenu);
        homePage.loopAndClick(homePage.provinceList,input);
    }

    @Then("I entry phone number {}")
    public void phone(String input){homePage.fillInput(homePage.phoneBox,input);}

    @Then("I entry mail {}")
    public void mail(String input){homePage.fillInput(homePage.mailBox,input);}

    @Then("I click place order")
    public void placeOrder(){homePage.pause(3);homePage.click(homePage.placeOrderButton);}

    @Then("I verify invalid payment method")
    public void verifyPayment(){homePage.existInvalid();}



}
