package br.com.diegoczajka.bookErudio.Services;

import br.com.diegoczajka.bookErudio.Repository.PersonRepository;
import br.com.diegoczajka.bookErudio.data.vo.v1.PersonVO;
import br.com.diegoczajka.bookErudio.exceptions.ResourceNotFoundException;
import br.com.diegoczajka.bookErudio.mapper.DozerMapper;
import br.com.diegoczajka.bookErudio.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired(required = false)
    PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<PersonVO> findAll() {

        return DozerMapper.mapListObjectToListNewObject(repository.findAll(), PersonVO.class);
    }


    public PersonVO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Can not find person with this id!"));
        return DozerMapper.parseObject(entity, PersonVO.class);

    }


    public PersonVO create(PersonVO person) {

        var entity = DozerMapper.parseObject(person, Person.class);

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;


    }

    public PersonVO update(PersonVO person) {
        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Can not find person with this id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;

    }

    public void delete(Long id) {
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Can not find person with this id!"));
        repository.delete(entity);
    }
}
