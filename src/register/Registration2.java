package register;
	import java.awt.*;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	import java.awt.event.*;
	import javax.swing.*;

	
	public class Registration2 extends JFrame{
		private static final long serialVersionUID = 1L;
		static String url="jdbc:mysql://localhost:3306/Event";
		  JLabel namelb,cellNolb,emaillb;
		 JButton Registerbt,Cancelbt;
		 JTextField nametf,cellnotf,Emailtf;
	
		 
		 
		 Registration2(){
			 // JTable table2;
			 setTitle("Event Registration");
			 namelb=new JLabel("Name");
			 cellNolb=new JLabel("CellNo");
			 cellNolb.setBackground(new Color(192, 192, 192));
			 emaillb=new JLabel("Email");
			 nametf=new JTextField(20);
			 cellnotf=new JTextField(20);
			 Emailtf=new JTextField(20);
			 Registerbt=new JButton("Register");
			 Cancelbt=new JButton("Cancel");
			 
	      Container pane=getContentPane();	
			pane.setLayout(new GridLayout(4,2));
			pane.setBackground(new Color(192, 192, 192));
			pane.add(namelb);
			pane.add(nametf);
			pane.add(cellNolb);
			pane.add(cellnotf);
			pane.add(emaillb);
			pane.add(Emailtf);
			pane.add(Registerbt);
			pane.add(Cancelbt);
			setSize(555,400);
			setResizable(false);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			event Register1=new event();
			Registerbt.addActionListener(Register1);
			event2 Cancel1=new event2();
			Cancelbt.addActionListener(Cancel1);
			
		 }
		 
		 class event2 implements ActionListener{
			 public void actionPerformed(ActionEvent e) {
				 Emailtf.setText(" ");
				 nametf.setText("");
				 cellnotf.setText(" ");
			 }
		 }
			 class event implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					
					String Name=nametf.getText();
					System.out.print(Name+" ");
					String cellNo=cellnotf.getText();
					System.out.print(cellNo+" ");
					 int cell=Integer.parseInt(cellNo);
					 String Email=Emailtf.getText();
					 System.out.print(Email+" ");
				
					 
					 try {
				        	Class.forName("com.mysql.cj.jdbc.Driver");
				        	Connection conn=DriverManager.getConnection(url,"root","");
				Statement stm=conn.createStatement();
				String st ="insert into EventRegistration (Name,cellNo,Email)values('"+Name+"',"+cell+",'"+Email+"')";
				           stm.executeUpdate(st);
				       
				       
				     

				           
					           
				        } catch (Exception e1) {
				            e1.printStackTrace();
		 }}
			 }
		//main method

	public static void main(String[] args) {
		
new Registration2();


	}

			 }
	
	 

