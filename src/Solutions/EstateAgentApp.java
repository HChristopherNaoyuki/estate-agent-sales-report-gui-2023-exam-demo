package Solutions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * AUTHOR:
 * CLASS NAME: EstateAgentApp.java
 */

public class EstateAgentApp extends JFrame
{
    // Declare the GUI components used in the application
    private final JComboBox<String> locationComboBox;
    private final JTextField agentNameTextField;
    private final JTextField propertyPriceTextField;
    private final JTextField commissionTextField;
    private final JTextArea reportTextArea;

    // Create an instance of EstateAgent
    private final EstateAgent estateAgent = new EstateAgent();

    public EstateAgentApp()
    {
        try
        {
            // Set the Look and Feel to match macOS style
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }

        // Initialize components
        locationComboBox = new JComboBox<>(new String[] { "Cape Town", "Durban", "Pretoria" });
        agentNameTextField = new JTextField();
        propertyPriceTextField = new JTextField();
        commissionTextField = new JTextField();
        reportTextArea = new JTextArea();

        // Set up the frame and layout
        setTitle("Estate Agent App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Customize the UI
        customizeComponents();

        // Add the menu bar
        setJMenuBar(createMenuBar());

        // Make the frame visible
        setVisible(true);
    }

    private void customizeComponents()
    {
        // Set fonts and other styling properties
        Font font = new Font("San Francisco", Font.PLAIN, 14);
        locationComboBox.setFont(font);
        agentNameTextField.setFont(font);
        propertyPriceTextField.setFont(font);
        commissionTextField.setFont(font);
        reportTextArea.setFont(font);

        // Set rounded borders
        locationComboBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
        agentNameTextField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
        propertyPriceTextField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
        commissionTextField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
        reportTextArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));

        // Add padding and margin to make it look cleaner
        locationComboBox.setMaximumSize(new Dimension(350, 30));
        agentNameTextField.setMaximumSize(new Dimension(350, 30));
        propertyPriceTextField.setMaximumSize(new Dimension(350, 30));
        commissionTextField.setMaximumSize(new Dimension(350, 30));
        reportTextArea.setMaximumSize(new Dimension(350, 150));

        // Add the components to the frame
        add(new JLabel("Agent Location:"));
        add(locationComboBox);
        add(new JLabel("Agent Name:"));
        add(agentNameTextField);
        add(new JLabel("Property Price:"));
        add(propertyPriceTextField);
        add(new JLabel("Commission Percentage:"));
        add(commissionTextField);
        add(new JLabel("Report:"));
        add(new JScrollPane(reportTextArea));

        // Apply a background color (light gray)
        getContentPane().setBackground(new Color(245, 245, 245));
    }

    // Create the menu bar with required items
    private JMenuBar createMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processMenuItem = new JMenuItem("Process Report");
        processMenuItem.addActionListener(this::processReport);
        JMenuItem clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.addActionListener(e -> clearFields());
        JMenuItem saveMenuItem = new JMenuItem("Save Report");
        saveMenuItem.addActionListener(this::saveReport);

        toolsMenu.add(processMenuItem);
        toolsMenu.add(clearMenuItem);
        toolsMenu.add(saveMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        return menuBar;
    }

    // Method to process the report based on user input
    private void processReport(ActionEvent e)
    {
        String location = (String) locationComboBox.getSelectedItem();
        String agentName = agentNameTextField.getText();
        String propertyPrice = propertyPriceTextField.getText();
        String commissionPercentage = commissionTextField.getText();

        // Use instance of EstateAgent to call generateReport
        String report = estateAgent.generateReport(location, agentName, propertyPrice, commissionPercentage);
        reportTextArea.setText(report);  // Display the generated report in the text area
    }

    // Method to clear all input fields
    private void clearFields()
    {
        locationComboBox.setSelectedIndex(0);
        agentNameTextField.setText("");
        propertyPriceTextField.setText("");
        commissionTextField.setText("");
        reportTextArea.setText("");
    }

    // Method to save the report to a text file
    private void saveReport(ActionEvent e)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt")))
        {
            writer.write(reportTextArea.getText());
            JOptionPane.showMessageDialog(this, "Report saved to report.txt");
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(EstateAgentApp::new);
    }
}
