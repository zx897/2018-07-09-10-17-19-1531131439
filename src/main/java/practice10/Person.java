package practice10;

import java.util.Objects;

public class Person {
    private int age;
    private String name;
    private int id;

    public Person(int id, String name, int age) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Person person2 =  (Person)obj;
        if (getClass() != person2.getClass())
            return false;

        if (this.age != person2.age)
            return false;
        if (this.name == null) {
            return person2.name == null;
        } else return this.name.equals(person2.name);
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }

    public boolean isEqualTo(Person per) {
        if (this == per) return true;
        if (per == null || getClass() != per.getClass()) return false;
        return age == per.age &&
                Objects.equals(id, per.id) &&
                Objects.equals(name, per.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String introduce() {
        return "My name is " + this.name + "." + " I am " + this.age + " years old.";
    }

}
