package id.oneindoensia.javabootcamp.day3.todo;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Todo todo = new Todo("Weak up in morning", true);
        Todo todo2 = new Todo("Have a breakfast", true);
        Todo todo3 = new Todo("Call parents", false);
        Todo todo4 = new Todo("Call crush", true);
        Todo todo5 = new Todo("Java BootCamp", false);
        Todo todo6 = new Todo("Sleepy", true);


        TodoRepository todoRepository = new TodoRepository(new DataSources());
        if (todo == null ) {
            throw new NullPointerException("todo di kelas main null");
        } else {
            todoRepository.insertTodo(todo);
        }
        if (todo2 != null) {
            todoRepository.insertTodo(todo2);
        }
        todoRepository.insertTodo(todo3);
        todoRepository.insertTodo(todo4);
        todoRepository.insertTodo(todo5);
        todoRepository.insertTodo(todo6);
        List<Todo> todos = todoRepository.allTodo();
        for (Todo data : todos){
            System.out.println(data.toString());
        }
    }
}
