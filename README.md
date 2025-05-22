# Binary-2-Decimal-Convertor

Binary is the number system all digital computers are based on. Therefore it's important for developers to understand binary, or base 2, mathematics. The purpose of Bin2Dec is to provide practice and understanding of how binary calculations.

Bin2Dec allows the user to enter strings of up to 8 binary digits, 0's and 1's, in any sequence and then displays its decimal equivalent.

This challenge requires that the developer implementing it follow these constraints:

Arrays may not be used to contain the binary digits entered by the user
Determining the decimal equivalent of a particular binary digit in the sequence must be calculated using a single mathematical function, for example the natural logarithm. It's up to you to figure out which function to use.


# User Stories
 User can enter a variable number of binary digits
 User must be notified if anything other than a 0 or 1 was entered
 User views the results in a single output field containing the decimal (base 10) equivalent of the binary number that was entered


# Design

![image](design.png)

# System Architecture
This a monolithic application that is built using the following technologies:
- Java 21
- JavaFX
- Maven
- JUnit 5
- Mockito
- Log4j
- JavaFX Scene Builder
- JavaFX CSS
- JavaFX FXML

# Contributing

## Issue Reporting

### Using the GitHub UI
1. Navigate to the [Issues](https://github.com/msjackiebrown/binary-2-decimal-convertor/issues) tab of the repository
2. Click on "New Issue"
3. Select either "Bug Report" or "Feature Request" template
4. Fill in the required information and submit the issue


## Bulk Issue Format

The [Bulk GitHub Issue Creator](#using-bulk-github-issue-creator-tool) tool supports both JSON and CSV formats for defining issues:

### JSON Format
```json
[
  {
    "title": "Issue Title",
    "body": "Issue description and details",
    "labels": "label1,label2",
    "assignees": "username1,username2"
  },
  {
    "title": "Another Issue",
    "body": "Description for another issue",
    "labels": "bug",
    "assignees": ""
  }
]
```

### CSV Format
```csv
title,body,labels,assignees
"Issue Title","Issue description and details","label1,label2","username1,username2"
"Another Issue","Description for another issue","bug",""
```

You can add as many issues as needed to these files. To use your custom file with the Bulk GitHub Issue Creator tool, see the section below.

### Using Bulk GitHub Issue Creator Tool

The recommended tool for bulk issue creation is our custom-built application:

**[Bulk GitHub Issue Creator](https://github.com/msjackiebrown/bulk-github-issue-creator)**

This standalone Java application provides the following benefits:
- Create multiple issues at once using JSON or CSV files
- Use from any machine with Java installed
- Work with any GitHub repository
- Detailed reporting of creation results
- Dry-run mode to preview before creating

To use this tool:
1. Clone the repository: `git clone https://github.com/msjackiebrown/bulk-github-issue-creator.git`
2. Build with Maven: `mvn clean package`
3. Run with your repository and issue file: 
   ```
   java -jar target/bulk-github-issue-creator-1.0.0-jar-with-dependencies.jar --repo msjackiebrown/binary-2-decimal-convertor --file issues.json
   ```

See the [Bulk GitHub Issue Creator README](https://github.com/msjackiebrown/bulk-github-issue-creator) for complete documentation.


