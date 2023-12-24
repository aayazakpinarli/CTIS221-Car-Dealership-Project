//package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;

//import InheritanceClasses.Customer;
//import MainandSystem.DealerSys;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

	private JPanel MainFrame;

	private JTextField idField;
	
	public void CreateDealerFrame() {
		if(!idField.getText().equals(null)) {
			DealerFrame df = new DealerFrame(this, idField.getText());
			df.setVisible(true);
		}
	}
	
	public void CreateCustomerFrame() {
		if(!idField.getText().equals(null)) {
			CustomerFrame cf = new CustomerFrame(this, idField.getText());
			cf.setVisible(true);
		}
	}
	AddUserFrame af = new AddUserFrame(this);
	private JPasswordField passwordField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		
		setTitle("MainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 281);
		MainFrame = new JPanel();
		MainFrame.setBackground(new Color(242, 253, 245));
		MainFrame.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(MainFrame);
		MainFrame.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEALERSHIP SYSTEM");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		lblNewLabel.setBounds(102, 10, 247, 37);
		MainFrame.add(lblNewLabel);
		
		
		idField = new JTextField();
		idField.setBounds(182, 57, 167, 19);
		MainFrame.add(idField);
		idField.setColumns(10);
		

		JLabel idLabel = new JLabel("Enter your id");
		idLabel.setBounds(52, 60, 91, 13);
		MainFrame.add(idLabel);
		
		JLabel passwordLabel = new JLabel("Enter your password");
		passwordLabel.setBounds(52, 89, 120, 13);
		MainFrame.add(passwordLabel);
		
		JLabel fillMessageLabel = new JLabel("Please fill the id and password area!!");
		fillMessageLabel.setVisible(false);
		fillMessageLabel.setBounds(52, 112, 297, 13);
		MainFrame.add(fillMessageLabel);
		
		JLabel wrongLabel = new JLabel("Wrong id or password!!");
		wrongLabel.setVisible(false);
		wrongLabel.setBounds(52, 112, 297, 13);
		MainFrame.add(wrongLabel);

		
		
		JButton loginButton = new JButton("Login");
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.setBackground(new Color(51, 221, 200));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(idField.getText().equals("") || passwordField.getText().equals("")) {
					fillMessageLabel.setVisible(true);
					wrongLabel.setVisible(false);
				}
				else {
					
					String out = DealerSys.searchId(Integer.parseInt(idField.getText()));
					if(out == null) //id is wrong
					{
						wrongLabel.setVisible(true);
						fillMessageLabel.setVisible(false);
				
					} else if(out.equalsIgnoreCase("dealer") && passwordField.getText().equals(DealerSys.searchDealer(idField.getText()).getPassword())) {
						CreateDealerFrame();
						setVisible(false);
					} else if(out.equals("customer") && passwordField.getText().equals(DealerSys.searchCustomer(Integer.parseInt(idField.getText())).getPassword())) {
						CreateCustomerFrame();
						setVisible(false);
					} else { // password is wrong
						wrongLabel.setVisible(true);
						fillMessageLabel.setVisible(false);
					}
				}
			}
		});
		loginButton.setBounds(52, 137, 297, 21);
		MainFrame.add(loginButton);
		
		JButton CreateNewUserButton = new JButton("Create New User");
		CreateNewUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				af.setVisible(true);
				setVisible(false);
			}
		});
		CreateNewUserButton.setBackground(new Color(51, 221, 200));
		CreateNewUserButton.setBounds(52, 201, 297, 21);
		MainFrame.add(CreateNewUserButton);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginButton.doClick();
				}
			}
		});
		passwordField.setBounds(182, 86, 167, 19);
		MainFrame.add(passwordField);
		
		JLabel forgotLabel = new JLabel("Did you forgot your password?");
		forgotLabel.setBounds(52, 172, 185, 13);
		MainFrame.add(forgotLabel);
		
		JButton ForgotButton = new JButton("Click Here");
		ForgotButton.setBackground(new Color(51, 221, 200));
		ForgotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		ForgotButton.setBounds(247, 168, 102, 21);
		MainFrame.add(ForgotButton);
		

	
		


	}
}
