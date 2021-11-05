package app;

import connection.ConnectionFactory;
import exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class AppDelete {

        public static void main(String[] args) throws SQLException {

            //ConnectionFactory connFactory = new ConnectionFactory();
            Connection conn = ConnectionFactory.getConnection();

            try {


                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                PreparedStatement st = conn.prepareStatement(""
                        + "DELETE FROM department WHERE Id = ?");



                st.setInt(1, 6);

                st.executeUpdate();



            } catch (SQLException e) {
                throw new DatabaseException("Erro de remoção de dados" );
            }

        }
    }

