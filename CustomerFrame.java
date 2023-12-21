//package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	MainFrame mf = null;
	private JTextField newInfo;

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
	}*/
	
	/**
	 * Create the frame.
	 */
	public CustomerFrame(MainFrame frame, String id) {
		mf = frame;

		setTitle("CustomerFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane InfoPane = new JEditorPane();
		InfoPane.setBounds(200, 10, 306, 243);
		contentPane.add(InfoPane);
		
		JButton btnNewButton = new JButton("Display Purchase");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String res = "";
				res = DealerSys.displayCustomersCar(Integer.parseInt(id));
				InfoPane.setText(res);
			}
		});
		btnNewButton.setBounds(10, 10, 180, 21);
		contentPane.add(btnNewButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoPane.setText("");
			}
		});
		clearButton.setBounds(10, 201, 180, 21);
		contentPane.add(clearButton);
		
		
		
		JButton logOutButton = new JButton("LOG OUT");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mf.setVisible(true);
				dispose();
			}
		});
		logOutButton.setBounds(10, 232, 180, 21);
		contentPane.add(logOutButton);
		
		
		
		JLabel addressLabel = new JLabel("Enter your new address");
		addressLabel.setVisible(false);
		addressLabel.setBounds(10, 103, 180, 13);
		contentPane.add(addressLabel);
		
		JLabel phoneNumLabel = new JLabel("Enter your new phone number");
		phoneNumLabel.setVisible(false);
		phoneNumLabel.setBounds(10, 103, 180, 13);
		contentPane.add(phoneNumLabel);
		
		newInfo = new JTextField();
		newInfo.setVisible(false);
		newInfo.setBounds(10, 126, 180, 19);
		contentPane.add(newInfo);
		newInfo.setColumns(10);
		
		JButton updateInfoButton = new JButton("Update Info");
		updateInfoButton.setVisible(false);
		updateInfoButton.setBounds(10, 155, 180, 21);
		contentPane.add(updateInfoButton);
		
		
		
		JComboBox options = new JComboBox();
		options.setVisible(false);
		options.setModel(new DefaultComboBoxModel(new String[] {" ","Phone Number", "Address"}));
		options.setBounds(10, 72, 180, 21);
		contentPane.add(options);
		options.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(options.getSelectedItem().equals("Address")) {
					// phone must be false as if option is changed 
					// written part would be change
					phoneNumLabel.setVisible(false);
					addressLabel.setVisible(true);
					newInfo.setVisible(true);
					updateInfoButton.setVisible(true);
				} else if(options.getSelectedItem().equals("Phone Number")){
					addressLabel.setVisible(false);
					phoneNumLabel.setVisible(true);
					newInfo.setVisible(true);
					updateInfoButton.setVisible(true);
				}

			}
			
		});
			

		JButton changeInfoButton = new JButton("Change Info");
		changeInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				options.setVisible(true);

			}
		});
		changeInfoButton.setBounds(10, 41, 180, 21);
		contentPane.add(changeInfoButton);
		



	}
}
