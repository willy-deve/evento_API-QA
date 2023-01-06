package eventos_testes.service;

import eventos_testes.dto.CityDTO;
import eventos_testes.entities.City;
import eventos_testes.exception.ResourceNotFoundException;
import eventos_testes.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityService {

    @Autowired
    private CityRepository repository;

    @Transactional(readOnly = true)
    public List<CityDTO>  findAll() {
        List<City> list = repository.findAll(Sort.by("name"));
        return list.stream().map(c -> new CityDTO(c)).collect(Collectors.toList());
    }

    public String deleteCity (Long id){
        try{
            repository.deleteById(id);
            return "City apagada";
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("ID Nâo encontrado" + id);
        }
    }


}
