Zopa Rate Calculation system

Problem Statement :
There is a need for a rate calculation system allowing prospective borrowers to obtain a quote from zopa's pool of lenders for 36 month loans.
This new system should strive to provide as low a rate to the borrower as is possible to ensure that Zopa's quotes are as competitive as they can be against our competitors'.
And also to provide the borrower with the details of the monthly repayment amount and the total repayment amount.

Assumptions

That the supplied rate in the excel file is yearly rate
That a lender's offer can be partly utilized but at the given offer rate i.e. a lender can have availability of £600 but we may only need £300

Prerequisites
You need to install the following in your system

Java 1.8 
Maven 

Building the code:

Clone from git or unzip the supplied zip file  

 * git clone git@github.com:jehovah1215/zopa.git 

From the terminal (MAC) navigate to the root location of the project, where the POM.xml is located.
  ( /*path to zopa folder/*)

 * mvn clean install

Running the App

Sample test file is located at /src/test/resources

From the root path, run the following commands:

*  mvn exec:java -Dexec.mainClass=com.zopa.main.App -Dexec.args="src/test/resources/MarketData.csv 1000"

Running the tests

*  mvn test

Test driven development (TDD) using jUnit

TO DO :

Implement dependency injection for a loosely couple system
Implement proper logging using SL4J or another library 
Use of lombok for getters and setters in POJO classes
Make the project spring boot 
Use strategy design pattern for calculation algorithms (dynamically we can decide which set of rules to pick )
