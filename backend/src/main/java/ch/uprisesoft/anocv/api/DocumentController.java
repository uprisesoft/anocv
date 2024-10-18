package ch.uprisesoft.anocv.api;

import ch.uprisesoft.anocv.model.Document;
import ch.uprisesoft.anocv.repository.DocumentRepository;
import ch.uprisesoft.anocv.repository.UserRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

	private final Logger log = LoggerFactory.getLogger(DocumentController.class);
	private final DocumentRepository documentRepository;
	private final UserRepository userRepository;

	public DocumentController(DocumentRepository documentRepository, UserRepository userRepository) {
		this.documentRepository = documentRepository;
		this.userRepository = userRepository;
	}

	@GetMapping()
	List<Document> getAllDocuments() {
		log.info("Request to get all documents");
		return documentRepository.findAll();
	}

	@GetMapping("/{id}")
	ResponseEntity<?> getDocument(@PathVariable Long id) {
		log.info("Request to get document: {}", id);
		Optional<Document> document = documentRepository.findById(id);
		return document.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("")
	ResponseEntity<Document> createDocument(@Valid @RequestBody Document document) throws URISyntaxException {
		log.info("Request to create document: {}", document);
		Document result = documentRepository.save(document);
		return ResponseEntity.created(new URI("/api/document/" + result.getId())).body(result);
	}

	@PutMapping("/{id}")
	ResponseEntity<Document> updateDocument(@Valid @RequestBody Document document) {
		log.info("Request to update document: {}", document);
		Document result = documentRepository.save(document);
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDocument(@PathVariable Long id) {
		log.info("Request to delete document: {}", id);
		documentRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
