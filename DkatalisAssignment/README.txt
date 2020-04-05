################# UI automation framework ################

###Prerequisites to run the project
1. JDK configured
2. Maven configured



###Steps to run the project
1. Open cmd, go to root location of project, i.e. \DkatalisAssignment
2. Execute command: mvn clean test
3. Report will be generated in location "\DkatalisAssignment\target" by the name "ExtentReport.html"



###Following technologies have been used in project:
Language- Java
Build tool- Maven
Testing framework- TestNG, Page Object Model
Reporting framework- Extent Reports



###File structure of project:
As maven is used, we have following project structure:
	
DkatalisAssignment
	src/main/java
		com.dkatalis.pageobjects
		com.dkatalis.resources
		com.dkatalis.utils
	src/test/java
		com.dkatalis.uitestcases
	JRE System Library
	Maven Dependencies
	src
	target
	pom.xml
	testng.xml

1. In "com.dkatalis.pageobjects" package, all the page object classes are created.
2. In "com.dkatalis.resources" package, following resources are present.
	a)Customer details CSV sheet 
	b)Credit card details CSV sheet
	c)Chrome driver
	d)Firefox drivers.
3. In "com.dkatalis.utils" package, following utility classes are created.
	a)To read CSV datasheets
	b)To switch to a frame
	c)To take screenshot are present
4. In "com.dkatalis.uitestcases", following test classes are created.
	a)BaseUITest
	b)CheckoutFlowsTest
5. In testng, following four parameters are passed.
	a)Browser: chrome/firefox
	b)Frontend_Server(application url): https://demo.midtrans.com/
	c)Pageload_Timeout: 5
	d)Implicit_Wait: 5
   So user can update the value of these parameters accordingly. By default script will run in "Chrome". To run it in "Firefox" browser, change parameter value to             "firefox".
6. Extet report will be generated in "target" folder.



###Assumptions
1. As we are creating end to end flow, so in positive testcase we are asserting in the end to verify whether order is placed successfully.
   Intermediate assertions are not used as we would have diff tescases for those.
2. Negative testcases steps are same as positive, just the difference is that it will fail because of invalid card.
   As mentioned in assignment that it should fail, so we have not handled that exception. Because if we had handled it then testcase will not fail.

   

   
