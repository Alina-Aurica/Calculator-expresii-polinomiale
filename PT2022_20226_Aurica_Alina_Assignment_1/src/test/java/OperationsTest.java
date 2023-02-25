import Model.Monom;
import Model.Operations;
import Model.Polinom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationsTest {
    private static Operations op;

    //public static Polinom p1;
    //public static Polinom p2;

    /*
    @BeforeAll
    public static void init(){
        Monom m1 = new Monom(-6, 3);
        Monom m2 = new Monom(7, 2);

        p1.addPolinom(m1);
        p1.addPolinom(m2);

        Monom m3 = new Monom(3, 2);
        Monom m4 = new Monom(5, 3);

        p2.addPolinom(m3);
        p2.addPolinom(m4);
    }
     */

    @Test
    public void addOperationsTest(){
        op = new Operations();

        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();

        Monom m1 = new Monom(-6, 3);
        Monom m2 = new Monom(7, 2);

        p1.addPolinom(m1);
        p1.addPolinom(m2);

        Monom m3 = new Monom(3, 2);
        Monom m4 = new Monom(5, 3);

        p2.addPolinom(m3);
        p2.addPolinom(m4);

        Polinom res = new Polinom();

        Monom mr1 = new Monom(10, 2);
        Monom mr2 =  new Monom(-1, 3);
        res.addPolinom(mr2);
        res.addPolinom(mr1);

        assertEquals(res.toString(), op.add(p1, p2).toString());
    }

    @Test
    public void subOperationsTest(){
        op = new Operations();

        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();

        Monom m1 = new Monom(-6, 3);
        Monom m2 = new Monom(7, 2);

        p1.addPolinom(m1);
        p1.addPolinom(m2);

        Monom m3 = new Monom(3, 2);
        Monom m4 = new Monom(5, 3);

        p2.addPolinom(m3);
        p2.addPolinom(m4);

        Polinom res = new Polinom();

        Monom mr1 = new Monom(4, 2);
        Monom mr2 =  new Monom(-11, 3);
        res.addPolinom(mr2);
        res.addPolinom(mr1);

        assertEquals(res.toString(), op.sub(p1, p2).toString());
    }

    @Test
    public void mulOperationsTest(){
        op = new Operations();

        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();

        Monom m1 = new Monom(-6, 3);
        Monom m2 = new Monom(7, 2);

        p1.addPolinom(m1);
        p1.addPolinom(m2);

        Monom m3 = new Monom(3, 2);
        Monom m4 = new Monom(5, 3);

        p2.addPolinom(m3);
        p2.addPolinom(m4);

        Polinom res = new Polinom();

        Monom mr1 = new Monom(17, 5);
        Monom mr2 =  new Monom(21, 4);
        Monom mr3 =  new Monom(-30, 6);
        res.addPolinom(mr1);
        res.addPolinom(mr3);
        res.addPolinom(mr2);

        assertEquals(res.toString(), op.mul(p1, p2).toString());
    }

    @Test
    public void divOperationsTest(){
        op = new Operations();

        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();

        Monom m1 = new Monom(-6, 3);
        Monom m2 = new Monom(7, 2);
        p1.addPolinom(m1);
        p1.addPolinom(m2);
        Monom m3 = new Monom(3, 2);
        Monom m4 = new Monom(1, 3);
        p2.addPolinom(m3);
        p2.addPolinom(m4);

        Polinom resCat = new Polinom();
        Polinom resRest = new Polinom();

        Monom mr1 = new Monom(25, 2);
        Monom mr2 =  new Monom(-6, 0);
        resRest.addPolinom(mr1);
        resCat.addPolinom(mr2);

        op.div(p1, p2);

        assertEquals(resCat.toString(), op.resultCat.toString());
        assertEquals(resRest.toString(), op.resultRest.toString());
    }

    @Test
    public void derivOperationsTest(){
        op = new Operations();

        Polinom p1 = new Polinom();

        Monom m1 = new Monom(-6, 3);
        Monom m2 = new Monom(7, 2);

        p1.addPolinom(m1);
        p1.addPolinom(m2);

        Polinom res = new Polinom();

        Monom mr1 = new Monom(-18, 2);
        Monom mr2 =  new Monom(14, 1);
        res.addPolinom(mr1);
        res.addPolinom(mr2);

        assertEquals(res.toString(), op.deriv(p1).toString());
    }

    @Test
    public void integrOperationsTest(){
        op = new Operations();

        Polinom p1 = new Polinom();

        Monom m1 = new Monom(-6, 3);
        Monom m2 = new Monom(7, 2);

        p1.addPolinom(m1);
        p1.addPolinom(m2);

        String res = new String();
        //res = op.integr(p1);
        res = " 7*1/3*x^3 + (-6)*1/4*x^4 + C";

        assertEquals(res, op.integr(p1));
    }



}
