package rossi.gu.controleRifa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rossi.gu.controleRifa.models.Rifa;

@Repository
public interface ControleRifaRepository extends JpaRepository<Rifa, Long> {
}
