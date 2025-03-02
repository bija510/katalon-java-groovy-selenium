# Katalon Studio-Selenium-Java-Groovy

# Katalon Studio Project

## 📌 Overview
This project showcases my hands-on experience in Katalon Studio, where I have worked extensively on various testing methodologies, enhancing automation efficiency and reliability.

## 🔍 Areas of Expertise
- ✅ **Mobile Testing** – Automated testing for mobile applications across different platforms.
- ✅ **API Testing** – Validating API endpoints, request/response handling, and integration testing.
- ✅ **Cucumber BDD** – Implementing Behavior-Driven Development for better collaboration and readability.
- ✅ **Desktop Application Testing** – Ensuring seamless functionality and performance of desktop applications.
- ✅ **Web UI Testing Framework** – Enhancing and optimizing the test automation framework for better scalability.

## 🎯 Key Contributions
- 🚀 Improved the efficiency and performance of the testing framework.
- 🔧 Ensured better test automation, reliability, and maintainability.
- 📌 Implemented best practices for scalable and reusable test scripts.

## 📂 Tech Stack
- 🔹 **Katalon Studio**
- 🔹 **Groovy**
- 🔹 **Selenium WebDriver**
- 🔹 **Cucumber BDD**
- 🔹 **API Automation**

## 📢 Let's Connect!
Feel free to connect with me for collaboration or discussion on test automation! 🚀

# Web & Mobile Test Automation Guide

## Overview
This repository contains demo test cases and best practices for web, mobile, desktop, and API testing using **Katalon Studio**, **Selenium**, **Cucumber BDD**, **TestNG**, and **WinAppDriver**.

## Contents

### Web Application Testing
- Web UI testing demo using **Katalon WebUI library** and **Selenium**
- Web testing using **Cucumber BDD**
- Web testing using **TestNG framework with Java**

### Mobile Application Testing
- **Android Testing** using **Katalon Mobile library** (built on Appium)

### Windows Application Testing
- **Desktop Application Testing** using **Katalon Windows library** with **WinAppDriver**

### API Testing
- Comprehensive **API Testing**

## UI Test Automation Best Practices

Refer to: [Top 15 UI Test Automation Best Practices](https://www.blazemeter.com/blog/top-15-ui-test-automation-best-practices-you-should-follow)

### Agile Test Pyramid (By Mike Cohn)
1. **Unit Tests (70%)** – Fastest feedback
2. **API, Integration & Component Tests (20%)**
3. **GUI Testing (Manual + Automated) (10%)**

### Key Best Practices:
- Use **BDD frameworks** to improve collaboration
- Follow **test design patterns** (e.g., **Page Object Model**) to improve code maintenance
- **Avoid `Thread.sleep()`**, use **Explicit Waits** instead
- **Cross-browser testing:**
  - Run main test cases in additional browsers
  - **E2E tests should run only on the most used browser (Chrome 63.5%)**
- **Keep test automation framework separate from tests**
- **Make the framework portable**
- **Use meaningful test names**
- **Use soft assertions for multiple checks on a page**
- **Take screenshots for failure analysis**
- **Follow a "green tests" policy**
- **Use data-driven testing instead of repeated test cases**
- **Ensure test independence** for better parallel execution
- **Enable detailed test reporting**
- **Use assertions only in the test class**
- **Never use the driver instance in the test class**
- **Implement rerun for failing tests in regression suites**

## Git & GitHub Usage
### Getting Started with Git
1. Download Git: [Git-SCM](https://git-scm.com/downloads)
2. Create a **GitHub Account**: [Sign Up](https://github.com/join)
3. Clone a Project:
   ```sh
   git clone <repo_url>
   ```
4. Check commit history:
   ```sh
   git log --oneline
   ```

### Git Workflow Commands
- **Check Status:**
  ```sh
  git status
  ```
- **Add Files:**
  ```sh
  git add .
  ```
- **Commit Changes:**
  ```sh
  git commit -m "Your commit message"
  ```
- **Push to Remote:**
  ```sh
  git push origin master
  ```
- **Pull Latest Changes:**
  ```sh
  git pull origin master
  ```
- **Fetch Updates:**
  ```sh
  git fetch
  ```
- **Merge Branch:**
  ```sh
  git merge <branch_name>
  ```
- **Create & Use Personal Access Token**: [GitHub Token Authentication](https://github.blog/2020-12-15-token-authentication-requirements-for-git-operations/)

## Automating UWP Desktop Applications in Windows

### Steps:
1. **Install WinAppDriver:**
   - Go to `C:\Program Files (x86)\Windows Application Driver\WinAppDriver.exe`
   - Open CMD in that folder and run:
     ```sh
     WinAppDriver.exe
     ```
2. **Enable Developer Mode:**
   - Open Windows search → Type **Developer Settings** → Turn on **Developer Mode**
3. **Find Package Family Name & Application ID:**
   - Open **PowerShell** and run:
     ```sh
     get-appxpackage > C:\temp\UWP_Apps_List.txt
     ```
   - Open `UWP_Apps_List.txt` and locate the target app details.
4. **Create a Test Case in Katalon Studio:**
   ```groovy
   Windows.startApplication('PackageFamilyName! Application ID')
   ```
5. **Run as Windows Test** – This will launch the UWP application.

---
### 🎯 Keep your test automation scalable, maintainable, and efficient! 🚀