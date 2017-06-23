package proyectofinal_ed2_haroldmendoza_josefernandez;

public class Person {
    char estadoRecord;
    String name;//maximo 40 char
    String birthDate;//YYYY MM DD // maximo 10 char
    float salary;
    int id; 
    

    public Person(float salary, int id) {
        this.salary = salary;
        this.id = id;
    }

    public Person() {
    }

    public char getEstadoRecord() {
        return estadoRecord;
    }

    public void setEstadoRecord(char estadoRecord) {
        this.estadoRecord = estadoRecord;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" + "estadoRecord=" + estadoRecord + ", name=" + name + ", birthDate=" + birthDate + ", salary=" + salary + ", id=" + id + '}';
    }

    
    
    
    
}

