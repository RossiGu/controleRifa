package rossi.gu.controleRifa.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rossi.gu.controleRifa.dtos.ControleRifaDto;
import rossi.gu.controleRifa.models.Rifa;
import rossi.gu.controleRifa.repositories.ControleRifaRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class RifaController {

    @Autowired
    ControleRifaRepository controleRifaRepository;

    @PostMapping("/rifa")
    public ResponseEntity<Rifa> saveRifa(@RequestBody @Valid ControleRifaDto controleRifaDto) {
        var rifa = new Rifa();
        BeanUtils.copyProperties(controleRifaDto, rifa);
        return ResponseEntity.status(HttpStatus.CREATED).body(controleRifaRepository.save(rifa));
    }

    @GetMapping("/rifa")
    public ResponseEntity<List<Rifa>> getAllRifas() {
        return ResponseEntity.status(HttpStatus.OK).body(controleRifaRepository.findAll());
    }

    @GetMapping("/rifa/{id}")
    public ResponseEntity<Object> getOneRifa(@PathVariable(value = "id") Long id) {
        Optional<Rifa> rifaOptional = controleRifaRepository.findById(id);
        if (rifaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rifa não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(rifaOptional.get());
    }

    @PutMapping("rifa/{id}")
    public ResponseEntity<Object> updateRifa(@PathVariable(value = "id") Long id,
                                             @RequestBody @Valid ControleRifaDto controleRifaDto) {
        Optional<Rifa> rifaOptional = controleRifaRepository.findById(id);
        if (rifaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rifa não encontrada!");
        }
        var rifa = rifaOptional.get();
        BeanUtils.copyProperties(controleRifaDto, rifa);
        return ResponseEntity.status(HttpStatus.OK).body(controleRifaRepository.save(rifa));
    }

    @DeleteMapping("/rifa/{id}")
    public ResponseEntity<Object> deleteRifa(@PathVariable(value = "id") Long id) {
        Optional<Rifa> rifaOptional = controleRifaRepository.findById(id);
        if (rifaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rifa não encontrada!");
        }
        controleRifaRepository.delete(rifaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Rifa excluída com sucesso!");
    }

}
