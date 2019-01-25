# Selenium-Google

## Installation
The following need to be installed:
* Cucumber for Java plugin installed
* Maven installed
* Java 11

## Running the tests
Tests can be run in one of the following ways:
* Running one of the individual RunCucumberTest_* classes.
* Running one of the Maven profiles that have been set up in the POM.

To run all of the tests in parallel using a Chrome on your local machine:
* mvn clean test -PChrome

You can also run the tests in parallel against a specific browser/operating system.
* mvn clean test -POSXMojaveChrome
* mvn clean test -PW10Firefox

This will run these tests on Browserstack using the specified browser and operation system.
The environment configuration can be found you can be found here: src\test\resources\SeleniumGoogle
You will need to update the Config.properties file with your BrowserStack username and access key.

## Project information
* Please note, the tests are just an example of what can be done, they're not designed to be exhaustive.
* Due to the tests running against Google, they occasionally trigger Captcha which causes them to fail.