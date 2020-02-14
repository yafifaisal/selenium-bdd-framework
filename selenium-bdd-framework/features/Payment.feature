Feature: Checkout Pillow
  As a user I want to buy pillow

  Scenario: Payment Successful
    Given I navigate to "https://demo.midtrans.com/"
    And I click on element having xpath "//*[@class='btn buy']"
    And I click on element having class "cart-checkout"
    And I click on element having xpath "//*[@id='application']/div[1]/a"
    And I click on element having xpath "//*[@class='list with-promo']"
    When I enter "4811111111111114" into input field having name "cardnumber"
    When I enter "0220" into input field having xpath "//*[@class='input-group col-xs-7']/input"
    When I enter "123" into input field having xpath "//*[@class='input-group col-xs-5']/input"
    And I click on element having class "button-main-content"
    When I enter "112233" into input field having name "PaRes"
    And I click on element having name "ok"
    Then element having xpath "//*[@data-reactid='.0.0.0.2.0.1.0.0:0']" should have text as "Thank you for your purchase."
    
    Scenario: Payment Failed
    Given I navigate to "https://demo.midtrans.com/"
    And I click on element having xpath "//*[@class='btn buy']"
    And I click on element having class "cart-checkout"
    And I click on element having xpath "//*[@id='application']/div[1]/a"
    And I click on element having xpath "//*[@class='list with-promo']"
    When I enter "4811111111111113" into input field having name "cardnumber"
    Then element having xpath "//*[@class='notice danger']/*[1]/*[1]" should have text as "Invalid card number"