package test.java;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.jupiter.api.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import java.util.List;

public class AssignmentTest {

@Test
    void testCase1(){
    //success
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
    List<Tema> teme = (List<Tema>)service.findAllTeme();
    int size = teme.size();
    service.saveTema("id1", "descriere1", 2, 1);

    List<Tema> teme2= (List<Tema>)service.findAllTeme();
    int size2 = teme2.size();

    assert(size + 1 == size2);

}

@Test
    void testCase2(){
    //failure
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

    List<Tema> teme = (List<Tema>)service.findAllTeme();
    int size = teme.size();
    service.saveTema("", "descriere1", 2, 1);

    List<Tema> teme2= (List<Tema>)service.findAllTeme();
    int size2 = teme2.size();

    assert(size == size2);
}

@Test
void testCase3(){
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

    List<Tema> teme = (List<Tema>)service.findAllTeme();
    int size = teme.size();
    service.saveTema(null, "descriere1", 2, 1);

    List<Tema> teme2= (List<Tema>)service.findAllTeme();
    int size2 = teme2.size();

    assert(size == size2);
}


}
