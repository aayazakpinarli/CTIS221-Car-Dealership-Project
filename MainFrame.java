//package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

	private JPanel MainFrame;
	private JTextField idField;
	DealerFrame df = new DealerFrame(this);
	CustomerFrame cf = new CustomerFrame(this, idField.getText());

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
		setBounds(100, 100, 450, 300);
		MainFrame = new JPanel();
		MainFrame.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(MainFrame);
		MainFrame.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Dealership System Page");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setBounds(83, 23, 304, 50);
		MainFrame.add(lblNewLabel);
		
		JComboBox menu = new JComboBox();
		menu.setModel(new DefaultComboBoxModel(new String[] {"Customer", "Dealer", "Look at Vehicles on Sale"}));
		menu.setBounds(135, 117, 161, 21);
		MainFrame.add(menu);
		
		JLabel lblNewLabel_1 = new JLabel("Please select  : ");
		lblNewLabel_1.setBounds(26, 121, 99, 13);
		MainFrame.add(lblNewLabel_1);
		

		idField = new JTextField();
		idField.setVisible(false);
		idField.setBounds(135, 182, 161, 19);
		MainFrame.add(idField);
		idField.setColumns(10);
		
		JLabel idLabel = new JLabel("Enter your id : ");
		idLabel.setVisible(false);
		idLabel.setBounds(26, 185, 99, 13);
		MainFrame.add(idLabel);
		
	
		
		JButton EnterButton = new JButton("ENTER");
		EnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(menu.getSelectedItem().equals("Customer")) {
					cf.setVisible(true);
					setVisible(false);
				}
				
				
			}
		});
		EnterButton.setBounds(162, 232, 85, 21);
		MainFrame.add(EnterButton);
		
		JButton btnNewButton = new JButton("Choose");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!menu.getSelectedItem().equals("Look at Vehicles on Sale")) {
					idField.setVisible(true);
					idLabel.setVisible(true);
				} else {
					idField.setVisible(false);
					idLabel.setVisible(false);
				}
				
			}
		});
		btnNewButton.setBounds(341, 117, 85, 21);
		MainFrame.add(btnNewButton);
		
		


	}
}
