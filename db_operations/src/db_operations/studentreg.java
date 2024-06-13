package db_operations;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class studentreg {

	private JFrame frame;
	private JTextField tb1;
	private JTextField tb2;
	private JTextField tb3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentreg window = new studentreg();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public studentreg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT REGISTRATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(150, 24, 182, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(90, 126, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ROLLNO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(90, 79, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("BRANCH");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(90, 170, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("MARKS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(90, 211, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tb1 = new JTextField();
		tb1.setBounds(213, 76, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		tb2 = new JTextField();
		tb2.setBounds(213, 123, 86, 20);
		frame.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		JComboBox cb1 = new JComboBox();
		cb1.setFont(new Font("Tahoma", Font.BOLD, 11));
		cb1.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "ECE", "EEE", "IT", "CSE", "MECH"}));
		cb1.setBounds(213, 166, 86, 22);
		frame.getContentPane().add(cb1);
		
		tb3 = new JTextField();
		tb3.setBounds(213, 208, 86, 20);
		frame.getContentPane().add(tb3);
		tb3.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rno=tb1.getText();
				int rollno=Integer.parseInt(rno);
				String name=tb2.getText();
				String branch=(String) cb1.getSelectedItem();
				String m=tb3.getText();
				int marks=Integer.parseInt(m);
				try
				{
					Connection con=DriverManager.getConnection
							("jdbc:mysql://localhost:3306/mydb","root","mrec");
					String q="insert into student values('"+rollno+"','"+name+"','"+branch+"','"+marks+"')";
					Statement stn=con.createStatement();
					stn.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "inserted successfully");
				}
				catch(SQLException e1)
				{
				e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\th.jpg"));
		lblNewLabel_5.setBounds(141, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
