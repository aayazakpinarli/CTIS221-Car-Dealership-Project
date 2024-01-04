//package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import MainandSystem.DealerSys;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WalletFrame extends JFrame {

	private JPanel contentPane;
	private JTextField moneyField;
	private CustomerFrame cf = null;
	private BuyVehicleFrame bf = null;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					walletFrame frame = new walletFrame();
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
	public WalletFrame(CustomerFrame frame , Integer customerId, BuyVehicleFrame frame2) {
		cf = frame;
		bf = frame2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 287, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		moneyField = new JTextField();
		moneyField.setBounds(10, 64, 256, 19);
		contentPane.add(moneyField);
		moneyField.setColumns(10);
		
		JLabel enterLabel = new JLabel("Please enter the amount you will upload\r\n");
		enterLabel.setBounds(10, 41, 256, 13);
		contentPane.add(enterLabel);
		
		JLabel lblNewLabel = new JLabel("After press the following button, you will\r\n");
		lblNewLabel.setBounds(10, 93, 256, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("enter your credit/debit card information");
		lblNewLabel_1.setBounds(10, 109, 256, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("on the page that opens after registration.");
		lblNewLabel_2.setBounds(10, 123, 256, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton AddButton = new JButton("ADD");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DealerSys.addMoneyToWallet(customerId, moneyField.getText());
				bf.setMoney(customerId.toString());
				moneyField.setText("");
				dispose();			
				cf.setVisible(true);	
			}
		});
		AddButton.setBounds(93, 151, 85, 21);
		contentPane.add(AddButton);
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moneyField.setText("");
				dispose();
				cf.setVisible(true);
				
			}
		});
		closeButton.setBounds(188, 10, 85, 21);
		contentPane.add(closeButton);
	}
}
