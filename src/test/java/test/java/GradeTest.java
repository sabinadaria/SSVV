package test.java;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class GradeTest {


    static String temaLabFileName ="TemaLaboratorIntegrationTestXML.xml";
    static String studentFileName ="StudentiXMLIntegrationTestXML.xml";

    static String notaLabFileName ="NotaIntegrationTestXML.xml";
    private static Service service;

    @BeforeAll

    static void deleteFiles(){
        File f = new File(temaLabFileName);
        f.delete();
        f = new File(studentFileName);
        f.delete();
        f = new File(notaLabFileName);
        f.delete();
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, studentFileName);
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, temaLabFileName);
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, notaLabFileName);

        service = new Service(fileRepository1, fileRepository2, fileRepository3);
        service.saveTema("idGrade","tema1",2, 1);
        service.saveStudent("idGrade","Daria",932);
    }


    @Test
    void addStudentTest1(){

        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent("uniqueId","Daria",932);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();
        service.deleteStudent("uniqueId");

        assert size1 +1 == size2;
    }

    @Test
    void addAssignmentTest1(){

        AtomicInteger teme = new AtomicInteger();
        AtomicInteger teme2 = new AtomicInteger();
        service.findAllTeme().forEach(tema->{
            teme.addAndGet(1);});
        service.saveTema("idTema","tema1",2, 1);
        service.findAllTeme().forEach(tema->{
            teme2.addAndGet(1);});
        int size1 = teme.get();
        int size2 = teme2.get();
        service.deleteTema("idTema");

        assert size1 +1 == size2;
    }

    @Test
    void addGradeTest1(){

        AtomicInteger note = new AtomicInteger();
        AtomicInteger note2 = new AtomicInteger();
        service.findAllNote().forEach(nota->{
            note.addAndGet(1);});
        service.saveNota("idGrade", "idGrade", 10, 2, "customFeedback");
        service.findAllNote().forEach(nota->{
            note2.addAndGet(1);});
        int size1 = note.get();
        int size2 = note2.get();
        assert size1 +1 == size2;

    }

    @Test
    void addGradeTestComplete(){

        service.saveStudent("uniqueId3","Daria",932);
        service.saveTema("idTema3","tema1",2, 1);

        AtomicInteger note = new AtomicInteger();
        AtomicInteger note2 = new AtomicInteger();
        service.findAllNote().forEach(nota->{
            note.addAndGet(1);});
        service.saveNota("uniqueId3", "idTema3", 10, 2, "customFeedback");
        service.findAllNote().forEach(nota->{
            note2.addAndGet(1);});
        int size1 = note.get();
        int size2 = note2.get();
        service.deleteStudent("uniqueId3");
        service.deleteTema("idTema3");

        assert size1 +1 == size2;
    }


    @Test
    void addStudentTestTD(){

        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent("uniqueId","Daria",932);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();
        service.deleteStudent("uniqueId");

        assert size1 +1 == size2;
    }

    @Test
    void addAssignmentTestTD(){

        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent("uniqueId","Daria",932);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();


        AtomicInteger teme = new AtomicInteger();
        AtomicInteger teme2 = new AtomicInteger();
        service.findAllTeme().forEach(tema->{
            teme.addAndGet(1);});
        service.saveTema("idTema","tema1",2, 1);
        service.findAllTeme().forEach(tema->{
            teme2.addAndGet(1);});
        int size3 = teme.get();
        int size4 = teme2.get();

        service.deleteStudent("uniqueId");
        service.deleteTema("idTema");

        assert size3 +1 == size4;
        assert size1 +1 == size2;
    }

    @Test
    public void addGradeTestTD(){


        AtomicInteger students = new AtomicInteger();
        AtomicInteger students2 = new AtomicInteger();
        service.findAllStudents().forEach(stud->{
            students.addAndGet(1);});
        service.saveStudent("uniqueId2","Daria",932);
        service.findAllStudents().forEach(stud->{
            students2.addAndGet(1);});
        int size1 = students.get();
        int size2 = students2.get();
        assert size1 +1 == size2;

        AtomicInteger teme = new AtomicInteger();
        AtomicInteger teme2 = new AtomicInteger();
        service.findAllTeme().forEach(tema->{
            teme.addAndGet(1);});
        service.saveTema("idTema2","tema1",2, 1);
        service.findAllTeme().forEach(tema->{
            teme2.addAndGet(1);});
        int size3 = teme.get();
        int size4 = teme2.get();
        assert size3 +1 == size4;

        AtomicInteger note = new AtomicInteger();
        AtomicInteger note2 = new AtomicInteger();
        service.findAllNote().forEach(nota->{
            note.addAndGet(1);});
        service.saveNota("uniqueId2", "idTema2", 10, 2, "customFeedback");
        service.findAllNote().forEach(nota->{
            note2.addAndGet(1);});
        int size5 = note.get();
        int size6 = note2.get();
        assert size5 +1 == size6;
        service.deleteStudent("uniqueId2");
        service.deleteTema("idTema2");
    }


}
