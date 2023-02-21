package register;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;



public class Orders {
	JLabel namelab,password;
	JTextField nametf, passwordtf;
	

	private JFrame frmHardwarehome;
	static String url="jdbc:mysql://localhost/Hardware";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orders window = new Orders();
					window.frmHardwarehome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Orders() {
		initialize();
	}
	private void initialize() {
		frmHardwarehome = new JFrame();
		frmHardwarehome.setTitle("Hardware/home");
		frmHardwarehome.setBounds(100, 100, 486, 300);
		frmHardwarehome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		frmHardwarehome.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JLabel labelTitle = new JLabel("Kamau And Sons Hardware");
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		labelTitle.setBackground(Color.GRAY);
		labelTitle.setBounds(100, 5, 254, 74);
		panel.add(labelTitle);
		//another window  for login
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 JFrame frame=new JFrame();
				 frame.setTitle("login");
				 JButton register=new JButton("Register");
				 JButton login=new JButton("Login");
				
				 
				namelab=new JLabel("Name");
				password=new JLabel("Password");
				nametf=new JTextField(30);
				passwordtf=new JTextField(30);
				frame.setSize(300,100);
				frame.getContentPane();
				frame.getContentPane().setLayout(new GridLayout(3,2));
				frame.getContentPane().add(namelab);
				frame.getContentPane().add(nametf);
				frame.getContentPane().add(password);
				frame.getContentPane().add(passwordtf);
				frame.getContentPane().add(login);
				frame.getContentPane().add(register);
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setResizable(false);login.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e1) {
						if(nametf.getText().equals("")||passwordtf.getText().equals("")){
							JOptionPane.showMessageDialog(null, "please fill all the information");
						}else {
							String name=nametf.getText();
							System.out.print(name);
							
						String password=passwordtf.getText();
						System.out.print(password);
						if(passwordtf.getText().equals("select password from accounts where name="+nametf.getText()+"")){
						
							
						}
							
						}
						
					}
				});
				
				

			}
		});
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setBounds(149, 208, 72, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Already have account?");
		lblNewLabel.setBounds(14, 212, 132, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("or create account");
		lblNewLabel_1.setBounds(231, 210, 111, 18);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame2=new JFrame();
				 frame2.setTitle("New Account");
				 JButton register=new JButton("Register");
				 JButton login=new JButton("Login");
				 
				
				 
				namelab=new JLabel("Name");
				password=new JLabel("Password");
				nametf=new JTextField(30);
				passwordtf=new JTextField(30);
				frame2.setSize(300,100);
				frame2.getContentPane();
				frame2.getContentPane().setLayout(new GridLayout(3,2));
				frame2.getContentPane().add(namelab);
				frame2.getContentPane().add(nametf);
				frame2.getContentPane().add(password);
				frame2.getContentPane().add(passwordtf);
				frame2.getContentPane().add(login);
				frame2.getContentPane().add(register);
				
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setVisible(true);
				frame2.setResizable(false);
				register.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						String name1=nametf.getText();
						System.out.print(name1+" ");
						
						String password1=passwordtf.getText();
						System.out.print(password1+" ");
						try {
							if(nametf.getText().equals("")||passwordtf.getText().equals("")){
								JOptionPane.showMessageDialog(null, "please fill all the information");}
							else {
								JOptionPane.showMessageDialog(null, "account created successfully");
							}
				        	Class.forName("com.mysql.cj.jdbc.Driver");
				        	Connection conn=DriverManager.getConnection(url,"root","Maseno5962#@");
				Statement stm=conn.createStatement();
				String st ="insert into Accounts(Name,password)values('"+name1+"','"+password1+"')";
				           stm.executeUpdate(st);
				           
				       
				       
				     

				           
				           
				        } catch (Exception e1) {
				            e1.printStackTrace();
					}}
				});
			}
		}
		);
		
		btnNewButton_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(340, 208, 83, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("We deal in sales of various building and construction materials like:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 66, 399, 51);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("1.cement");
		lblNewLabel_3.setBounds(52, 114, 72, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("4. Paints");
		lblNewLabel_4.setBounds(52, 147, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("2. Gauged Metals");
		lblNewLabel_5.setBounds(134, 123, 103, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("3. pipes");
		lblNewLabel_6.setBounds(260, 123, 71, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("5. electrical components e.t.c");
		lblNewLabel_7.setBounds(134, 147, 197, 23);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("!!Place Your Order Today!!");
		lblNewLabel_8.setFont(new Font("Algerian", Font.ITALIC, 12));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(100, 172, 204, 14);
		panel.add(lblNewLabel_8);
		
		JLabel LabelPic = new JLabel("LabelPic");
		LabelPic.setIcon(new ImageIcon("C:\\Users\\HP\\Pictures\\health.png"));
		LabelPic.setBounds(0, 11, 98, 67);
		panel.add(LabelPic);
		
		JLabel LabelPic2 = new JLabel("labelPic2");
		LabelPic2.setIcon(new ImageIcon("C:\\Users\\HP\\Pictures\\health.png"));
		LabelPic2.setBounds(367, 17, 103, 67);
		panel.add(LabelPic2);
	}
}
