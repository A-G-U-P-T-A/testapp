package org.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.db.mysql.entity.DocumentEntity;
import org.test.db.mysql.repository.DocumentEntityRepository;

import java.util.List;

@Service
public class DocumentService {
    private final DocumentEntityRepository documentRepository;

    @Autowired
    public DocumentService(DocumentEntityRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<DocumentEntity> searchDocuments(String keyword) {
        return documentRepository.freeTextSearch(keyword);
    }

    public DocumentEntity saveDocument(DocumentEntity document) {
        return documentRepository.save(document);
    }
}
