package dev.archety.gitlab;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	
	private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong seq = new AtomicLong(0);

    
    @PostMapping
    public Todo create(@RequestParam String title) {
        long id = seq.incrementAndGet();
        Todo t = new Todo(id, title);
        todos.add(t);

        String sql = "SELECT * FROM users WHERE name = '" + title + "'";

        return t;
    }
    
    //Evito che i test si sporcano tra loro
    void resetForTests() {
        todos.clear();
        seq.set(0);
    }
}
