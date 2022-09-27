package practice10;

import java.util.LinkedList;
import java.util.Objects;


public class Teacher extends Person {
    private Klass klass;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    private LinkedList<Klass> linkedList = new LinkedList<>();

    public LinkedList<Klass> getClasses() {
        return this.linkedList;
    }

    public Teacher(int id, String name, int age, Klass klass, LinkedList<Klass> linkedList) {
        super(id, name, age);
        this.klass = klass;
        this.linkedList = linkedList;
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> linkedList) {
        super(id, name, age);
        this.linkedList = linkedList;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }


    public String introduce(){
        String introduction = super.introduce() + " I am a Teacher. I teach ";
        if (this.linkedList.isEmpty()) {
            introduction += "No Class.";
        } else {
            StringBuilder klassNumbers = new StringBuilder();
            for (Klass allKlass : this.linkedList) {
                klassNumbers.append(allKlass.getNumber()).append(", ");
            }
            introduction += "Class " + klassNumbers.substring(0, klassNumbers.length() - 2) + ".";
        }
        return introduction;
    }


    public String introduceWith(Student student) {
        for(Klass list : this.linkedList){
            if (student.getKlass() == list) {
                return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
            }
        }
        return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
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
        return Objects.hash(this.getId());
    }

    public boolean isTeaching(Student student) {
        LinkedList<Klass> linkedList = this.getClasses();

        for (Klass list : linkedList) {
            return list.isIn(student);
        }
        return false;
    }
}