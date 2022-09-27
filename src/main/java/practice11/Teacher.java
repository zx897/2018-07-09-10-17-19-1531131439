package practice11;

import java.util.LinkedList;
import java.util.Objects;


public class Teacher extends Person {
    private Klass klass;
    private int id;
    private int age;
    LinkedList<Klass> linkedList = new LinkedList<>();

    public LinkedList<Klass> getClasses() {
        return this.linkedList;
    }


    public void setClasses(LinkedList<Klass> linkedList) {
        this.linkedList = linkedList;
    }

    public Teacher(int id, String name, int age, Klass klass, LinkedList<Klass> linkedList) {
        super(id, name, age);
        this.klass = klass;
        this.linkedList = linkedList;
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> linkedList) {
        super(id, name, age);
        linkedList.forEach(klass1 -> klass1.setTeacher(this));
        this.linkedList = linkedList;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    @Override
    public String introduce(){
        String introduction = super.introduce() + " I am a Teacher. I teach ";
        if (this.linkedList.isEmpty()) {
            introduction += "No Class.";
        } else {
            String klassNumbers = "";
            for (Klass allKlass : this.linkedList) {
                klassNumbers += allKlass.getNumber() + ", ";
            }
            introduction += "Class " + klassNumbers.substring(0, klassNumbers.length() - 2) + ".";
        }
        return introduction;
    }

    public String introduceWith(Student student) {
        for (Klass list : this.linkedList) {
            if (list.isIn(student)) {
                return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
            } else {
                return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(klass, student.getKlass()) && Objects.equals(this.getAge(), student.getAge()) && Objects.equals(this.getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isTeaching(Student student) {
        var klassesList = this.getClasses();

        for (Klass list : linkedList) {
            return list.isIn(student);
        }
        return false;
    }
}