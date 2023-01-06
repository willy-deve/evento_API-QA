package eventos_testes.dto;

import eventos_testes.entities.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityDTO {

    private Long id;
    private String name;

    public CityDTO(City entity) {
        this.setId(entity.getId());
        this.setName(entity.getName());
    }
}
