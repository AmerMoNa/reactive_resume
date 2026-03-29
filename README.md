🚀 Reactive Resume Automation Testing

This project is an automated testing suite for the Reactive Resume web application using Selenium WebDriver, TestNG, and Java. It covers end-to-end testing of core functionalities such as authentication, resume creation, editing, and more.


📌 Project Overview

The purpose of this project is to:

Automate user workflows in the Reactive Resume application
Validate core functionalities using UI testing
Ensure system reliability through repeatable test cases

🛠️ Technologies Used
Java
Selenium WebDriver
TestNG
Maven (optional if you are using it)
ChromeDriver / WebDriver

📂 Project Structure
ReactiveResume/
│
├── src/
│   ├── test/java/
│   │   └── ReactiveResume/
│   │       ├── resumeTest.java
│   │       └── testData.java
│
├── testng.xml
├── pom.xml (if Maven is used)
└── README.md


🧪 Test Scenarios Covered

✅ Authentication
Register a new account
Login
Logout

📄 Resume Management
Create a new resume
Edit resume name
Delete resume

🖼️ Resume Features
Upload profile image
Add personal information
Download resume as PDF

🌐 UI Features
Language switching (English → Arabic)

🔍 Test Case Details
Test Case           |           Description
Register Account                Creates a new user with valid data
Login	                        Signs in using registered credentials
Logout                         	Logs out from the system
Create Resume	                Creates a new resume
Edit Resume                 	Updates resume name and verifies change
Upload Image                	Adds profile image via URL
Resume Info	                    Inputs name and email
Download Resume             	Exports resume as PDF
Delete Resume               	Deletes existing resume
Language Switching	            Changes UI language and verifies

📊 Assertions Used
assertEquals() → For validating expected vs actual values
assertTrue() → For checking element visibility

⚠️ Notes
Ensure stable internet connection during test execution
Some tests depend on execution order (priority in TestNG)
Test data is managed in testData.java

💡 Future Improvements
Add Page Object Model (POM) design pattern
Integrate Allure Reports / Extent Reports
Add CI/CD pipeline (GitHub Actions / Jenkins)
Cross-browser testing (Firefox, Edge)

👨‍💻 Author

Amer Nawasrah
Softwar Quality Assurance Engineer

⭐ Contributing

Feel free to fork this project and improve it. Contributions are welcome!

📜 License

This project is for educational and testing purposes.
