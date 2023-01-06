package eventos_testes.resource;

import eventos_testes.dto.CityDTO;
import eventos_testes.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityControler {

    @Autowired
    private CityService service;

    @GetMapping()
    public ResponseEntity<List<CityDTO>> findAll() {
        List<CityDTO> dtoList = service.findAll();
        return ResponseEntity.ok().body(dtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.deleteCity(id);
        return ResponseEntity.noContent().build();
    }

}
