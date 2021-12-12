package id.oneindoensia.javabootcamp.day3;

import java.sql.*;

public class JDBCExample {

    public static void main(
            String args[]) throws SQLException,
            ClassNotFoundException
    {
        // create connection
        Connection connection = DriverManager
                .getConnection("jdbc:sqlite:jdbc-test.db");
        // create statement
        PreparedStatement createTabelStm = connection.prepareStatement("CREATE TABLE IF NOT EXISTS test " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,todo TEXT, status INTEGER)");
        // execute statement to create todolist tabel
        createTabelStm.execute();
        // close statement
        createTabelStm.close();

        // insert new todo to database using createStatement
        // prepare statement
        PreparedStatement insertStatement = connection
                .prepareStatement("INSERT INTO test (todo, status) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        // configure value
        insertStatement.setString(1, "makan pagi");
        insertStatement.setString(2, "1");
        // execute statemen
        insertStatement.execute();
        // configure other value
        insertStatement.setString(1, "makan siang");
        insertStatement.setString(2, "0");
        // execute statement
        insertStatement.execute();
        // configure other value
        insertStatement.setString(1, "makan malam");
        insertStatement.setString(2, "0");
        // execute statement
        insertStatement.execute();
        // close statement
        insertStatement.close();

        // init using create statement
        Statement statement = connection.createStatement();

        // update todo status
        statement.execute("UPDATE test SET status = 1 where todo = 'makan pagi'");
        statement.execute("UPDATE test SET status = 1 where todo = 'akan siang'");

        // delete todo from todos table
        statement.execute("DELETE FROM test where todo = 'makan pagi'");
        statement.execute("DELETE FROM test where todo = 'makan siang'");

        // close statement
        statement.close();

        // query todo from todos tabel
        // make sure to add new statement if create multiple query
        // since the old statemetn will close automatically if new query statement is created
        PreparedStatement queryStatement = connection.prepareStatement("SELECT * FROM test");
        ResultSet resultSet = queryStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("todo") + " | "
            +resultSet.getInt("status"));
        }
        // close result set
        resultSet.close();
        // close queryStatement
        queryStatement.close();

        // close the connection resources
        connection.close();
    }

    private void exampleTransaction(){
        Connection connection = null;
        try {
            // create connection
            connection = DriverManager
                    .getConnection("jdbc:sqlite:jdbc-test.db");

            // turn off auto commit
            connection.setAutoCommit(false);

            // create statement
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT INTO test (todo, status) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            // configure statement value
            insertStatement.setString(1, "Pesta makan");
            insertStatement.setInt(2, 0);
            // execute statement
            insertStatement.execute();
            // close statement
            insertStatement.close();

            // commit the transaction
            connection.commit();
        } catch (SQLException e){
            // somethings wrong, rollback the transaction
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
