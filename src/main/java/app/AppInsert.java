package app;

import connection.ConnectionFactory;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AppInsert {
    public static void main(String[] args) throws SQLException {

        //ConnectionFactory connFactory = new ConnectionFactory();
        Connection conn = ConnectionFactory.getConnection();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            PreparedStatement st = conn.prepareStatement(""
                    + "INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId)"
                    + "VALUES(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Jefferson");
            st.setString(2, "jefferson.sjaves@ifpr.edu.br");
            st.setDate(3, new java.sql.Date(dateFormat.parse("26/04/1989").getTime()));
            st.setDouble(4,10000);
            st.setInt(5, 1);

            int rowsAffected =  st.executeUpdate();

            System.out.println("Linhas afetadas "+ rowsAffected);


            //Obter os ids ou id inseridos
            ResultSet ids = st.getGeneratedKeys();
            ids.next();
            Integer id = ids.getInt(1);
            System.out.println("O id inserido foi: "+id);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}