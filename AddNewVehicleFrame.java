//package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import InheritanceClasses.Dealer;
//import MainandSystem.DealerSys;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewVehicleFrame extends JFrame {

	private JPanel contentPane;
	private JTextField regNumField;
	private JTextField brandField;
	private JTextField ModelField;
	private JTextField ModelYearField;
	private JTextField priceField;
	public DealerFrame df = null;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewVehicleFrame frame = new AddNewVehicleFrame();
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
	public AddNewVehicleFrame(DealerFrame mf, String id) {
		
		this.df = mf;
		Dealer d = DealerSys.searchDealer(id);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idLabel = new JLabel("");
		idLabel.setBounds(27, 32, 221, 19);
		contentPane.add(idLabel);
		
		JLabel regNumLabel = new JLabel("Enter Registration Number : ");
		regNumLabel.setBounds(23, 32, 212, 19);
		contentPane.add(regNumLabel);
		
		JLabel brandLabel = new JLabel("Enter Brand : ");
		brandLabel.setBounds(23, 72, 127, 19);
		contentPane.add(brandLabel);
		
		JLabel modelLabel = new JLabel("Enter Model : ");
		modelLabel.setBounds(23, 116, 127, 13);
		contentPane.add(modelLabel);
		
		JLabel lblNewLabel = new JLabel("Enter Model Year : ");
		lblNewLabel.setBounds(23, 157, 127, 13);
		contentPane.add(lblNewLabel);
		
		regNumField = new JTextField();
		regNumField.setBounds(199, 32, 140, 19);
		contentPane.add(regNumField);
		regNumField.setColumns(10);
		
		brandField = new JTextField();
		brandField.setBounds(199, 72, 140, 19);
		contentPane.add(brandField);
		brandField.setColumns(10);
		
		ModelField = new JTextField();
		ModelField.setBounds(199, 113, 140, 19);
		contentPane.add(ModelField);
		ModelField.setColumns(10);
		
		ModelYearField = new JTextField();
		ModelYearField.setBounds(199, 154, 140, 19);
		contentPane.add(ModelYearField);
		ModelYearField.setColumns(10);
		
		
		JLabel fillLabel = new JLabel("Please Fill All The Labels !!!");
		fillLabel.setVisible(false);
		fillLabel.setBounds(23, 235, 177, 25);
		contentPane.add(fillLabel);
		
		JLabel SuccessfulLabel = new JLabel("Car Addition is Successful ");
		SuccessfulLabel.setVisible(false);
		SuccessfulLabel.setBounds(23, 235, 177, 25);
		contentPane.add(SuccessfulLabel);
		
		JLabel priceLabel = new JLabel("Enter Price : ");
		priceLabel.setBounds(23, 196, 127, 13);
		contentPane.add(priceLabel);
		
		priceField = new JTextField();
		priceField.setBounds(199, 193, 140, 19);
		contentPane.add(priceField);
		priceField.setColumns(10);
		
		JButton addButton = new JButton("ADD");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ModelYearField.getText().equals("") || ModelField.getText().equals("") ||
						brandField.getText().equals("") || regNumField.getText().equals("") || priceField.getText().equals("")) {
					fillLabel.setVisible(true);
					SuccessfulLabel.setVisible(false);
				} else {
					if(DealerSys.addDealersCar(d, regNumField.getText() , brandField.getText(), ModelField.getText(),
											Integer.parseInt(ModelYearField.getText()), Double.parseDouble(priceField.getText()))) {
						SuccessfulLabel.setVisible(true);
						fillLabel.setVisible(false);
						slp(SuccessfulLabel);
					}
				}
			}
		});
		addButton.setBounds(199, 233, 140, 29);
		contentPane.add(addButton);

		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				df.setVisible(true);
				dispose();
			}
		});
		closeButton.setBounds(199, 274, 140, 23);
		contentPane.add(closeButton);
		

	}
	
	public void slp(JLabel label) {
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
	                }
	            });
	        }
	    }).start();
	}

}
