package Solutions;

import java.text.DecimalFormat;

/**
 * AUTHOR:
 * CLASS NAME: EstateAgent.java
 * 
 * EstateAgent class that implements the IEstateAgent interface.
 * It provides methods for calculating commission and validating input data.
 */

public class EstateAgent implements IEstateAgent
{
    private static final DecimalFormat df = new DecimalFormat("R#,###.00");

    /**
     * This method calculates the commission for a property based on the provided
     * property price and agent commission percentage. It converts the input strings to
     * double values before performing the calculation.
     *
     * @param propertyPrice The price of the property as a string.
     * @param agentCommission The commission percentage as a string.
     * @return The calculated commission as a double.
     */
    @Override
    public double CalculateCommission(String propertyPrice, String agentCommission)
    {
        try
        {
            // Convert the input strings to double values
            double price = Double.parseDouble(propertyPrice);
            double commission = Double.parseDouble(agentCommission);

            // Ensure both values are positive before calculating the commission
            if (price <= 0)
            {
                throw new IllegalArgumentException("Price must be greater than zero.");
            }
            else if (commission <= 0)
            {
                throw new IllegalArgumentException("Commission must be greater than zero.");
            }

            // Calculate the commission
            return calculateCommission(price, commission);
        }
        catch (NumberFormatException e)
        {
            throw new IllegalArgumentException("Invalid number format for property price or commission percentage.");
        }
    }

    /**
     * This method validates the provided Data object, ensuring that all fields
     * meet the required criteria.
     *
     * @param dataToValidate A Data object containing input fields for validation.
     * @return True if the data is valid, otherwise false.
     */
    @Override
    public boolean ValidateData(Data dataToValidate)
    {
        // Check if any of the fields in the Data object are empty or invalid
        if (dataToValidate.getLocation() == null || dataToValidate.getLocation().isEmpty() ||
            dataToValidate.getAgentName() == null || dataToValidate.getAgentName().isEmpty() ||
            dataToValidate.getPropertyPrice() == null || dataToValidate.getPropertyPrice().isEmpty() ||
            dataToValidate.getCommissionPercentage() == null || dataToValidate.getCommissionPercentage().isEmpty())
        {
            return false; // Data is invalid
        }

        try
        {
            // Attempt to parse the property price and commission percentage
            double price = Double.parseDouble(dataToValidate.getPropertyPrice());
            double commission = Double.parseDouble(dataToValidate.getCommissionPercentage());

            // Ensure the parsed values are positive
            return price > 0 && commission > 0;
        }
        catch (NumberFormatException e)
        {
            return false; // Data is invalid due to incorrect number formatting
        }
    }

    /**
     * Private method to calculate the commission based on the price and percentage.
     *
     * @param propertyPrice The price of the property.
     * @param commissionPercentage The percentage of commission.
     * @return The calculated commission.
     */
    private double calculateCommission(double propertyPrice, double commissionPercentage)
    {
        return propertyPrice * (commissionPercentage / 100);
    }

    /**
     * Generates a report string based on the provided location, agent name,
     * property price, and commission percentage.
     *
     * @param location The location of the estate agent.
     * @param agentName The name of the estate agent.
     * @param propertyPrice The price of the property as a string.
     * @param commissionPercentage The commission percentage as a string.
     * @return A formatted report string or an error message if validation fails.
     */
    public String generateReport(String location, String agentName, String propertyPrice, String commissionPercentage)
    {
        // Validate the input data
        Data data = new Data(location, agentName, propertyPrice, commissionPercentage);
        if (!ValidateData(data))
        {
            return "Error: Invalid data provided.";
        }

        // Calculate the commission after validation has passed
        double price = Double.parseDouble(propertyPrice);
        double commission = Double.parseDouble(commissionPercentage);
        double commissionAmount = calculateCommission(price, commission);

        // Format and return the report
        return String.format(
            "Agent Location: %s\nAgent Name: %s\nProperty Price: %s\nCommission Percentage: %.2f%%\nCommission Earned: %s",
            location, agentName, df.format(price), commission, df.format(commissionAmount)
        );
    }
}
