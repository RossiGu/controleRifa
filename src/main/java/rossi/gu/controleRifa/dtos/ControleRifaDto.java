package rossi.gu.controleRifa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ControleRifaDto(@NotNull Integer number, @NotBlank String name, @NotNull Integer quantity) {
}
