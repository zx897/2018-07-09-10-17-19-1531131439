package practice09;


public class Klass {
    private int number;
    private Student leader;

    public void setNumber(int number) {
        this.number = number;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public void assignLeader(Student student) {
        if (isIn(student)) {
            this.leader = student;
        } else {
            System.out.println("It is not one of us.");
        }

    }

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + this.number;
    }

    public void appendMember(Student student) {
    }
    public boolean isIn(Student student) {
        return student.getKlass() == this;
    }
}
