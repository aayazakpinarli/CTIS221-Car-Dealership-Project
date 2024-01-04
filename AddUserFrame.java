//package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import MainandSystem.DealerSys;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextArea;
import java.awt.Font;

public class AddUserFrame extends JFrame {

	private JPanel contentPane;
	MainFrame mf = null;
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField addressField;
	private JTextField passField;
	private JTextField verifyPassField;
	private JRadioButton customerRadioButton;
	private JLabel moneyLabel;
	private JTextField moneyField;
	private JLabel walletVerifyLabel;
	private JLabel walletVerifyLabel2;
	private JButton signUpButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel fillLabel;
	private JButton closeButton;
	private JLabel passMatchLabel;
	private JLabel successLabel;
	private JLabel radioButtonLabel;
	private TextArea textArea;
	private int userId;
	private JLabel mailLabel;
	private JTextField mailField;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUserFrame frame = new AddUserFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public AddUserFrame(MainFrame frame) {
		mf = frame;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new TextArea();
		textArea.setFont(new Font("Arial Black", Font.BOLD, 15));
		textArea.setVisible(false);
		textArea.setBounds(10, 59, 423, 286);
		contentPane.add(textArea);
		
		JLabel nameLabel = new JLabel("Enter your name and surname : ");
		nameLabel.setBounds(26, 95, 221, 13);
		contentPane.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(257, 89, 165, 19);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel phoneLabel = new JLabel("Enter your phone number : ");
		phoneLabel.setBounds(26, 125, 201, 13);
		contentPane.add(phoneLabel);
		
		phoneField = new JTextField();
		phoneField.setBounds(257, 119, 165, 19);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
		
		JLabel addressLabel = new JLabel("Enter your address (city) : ");
		addressLabel.setBounds(26, 158, 201, 13);
		contentPane.add(addressLabel);
		
		JLabel passLabel = new JLabel("Enter your password : ");
		passLabel.setBounds(26, 192, 201, 13);
		contentPane.add(passLabel);
		
		addressField = new JTextField();
		addressField.setBounds(257, 152, 165, 19);
		contentPane.add(addressField);
		addressField.setColumns(10);
		
		passField = new JTextField();
		passField.setBounds(257, 186, 165, 19);
		contentPane.add(passField);
		passField.setColumns(10);
		
		JLabel passCheckLabel = new JLabel("Verify password : ");
		passCheckLabel.setBounds(26, 225, 201, 13);
		contentPane.add(passCheckLabel);
		
		verifyPassField = new JTextField();
		verifyPassField.setBounds(257, 219, 165, 19);
		contentPane.add(verifyPassField);
		verifyPassField.setColumns(10);
		
		customerRadioButton = new JRadioButton("Customer");
		customerRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				customerSelected();
			}
		});
		buttonGroup.add(customerRadioButton);
		customerRadioButton.setBounds(46, 32, 103, 21);
		contentPane.add(customerRadioButton);
		
		JRadioButton dealerRadioButton = new JRadioButton("Dealer");
		dealerRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearCustomerSelected();
				radioButtonLabel.setVisible(false);
			}
		});
		buttonGroup.add(dealerRadioButton);
		dealerRadioButton.setBounds(203, 32, 103, 21);
		contentPane.add(dealerRadioButton);
		
		
		radioButtonLabel = new JLabel("Please select one of the radio buttons.");
		if(!customerRadioButton.isSelected() || !dealerRadioButton.isSelected()) {
			radioButtonLabel.setVisible(true);
		}
		radioButtonLabel.setBounds(26, 63, 396, 13);
		contentPane.add(radioButtonLabel);
		
		moneyLabel = new JLabel("Wallet Money : ");
		moneyLabel.setVisible(false);
		moneyLabel.setBounds(26, 278, 221, 13);
		contentPane.add(moneyLabel);
		
		moneyField = new JTextField();
		moneyField.setVisible(false);
		moneyField.setBounds(257, 272, 165, 19);
		contentPane.add(moneyField);
		moneyField.setColumns(10);
		
		walletVerifyLabel = new JLabel("If you want to add money to your online wallet, you will enter your");
		walletVerifyLabel.setVisible(false);
		walletVerifyLabel.setBounds(26, 301, 396, 13);
		contentPane.add(walletVerifyLabel);
		
		walletVerifyLabel2 = new JLabel("credit/debit card information on the page that opens after registration.");
		walletVerifyLabel2.setVisible(false);
		walletVerifyLabel2.setBackground(new Color(240, 240, 240));
		walletVerifyLabel2.setBounds(26, 314, 396, 13);
		contentPane.add(walletVerifyLabel2);
		
		fillLabel = new JLabel("Please Fill All the Labels !!!");
		fillLabel.setVisible(false);
		fillLabel.setBounds(26, 332, 342, 13);
		contentPane.add(fillLabel);
		
		passMatchLabel = new JLabel("Passwords are NOT matched !!!");
		passMatchLabel.setVisible(false);
		passMatchLabel.setBounds(26, 332, 396, 13);
		contentPane.add(passMatchLabel);
		
		successLabel = new JLabel("You have successfully registered to the system.");
		successLabel.setVisible(false);
		successLabel.setBounds(26, 63, 396, 13);
		contentPane.add(successLabel);

		
		mailLabel = new JLabel("Enter your mail account : ");
		mailLabel.setBounds(26, 255, 201, 13);
		contentPane.add(mailLabel);
		
		mailField = new JTextField();
		mailField.setBounds(257, 248, 165, 19);
		contentPane.add(mailField);
		mailField.setColumns(10);
		
		
		
		signUpButton = new JButton("SIGN UP");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nameField.getText().equals("") || phoneField.getText().equals("") || addressField.getText().equals("") 
						|| passField.getText().equals("") || verifyPassField.getText().equals("") || mailField.getText().equals("")) {
					passMatchLabel.setVisible(false);
					fillLabel.setVisible(true);			
				} else {
					fillLabel.setVisible(false);
					if(!passField.getText().equals(verifyPassField.getText())) {
						passMatchLabel.setVisible(true);
					} else {
						passMatchLabel.setVisible(false);
						if(customerRadioButton.isSelected()) {
							userId = DealerSys.addCustomer(nameField.getText(), phoneField.getText(),addressField.getText(), passField.getText(),moneyField.getText(), mailField.getText() );
						} else if(dealerRadioButton.isSelected()) {
							clearCustomerSelected();
							userId = DealerSys.addDealer(nameField.getText(), phoneField.getText(),addressField.getText(), passField.getText(),  mailField.getText() );
						} else {
							radioButtonLabel.setVisible(true);
						}
						successLabel.setVisible(true);
						slp(); 
					}
				}
			}
		});
		signUpButton.setBounds(257, 359, 165, 21);
		contentPane.add(signUpButton);
		
		closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				dispose();
			}
		});
		closeButton.setBounds(337, 32, 85, 21);
		contentPane.add(closeButton);




	}

	public void clearCustomerSelected() {
		walletVerifyLabel.setVisible(false);
		walletVerifyLabel2.setVisible(false);
		moneyField.setVisible(false);
		moneyLabel.setVisible(false);
	}
	
	public void customerSelected() {
		walletVerifyLabel.setVisible(true);
		walletVerifyLabel2.setVisible(true);
		moneyField.setVisible(true);
		moneyLabel.setVisible(true);
	}
	
	public void slp() {
	    new Thread(new Runnable() {
	        public void run() {
	        	textArea.setVisible(true);
	        	String x = "\n\n\n\tPlease Note That\n\n"
	        			+ " \tYour Id Number = " + userId;
	        	textArea.setText(x);
	            try {
	                Thread.sleep(3000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            SwingUtilities.invokeLater(new Runnable() {
	                public void run() {
	                	mf.setVisible(true);
	                	dispose();
	                }
	            });
	        }
	    }).start();
	}
}
