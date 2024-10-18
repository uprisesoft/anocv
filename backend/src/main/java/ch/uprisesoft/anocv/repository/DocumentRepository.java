package ch.uprisesoft.anocv.repository;

import ch.uprisesoft.anocv.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
