# Ndosi Automation Test Site: Profile Picture UI + API Tests

## Overview

An automated test suite that verifies a user can upload a new profile picture on the Ndosi automation test site. The suite covers both layers of the feature:

UI tests (Selenium WebDriver) drive the browser through the full user journey.
API tests (Rest Assured) validate the response codes of every endpoint the UI touched during that journey.

Results are published as an Allure Report with screenshots, and the whole suite runs in GitHub Actions on every push and automatically every night at midnight SAST.
## Test Scenarios
### UI Test: Upload a profile picture
     Step	              Action	                              Expected result
      1	        Log in to the Ndosi automation test site	User lands on the home/dashboard page

      2	        Click Menu	                                Menu opens

      3	        Click My Profile	                        Profile page is displayed

      4	        Click Edit Profile	                        Edit profile form is displayed

      5     	Upload a new profile picture	            File is accepted and saved

      6	        Verify the profile picture	                The displayed picture is updated (differs from the original)



### API Tests: Validate endpoints used by the UI
    1.Capture every endpoint the UI interacts with during the steps above (using browser DevTools → Network tab).
    2.For each endpoint, send the request with Rest Assured and assert the response status code.

        Purpose	                Method                   Endpoint	           Expected status
    1.   Login	                 POST	         /api/<login-endpoint>	             200
    2.	Get profile	             GET	        /api/<profile-endpoint>	             200
    3.	Upload profile picture   POST/PUT	    /api/<upload-endpoint>	           200 / 201
    4.	Get profile after update GET	       /api/<profile-endpoint>	             200

## Tech Stack


     Tool	                        Purpose
    -Java 17	              Programming language
    -Maven	                  Build and dependency management
    -Selenium WebDriver 4	  Browser automation (UI tests)
    -Rest Assured	          API testing
    -TestNG or JUnit 5	      Test runner and assertions
    -Allure Report	          Test reporting with steps, attachments and history
    -WebDriverManager	      Automatic browser driver management
    -GitHub Actions	          CI pipeline and scheduled runs

## Project Structure

    NdosiFrameworkFinalProject/ 
    ├── .github/ 
    │      └── workflows/  
           └── tests.yml 
    ├── src/ 
    │     ├── main/
    │     │   └── java/
    │     │   │       └── api/
    │     │   │       │     └── payloadbuilder
    │     │   │       │                 ├── LoginPayload
    │     │   │       │                 ├── ProfilePayload
    │     │   │       │     └── requestbuileder
    │     │   │       │                 ├── ProfileRequestBuilder
    │     │   │       │                 ├── UserRequestBuilder
    │     │   │       └── config
    │     │   │       │     ├── ConfigReader                              
    │     │   │       └── pages/ 
    │     │   │       │     ├── LoginPage.java 
    │     │   │       │     ├── HomePage.java 
    │     │   │       │     ├── DashboardPage.java
    │     │   │       │     ├── MyProfilePage.java 
    │     │   │       │     └── EditProfilePage.java
    │     │   │       └── reporting
    │     │   │       │     ├── ExtentReportManager
    │     │   │       └── utils
    │     │   │             ├── BrowserFactory
    │     │   │             ├── DatabaseConnection
    │     │   │             ├── ReadFromFile
    │     │   │             ├── TakeScreenshots
    │     └── test/ 
    │         ├── java/ 
    │         │   ├── ui/ 
    │         │   │   └── ProfilePictureTest.java 
    │         │   ├── api/
    │         │   │   └── ProfilePictureApiTest.java 
    │         │   └── base/ 
    │         └── resources/ 
    │             ├── testdata/ 
    │             │   └── profile-picture.jpg 
    │             └── allure.properties 
    ├── pom.xml 
    └── README.md

The UI layer follows the Page Object Model (POM): each page (Homepage, Login, Dashboard, Edit Profile, My profile) has its own class so locators and actions live in one place and tests stay readable.

## Prerequisites

#### Make sure you have the following installed:
     - JDK 17 or later – check with java -version
     - Maven 3.9+ – check with mvn -version
     - Google Chrome (latest) – the default browser
     - Git
     - Allure CLI (optional, only to view reports locally) – see the Allure installation guide

## Getting Started

### 1. Clone the repository
git clone https://github.com/ThulaBrian/NdosiFrameworkFinalProject.git
cd NdosiFrameworkFinalProject

### 2. Install dependencies
mvn clean install -DskipTests

This command cleans the previous build, compiles the project, and resolves the required Maven dependencies without executing the tests.

### 3.Run the automated tests

Run the complete test suite:

mvn clean test

### 4. Generate and view the Allure report

After test execution, generate the report:

allure generate allure-results --clean -o allure-report

Open the report in your browser:

allure open allure-report

# Continuous Integration with GitHub Actions

The test suite is intended to run automatically through GitHub Actions:

**On every push to the configured branches.
**On a nightly schedule at midnight SAST.
**With test results and Allure report artifacts retained for review.

GitHub Actions scheduled workflows use UTC. Since SAST is UTC+2, midnight SAST corresponds to 22:00 UTC on the previous day.

on:
push:
schedule:
- cron: '0 22 * * *'
workflow_dispatch:

The scheduled run is subject to GitHub Actions scheduling behavior. Configure the appropriate branches, Java and Maven setup, browser dependencies, secrets, and report artifact upload in the workflow.

# Reporting and Test Evidence

The suite should produce an Allure report containing:

Test names and execution results.
Step-by-step execution details.
Failure messages and stack traces.
Screenshots captured during UI test failures, and optionally at key checkpoints.
API request and response details where appropriate, with passwords, tokens, cookies, and other sensitive data redacted.

The report helps identify failures and provides evidence for debugging and regression testing.

# Notes and Limitations

- The actual API endpoints and their expected status codes must be confirmed against the application.
- API tests must reproduce the authentication and request requirements of the live test environment.
- UI tests should use explicit waits rather than fixed sleep intervals wherever possible.
- Profile picture verification should compare the actual displayed image or a stable image identifier rather than relying only on a success message.
- The application URL, credentials, and test data should be configurable so the suite can run locally and in CI.
- The exact test commands and report paths depend on the existing Maven, test-runner, and Allure configuration.

# Project Repository

NdosiFrameworkFinalProject on GitHub