//package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import InheritanceClasses.Customer;
//import InheritanceClasses.Dealer;
//import MainandSystem.DealerSys;
//import OtherClasses.mailService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgetPasswordFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private MainFrame mf = null;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPasswordFrame frame = new ForgetPasswordFrame();
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
	public ForgetPasswordFrame(MainFrame frame) {
		mf = frame;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel enterIdLabel = new JLabel("Enter your id number : ");
		enterIdLabel.setBounds(10, 44, 145, 13);
		contentPane.add(enterIdLabel);
		
		idField = new JTextField();
		idField.setBounds(173, 41, 121, 19);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel notSysLabel = new JLabel("Your id number is not in the system!!!");
		notSysLabel.setVisible(false);
		notSysLabel.setBounds(10, 114, 284, 13);
		contentPane.add(notSysLabel);
		
		JLabel successLabel = new JLabel("Your password is successfully sent to your mail addess");
		successLabel.setVisible(false);
		successLabel.setBounds(10, 114, 284, 13);
		contentPane.add(successLabel);
		
		JLabel idemptyLabel = new JLabel("Id field cannot be empty");
		idemptyLabel.setVisible(false);
		idemptyLabel.setBounds(10, 114, 284, 13);
		contentPane.add(idemptyLabel);
		
		JButton sendMailButton = new JButton("SEND MAIL");
		sendMailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idField.getText().equals("")) {
					idemptyLabel.setVisible(true);
					successLabel.setVisible(false);
					notSysLabel.setVisible(false);
				} else {
					if(DealerSys.searchCustomer(Integer.parseInt( idField.getText())) == null) {
						if(DealerSys.searchDealer(idField.getText()) == null) {
							notSysLabel.setVisible(true);
						} else {
							Dealer d = DealerSys.searchDealer(idField.getText());
							mailService.sendMail(d.getPassword(), d.getMail());
						}
					} else {
						Customer c = DealerSys.searchCustomer(Integer.parseInt( idField.getText()));
						mailService.sendMail(c.getPassword(), c.getMail());
					}
					// clear field
					idField.setText("");
					slp();
				}
			}
		});
		sendMailButton.setBounds(173, 82, 121, 21);
		contentPane.add(sendMailButton);
		

		

	}
	
	
	public void slp() {
	    new Thread(new Runnable() {
	        public void run() {
	            try {
	                Thread.sleep(1000);
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
