@Case
Feature:

  Background:
    * I navigate to training.qastorming.com

  Scenario:Register Scenario

    * I click My account
    * I Register in email getir@case.com
    * I click Register

  Scenario:Change Profile Details

    * I click My account
    * I Log in email or Username beyazgulsamil@gmail.com
    * I Log in password beyazgul741 and Hide off
    * I remember me
    * I click Log in
    * I Edit Account
    * I entry First name Şamil and Last name Beyazgül
    * I entry display name samilBeyazgul
    * Enter current password beyazgul741 Hide on
    * Enter new password and confirm NewPassword63 Hide off
    * I click Save Changes

  Scenario:Complete Order Until You See Payment Error
    * I click Shop
    * I click random product
    * I Check this existing to product description, price, and photo existence
    * This product add to cart
    * I go to cart
    * Verify check price
    * I Proceed to checkout
    * I entry first name Şamil
    * I entry last name Beyaz
    * I entry company Getir
    * I select country Netherlands
    * I entry street name Red Light
    * I entry apartment name White Tower
    * I entry post code 300500
    * I entry town name CityTown
    * I entry phone number 0500300500300
    * I entry mail getir@case.com
    * I click place order
    * I verify invalid payment method
