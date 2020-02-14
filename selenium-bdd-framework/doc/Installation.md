# Pre-requisites
- <a href="https://java.com/en/download/manual.jsp" target="_blank">Java</a>
- <a href="https://maven.apache.org/download.cgi" target="_blank">Maven</a>
- <a href="https:https://eclipse.org/downloads/" target="_blank">Eclipse</a>
- Eclipse Plugins
  - <a href="http://download.eclipse.org/technology/m2e/releases/1.4" target="_blank">Maven</a> 
  - <a href="http://cucumber.github.io/cucumber-eclipse/update-site/" target="_blank">Cucumber</a>
  
# Setting up selenium-cucumber-java
- Install Java and set path.
- Install Maven and set path.
- Clone respective repository or download zip.
	- maven : https://github.com/yafifaisal/selenium-bdd-framework

# Running features
- Goto project directory.
- Use "mvn test" command to run features.
- Use "mvn test -Dbrowser=browser_name" to run features on specific browser.
- browser_name can be one of following but make sure that browser’s driver file are present and specified in system variable.
-- ff
-- chrome
-- ie
-- safari