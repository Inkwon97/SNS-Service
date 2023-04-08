package com.project.snsservice.service;

import com.project.snsservice.doamin.dto.DocumentDto;
import com.project.snsservice.doamin.type.SearchType;
import com.project.snsservice.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class DocumentService {

    private final DocumentRepository documentRepository;


    @Transactional(readOnly = true)
    public Page<DocumentDto> searchDocuments(SearchType title, String search_keyword) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public DocumentDto searchDocument(long documentId) {
        return null;
    }

    public void updateArticle(long documentId, DocumentDto dto) {

    }

    public void deleteDocument(long documentId) {

    }
}
