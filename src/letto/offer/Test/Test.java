package letto.offer.Test;

import javax.rmi.CORBA.StubDelegate;
import java.util.Vector;

public class Test {
    static class student{
        int id;

        public student(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
    public static void main(String[] args) {
        Vector<student> v = new Vector(10);
        for (int i = 0; i<10; i++){
            student s = new student(i);
            v.add(s);
            s = null;
        }
        System.out.println(v.get(1).getId());
    }
}
