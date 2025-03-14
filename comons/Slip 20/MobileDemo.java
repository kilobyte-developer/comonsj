import java.sql.*;
import java.io.*;
public class MobileDemo
{
    public static void main(String[] args) throws Exception
    {
    Connection con;
    ResultSet rs;
    Statement t;
    PreparedStatement ps=null;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    Class.forName("org.postgresql.Driver");
    con=DriverManager.getConnection("jdbc:postgresql://localhost/tydb","root","root123");
    do
    {
    System.out.println("\n1.Insert\n2.Modify\n3.Delete\n4.Search\n5.View all\n6.Exit");
    System.out.println("Enter the choice");
    int ch=Integer.parseInt(br.readLine());
    switch(ch)
    {
        case 1:
            System.out.println("Enter the Modelno");
            int mno=Integer.parseInt(br.readLine());
            
            System.out.println("Enter the Modelname");
            String mname=br.readLine();
            
            System.out.print("Enter Model Color:");
            String mcolor=br.readLine();
            
            System.out.print("Enter Sim type:");
            String mstype = br.readLine();
            
            System.out.print("Enter Network Type:");
            String mntype=br.readLine();
            
            System.out.print("Enter Battery Capacity:");
            String capacity= br.readLine();
            
            System.out.print("Enter Internal Storage:");
            int storage=Integer.parseInt(br.readLine());
            
            System.out.println("Enter the RAM");
            int ram=Integer.parseInt(br.readLine());
            
            System.out.print("Enter Processor Type:");
            String ptype=br.readLine();
            
            ps=con.prepareStatement("insert into MobileInfo values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, mno);
			ps.setString(2, mname);
			ps.setString(3,mcolor);
			ps.setString(4, mstype);
			ps.setString(5, mntype);
			ps.setString(6, capacity);
			ps.setInt(7, storage);
			ps.setInt(8, ram);
			ps.setString(9, ptype);
			int i=ps.executeUpdate();
			if(i==0)
				System.out.println("Unable to insert");
			else
				System.out.println("Data Inserted Succesfully");
            break;
            
        case 2:
        	System.out.println("Enter to Modify record");
            System.out.println("Enter the Modelno");
             mno=Integer.parseInt(br.readLine());
            
            System.out.println("Enter the Modelname");
             mname=br.readLine();
            
            System.out.print("Enter Model Color:");
            mcolor=br.readLine();
            
            System.out.print("Enter Sim type:");
            mstype = br.readLine();
            
            System.out.print("Enter Network Type:");
             mntype=br.readLine();
            
            System.out.print("Enter Battery Capacity:");
             capacity= br.readLine();
            
            System.out.print("Enter Internal Storage:");
             storage=Integer.parseInt(br.readLine());
            
            System.out.println("Enter the RAM");
            ram=Integer.parseInt(br.readLine());
            
            System.out.print("Enter Processor Type:");
             ptype=br.readLine();
            
            ps=con.prepareStatement("insert into MobileInfo values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, mno);
			ps.setString(2, mname);
			ps.setString(3,mcolor);
			ps.setString(4, mstype);
			ps.setString(5, mntype);
			ps.setString(6, capacity);
			ps.setInt(7, storage);
			ps.setInt(8, ram);
			ps.setString(9, ptype);
			 i=ps.executeUpdate();
			if(i==0)
				System.out.println("Unable to insert");
			else
				System.out.println("Data Inserted Succesfully");
            break;
            
        case 3:
            System.out.println("Enter the Model Number for delete record");
            int no=Integer.parseInt(br.readLine());
            ps=con.prepareStatement("delete from MobileInfo where model_number=?");
            ps.setInt(1, no);
            i=ps.executeUpdate();
			if(i==0)
				System.out.println("Unable to Delete");
			else
				System.out.println("Data deleted Succesfully");
            break;
            
            
        case 4:
            System.out.println("Enter the Model Number for search");
            no=Integer.parseInt(br.readLine());
            t=con.createStatement();
            rs=t.executeQuery("select * from MobileInfo where mno="+no);
            while(rs.next())
            {
            	 System.out.println("Model Number="+rs.getInt(1));
                 System.out.println("Model Name="+rs.getString(2));
                 System.out.println("Model Color="+rs.getString(3));
                 System.out.println("Sim Type:" +rs.getString(4));
                 System.out.println("Network Type=" +rs.getString(5));
                 System.out.println("Battery Capacity=:" +rs.getString(6));
                 System.out.println("Internal Strorage=" +rs.getInt(7));
                 System.out.println("RAm=" +rs.getInt(8));
                 System.out.println("Processor:" +rs.getString(9));
            }
            break;
        case 5:
            t=con.createStatement();
            rs=t.executeQuery("select * from MobileInfo");
            while(rs.next())
            {
                System.out.println("Model Number="+rs.getInt(1));
                System.out.println("Model Name="+rs.getString(2));
                System.out.println("Model Color="+rs.getString(3));
                System.out.println("Sim Type:" +rs.getString(4));
                System.out.println("Network Type=" +rs.getString(5));
                System.out.println("Battery Capacity=:" +rs.getString(6));
                System.out.println("Internal Strorage=" +rs.getInt(7));
                System.out.println("RAm=" +rs.getInt(8));
                System.out.println("Processor:" +rs.getString(9));
                }
            break;
        case 6:
            System.exit(0);
            break;
    }
    }while(true);
    }
}