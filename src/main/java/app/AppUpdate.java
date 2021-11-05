package app;

import connection.ConnectionFactory;
import exceptions.DatabaseException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AppUpdate {

        public static void main(String[] args) throws SQLException {

            //ConnectionFactory connFactory = new ConnectionFactory();
            Connection conn = ConnectionFactory.getConnection();

            try {

                conn.setAutoCommit(false);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                PreparedStatement st = conn.prepareStatement(""
                        + "UPDATE  seller SET  BaseSalary = BaseSalary + ? WHERE DepartmentId = ?");


                if (2>1) {
                    throw new SQLException("Fake Error");
                }

                    st.setDouble(1, 500);
                    st.setInt(2, 1);

                    st.executeUpdate();

                conn.commit();



            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    conn.rollback();
                    throw new DatabaseException("Problema de transação");
                } catch(SQLException e1){
                e1.printStackTrace();
                }
            }

        }
}

