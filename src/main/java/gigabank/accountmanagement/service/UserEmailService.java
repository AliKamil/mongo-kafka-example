package gigabank.accountmanagement.service;

import gigabank.accountmanagement.dto.UserDTO;
import gigabank.accountmanagement.entity.UserEmail;
import gigabank.accountmanagement.mapper.UserMapper;
import gigabank.accountmanagement.repository.EmailRepository;
import jakarta.validation.constraints.Email;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserEmailService {

  EmailRepository emailRepository;

  @KafkaListener(topics = "${tpd.topic-name}", groupId = "email")
  public void sendRegistrationEmailListener(UserDTO user) {
    System.out.println("Sending registration email to " + user.getPhoneNumber());
    UserEmail userEmail = new UserEmail();
    userEmail.setEmail("Congratulations! You have successfully registered with the phone number: " + user.getPhoneNumber());
    userEmail.setId(UUID.randomUUID().toString());
    emailRepository.save(userEmail);
    System.out.println(userEmail);
  }
}
