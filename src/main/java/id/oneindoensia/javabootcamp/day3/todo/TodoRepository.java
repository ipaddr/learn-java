package id.oneindoensia.javabootcamp.day3.todo;

import java.util.List;

public class TodoRepository {

    private DataSources dataSources;

    public TodoRepository(DataSources dataSources) {
        this.dataSources = dataSources;
        this.dataSources.create();
    }

    public void insertTodo(Todo todo){
        dataSources.insert(todo);
    }

    public void updateTodo(Todo todo){
        dataSources.update(todo);
    }

    public void deleteTodo(Todo todo){
        dataSources.delete(todo);
    }

    public List<Todo> allTodo(){
        return dataSources.queryAllTable();
    }

    public Todo getTodoWithId(Todo todo){
        return dataSources.queryTodoWithId(todo);
    }

}
