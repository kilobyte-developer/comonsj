import java.sql.*;

class DatabaseMetaDataDemo {
    public static void main(String args[]) throws Exception {
        Class.forName("org.postgresql.Driver");
        System.out.println("Driver Loaded");
        
        Connection con = DriverManager.getConnection("jdbc:postgresql:tybcs", "postgres", "postgres");
        System.out.println("Connection Established");
        
        DatabaseMetaData dmd = con.getMetaData();
        System.out.println("==========DB Details==========");
        System.out.println("DB Name=" + dmd.getDatabaseProductName());
        System.out.println("DB Version=" + dmd.getDatabaseProductVersion());
        System.out.println("DB Driver Name=" + dmd.getDriverName());
        System.out.println("Driver Major Version=" + dmd.getDriverMajorVersion());
        System.out.println("Driver Minor Version=" + dmd.getDriverMinorVersion());
        System.out.println("URL of DB=" + dmd.getURL());
        System.out.println("Current UserName=" + dmd.getUserName());
        
        System.out.println("==========Tables===========");
        String t[] = {"Tables"};
        ResultSet rs = dmd.getTables(null, null, null, t);
        while (rs.next()) {
            System.out.println(rs.getString("Table Name"));
        }
        
        System.in.read();
        
        System.out.println("==========Views=========");
        String v[] = {"Views"};
        rs = dmd.getTables(null, null, null, v);
        while (rs.next()) {
            System.out.println(rs.getString("Table Views"));
        }
        
        con.close();
    }
}
