import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class ProjectDemo extends JFrame implements ActionListener       
{   
    JTextField t1,t2,t3,t4;
    JLabel l1,l2,l3,l4;
    JButton b1,b2;
    int row,column;
    ProjectDemo()
    {
        setLayout(new FlowLayout());
        setSize(500,500);
        setVisible(true);       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        l1=new JLabel("Project Id");
        add(l1);
         
        t1=new JTextField(10);
        add(t1);
         
        l2=new JLabel("Project Name");
        add(l2);
         
        t2=new JTextField(10);
        add(t2);
         
        l3=new JLabel("Project Description");
        add(l3);
         
        t3=new JTextField(10);
        add(t3);

	l4=new JLabel("Project Status");
	add(l4);
	
	t4=new JTextField(10);
	add(t4);
        
        b1=new JButton("Insert");
        add(b1);
        b1.addActionListener(this);
         
        b2=new JButton("Display");
        add(b2);
        b2.addActionListener(this);
         
        try
        {
            Class.forName("org.postgresql.Driver");
        }
        catch(Exception e)
        {
          System.out.println("Error"+e.getMessage());     
        }
    }
    public void actionPerformed(ActionEvent e2)
    {
        if(e2.getSource()==b1)
        {
            try
           {
               int pid=Integer.parseInt(t1.getText());
               String pname=t2.getText();
               String pdesc=t3.getText();
               String pstat=t4.getText(); 
      Connection conn = DriverManager.getConnection("jdbc:postgresql:tybcs","postgres","postgres"); 
                 
                PreparedStatement st=conn.prepareStatement("insert into Project values(?,?,?,?)");
                st.setInt(1, pid);
                st.setString(2,pname);
                st.setString(3,pdesc);
		st.setString(4,pstat);
                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(this,"Inserted");
                     
           }catch(Exception e)
           {
               System.out.println("Error"+e.getMessage());
           }
        }  
        if(e2.getSource()==b2)
        {
            try
           {
               
               Object[] data=new Object[3];
               DefaultTableModel dtm=new DefaultTableModel();
               JTable jt=new JTable(dtm);
               ResultSet rs;
                System.out.println("hello");
               jt.setBounds(20,20,50,50);
               String[] darr={"Project ID ","Project Name","Project Description","Project Status"};
               for(int column=0;column<4;column++)        
               {
                   dtm.addColumn(darr[column]);
               }
               Connection conn = DriverManager.getConnection("jdbc:postgresql:tybcs","postgres","postgres"); 
                Statement st=conn.createStatement();
                rs=st.executeQuery("select * from Project");
               for(row=0;rs.next();row++)        
               {
                  for(int column=0;column<4;column++)        
                  {
                      data[column]=rs.getObject(column+1);
                  }
                  dtm.addRow(data);
               }
               rs.close();
               getContentPane().add(new JScrollPane(jt));
           }catch(Exception e)
           {
                
           }
        }
    }
    public static void main(String[] args) 
    {
        new ProjectDemo();
    }
     
}