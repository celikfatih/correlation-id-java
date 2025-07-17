package com.fati.correlationidjava.client;

import com.fati.correlationidjava.model.TodoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "todo-api-client", url = "${todo.api.client}")
public interface TodoApiClient {

    @GetMapping("/todos")
    ResponseEntity<List<TodoResponse>> getTodos();
}
