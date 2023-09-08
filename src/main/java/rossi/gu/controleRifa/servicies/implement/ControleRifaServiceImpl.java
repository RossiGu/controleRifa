package rossi.gu.controleRifa.servicies.implement;

import org.springframework.beans.factory.annotation.Autowired;
import rossi.gu.controleRifa.models.Rifa;
import rossi.gu.controleRifa.repositories.ControleRifaRepository;
import rossi.gu.controleRifa.servicies.ControleRifaService;

import java.util.List;

public class ControleRifaServiceImpl implements ControleRifaService {

    @Autowired
    ControleRifaRepository controleRifaRepository;

    @Override
    public List<Rifa> findAll() {
        return controleRifaRepository.findAll();
    }

    @Override
    public Rifa findById(Long id) {
        return controleRifaRepository.findById(id).get();
    }

    @Override
    public Rifa save(Rifa rifa) {
        return controleRifaRepository.save(rifa);
    }
}
