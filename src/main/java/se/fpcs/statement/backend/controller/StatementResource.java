package se.fpcs.statement.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.fpcs.statement.backend.StatementService;
import se.fpcs.statement.backend.service.StatementParserService;
import se.fpcs.statement.parser_core.Statement;

@RestController
@RequestMapping("/api/statements")
public class StatementResource {

    @Autowired
    private StatementService statementService;

    @PostMapping
    public ResponseEntity<Statement> createProduct(@RequestBody Statement statement) {

        Statement savedProduct = statementService.create(statement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);

    }
}
