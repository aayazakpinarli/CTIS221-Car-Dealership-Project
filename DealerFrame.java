//package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import InheritanceClasses.Dealer;
//import MainandSystem.DealerSys;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import java.awt.Font;

public class DealerFrame extends JFrame {

	private JPanel contentPane;
	MainFrame mf = null;
	AddNewVehicleFrame avf = null;
	int id;
	private JPasswordField newpasswordField;
	private JPasswordField oldpasswordField;
	private JLabel OldPassLabel;
	private JLabel newPassLabel;
	private JLabel SuccessfulLabel;
	private JLabel oldPassWrongLabel;
	private JLabel fillLabel;
	private JButton lastChangeButton ;
	private JButton clearButton;
	private JScrollPane scrollPane;
	
	
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DealerFrame frame = new DealerFrame();
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
	public DealerFrame(MainFrame frame, String id) {
		mf = frame;
		this.id = Integer.parseInt(id);
		avf = new AddNewVehicleFrame(this, id);
		
		//welcomeLabel
		Dealer d = DealerSys.searchDealer(id);
		String x = d.getNameSurname();
		
		setTitle("DealerFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 41, 302, 369);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton logOutButton = new JButton("LOG OUT");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				dispose();
			}
		});
		logOutButton.setBounds(481, 10, 85, 21);
		contentPane.add(logOutButton);
		
		JButton revenueButton = new JButton("Display Revenue");
		revenueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(DealerSys.displayDealersRevenue(d));
			}
		});
		revenueButton.setBounds(10, 10, 244, 34);
		contentPane.add(revenueButton);
		
		JButton displayCustomerByPurchase = new JButton("Display Customers by Their Purchase");
		displayCustomerByPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(DealerSys.displayCustomersByExpense());
			}
		});
		displayCustomerByPurchase.setBounds(10, 98, 244, 34);
		contentPane.add(displayCustomerByPurchase);
		
		JButton displayCustomerButton = new JButton("Display Customers");
		displayCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(DealerSys.displayCustomersById());
			}
		});
		displayCustomerButton.setBounds(10, 54, 244, 34);
		contentPane.add(displayCustomerButton);
		
		JButton addCarButton = new JButton("ADD NEW CAR");
		addCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avf.setVisible(true);
				setVisible(false);				
			}
		});
		addCarButton.setBounds(10, 230, 244, 34);
		contentPane.add(addCarButton);
		
		JButton displayCarsButton = new JButton("Display Cars in System");
		displayCarsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(DealerSys.displayDealersCars(d));
			}
		});
		displayCarsButton.setBounds(10, 142, 244, 34);
		contentPane.add(displayCarsButton);
		
		JButton changeInfoButton = new JButton("Change Password");
		changeInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeButtonPressed();
			}
		});
		changeInfoButton.setBounds(10, 277, 244, 21);
		contentPane.add(changeInfoButton);
		
		newpasswordField = new JPasswordField();
		newpasswordField.setVisible(false);
		newpasswordField.setBounds(119, 346, 135, 19);
		contentPane.add(newpasswordField);
		
		oldpasswordField = new JPasswordField();
		oldpasswordField.setVisible(false);
		oldpasswordField.setBounds(119, 317, 135, 19);
		contentPane.add(oldpasswordField);
		
		OldPassLabel = new JLabel("Enter old password");
		OldPassLabel.setVisible(false);
		OldPassLabel.setBounds(10, 320, 108, 13);
		contentPane.add(OldPassLabel);
		
		newPassLabel = new JLabel("Enter new password");
		newPassLabel.setVisible(false);
		newPassLabel.setBounds(10, 349, 108, 13);
		contentPane.add(newPassLabel);
		
		SuccessfulLabel = new JLabel("Your pasword is succesfully changed");
		SuccessfulLabel.setVisible(false);
		SuccessfulLabel.setBounds(10, 397, 244, 13);
		contentPane.add(SuccessfulLabel);
		
		oldPassWrongLabel = new JLabel("Old password is wrong");
		oldPassWrongLabel.setVisible(false);
		oldPassWrongLabel.setBounds(10, 397, 244, 13);
		contentPane.add(oldPassWrongLabel);
		
		fillLabel = new JLabel("Fill the old and new password");
		fillLabel.setVisible(false);
		fillLabel.setBounds(10, 397, 244, 13);
		contentPane.add(fillLabel);
		
		
		lastChangeButton = new JButton("Save");
		lastChangeButton.setVisible(false);
		lastChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(oldpasswordField.getText().equals("") && newpasswordField.getText().equals("")) {
					fillLabel.setVisible(true);
					SuccessfulLabel.setVisible(false);
					oldPassWrongLabel.setVisible(false);
				} else if(DealerSys.changePassword(d, oldpasswordField.getText(), newpasswordField.getText()))
				{
					SuccessfulLabel.setVisible(true);
					fillLabel.setVisible(false);
					oldPassWrongLabel.setVisible(false);
				} else if(!DealerSys.changePassword(d, oldpasswordField.getText(), newpasswordField.getText())){
					oldPassWrongLabel.setVisible(true);
					fillLabel.setVisible(false);
					SuccessfulLabel.setVisible(false);
				}
				clearAfterChange();
				slp(oldPassWrongLabel,fillLabel,SuccessfulLabel);
			}
		});
		lastChangeButton.setBounds(10, 372, 244, 19);
		contentPane.add(lastChangeButton);
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		clearButton.setBounds(10, 186, 244, 34);
		contentPane.add(clearButton);
		
		JLabel nameLabel = new JLabel(x);
		nameLabel.setFont(new Font("Britannic Bold", Font.PLAIN, 17));
		nameLabel.setBounds(264, 14, 207, 19);
		contentPane.add(nameLabel);
		

		
		
	}
	
	public void changeButtonPressed() {
		newpasswordField.setVisible(true);
		oldpasswordField.setVisible(true);
		OldPassLabel.setVisible(true);
		newPassLabel.setVisible(true);
		lastChangeButton.setVisible(true);
	}
	
	public void clearAfterChange() {
		newpasswordField.setVisible(false);
		oldpasswordField.setVisible(false);
		OldPassLabel.setVisible(false);
		newPassLabel.setVisible(false);
		lastChangeButton.setVisible(false);
	}
	
	
	public void slp(JLabel label, JLabel label2, JLabel label3) {
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
	                    label3.setVisible(false);
	                }
	            });
	        }
	    }).start();
	}
}
