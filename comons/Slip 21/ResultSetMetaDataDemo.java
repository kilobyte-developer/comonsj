import java.sql.*;

class ResultSetMetaDataDemo {
    public static void main(String args[]) throws Exception {
        Class.forName("org.postgresql.Driver");
        System.out.println("Driver Loaded");
        
        Connection con = DriverManager.getConnection("jdbc:postgresql:tybcs", "postgres", "postgres");
        System.out.println("Connection Established");
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from Student");
        ResultSetMetaData rsmd = rs.getMetaData();
        
        int n = rsmd.getColumnCount();
        System.out.println("No. of columns=" + n);
        
        for (int i = 1; i <= n; i++) {
            System.out.println("Column Number: " + i);
            System.out.println("===============");
            System.out.println("Column name=" + rsmd.getColumnName(i));
            System.out.println("Column Type=" + rsmd.getColumnTypeName(i));
            System.out.println("Column Width=" + rsmd.getColumnDisplaySize(i));
            System.out.println("Column Precision=" + rsmd.getPrecision(i));
            System.out.println("Is Currency=" + rsmd.isCurrency(i));
            System.out.println("Is ReadOnly=" + rsmd.isReadOnly(i));
            System.out.println("Is Writable=" + rsmd.isWritable(i));
            System.out.println("Is Searchable=" + rsmd.isSearchable(i));
            System.out.println("Is Signed=" + rsmd.isSigned(i));
        }
        
        con.close();
    }
}
