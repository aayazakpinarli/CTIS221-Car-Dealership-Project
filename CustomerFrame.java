//package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import InheritanceClasses.Customer;
//import MainandSystem.DealerSys;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import java.awt.EventQueue;
import java.awt.Font;

public class CustomerFrame extends JFrame {

	protected static final CustomerFrame CustomerFrame = null;
	private JPanel address;
	MainFrame mf = null;
	BuyVehicleFrame bf = null;
	String id = null;
	
	private JTextField newInfo;
	private JTextField FillField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	JComboBox options = new JComboBox();
	private JLabel addressLabel;
	private JLabel phoneNumLabel;
	private JLabel oldPassLabel;
	private JLabel newPassLabel;
	private JLabel successfulMessageLabel;
	private JLabel passwordWrongLabel;
	private JLabel chooseLabel;
	private JButton lastChangeButton;
	private JScrollPane scrollPane;
	
	
	

	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame("101");
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
	public CustomerFrame(MainFrame frame, String id) {
		mf = frame;		
		this.id = id;
		bf = new BuyVehicleFrame(this, id);
		
		//welcomeLabel
		Customer c = DealerSys.searchCustomer(Integer.parseInt(id));
		String x = c.getNameSurname();

		setTitle("CustomerFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 406);
		address = new JPanel();
		address.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(address);
		address.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(301, 71, 377, 288);
		address.add(scrollPane);
		
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		JButton logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				dispose();
			}
		});
		logoutButton.setBounds(593, 30, 85, 21);
		address.add(logoutButton);
		
		JButton displayButton = new JButton("Display Purchase");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(DealerSys.displayCustomersCar(Integer.parseInt(id)));
				
			}
		});
		displayButton.setBounds(10, 68, 127, 33);
		address.add(displayButton);
		
		JButton ClearButton = new JButton("Clear");
		ClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		ClearButton.setBounds(10, 131, 127, 33);
		address.add(ClearButton);

		
		chooseLabel = new JLabel("Please choose");
		chooseLabel.setVisible(false);
		chooseLabel.setBounds(147, 99, 127, 13);
		address.add(chooseLabel);
		

		
		addressLabel = new JLabel("Enter your new address");
		addressLabel.setVisible(false);
		addressLabel.setBounds(147, 151, 173, 13);
		address.add(addressLabel);
		
		phoneNumLabel = new JLabel("Enter your new phone number");
		phoneNumLabel.setVisible(false);
		phoneNumLabel.setBounds(147, 151, 173, 13);
		address.add(phoneNumLabel);
		
		FillField = new JTextField();
		FillField.setVisible(false);
		FillField.setBounds(147, 174, 127, 19);
		address.add(FillField);
		FillField.setColumns(10);
		
		oldPassLabel = new JLabel("Enter your old password");
		oldPassLabel.setVisible(false);
		oldPassLabel.setBounds(147, 151, 127, 13);
		address.add(oldPassLabel);
		
		passwordField = new JPasswordField();
		passwordField.setVisible(false);
		passwordField.setBounds(147, 174, 127, 19);
		address.add(passwordField);
		
		newPassLabel = new JLabel("Enter your new password");
		newPassLabel.setVisible(false);
		newPassLabel.setBounds(147, 203, 127, 13);
		address.add(newPassLabel);
		
		successfulMessageLabel = new JLabel("Successfully changed!");
		successfulMessageLabel.setVisible(false);
		successfulMessageLabel.setBounds(147, 88, 127, 58);
		address.add(successfulMessageLabel);
		
		passwordWrongLabel = new JLabel("Wrong old Password !!!");
		passwordWrongLabel.setVisible(false);
		passwordWrongLabel.setBounds(147, 286, 127, 55);
		address.add(passwordWrongLabel);
		
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setVisible(false);
		passwordField_1.setBounds(147, 226, 127, 19);
		address.add(passwordField_1);
		
		lastChangeButton = new JButton("Save");
		lastChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(options.getSelectedItem().equals("Address")) {
					DealerSys.changeAddress(c, FillField.getText());
					successfulMessageLabel.setVisible(true);
					
				} else if(options.getSelectedItem().equals("Password")) {
					if(DealerSys.changePassword(c, oldPassLabel.getText(),newPassLabel.getText())) 
						successfulMessageLabel.setVisible(true);
					else
						passwordWrongLabel.setVisible(true);
					
				} else if(options.getSelectedItem().equals("Phone Number")) {
					DealerSys.changePhoneNumber(c, FillField.getText());
					successfulMessageLabel.setVisible(true);
					addressLabel.setVisible(false);
					oldPassLabel.setVisible(false);
				}
					slp(passwordWrongLabel, successfulMessageLabel);
				// clear all change elements
				clearChangeOptions();
			}
		});
		lastChangeButton.setVisible(false);
		lastChangeButton.setBounds(147, 255, 127, 21);
		address.add(lastChangeButton);
		

		options.setVisible(false);
		options.setModel(new DefaultComboBoxModel(new String[] {"", "Address", "Phone Number", "Password"}));
		options.setBounds(147, 120, 127, 21);
		address.add(options);
		options.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

				clearChangeOptions();
				options.setVisible(true);
				lastChangeButton.setVisible(true);

				passwordWrongLabel.setVisible(false);
				successfulMessageLabel.setVisible(false);
				if(options.getSelectedItem().equals("Address")) {
					addressLabel.setVisible(true);
					FillField.setVisible(true);
				} else if(options.getSelectedItem().equals("Phone Number")) {
					phoneNumLabel.setVisible(true);
					FillField.setVisible(true);
				} else if(options.getSelectedItem().equals("Password")) {
					oldPassLabel.setVisible(true);
					passwordField.setVisible(true);		
					newPassLabel.setVisible(true);
					passwordField_1.setVisible(true);
				}

				lastChangeButton.setVisible(true);
				
			}
			
		});
		

		
		JButton changeButton = new JButton("Change Info");
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseLabel.setVisible(true);
				options.setVisible(true);
			}
		});
		changeButton.setBounds(147, 68, 127, 21);
		address.add(changeButton);
		
		JButton displayCarButton = new JButton("Display Cars on Sale");
		displayCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(DealerSys.displayVehicleonSale());
				
			}
		});
		displayCarButton.setBounds(10, 193, 127, 33);
		address.add(displayCarButton);
		
		JButton buyCarButton = new JButton("Buy New Car");
		buyCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// not use fill combo box method to send the id of customer
				bf.getComboBox().setModel(new DefaultComboBoxModel(DealerSys.getVehicleIdonSale()));
				bf.setVisible(true);
				dispose();
			}
		});
		buyCarButton.setBounds(10, 262, 127, 33);
		address.add(buyCarButton);
		

		JLabel welcomeLabel = new JLabel(x.toString());
		welcomeLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		welcomeLabel.setBounds(10, 10, 247, 33);
		address.add(welcomeLabel);
		
		JButton walletButton = new JButton("Add Money to Wallet");
		walletButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		walletButton.setBounds(10, 326, 127, 33);
		address.add(walletButton);
		

	}
	
	public void clearChangeOptions() {
		// set visible false for the fields and labels
		addressLabel.setVisible(false);
		FillField.setVisible(false);
		phoneNumLabel.setVisible(false);
		oldPassLabel.setVisible(false);
		passwordField.setVisible(false);		
		newPassLabel.setVisible(false);
		passwordField_1.setVisible(false);
		lastChangeButton.setVisible(false);
		chooseLabel.setVisible(false);
		options.setVisible(false);
		
		//clear the fields
		FillField.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
	}
	
	
	public void slp(JLabel label, JLabel label2) {
	    new Thread(new Runnable() {
	        public void run() {
	            try {
	                Thread.sleep(2000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            SwingUtilities.invokeLater(new Runnable() {
	                public void run() {
	                    label.setVisible(false);
	                    label2.setVisible(false);
	                }
	            });
	        }
	    }).start();
	}
}
