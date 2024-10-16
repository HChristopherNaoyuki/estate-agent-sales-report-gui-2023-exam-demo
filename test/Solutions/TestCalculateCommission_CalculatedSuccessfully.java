package Solutions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * AUTHOR:
 * CLASS NAME: TestCalculateCommission_CalculatedSuccessfully.java
 * 
 * This class tests the successful calculation of commission using the EstateAgent class.
 * The commission should be correctly calculated based on valid inputs.
 */

public class TestCalculateCommission_CalculatedSuccessfully
{
    private final IEstateAgent estateAgent = new EstateAgent(); // Using the interface type

    /**
     * This test case verifies that the commission is calculated correctly for valid inputs.
     * We test with a property price of 100,000.0 and a commission rate of 5.0%.
     */
    @Test
    public void calculateCommission_CalculatedSuccessfully()
    {
        // Valid property price and commission percentage as Strings
        double commission = estateAgent.CalculateCommission("100000.0", "5.0");

        // Assert that the commission is correctly calculated as 5000.0 (5% of 100,000)
        assertEquals(5000.0, commission, 0.01); // Tolerance of 0.01 for double comparison
    }
}
