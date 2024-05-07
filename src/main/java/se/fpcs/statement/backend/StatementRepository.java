package se.fpcs.statement.backend;

import se.fpcs.statement.parser_core.Statement;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRepository extends JpaRepository<Statement, UUID> {
    // You can define custom query methods here if needed
}

