package practice11;

public class Klass {
    private int number;
    private Student leader;
    private Teacher teacher;

    public void setNumber(int number) {
        this.number = number;
    }

    public Student getLeader() {
        return this.leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public void assignLeader(Student student) {
        if (isIn(student)) {
            this.leader = student;
            if (this.teacher != null){
                System.out.print("I am " + this.getTeacher().getName() + ". I know " + student.getName() +" become Leader of " + this.number + ".");
            }

        }
        else {
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

    public String appendMember(Student student) {
        student.setKlass(this);
        if (this.teacher != null) {
            System.out.println("I am " + this.getTeacher().getName() + ". I know " + student.getName() + " has joined Class " + this.number + ".");
        }
        return null;
    }

    public boolean isIn(Student student) {
        boolean klassJudg = (student.getKlass() == this);
        return klassJudg;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public  Teacher getTeacher() {
        return this.teacher;
    }
}
