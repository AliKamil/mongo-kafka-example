package gigabank.accountmanagement.service;

import gigabank.accountmanagement.dto.UserDTO;
import gigabank.accountmanagement.entity.BankAccount;
import gigabank.accountmanagement.entity.User;
import gigabank.accountmanagement.mapper.UserMapper;
import gigabank.accountmanagement.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class KafkaService {

  private final BankAccountService bankAccountService;

  @KafkaListener(topics = "${tpd.topic-name}", groupId = "bankAccount")
  public void listen(UserDTO user) {

    bankAccountService.createBankAccountForUser(UserMapper.fromDTO(user)
    );
  }


}
