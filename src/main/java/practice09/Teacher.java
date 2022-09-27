package practice09;

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

    public Teacher(int id , String name, int age ) {
        super(id, name,age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id,name,age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }


    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        if(klass == null){return super.introduce() + " I am a Teacher. I teach No Class.";}
        else{
            return super.introduce() + " I am a Teacher. I teach Class " + this.klass.getNumber() + '.';}
    }

    public String introduceWith(Student student) {
        if(student.getKlass() == this.klass){
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        }
        else{
            return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(klass,student.getKlass()) && Objects.equals(this.getAge(),student.getAge()) && Objects.equals(this.getName(), student.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}
