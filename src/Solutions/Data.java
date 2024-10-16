package Solutions;

/**
 * AUTHOR:
 * CLASS NAME: Data.java
 * 
 * Data class representing the input fields for an estate agent.
 */

public class Data 
{
    private final String location;
    private final String agentName;
    private final String propertyPrice;
    private final String commissionPercentage;

    // Constructor to initialize all fields
    public Data(String location, String agentName, String propertyPrice, String commissionPercentage)
    {
        this.location = location;
        this.agentName = agentName;
        this.propertyPrice = propertyPrice;
        this.commissionPercentage = commissionPercentage;
    }

    // Getters for all fields
    public String getLocation() { return location; }
    public String getAgentName() { return agentName; }
    public String getPropertyPrice() { return propertyPrice; }
    public String getCommissionPercentage() { return commissionPercentage; }
}
