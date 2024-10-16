package Solutions;

import org.junit.Test;

/**
 * AUTHOR:
 * CLASS NAME: TestCalculateCommission_CalculatedUnsuccessfully.java
 * 
 * This class tests the unsuccessful calculation of commission when invalid inputs are provided.
 * We check for a scenario where the commission calculation should fail due to invalid input.
 */

public class TestCalculateCommission_CalculatedUnsuccessfully
{
    private final IEstateAgent estateAgent = new EstateAgent(); // Using the interface type

    /**
     * This test case simulates a failed commission calculation by providing an invalid price.
     * It checks that the method throws an IllegalArgumentException for invalid inputs.
     */
    @Test(expected = IllegalArgumentException.class)
    public void calculateCommission_CalculatedUnsuccessfully()
    {
        // Providing invalid property price (non-numeric) which should cause an exception
        estateAgent.CalculateCommission("invalidPrice", "5.0");

        // The test will pass if an IllegalArgumentException is thrown
    }
}
