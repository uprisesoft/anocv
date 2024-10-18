package ch.uprisesoft.anocv;

import ch.uprisesoft.anocv.model.Document;
import ch.uprisesoft.anocv.model.User;
import ch.uprisesoft.anocv.repository.DocumentRepository;
import ch.uprisesoft.anocv.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
class Initializer implements CommandLineRunner {

	private final UserRepository userRepository;
	private final DocumentRepository documentRepository;

	public Initializer(UserRepository userRepository, DocumentRepository documentRepository) {
		this.userRepository = userRepository;
		this.documentRepository = documentRepository;
	}

	@Override
	public void run(String... strings) {

		User u1 = userRepository.save(new User("The Debugger!", "masterofthe@universe.gov"));
		User u2 = userRepository.save(new User("Albus Dumbledore", "bla@hogwarts.edu"));
		User u3 = userRepository.save(new User("Tom Riddle", "boo@deatheaters.com"));

		Document d1 = documentRepository.save(new Document("asdasd", "xxxxxxx", "yyyyyyyyyy", u1));
		Document d2 = documentRepository.save(new Document("blrbl", "xxxxxxx", "yyyyyyyyyy", u1));
		Document d3 = documentRepository.save(new Document("lalalal", "aaaaaaaaaa", "bbbbbbbb", u2));
		Document d4 = documentRepository.save(new Document("reugf", "aaaaaaaaaa", "bbbbbbbb", u2));

		userRepository.findAll().forEach(System.out::println);
		documentRepository.findAll().forEach(System.out::println);
	}
}
