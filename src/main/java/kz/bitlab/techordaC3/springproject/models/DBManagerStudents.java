package kz.bitlab.techordaC3.springproject.models;

import java.util.ArrayList;

public class DBManagerStudents {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Long id = 5L;

    static {
        students.add(new Student(1L,"Abai","Amangeldiuly",89,"B"));
        students.add(new Student(2L,"Adilzhan","Babakhan",90,"A"));
        students.add(new Student(3L,"Ruslan","Senky",74,"C"));
        students.add(new Student(4L,"Dimash","Nabi",50,"D"));

    }
    public static void addStudent(Student student) {
        students.add(student);
        student.setId(id);
        id++;
        if(student.getExam() >= 90) {
            student.setMark("A");
        } else if(student.getExam() >= 75 && student.getExam() <= 89) {
            student.setMark("B");
        } else if (student.getExam() >= 60 && student.getExam() <= 74) {
            student.setMark("C");
        } else if (student.getExam() >=50 && student.getExam() <= 59) {
            student.setMark("D");
        } else if (student.getExam() < 50){
            student.setMark("F");
        } else {
            student.setMark("Error");
        }
    }
    public static ArrayList<Student> getAllStudents() {
        return students;
    }
    public static Student getStudent(Long id) {
        return students.stream().filter(s -> s.getId()==id).findFirst().orElseThrow();
    }
}
