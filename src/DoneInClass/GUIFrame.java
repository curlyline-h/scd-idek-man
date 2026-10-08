package DoneInClass;

import java.awt.*;
import java.awt.event.*;

public class GUIFrame extends Frame implements  ActionListener {



    private Label lbWelcome;
    private Label lbUsername;
    private Label lbPass;
    private TextField   txtUsername;
    private TextField txtPass;
    private Button btnSubmit;
    private Label lbWrong;



    public GUIFrame() {

        setTitle("Login Module");
        setSize(1200,500);
        setLocationRelativeTo(null);
        //setResizable(false);
        setLayout(new FlowLayout());

        // create components

        lbWelcome = new Label("Welocme to Login Module, Please enter credentials");
        lbUsername = new Label("Username");
        txtUsername = new TextField(20);
        lbPass = new Label("Password");
        txtPass = new TextField(20);
        txtPass.setEchoChar('*');
        btnSubmit = new Button("Submit");
        lbWrong = new Label("");
        //lbWrong.setVisible(false);
        // adding all components in frame
        add(lbWelcome);
        add(lbUsername);
        add(txtUsername);
        add(lbPass);
        add(txtPass);
        add(btnSubmit);
        add(lbWrong);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btnSubmit.addActionListener(this);

        // set frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(txtUsername.getText().isEmpty() || txtPass.getText().isEmpty()) {
            lbWrong.setText("Empty fields are not allowed");

        }
        else
        {

            AddPersonalInfo form = new AddPersonalInfo(this,txtUsername.getText());
            form.setVisible(true);
            this.setVisible(false);
            lbWrong.setText("Welcome "+txtUsername.getText()+"");
        }

    }

}
