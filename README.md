# Estate Agent Application

## Overview
The Estate Agent Application is a Java-based application designed for managing and reporting on real estate sales. It enables users to input property sales data, calculates commissions based on input values, and generates reports for estate agents.

## Features
- **User Interface**: A graphical user interface (GUI) built using Swing, allowing easy data entry.
- **Commission Calculation**: Calculates commissions based on property prices and commission percentages.
- **Data Validation**: Validates user input to ensure all fields are correctly filled out and numeric values are valid.
- **Report Generation**: Generates formatted reports displaying agent information, property prices, and commission earned.
- **File Saving**: Allows users to save generated reports to a text file.

## Components
- **Data Class**: Represents the input fields for an estate agent.
- **EstateAgent Class**: Implements commission calculation and data validation.
- **IEstateAgent Interface**: Defines methods for commission calculation and data validation.
- **EstateAgentApp Class**: Main application class that handles GUI interactions.
- **JUnit Tests**: Includes tests to ensure the functionality of commission calculation and data validation.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Running the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/HChristopherNaoyuki/estate-agent-sales-report-gui-2023-exam-demo.git
   ```
2. Open the project in your IDE.
3. Compile and run the `EstateAgentApp` class.

## Testing
- The application includes JUnit tests to validate the functionality of commission calculations and data validation.
- You can run tests directly from your IDE or use Maven/Gradle commands.

## Contributing
Contributions are welcome! If you have suggestions for improvements or additional features, please fork the repository and submit a pull request.

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a pull request
