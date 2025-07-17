# Correlation ID Java (Spring Boot)

A sample Spring Boot project demonstrating how to implement and propagate correlation IDs for distributed tracing and logging. This project shows how to generate, propagate, and log correlation IDs in a microservices environment, including optional support for FeignClient.

## Introduction

In distributed systems, tracing a request across multiple services can be challenging. Correlation IDs are unique identifiers attached to each request, making it easy to follow a request's journey through logs and across service boundaries. This project demonstrates how to:

- Generate or extract a correlation ID for each incoming HTTP request
- Log the correlation ID with every log entry
- (Optionally) Propagate the correlation ID to downstream services using FeignClient

## Features

- **CorrelationIdFilter**: Servlet filter to manage correlation IDs
- **MDC Logging**: Logback configuration to include correlation IDs in logs
- **FeignClient Propagation**: (Optional) Propagate correlation IDs in outgoing HTTP requests
- **Sample Controller & Service**: Example endpoints and Feign client usage

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+

### Running the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## Usage

- Send a request to the sample endpoint (e.g., `/todos`).
- The application will generate or extract a correlation ID from the `X-Correlation-Id` header.
- All logs for the request will include the correlation ID.
- If FeignClient is enabled and used, the correlation ID will be propagated to downstream services.

### Example Request

```bash
curl -X GET http://localhost:8080/todos
```

### Example Logs

```
2025-07-17 | 14:33:39.765 | http-nio-8080-exec-1 | INFO  | o.s.w.s.DispatcherServlet    | correlationId:             | Initializing Servlet 'dispatcherServlet'
2025-07-17 | 14:33:39.787 | http-nio-8080-exec-1 | DEBUG | c.f.c.c.TodoApiClient        | correlationId: 44626021-7f62-4462-94e8-e5a1454899cc | [TodoApiClient#getTodos] ---> GET https://jsonplaceholder.typicode.com/todos HTTP/1.1
```

## FeignClient Correlation ID Propagation (Optional)

If your service calls other services using `FeignClient`, correlation IDs are automatically added to outgoing requests via a `RequestInterceptor`. See `TodoApiFeignConfig.java` for details.

## License

This project is licensed under the MIT License.
