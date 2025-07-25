
# SeleniumFramework
Structured environment designed to create and execute automated test scripts using the Selenium WebDriver. The framework is built with reusable components, best practices, and tools that help standardize and streamline the testing process for web applications, and below the application's structure.
<br>
<br>

![img_1.png](img_1.png)

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
      <li>
            <strong>CI/CD Integration:</strong>
            <ul>
                <li>Seamlessly integrate with Jenkins.</li>
            </ul>
        </li>
    </ol>
</body>
</html>


