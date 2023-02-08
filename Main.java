import java.io.*;
import java.util.Scanner;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws Exception {
        String connectionUrl =
                "jdbc:sqlserver://EC2AMAZ-V0QM5Q7:1433;"
                        + "database=EmissionsAndClimateDW;"
                        + "user=;"
                        + "password=;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT TOP 10 * from dbo.Dim_Location";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        Scanner sc=new Scanner(new File("elo.csv"));
        sc.useDelimiter("\n");
        while(sc.hasNext()){
            System.out.println(sc.next().split(",")[1]);
        }
    }
}
