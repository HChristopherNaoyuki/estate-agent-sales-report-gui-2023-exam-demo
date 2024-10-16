package Solutions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * AUTHOR:
 * CLASS NAME: EstateAgentTest.java
 */

public class EstateAgentTest
{
    private final IEstateAgent estateAgent = new EstateAgent(); // Using the interface type

    /**
     * This test case checks if the data is valid when all inputs are correct.
     */
    @Test
    public void validateData_AllValidInputs()
    {
        // Create a valid Data object
        Data validData = new Data("Cape Town", "John Doe", "500000.0", "5.0");
        
        // The validation should pass (return true)
        assertTrue(estateAgent.ValidateData(validData));
    }

    /**
     * This test case checks if the validation fails when the location is empty.
     */
    @Test
    public void validateData_InvalidLocation()
    {
        // Invalid Data object with an empty location
        Data invalidData = new Data("", "John Doe", "500000.0", "5.0");
        
        // The validation should fail (return false)
        assertFalse(estateAgent.ValidateData(invalidData));
    }

    /**
     * This test case checks if the validation fails when the agent's name is empty.
     */
    @Test
    public void validateData_InvalidName()
    {
        // Invalid Data object with an empty agent name
        Data invalidData = new Data("Cape Town", "", "500000.0", "5.0");
        
        // The validation should fail (return false)
        assertFalse(estateAgent.ValidateData(invalidData));
    }

    /**
     * This test case checks if the validation fails when the property price is invalid (negative value).
     */
    @Test
    public void validateData_InvalidPropertyPrice()
    {
        // Invalid Data object with a negative property price
        Data invalidData = new Data("Cape Town", "John Doe", "-500000.0", "5.0");
        
        // The validation should fail (return false)
        assertFalse(estateAgent.ValidateData(invalidData));
    }

    /**
     * This test case checks if the validation fails when the commission percentage is invalid (negative value).
     */
    @Test
    public void validateData_InvalidCommission()
    {
        // Invalid Data object with a negative commission percentage
        Data invalidData = new Data("Cape Town", "John Doe", "500000.0", "-5.0");
        
        // The validation should fail (return false)
        assertFalse(estateAgent.ValidateData(invalidData));
    }
}
