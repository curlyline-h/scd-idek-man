package DoneInClass;

import java.awt.*;
import java.awt.event.*;

    public class AddPersonalInfo extends Frame {

        // Form Component Declarations
        private Frame parentFrame;
        private TextField txtFullName;
        private CheckboxGroup genderGroup;
        private Checkbox chkMale, chkFemale, chkOther;
        private Choice choiceCity;
        private Checkbox chkReading, chkTravelling, chkGaming;
        private TextArea txtAddress;
        private Button btnSubmit, btnClear, btnClose;

        public AddPersonalInfo(Frame pF ,String username) {
            // Main Frame Configuration
            this.parentFrame = pF;
            setTitle("User Details - Personal Information");
            setSize(550, 600);
            setLayout(new BorderLayout(10, 10));
            setBackground(new Color(245, 245, 245));

            // =================================================================
            // 1. NORTH PANEL: Welcome / Header Section
            // =================================================================
            Panel headerPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 15));
            headerPanel.setBackground(new Color(51, 102, 153)); // Dark Blue

            String displayName = (username != null && !username.trim().isEmpty()) ? username : "User";
            Label welcomeLabel = new Label("Welcome, " + displayName + "! Please enter your personal details.");
            welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
            welcomeLabel.setForeground(Color.WHITE);

            headerPanel.add(welcomeLabel);
            add(headerPanel, BorderLayout.NORTH);

            // =================================================================
            // 2. CENTER PANEL: Form Inputs (GridBagLayout for neat alignment)
            // =================================================================
            Panel formPanel = new Panel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(8, 10, 8, 10);
            gbc.anchor = GridBagConstraints.WEST;

            Font labelFont = new Font("SansSerif", Font.PLAIN, 13);
            int row = 0;

            // --- Full Name (TextField) ---
            gbc.gridx = 0; gbc.gridy = row;
            Label lblName = new Label("Full Name:");
            lblName.setFont(labelFont);
            formPanel.add(lblName, gbc);

            gbc.gridx = 1;
            txtFullName = new TextField(25);
            formPanel.add(txtFullName, gbc);

            // --- Gender (CheckboxGroup / Radio Buttons) ---
            row++;
            gbc.gridx = 0; gbc.gridy = row;
            Label lblGender = new Label("Gender:");
            lblGender.setFont(labelFont);
            formPanel.add(lblGender, gbc);

            gbc.gridx = 1;
            Panel genderPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 5, 0));
            genderGroup = new CheckboxGroup();
            chkMale = new Checkbox("Male", genderGroup, true);
            chkFemale = new Checkbox("Female", genderGroup, false);
            chkOther = new Checkbox("Other", genderGroup, false);
            genderPanel.add(chkMale);
            genderPanel.add(chkFemale);
            genderPanel.add(chkOther);
            formPanel.add(genderPanel, gbc);

            // --- City (Choice Dropdown) ---
            row++;
            gbc.gridx = 0; gbc.gridy = row;
            Label lblCity = new Label("City:");
            lblCity.setFont(labelFont);
            formPanel.add(lblCity, gbc);

            gbc.gridx = 1;
            choiceCity = new Choice();
            choiceCity.add("-- Select City --");
            choiceCity.add("New York");
            choiceCity.add("London");
            choiceCity.add("Tokyo");
            choiceCity.add("Lahore");
            choiceCity.add("Sydney");
            formPanel.add(choiceCity, gbc);

            // --- Hobbies (Multiple Checkboxes) ---
            row++;
            gbc.gridx = 0; gbc.gridy = row;
            Label lblHobbies = new Label("Hobbies:");
            lblHobbies.setFont(labelFont);
            formPanel.add(lblHobbies, gbc);

            gbc.gridx = 1;
            Panel hobbyPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 5, 0));
            chkReading = new Checkbox("Reading");
            chkTravelling = new Checkbox("Travelling");
            chkGaming = new Checkbox("Gaming");
            hobbyPanel.add(chkReading);
            hobbyPanel.add(chkTravelling);
            hobbyPanel.add(chkGaming);
            formPanel.add(hobbyPanel, gbc);

            // --- Address (TextArea) ---
            row++;
            gbc.gridx = 0; gbc.gridy = row;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            Label lblAddress = new Label("Address:");
            lblAddress.setFont(labelFont);
            formPanel.add(lblAddress, gbc);

            gbc.gridx = 1;
            txtAddress = new TextArea(4, 25);
            formPanel.add(txtAddress, gbc);

            add(formPanel, BorderLayout.CENTER);

            // =================================================================
            // 3. SOUTH PANEL: Action Buttons
            // =================================================================
            Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 10));
            buttonPanel.setBackground(new Color(230, 230, 230));

            btnSubmit = new Button("Submit");
            btnClear = new Button("Clear");
            btnClose = new Button("Close");

            buttonPanel.add(btnSubmit);
            buttonPanel.add(btnClear);
            buttonPanel.add(btnClose);

            add(buttonPanel, BorderLayout.SOUTH);

            // =================================================================
            // EVENT HANDLERS
            // =================================================================

            // Submit Button Action
            btnSubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("=== Submitted Personal Details ===");
                    System.out.println("User: " + displayName);
                    System.out.println("Full Name: " + txtFullName.getText());
                    System.out.println("Gender: " + genderGroup.getSelectedCheckbox().getLabel());
                    System.out.println("City: " + choiceCity.getSelectedItem());
                    System.out.println("Hobbies: "
                            + (chkReading.getState() ? "Reading " : "")
                            + (chkTravelling.getState() ? "Travelling " : "")
                            + (chkGaming.getState() ? "Gaming" : ""));
                    System.out.println("Address:\n" + txtAddress.getText());
                }
            });

            // Clear Button Action
            btnClear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtFullName.setText("");
                    txtAddress.setText("");
                    choiceCity.select(0);
                    chkMale.setState(true);
                    chkReading.setState(false);
                    chkTravelling.setState(false);
                    chkGaming.setState(false);
                }
            });

            // Close Button Action
            btnClose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    parentFrame.setVisible(true);
                    dispose(); // Close current window
                }
            });

            // Window Close Event (x button)
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    parentFrame.setVisible(true);
                    dispose();
                }
            });

            setLocationRelativeTo(null); // Center frame on screen
        }

        // Standalone main method for testing independently

    }



