package eventos_testes.resource;


import eventos_testes.dto.EventDTO;
import eventos_testes.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    @Autowired
    private EventService service;

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@RequestBody EventDTO dto, @PathVariable Long id){
        EventDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

}
