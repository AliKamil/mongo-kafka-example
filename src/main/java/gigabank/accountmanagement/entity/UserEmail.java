package gigabank.accountmanagement.entity;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserEmail {

  @Id
  private String id;
  private String email;


}
