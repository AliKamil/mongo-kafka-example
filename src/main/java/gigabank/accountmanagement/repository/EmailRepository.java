package gigabank.accountmanagement.repository;

import gigabank.accountmanagement.entity.UserEmail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailRepository extends MongoRepository<UserEmail, String> {
    UserEmail findByEmail(String email);
}
