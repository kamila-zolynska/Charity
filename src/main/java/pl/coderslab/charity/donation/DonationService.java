package pl.coderslab.charity.donation;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonationService {

  private final DonationRepository donationRepository;

  public long sumAllQuantities() {
    return donationRepository.findAll().stream()
        .map(Donation::getQuantity)
        .collect(Collectors.summarizingInt(Integer::intValue))
        .getSum();
  }

  public long countAllDonations() {
    return donationRepository.count();
  }
}
