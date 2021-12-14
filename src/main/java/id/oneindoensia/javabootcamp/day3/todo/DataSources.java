package id.oneindoensia.javabootcamp.day3.todo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSources {
    public static final String DB_NAME = "jdbc-test-db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:jdbc-test.db";

    public static final String TABLE_TODO = "table_todo";
    public static final String TABLE_TODO_COLUMN_ID = "_id";
    public static final String TABLE_TODO_COLUMN_TASK = "task";
    public static final String TABLE_TODO_COLUMN_STATUS = "status";

    public static final int INDEX_INSERT_TABLE_TODO_COLUMN_TASK =1;
    public static final int INDEX_INSERT_TABLE_TODO_COLUMN_STATUS =2;
    public static final int INDEX_SELECT_DELETE_TABLE_TODO_COLUMN_ID =1;
    public static final int INDEX_UPDATE_TABLE_TODO_COLUMN_TASK = 1;
    public static final int INDEX_UPDATE_TABLE_TODO_COLUMN_ID = 2;

    public static final String CREATE_TABLE_TODO = "CREATE TABLE IF NOT EXISTS "+TABLE_TODO+
            " ("+ TABLE_TODO_COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
            TABLE_TODO_COLUMN_TASK +" TEXT, " +
            TABLE_TODO_COLUMN_STATUS +" INTEGER)";

    public static final String INSERT_TODO = "INSERT INTO "+TABLE_TODO+" " +
            "("+TABLE_TODO_COLUMN_TASK+","+TABLE_TODO_COLUMN_STATUS+") VALUES (?, ?)";

    public static final String UPDATE_TASK = "UPDATE "+TABLE_TODO+" " +
            "SET "+TABLE_TODO_COLUMN_TASK+" = ? WHERE "+TABLE_TODO_COLUMN_ID+" = ?";

    public static final String DELETE_TASK = "DELETE FROM "+TABLE_TODO+" " +
            "WHERE "+TABLE_TODO_COLUMN_ID+" = ?";

    public static final String SELECT_TASK = "SELECT * FROM "+TABLE_TODO+" " +
            "WHERE "+TABLE_TODO_COLUMN_ID+" = ?";

    public static final String SELECT_ALL_TASK = "SELECT * FROM "+TABLE_TODO;

    private Connection conn;

    private boolean open(){
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        }catch (SQLException e){
            return false;
        }
    }

    private void close(){
        try {
            if (createTableTodo != null)
                createTableTodo.close();
            if (insertTodo != null)
                insertTodo.close();
            if (conn != null)
                conn.close();
        }catch (SQLException e){

        }
    }

    private PreparedStatement createTableTodo;
    public void create(){
        if (open()) {
            try {
                createTableTodo = conn.prepareStatement(CREATE_TABLE_TODO);
                createTableTodo.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private PreparedStatement queryTableTodo;
    public List<Todo> queryAllTable(){
        List<Todo> todos = new ArrayList<>();
        if (open()){
            try {
                queryTableTodo = conn.prepareStatement(SELECT_ALL_TASK);
                ResultSet resultSet = queryTableTodo.executeQuery();
                while (resultSet.next()){
                    todos.add(new Todo(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)==1 ? true: false));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return todos;
    }

    private PreparedStatement getQuerySingleTableTodo;
    public Todo queryTodoWithId(Todo todo){
        Todo todoFromDB = null;
        if (open()){
            try {
                getQuerySingleTableTodo = conn.prepareStatement(SELECT_TASK);
                getQuerySingleTableTodo.setInt(INDEX_SELECT_DELETE_TABLE_TODO_COLUMN_ID, todo.getId());
                ResultSet resultSet = getQuerySingleTableTodo.executeQuery();
                while (resultSet.next()){
                    todoFromDB = new Todo(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)==1 ? true: false);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return todoFromDB;
    }

    private PreparedStatement insertTodo;
    public void insert(Todo todo){
        if (open()){
            try {
                insertTodo = conn.prepareStatement(INSERT_TODO, Statement.RETURN_GENERATED_KEYS);
                insertTodo.setString(INDEX_INSERT_TABLE_TODO_COLUMN_TASK, todo.getTask());
                insertTodo.setInt(INDEX_INSERT_TABLE_TODO_COLUMN_STATUS, todo.isStatus()? 1:0);
                insertTodo.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private PreparedStatement updateTodo;
    public void update(Todo todo){
        if (open()){
            try {
                updateTodo = conn.prepareStatement(UPDATE_TASK, Statement.RETURN_GENERATED_KEYS);
                updateTodo.setString(INDEX_UPDATE_TABLE_TODO_COLUMN_TASK, todo.getTask());
                updateTodo.setInt(INDEX_UPDATE_TABLE_TODO_COLUMN_ID, todo.getId());
                updateTodo.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private PreparedStatement deleteTodo;
    public void delete(Todo todo){
        if (open()) {
            try {
                deleteTodo = conn.prepareStatement(DELETE_TASK, Statement.RETURN_GENERATED_KEYS);
                deleteTodo.setInt(INDEX_SELECT_DELETE_TABLE_TODO_COLUMN_ID, todo.getId());
                deleteTodo.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
