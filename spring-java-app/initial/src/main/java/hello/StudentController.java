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
public class StudentController {
  private List<Student> Studenti = new ArrayList<Student>();

  StudentController() {
    Student s1 = new Student(1, "Ion");
    Student s2 = new Student(2, "Vlad");
    Student s3 = new Student(3, "Alex");

    Studenti.add(s1);
    Studenti.add(s2);
    Studenti.add(s3);
  }

  @RequestMapping(value="/student", method = RequestMethod.GET)
  public List<Student> index() {
    return this.Studenti;
  }

  @RequestMapping(value="/student/{id}", method = RequestMethod.GET)
  public ResponseEntity showonestud(@PathVariable("id") int id) {
    for(Student s : this.Studenti) {
      if(s.getId() == id) {
        return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


@RequestMapping(value="/student/{id} /{name}", method = RequestMethod.POST)
  public ResponseEntity createstud(@PathVariable("id") int id, @PathVariable("name") String name) {

    Student stud = new Student(id,name);
    Studenti.add(stud);
    return new ResponseEntity<Student>(stud, new HttpHeaders(), HttpStatus.OK);
  }


  @RequestMapping(value="/student/{id} /{name}", method = RequestMethod.PUT)
  public ResponseEntity updatestud(@PathVariable("id") int id, @PathVariable("name") String name) {
    for(Student s : Studenti)
    {
      if(id == s.getId())
      {
        s.setName(name);
        return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }

    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


  @RequestMapping(value="/student/{id}", method = RequestMethod.DELETE)
  public ResponseEntity removestud(@PathVariable("id") int id) {
    for(Student s : this.Studenti) {
      if(s.getId() == id) {
        this.Studenti.remove(s);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}