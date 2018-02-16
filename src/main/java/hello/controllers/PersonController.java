package hello.controllers;

import hello.repositories.PersonRepository;
import hello.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hello.helpers.*;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    private Response response = new Response();

    @RequestMapping(method=RequestMethod.GET, value="/allPersons", produces = "application/json")
    public ResponseEntity<?> person() {
        //return new ResponseEntity<>(personRepository.findAll(),HttpStatus.OK);
        return new ResponseEntity<>(personRepository.findAll(),HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST, value="/addPerson", produces="application/json")
       public ResponseEntity<?> addPerson(String name, String surname){

        try{
            Person person = new Person(name,surname);
            personRepository.save(person);
            response.setErrorCode(200);
            response.setMessage("Kişi eklendi.");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            response.setErrorCode(500);
            response.setMessage("Kişi eklenemedi.");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method=RequestMethod.POST, value="/updatePerson", produces="application/json")
    public ResponseEntity<?> updatePerson(String id, String name, String surname){
        try {
            Person person = new Person(id,name,surname);
            personRepository.save(person);
            response.setErrorCode(200);
            response.setMessage("Kişi güncellendi.");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            response.setErrorCode(500);
            response.setMessage("Kişi güncellenemedi.");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method=RequestMethod.GET, value="/deletePerson/{id}", produces="application/json")
    public ResponseEntity<?> deletePerson(@PathVariable String id){

        try {
            personRepository.deleteById(id);
            response.setErrorCode(200);
            response.setMessage("Kişi silindi.");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            response.setErrorCode(500);
            response.setMessage("Kişi silinemedi.");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method=RequestMethod.GET, value="/findPerson/{id}")
    public ResponseEntity<?> show(@PathVariable String id) {
        try {
            return new ResponseEntity<>(personRepository.findOne(id),HttpStatus.OK);
        }catch(Exception e){
            response.setErrorCode(500);
            response.setMessage("Kişi bulunamadı.");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}