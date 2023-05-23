package org.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.db.mysql.entity.DocumentEntity;
import org.test.services.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("search")
    public ResponseEntity<List<DocumentEntity>> searchDocuments(@RequestParam("keyword") String keyword) {
        List<DocumentEntity> searchResults = documentService.searchDocuments(keyword);
        return ResponseEntity.ok(searchResults);
    }

    @PostMapping("create")
    public ResponseEntity<DocumentEntity> saveDocument(@RequestBody DocumentEntity document) {
        DocumentEntity savedDocument = documentService.saveDocument(document);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDocument);
    }

}
