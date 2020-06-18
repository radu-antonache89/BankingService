# BankingService

Requirement:
Write an endpoint that will allow an existing user to open a savings account. The account can only be opened from Monday to Friday within working hours and the user can have only one savings account.
The data can be stored however you see fit (e.g. database, in memory, file) and you can use any JVM language and framework.
Optional: Create a web form that will provide the data to the backend application.

Description:
The application uses the Spring Boot framework, which facilitates the development of RESTful web service application.
After loading the Java project into the eclipse IDE (Spring Tools plug-in required), the project must be run as a Spring Boot App.

USAGE:

1. Run the application in eclipse as Spring Boot app

2. Open the "OpenSavingsAccount.html" webpage in a browser

3. Use any of the available credentials listed below to open a new savings account. (the first user already has a savings account, so an error will be displayed)


The application includes 3 hard-coded users, with the following credentials:

User 1:

    username: "JohnDoe"
    
    password: "mypass"

User 2:

    username: "JaneDoe"
    
    password: "newpass"

User 3:

    username: "SteveSmith"
    
    password: "anotherpass"

In order to test the ability of a user to open a new savings account, the user must send a request with the following format:
http://localhost:8080/savingsAccounts/add?user=JaneDoe&pass=newpass&initialDeposit=400

The URL sent from the browser is validated to check if there is an existing user account with the specified credentials, and it will throw an error in case the user doesn't exist.

Afterwards, if the user validation passes, there will be a check to see if the current time of day and day of the week allow for the creation of a new savings account.

If this second validation also passes, the application will attempt to create a new savings account for the user, with the initial balanced specified by the "initialDeposit" query parameter retrieved from the URL.

If there is already an existing savings account for the specified user, the application will return an error message in the browser.
Otherwise, a new savings account will be created, and the information will be serialized in JSON format in a file called "savings_account_data.json", generated inside the root folder of the app ("Banking").

Initially, this file contains an account for the first user, so only the other two users can create new accounts. 
