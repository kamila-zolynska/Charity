package pl.coderslab.charity.institution;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstitutionService {

  private final InstitutionRepository institutionRepository;

  public List<Institution> findAll() {
    return institutionRepository.findAll();
  }
}
