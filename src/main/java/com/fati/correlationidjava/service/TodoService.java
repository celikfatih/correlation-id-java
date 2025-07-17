package com.fati.correlationidjava.service;

import com.fati.correlationidjava.client.TodoApiClient;
import com.fati.correlationidjava.model.TodoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoApiClient todoApiClient;

    public List<TodoResponse> getTodos() {
        ResponseEntity<List<TodoResponse>> todos = todoApiClient.getTodos();

        if (todos.getStatusCode().isError() || !todos.hasBody()) {
            log.warn("Error while fetching todos!");
            return Collections.emptyList();
        }

        log.info("Todos fetched successfully!");
        return todos.getBody();
    }
}
