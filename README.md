# Ndosi Automation Test Site: Profile Picture UI + API Tests

## Overview

An automated test suite that verifies a user can upload a new profile picture on the Ndosi automation test site. The suite covers both layers of the feature:

UI tests (Selenium WebDriver) drive the browser through the full user journey.
API tests (Rest Assured) validate the response codes of every endpoint the UI touched during that journey.

Results are published as an Allure Report with screenshots, and the whole suite runs in GitHub Actions on every push and automatically every night at midnight SAST.
## Test Scenarios
### UI Test: Upload a profile picture
#### Step	              Action	                              Expected result
      1	        Log in to the Ndosi automation test site	User lands on the home/dashboard page

      2	        Click Menu	                                Menu opens

      3	        Click My Profile	                        Profile page is displayed

      4	        Click Edit Profile	                        Edit profile form is displayed

      5     	Upload a new profile picture	            File is accepted and saved

      6	        Verify the profile picture	                The displayed picture is updated (differs from the original)



### API Tests: Validate endpoints used by the UI
    1.Capture every endpoint the UI interacts with during the steps above (using browser DevTools → Network tab).
    2.For each endpoint, send the request with Rest Assured and assert the response status code.

####    Purpose	                Method                   Endpoint	           Expected status
    1.   Login	                 POST	         /api/<login-endpoint>	             200
    2.	Get profile	             GET	        /api/<profile-endpoint>	             200
    3.	Upload profile picture   POST/PUT	    /api/<upload-endpoint>	           200 / 201
    4.	Get profile after update GET	       /api/<profile-endpoint>	             200

## Tech Stack


###  Tool	                        Purpose
    -Java 17	              Programming language
    -Maven	                  Build and dependency management
    -Selenium WebDriver 4	  Browser automation (UI tests)
    -Rest Assured	          API testing
    -TestNG or JUnit 5	      Test runner and assertions
    -Allure Report	          Test reporting with steps, attachments and history
    -WebDriverManager	      Automatic browser driver management
    -GitHub Actions	          CI pipeline and scheduled runs

## Project Structure

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

