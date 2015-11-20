package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class ProdusController {
  private List<Produs> produse = new ArrayList<Produs>();

  ProdusController() {
    Produs p1 = new Produs(1, "Apple");
    Produs p2 = new Produs(2, "Samsung");
    Produs p3 = new Produs(3, "Microsoft");

    produse.add(p1);
    produse.add(p2);
    produse.add(p3);
  }

  @RequestMapping(value="/produs", method = RequestMethod.GET)
  public List<Produs> index() {
    return this.produse;
  }

  @RequestMapping(value="/produs/{id}", method = RequestMethod.GET)
  public ResponseEntity showoneprodus(@PathVariable("id") int id) {
    for(Produs p : this.produse) {
      if(p.getId() == id) {
        return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


@RequestMapping(value="/produs/{id} /{name}", method = RequestMethod.POST)
  public ResponseEntity createprodus(@PathVariable("id") int id, @PathVariable("name") String name) {

    Produs prod = new Produs(id,name);
    produse.add(prod);
    return new ResponseEntity<Produs>(prod, new HttpHeaders(), HttpStatus.OK);
  }


  @RequestMapping(value="/produs/{id} /{name}", method = RequestMethod.PUT)
  public ResponseEntity updateprodus(@PathVariable("id") int id, @PathVariable("name") String name) {
    for(Produs p : produse)
    {
      if(id == p.getId())
      {
        p.setName(name);
        return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }

    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


  @RequestMapping(value="/produs/{id}", method = RequestMethod.DELETE)
  public ResponseEntity removeprodus(@PathVariable("id") int id) {
    for(Produs p : this.produse) {
      if(p.getId() == id) {
        this.produse.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}