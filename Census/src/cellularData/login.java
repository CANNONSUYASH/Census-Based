package cellularData;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String user, pass;
	   TestGraphView testG;
	   private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(164, 74, 184, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(44, 77, 82, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(44, 107, 82, 14);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			


			
		           MyDb db = new MyDb();
		           Connection con = db.getCon();
		            try {
		                Statement stmt = con.createStatement();
		                
		                //stmt.executeUpdate("insert into temp_voter_card_number(voter_card_number)values('"+voter_card_number+"')");
		               // out.println("grt");
		               ResultSet rs1= stmt.executeQuery("select * from registration where username = '"+textField.getText()+"' and Password= '"+passwordField.getText()+"'");
		               // out.println("grt");
		              while(rs1.next()){
		            
		            	    user = rs1.getString(1);
		            	    pass = rs1.getString(3);
		            	   
		            	   
		               }
		              
		              if(textField.getText().equals(user) && passwordField.getText().equals(pass)) {
		            	  
		          		TestGraphView application = new TestGraphView();
		          		
		          		application.main(null);
		          		dispose();
		             
		            	  
		              }
		              else {
						
		            	  Invalid_Popup inv = new Invalid_Popup();
		            	  
		            	  inv.setVisible(true);
		            	  
					}
		              
		               }
		             catch (SQLException ex) {

		             }
				
				
				
			}
					
			
		});
		btnNewButton.setBounds(224, 150, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New Registration");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Registration reg = new Registration();
			reg.setVisible(true);
			
			}
		});
		btnNewButton_1.setBounds(205, 184, 143, 23);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 105, 184, 20);
		contentPane.add(passwordField);
	}
}
