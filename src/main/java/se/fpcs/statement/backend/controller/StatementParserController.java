package se.fpcs.statement.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import se.fpcs.statement.backend.dto.StatementDto;
import se.fpcs.statement.backend.service.StatementParserService;
import se.fpcs.statement.parser_core.Statement;
import se.fpcs.statement.parser_core.StatementType;

import java.io.File;
import java.io.IOException;

@Controller
public class StatementParserController {

    @Autowired
    private StatementParserService statementParserService;

    @PostMapping("/statement-parser")
    @ResponseBody
    public ResponseEntity<?> parseFile(
            @RequestParam("type") StatementType statementType,
            @RequestParam("file") MultipartFile multipartFile) {

        if (multipartFile.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }

        try {
            File tempFile = File.createTempFile(getClass().getSimpleName(), ".tmp");
            multipartFile.transferTo(tempFile);

            Statement statement = statementParserService.parse(statementType, tempFile);

            return ResponseEntity.ok(statement);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
