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

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentTest {
    @Test
    void addStudentTest1(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent("uniqueId","Daria",932);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();
        assert size1 +1 == size2;
        service.deleteStudent("uniqueId");
    }
    @Test
    void addStudentTest2(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        AtomicInteger students3 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent("uniqueId","Daria",932);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();
        assert size1 +1 == size2;
        service.saveStudent("uniqueId","Daria",932);
        service.findAllStudents().forEach(stud->{
            students3.addAndGet(1);});
        int size3 = students3.get();
        assert size3  ==size2;
        service.deleteStudent("uniqueId");
    }

    @Test
    void addStudentTest3(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent("uniqueId","Daria",110);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();
        assert size1 == size2;
    }

    @Test
    void addStudentTest4(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent("uniqueId","Daria",111);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();
        assert size1 +1 == size2;
    }

    @Test
    void addStudentTest5(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent("uniqueId","Daria",938);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();
        assert size1 == size2;
    }

    @Test
    void addStudentTest6(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent("uniqueId","Daria",937);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();
        assert size1 +1 == size2;
    }

    @Test
    void addStudentTest7(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent("","Daria",932);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();
        assert size1 == size2;
    }

    @Test
    void addStudentTest8(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent(null,"Daria",932);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();
        assert size1 == size2;
    }

    @Test
    void addStudentTest9(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent("uniqueId","",932);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();
        assert size1 == size2;
    }

    @Test
    void addStudentTest10(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent("uniqueId",null,932);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();
        assert size1 == size2;
    }

}
