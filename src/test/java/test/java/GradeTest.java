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

public class GradeTest {

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
    void addAssignmentTest1(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        AtomicInteger teme = new AtomicInteger();
        AtomicInteger teme2 = new AtomicInteger();
        service.findAllTeme().forEach(tema->{
            teme.addAndGet(1);});
        service.saveTema("idTema","tema1",2, 1);
        service.findAllTeme().forEach(tema->{
            teme2.addAndGet(1);});
        int size1 = teme.get();
        int size2 = teme2.get();
        assert size1 +1 == size2;
        service.deleteTema("idTema");
    }

    @Test
    void addGradeTest1(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        AtomicInteger note = new AtomicInteger();
        AtomicInteger note2 = new AtomicInteger();
        service.findAllNote().forEach(nota->{
            note.addAndGet(1);});
        service.saveNota("uniqueId", "idTema", 10, 2, "customFeedback");
        service.findAllNote().forEach(nota->{
            note2.addAndGet(1);});
        int size1 = note.get();
        int size2 = note2.get();
        assert size1 +1 == size2;
        service.deleteTema("idTema");
    }

    @Test
    void addGradeTestComplete(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        service.saveStudent("uniqueId","Daria",932);
        service.saveTema("idTema","tema1",2, 1);

        AtomicInteger note = new AtomicInteger();
        AtomicInteger note2 = new AtomicInteger();
        service.findAllNote().forEach(nota->{
            note.addAndGet(1);});
        service.saveNota("uniqueId", "idTema", 10, 2, "customFeedback");
        service.findAllNote().forEach(nota->{
            note2.addAndGet(1);});
        int size1 = note.get();
        int size2 = note2.get();
        assert size1 +1 == size2;
        service.deleteStudent("uniqueId");
    }

}
