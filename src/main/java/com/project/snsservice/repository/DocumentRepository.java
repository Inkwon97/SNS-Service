package com.project.snsservice.repository;

import com.project.snsservice.doamin.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {


}
