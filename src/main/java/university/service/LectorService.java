package university.service;

import java.util.List;
import university.model.Lector;

public interface LectorService {
    Lector save(Lector lector);

    List<Lector> getByTemplate(String template);
}
