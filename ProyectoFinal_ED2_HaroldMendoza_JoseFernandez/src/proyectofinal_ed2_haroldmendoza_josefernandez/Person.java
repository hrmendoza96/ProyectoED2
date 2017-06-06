/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_ed2_haroldmendoza_josefernandez;

/**
 *
 * @author Harold Mendoza
 */
public class Person {
    char[] name=  new char[40];
    char[] birthDate= new char[8];//YYYY MM DD
    float salary;
    int weight; //pounds

    public Person(float salary, int weight) {
        this.salary = salary;
        this.weight = weight;
    }

    public char[] getName() {
        return name;
    }

    public void setName(char[] name) {
        this.name = name;
    }

    public char[] getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(char[] birthDate) {
        this.birthDate = birthDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", birthDate=" + birthDate + ", salary=" + salary + ", weight=" + weight + '}';
    }
    
    
    
}

