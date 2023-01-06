package eventos_testes.dto;


import eventos_testes.entities.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventDTO {

    private Long id;
    private String name;
    private LocalDate date;
    private String url;
    private Long cityId;

    public EventDTO(Event entity){
        this.setId(entity.getId());
        this.setName(entity.getName());
        this.setDate(entity.getDate());
        this.setUrl(entity.getUrl());
        cityId = entity.getCity().getId();
    }

}
