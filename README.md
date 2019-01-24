# Selenium-Google

## Installation
The following need to be installed:
* Cucumber for Java plugin installed
* Maven installed
* Java 11

## Running the tests
Tests can be run in one of the following ways:
* Running one of the individual RunCucumberTest_* classes.
* 'mvn clean test' will run all tests against Chrome.

To run the tests in parallel against a specific browser, you can use one of the profies in the pom.xml:
* mvn clean test -PChrome
* mvn clean test -PFirefox
* mvn clean test -PEdge

## Project information
* Please note, the tests are just an example of what can be done, they're not designed to be exhaustive.