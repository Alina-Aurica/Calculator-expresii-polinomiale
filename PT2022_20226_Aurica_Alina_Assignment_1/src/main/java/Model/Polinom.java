package Model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    private ArrayList<Monom> polinom;

    public Polinom(){

        polinom = new ArrayList<Monom>();
    }

    @Override
    public String toString(){
        Monom e = polinom.remove(0);
        String result = " ";
        result = result + e.toString();

        for(Monom e1:polinom){
            result = result + " + " + e1.toString();
        }

        polinom.add(e);
        return result;
    }

    public void setPolinom(ArrayList<Monom> polinom){

        this.polinom = polinom;
    }

    public ArrayList<Monom> getPolinom(){

        return this.polinom;
    }

    public void addPolinom(Monom monom){

        this.polinom.add(monom);
    }

    public Monom removePolinom(int i){

        return this.polinom.remove(i);
    }

    public Monom getPol(int i){
        return this.polinom.get(i);
    }

    public void sortList(){ //nu merge sortarea cum trebuie
        for(Monom p1:this.polinom){
            for(Monom p2:this.polinom) {
                if (p1.compareTo(p2) == -1 && p2.getEsteVizitat() == false) {
                    Monom var = new Monom(p1.getCoef(), p1.getPutere());
                    p1.setCoef(p2.getCoef());
                    p1.setPutere(p2.getPutere());
                    p2.setCoef(var.getCoef());
                    p2.setPutere(var.getPutere());
                }
            }
            p1.setEsteVizitat(true);
        }
    }

    public void sim(){
        Polinom result = new Polinom();

        for(Monom p1 : this.getPolinom()){
            for(Monom p2 : this.getPolinom()){
                int i = this.getPolinom().indexOf(p1);
                int j = this.getPolinom().indexOf(p2);

                if(p1.getPutere() == p2.getPutere() && i != j && p1.getEsteVizitat() == false){
                    p1.setEsteVizitat( true );
                    p2.setEsteVizitat( true );
                    Monom var = new Monom(p1.getCoef() + p2.getCoef(), p1.getPutere());
                    result.addPolinom(var);
                }
            }
        }

        for(Monom p1 : this.getPolinom()){
            if(p1.getEsteVizitat() == false){
                result.addPolinom(p1);
            }
        }

        this.setPolinom(result.getPolinom());
    }

    public void reSet(){
        for(Monom p: this.polinom){
            p.setEsteVizitat(false);
        }
    }

    private static int getCoeficient(String expresie){
        String[] var = expresie.split("x");
        int coef = Integer.parseInt(var[0]);
        return coef;
    }

    private static int getPutere(String expresie){
        String[] var = expresie.split("\\^");
        int putere = Integer.parseInt(var[1]);
        return putere;
    }

    public static Polinom regex(String exp){ //formatul prin care poate desparti regex-ul este coefX^putere
        Polinom result = new Polinom();
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(exp);
        while (matcher.find()) {
            Monom var = new Monom(getCoeficient(matcher.group(1)), getPutere(matcher.group(1)));
            result.addPolinom(var);
        }

        return result;

    }

}
