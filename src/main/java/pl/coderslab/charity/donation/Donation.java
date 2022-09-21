package pl.coderslab.charity.donation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

@Entity
@Getter
@Setter
@Table(name = "donation")
public class Donation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Digits(message = "Należy podać liczbę całkowitą.", integer = 100, fraction = 1)
  private Integer quantity;

  @OneToMany
  private List<Category> categories;

  @ManyToOne
  @NotBlank (message = "Pole instytucja nie może być puste.")
  private Institution institution;

  private String street;

  @NotBlank (message = "Pole miejscowość nie może być puste.")
  private String city;

  @NotBlank (message = "Pole kod pocztowy nie może być puste.")
  @Column(name = "zip_code")
  private String zipCode;

  @NotNull(message = "Należy wybrać datę odbioru.")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "pick_up_date")
  private LocalDate pickUpDate;

  @NotNull(message = "Należy wybrać godzinę odbioru.")
  @DateTimeFormat(pattern = "HH:mm")
  @Column(name = "pick_up_time")
  private LocalTime pickUpTime;

  @Length(max = 100)
  @Nullable
  @Column(name = "pick_up_comment")
  private String pickUpComment;
}
