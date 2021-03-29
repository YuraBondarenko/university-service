package university.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import university.model.Lector;
import university.repository.LectorRepository;
import university.service.LectorService;

@RequiredArgsConstructor
@Service
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    @Override
    public Lector save(Lector lector) {
        return lectorRepository.save(lector);
    }

    @Override
    public List<Lector> getByTemplate(String template) {
        return lectorRepository.findByTemplate(template);
    }
}
