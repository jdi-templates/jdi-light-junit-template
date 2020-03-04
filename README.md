# JDI Light project template
For run new UI test autoamtion just download and open this project
Powered by [JDI Light](https://github.com/jdi-testing/jdi-light) and Selenium

# Instruction:
1. Download template and unpack in appropriate folder

2. Open project in IDE (for exampel IntelliJIdea)

3. For running demo tests:
	* Maven: just use "mvn clean install" command
http://pix.my/o/fkSH1s?1547398376
	* IDE: add **junit.jupiter.extensions.autodetection.enabled** property for default jUnit configuration 
https://pix.my/FGWRuX and run by click on "example" folder in src/test and select "Run tests"
http://pix.my/o/SJtkya?1547398292
	* Also it's possible to annotate test classes with **@ExtendWith(JDISetupExtension.class)** instead of passing this property to JUnit

4. Logs: Observe test run results in Console log
http://pix.my/o/CEtiOQ?1547398216

5. Reporting: Afterrunning tests copy paste **allure-results** folder in to target folder. Run **allure:serve** in maven plugins
http://pix.my/o/5KPsyr?1547398089

6. Use as template for your project: 
	* just remove all content from **src/main/.../example** folder, add your package you Page Objects
	* replace tests in **src/test/.../example** folder with your tests

7. TestNg Retry and before after listners: You can also modify rules of retry tests (now it is 1 retry for each test) and actions before/after all tests (now it prints test name and result) in **org.mytests.tests.testng** folder
