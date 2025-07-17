package com.fati.correlationidjava.model;

public record TodoResponse(Long id, Long userId, String title, boolean completed) {
}
