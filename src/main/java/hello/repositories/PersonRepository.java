package hello.repositories;

import hello.models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends MongoRepository<Person, String> {

    void deleteById(String id);
    //List<Person> findByLastName(@Param("name") String name);

}