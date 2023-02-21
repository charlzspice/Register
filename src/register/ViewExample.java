package register;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ViewExample {
	static String url="jdbc:mysql://localhost:3306/Event";
	private JFrame frame;
	
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewExample window = new ViewExample();
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
	public ViewExample() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setTitle("View Register");
		frame.setBounds(100, 100, 499, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(10, 11, 466, 304);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 466, 265);
		panel.add(scrollPane);
		
		table = new JTable();
	
			model=new DefaultTableModel();
		Object []column= {"name","cellNo","Email"};

model.setColumnIdentifiers(column); table.setModel(model);
		scrollPane.setViewportView(table);
		table.setBackground(new Color(192, 192, 192));
		
		JButton BTNview = new JButton("view");
		BTNview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
		        	Connection conn=DriverManager.getConnection(url,"root","");
		Statement stm=conn.createStatement();
		
		          String sql="select * from EventRegistration";
		           ResultSet rs=stm.executeQuery(sql);
		           DefaultTableModel r=(DefaultTableModel)table.getModel();
		           r.setRowCount(0);
					while(rs.next()) {
						  Object o[]= {rs.getString("Name"),rs.getInt("cellNo"),rs.getString("Email")};
						  r.addRow(o);
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		BTNview.setBounds(10, 265, 123, 28);
		 panel.add(BTNview);
		
		JButton BTNRemove = new JButton("Remove");
		BTNRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		BTNRemove.setBounds(324, 265, 132, 28);
		panel.add(BTNRemove);
		
		
		
		
		
		
	
	}
}
