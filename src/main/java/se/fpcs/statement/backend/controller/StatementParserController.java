package se.fpcs.statement.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class StatementParserController {

    @PostMapping("/statement-parser")
    @ResponseBody
    public ResponseEntity<String> parseFile(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }

        try {
            File tempFile = File.createTempFile(getClass().getSimpleName(), ".tmp");
            file.transferTo(tempFile);
            return ResponseEntity.ok(tempFile.getAbsolutePath());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
