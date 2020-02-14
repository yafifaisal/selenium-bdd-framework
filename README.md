# Selenium-BDD-Framework

Selenium-BDD-Framework is a project of UI automation framework covering the payment scenario of https://demo.midtrans.com/ website.  
This project is built using Selenium Webdriver with Java and TestNG. 

Documentation
-------------
* [Installation](doc/installation.md)

Download a Framework
--------------
* Maven - https://github.com/yafifaisal/selenium-bdd-framework

Writing a test
--------------

The cucumber features goes in the `features` library and should have the ".feature" extension.

You can start out by looking at `features/Payment.feature`. 

Running test
--------------

Go to your project directory from terminal and hit following commands
* `mvn test (defualt will run on local firefox browser)`
* `mvn test "-Dbrowser=chrome" (to use any other browser)`
