package cellularData;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(42, 47, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(42, 72, 76, 14);
		contentPane.add(lblContact);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(42, 97, 76, 14);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(42, 122, 120, 14);
		contentPane.add(lblConfirmPassword);
		
		textField = new JTextField();
		textField.setBounds(162, 44, 217, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 69, 217, 20);
		contentPane.add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 119, 217, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(162, 94, 217, 20);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				  try  {
			            /* TODO output your page here. You may use following sample code. */
			         
					  if(passwordField.getText().equals(passwordField_1.getText())) {
					  
			           
			 System.out.println("");
			         String s= "s";
			         MyDb db = new MyDb();
			         
			         
			          Connection con = db.getCon();
			          Statement stmt =  con.createStatement();
			  
			          // out.println("Data is inserted");
			stmt.execute("insert into registration(username,contact,Password)values('"+textField.getText()+"','"+textField_1.getText()+"','"+passwordField_1.getText()+"')");
			   
		
					confirm_Popup confirm = new confirm_Popup();
					confirm.setVisible(true);

					  }  
					  
					  
					  else {
						
						 Invalid_Popup inv = new Invalid_Popup();
						 inv.setVisible(true);
						  
						  
						}
					  
			        } catch (SQLException ex) {
			        	
			        	System.out.println(ex);
		 	        } 
				  
				
			
			}
		});
		btnNewButton.setBounds(162, 170, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
//				
//				Registration reg = new Registration();
//				reg.dispose();
//				reg.setVisible(false);
//				
				
			}
		});
		btnNewButton_1.setBounds(295, 170, 89, 23);
		contentPane.add(btnNewButton_1);
		
	
		
		
		 
		
	}
}
