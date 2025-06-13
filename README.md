<<<<<<< HEAD
# SeleniumFrameWork-

Structured environment designed to create and execute automated test scripts using the Selenium WebDriver. The framework is built with reusable components, best practices, and tools that help standardize and streamline the testing process for web applications, and down below the structure of the application.

<img src="file:///C:/Users/FarahMango/Downloads/Diagram.drawio%20(1).png" alt="">


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Core Components</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        ul {
            margin-left: 20px;
        }
        li {
            margin-bottom: 10px;
        }
        .nested {
            margin-left: 20px;
        }
    </style>
</head>
<body>
    <h1>Core Components</h1>
    <ol>
        <li>
            <strong>WebDriver:</strong>
            <ul>
                <li>Core tool to interact with web browsers (e.g., Chrome, Firefox, Edge).</li>
                <li>Automates browser actions like clicking, typing, and navigation.</li>
            </ul>
        </li>
        <li>
            <strong>Design Patterns:</strong>
            <ul>
                <li>
                    <strong>Page Object Model (POM):</strong>
                    <ul class="nested">
                        <li>Represents each webpage as a class.</li>
                        <li>Encapsulates UI elements and associated methods.</li>
                    </ul>
                </li>
            </ul>
        </li>
        <li>
            <strong>Test Data Management:</strong>
            <ul>
                <li>Externalize data for data-driven testing.</li>
                <li>Sources include Excel files, JSON, XML.</li>
            </ul>
        </li>
        <li>
            <strong>Test Runner:</strong>
            <ul>
                <li>Tools like TestNG to execute test cases, define test suites, and generate reports.</li>
            </ul>
        </li>
        <li>
            <strong>Build Tool:</strong>
            <ul>
                <li>Maven/Gradle: Manages dependencies like Selenium WebDriver, TestNG, and others.</li>
            </ul>
        </li>
        <li>
            <strong>Reporting:</strong>
            <ul>
                <li>Library's like ExtentReports or Allure provide rich, visual test execution reports.</li>
                <li>Capture screenshots for failed test cases for debugging.</li>
            </ul>
        </li>
        <li>
            <strong>Logging:</strong>
            <ul>
                <li>Libraries like Log4j or SLF4J help track test execution and debug failures.</li>
            </ul>
        </li>
        <li>
            <strong>Configuration Management:</strong>
            <ul>
                <li>Use <code>config.properties</code> or similar files to manage environment-specific settings like URLs, browser types, and credentials.</li>
            </ul>
        </li>
    </ol>
</body>
</html>
=======
# SeleniumFramework-

Structured environment designed to create and execute automated test scripts using the Selenium WebDriver. The framework is built with reusable components, best practices, and tools that help standardize and streamline the testing process for web applications.


<b>Core Components </b>
1.	WebDriver:
o	Core tool to interact with web browsers (e.g., Chrome, Firefox, Edge).
o	Automates browser actions like clicking, typing, and navigation.
2.	Design Patterns:
o	Page Object Model (POM):
	Represents each webpage as a class.
	Encapsulates UI elements and associated methods.
o	Factory Design Pattern (optional):
	Dynamically initializes elements using tools like Selenium’s PageFactory.
3.	Test Data Management:
o	Externalize data for data-driven testing.
o	Sources include Excel files, JSON, XML, or database connections.
4.	Test Runner:
o	Tools like TestNG or JUnit execute test cases, define test suites, and generate reports.
5.	Build Tool:
o	Maven/Gradle: Manages dependencies like Selenium WebDriver, TestNG, and others.
6.	Reporting:
o	Frameworks like ExtentReports or Allure provide rich, visual test execution reports.
o	Capture screenshots for failed test cases for debugging.
7.	Logging:
o	Libraries like Log4j or SLF4J help track test execution and debug failures.
8.	Configuration Management:
o	Use config.properties or similar files to manage environment-specific settings like URLs, browser types, and credentials.




>>>>>>> 8943e959b594dd672c5009df179df72a5947be08
