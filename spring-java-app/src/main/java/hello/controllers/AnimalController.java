package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;


@RestController
public class AnimalController {
  private List<Animal> animale = new ArrayList<Animal>();

  AnimalController() {
    Animal a1 = new Animal(1, "Vierme");
    Animal a2 = new Animal(2, "Soparla");
    Animal a3 = new Animal(3, "Hiena");

    animale.add(a1);
    animale.add(a2);
    animale.add(a3);
  }

  @RequestMapping(value="/animal", method = RequestMethod.GET)
  public List<Animal> index() {
    return this.animale;
  }

   @RequestMapping(value="/animal", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Animal a)    
  {
       animale.add(a);
        
       return new ResponseEntity<Animal>(a, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/animal/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Animal a : this.animale) {
      if(a.getId() == id) {
        return new ResponseEntity<Animal>(a, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  
   @CrossOrigin
   @RequestMapping(value="/animal/{id}", method = RequestMethod.PUT)
  public List<Animal> update(@PathVariable("id") int id,@PathVariable("nume") String nume) {
    for(Animal a : this.animale) {
      if(a.getId() == id) {
        a.setName(nume);   
      }
    }
    return this.animale;
  }

  @CrossOrigin
  @RequestMapping(value="/animal/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Animal a : this.animale) {
      if(a.getId() == id) {
        this.animale.remove(a);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}