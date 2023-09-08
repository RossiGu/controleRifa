package rossi.gu.controleRifa.servicies;

import rossi.gu.controleRifa.models.Rifa;

import java.util.List;

public interface ControleRifaService {

    List<Rifa> findAll();
    Rifa findById(Long id);
    Rifa save(Rifa rifa);
}
