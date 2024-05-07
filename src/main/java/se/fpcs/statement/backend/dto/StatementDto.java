package se.fpcs.statement.backend.dto;

import lombok.NonNull;
import se.fpcs.statement.parser_core.StatementRow;
import se.fpcs.statement.parser_core.StatementType;

import java.util.List;

public class StatementDto {
    private String person;
    private String statementType;
    private String accountNumber;
    private List<String> rows;
}
