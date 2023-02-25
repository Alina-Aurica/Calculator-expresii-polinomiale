import GUI.View;
import Model.Monom;
import Model.Operations;
import Model.Polinom;
import controller.Controller;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);

        view.setVisible(true);

        /*
        Monom m1 = new Monom(3, 3);
        Monom m2 = new Monom(4, 1);
        Monom m3 = new Monom(-5, 0);
        Monom m4 = new Monom(-9, 2);

        Polinom p1 = new Polinom();
        p1.addPolinom(m1);
        p1.addPolinom(m2);
        p1.addPolinom(m3);
        p1.addPolinom(m4);

        Monom m5 = new Monom(-2, 0);
        Monom m6 = new Monom(1, 2);

        Polinom p2 = new Polinom();
        p2.addPolinom(m5);
        p2.addPolinom(m6);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println("----------");
        */
        /*
        p1.sortList();
        p2.sortList();
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println("----------");
         */

        //System.out.println(Operations.add(p1, p2).toString());

        //System.out.println(Operations.sub(p1, p2).toString());

        //System.out.println(Operations.mul(p1, p2).toString());

        //System.out.println(Operations.deriv(p2).toString());
        //System.out.println(Operations.integr(p1));

        //Operations.div(p1, p2);
        //System.out.println(Operations.resultCat.toString());
        //System.out.println(Operations.resultRest.toString());

        //System.out.println(p1.regex("2x^3+4x^0"));
    }
}
