package Solutions;

/**
 * AUTHOR:
 * CLASS NAME: IEstateAgent.java
 * 
 * IEstateAgent interface that mandates the implementation of
 * methods to calculate commission and validate data.
 */

public interface IEstateAgent 
{
    /**
     * Calculates the commission for a given property price and agent commission percentage.
     * 
     * @param propertyPrice The property price as a string.
     * @param agentCommission The commission percentage as a string.
     * @return The calculated commission as a double.
     */
    double CalculateCommission(String propertyPrice, String agentCommission);

    /**
     * Validates the provided Data object to ensure it contains valid inputs.
     * 
     * @param dataToValidate A Data object containing information to validate.
     * @return True if the data is valid, otherwise false.
     */
    boolean ValidateData(Data dataToValidate);
}
