//package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import MainandSystem.DealerSys;
//import OtherClasses.Vehicle;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class BuyVehicleFrame extends JFrame {

	private JPanel contentPane;
	JComboBox CarId;
	private JButton buyButton;
	private String money ="";
	public CustomerFrame cf = null;
	JLabel moneyLabel;


	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyVehicleFrame frame = new BuyVehicleFrame();
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
	public BuyVehicleFrame(CustomerFrame frame, String id) {
		cf = frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 275, 298);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton displayCarButton = new JButton("Display Cars on Sale");
		displayCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(DealerSys.displayVehicleonSale());
			}
		});
		displayCarButton.setBounds(295, 78, 268, 35);
		contentPane.add(displayCarButton);
		
		JLabel walletLabel = new JLabel("Your Wallet Money : ");
		walletLabel.setBounds(295, 38, 122, 13);
		contentPane.add(walletLabel);
		

		money = DealerSys.getCustomersMoney(Integer.parseInt(id));
		moneyLabel = new JLabel(money);
		moneyLabel.setBounds(424, 38, 102, 13);
		contentPane.add(moneyLabel);
		
		CarId = new JComboBox();
		CarId.setBounds(295, 140, 268, 35);
		contentPane.add(CarId);
		
		
		
		buyButton = new JButton("Buy the Car");
		
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Vehicle c = DealerSys.searchVehicle(Integer.parseInt(CarId.getSelectedItem().toString()));
					if(Double.parseDouble(money) >= c.getPrice()) {
						DealerSys.buyVehicleToCustomer(Integer.parseInt(id), c.getId());
						textArea.setText("You bought a new car.");
						money = DealerSys.getCustomersMoney(
								Integer.parseInt(id));
						moneyLabel.setText(money);
						CarId.setModel(new DefaultComboBoxModel(DealerSys.getVehicleIdonSale()));
					} else {
						textArea.setText("You have not enough money in your wallet to buy this car.");
					}		
					
			}
		});
		buyButton.setBounds(295, 198, 268, 35);
		contentPane.add(buyButton);
		
		JButton closeButton = new JButton("CLOSE");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.setVisible(true);
				textArea.setText("");
				dispose();
			}
		});
		closeButton.setBounds(295, 253, 268, 35);
		contentPane.add(closeButton);
		
	}
	
	public JComboBox getComboBox() {
		return CarId;
	}
	
	public void setMoney(String id) {
		money = DealerSys.getCustomersMoney(Integer.parseInt(id));
		moneyLabel.setText(money);
	}
}
