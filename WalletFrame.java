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
	public WalletFrame(int customerId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 228, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		moneyField = new JTextField();
		moneyField.setBounds(10, 64, 194, 19);
		contentPane.add(moneyField);
		moneyField.setColumns(10);
		
		JLabel enterLabel = new JLabel("Please enter the amount you will upload\r\n");
		enterLabel.setBounds(10, 41, 230, 13);
		contentPane.add(enterLabel);
		
		JLabel lblNewLabel = new JLabel("After press the following button, you will\r\n");
		lblNewLabel.setBounds(10, 93, 194, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("enter your credit/debit card information");
		lblNewLabel_1.setBounds(10, 109, 194, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("on the page that opens after registration.");
		lblNewLabel_2.setBounds(10, 123, 194, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton AddButton = new JButton("ADD");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DealerSys.addMoneyToWallet(customerId, moneyField.getText());
			}
		});
		AddButton.setBounds(59, 151, 85, 21);
		contentPane.add(AddButton);
	}
}
