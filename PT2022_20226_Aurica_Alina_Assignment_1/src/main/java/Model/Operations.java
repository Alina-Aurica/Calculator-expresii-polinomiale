package Model;

import java.util.ArrayList;

// de schimbat numele la pachete - trebe sa inceapa cu litera mica
// nu ma lasa sa incarc pe git - intreaba laborantul
public class Operations {

    public static Polinom add(Polinom polinom1, Polinom polinom2) {
        Polinom result = new Polinom();

        for (Monom p1 : polinom1.getPolinom()) {
            for (Monom p2 : polinom2.getPolinom()) {
                if (p1.getPutere() == p2.getPutere()) {
                    p1.setEsteVizitat( true );
                    p2.setEsteVizitat( true );
                    Monom var = new Monom(p1.getCoef() + p2.getCoef(), p1.getPutere());
                    result.addPolinom(var);
                }
            }
        }

        for (Monom p1 : polinom1.getPolinom()){
            if(p1.getEsteVizitat() == false)
                result.addPolinom(p1);
        }

        for (Monom p2 : polinom2.getPolinom()){
            if(p2.getEsteVizitat() == false)
                result.addPolinom(p2);
        }
        return result;
    }

    public static Polinom sub(Polinom polinom1, Polinom polinom2) {
        Polinom result = new Polinom();

        for (Monom p1 : polinom1.getPolinom()) {
            for (Monom p2 : polinom2.getPolinom()) {
                if (p1.getPutere() == p2.getPutere()) {
                    p1.setEsteVizitat( true );
                    p2.setEsteVizitat( true );
                    Monom var = new Monom(p1.getCoef() - p2.getCoef(), p1.getPutere());
                    result.addPolinom(var);
                }
            }
        }

        for (Monom p1 : polinom1.getPolinom()){
            if(p1.getEsteVizitat() == false) {
                result.addPolinom(p1);
            }
        }

        for (Monom p2 : polinom2.getPolinom()){
            if(p2.getEsteVizitat() == false) {
                Monom var = new Monom(0 - p2.getCoef(), p2.getPutere());
                result.addPolinom(var);
            }
        }

        return result;
    }

    public static Polinom mul(Polinom polinom1, Polinom polinom2) {
        Polinom result = new Polinom();

        for (Monom p1 : polinom1.getPolinom()) {
            for (Monom p2 : polinom2.getPolinom()) {
                Monom var = new Monom(p1.getCoef() * p2.getCoef(), p1.getPutere() + p2.getPutere());
                result.addPolinom(var);
            }
        }
        result.sim();

        return result;

    }

    public static Polinom resultCat = new Polinom();
    public static Polinom resultRest = new Polinom();

    public static void div(Polinom polinom1, Polinom polinom2) { // imi trebuie o copie pt polinom1
        polinom1.reSet(); polinom2.reSet();
        polinom1.sortList(); polinom2.sortList(); //sortam polinoamele in ordine descrescatoare, sau macar incercam
        System.out.println(polinom1.toString());
        System.out.println(polinom2.toString());

        int i = polinom1.getPolinom().size()-1;
        int j = polinom2.getPolinom().size()-1;
        Monom monom1 = polinom1.getPol(i); Monom monom2 = polinom2.getPol(j);
        System.out.println("Monom1: " + monom1.toString() + " Monom2: " + monom2.toString());
        Monom var = new Monom(monom1.getCoef(), monom1.getPutere() - monom2.getPutere());
        Polinom intermedVar = new Polinom();
        intermedVar.addPolinom(var);
        resultCat.addPolinom(var);
        System.out.println("cat: " + resultCat.toString());

        Polinom intermedMul = Operations.mul(polinom2, intermedVar); //
        polinom1.reSet(); intermedMul.reSet();
        Polinom intermedSub = Operations.sub(polinom1, intermedMul);

        polinom1.setPolinom(intermedSub.getPolinom());
        System.out.println(polinom1.toString());
        polinom1.sortList();
        polinom1.removePolinom(0);

        System.out.println("polinom1 poz 0: " + polinom1.getPol(0));
        polinom2.reSet();
        polinom2.sortList();
        System.out.println("polinom2 poz 0: " + polinom2.getPol(0));
        if(polinom1.getPol(0).getPutere() >= polinom2.getPol(0).getPutere()) {
            Operations.div(polinom1, polinom2);
        }

        resultRest.setPolinom(polinom1.getPolinom());
    }

    public static Polinom deriv(Polinom polinom) {
        Polinom result = new Polinom();

        for (Monom p1 : polinom.getPolinom()) {
            if(p1.getPutere() != 0) {
                Monom var = new Monom(p1.getCoef() * p1.getPutere(), p1.getPutere() - 1);
                result.addPolinom(var);
            }
            else{
                Monom var = new Monom(0, p1.getPutere());
                result.addPolinom(var);
            }
        }

        return result;
    }

    public static String integr(Polinom polinom) {
        Monom e = polinom.removePolinom(1);
        String result = " ";
        result = result + e.toStringIntegr();

        for(Monom p : polinom.getPolinom()) {
            result += " + " + p.toStringIntegr();
        }

        result = result + " + " + "C";
        polinom.addPolinom(e);
        return result;
    }

}
