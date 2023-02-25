package Model;

public class Monom {
    private int coef;
    private int putere;
    private boolean esteVizitat;

    public Monom(int coef, int putere){
        this.coef = coef;
        this.putere = putere;
    }

    @Override
    public String toString(){
        if(this.putere > 0) {
            if (this.coef >= 0)
                return this.coef + "*" + "x" + "^" + this.putere;
            return "(" + this.coef + ")" + "*" + "x" + "^" + this.putere;
        }
        else {
            if (this.putere == 0) {
                if (this.coef >= 0)
                    return "" + this.coef;
                return "(" + this.coef + ")";
            }
            else {
                if (this.coef >= 0)
                    return this.coef + "*" + "x" + "^" + "(" + this.putere + ")";
                return "(" + this.coef + ")" + "*" + "x" + "^" + "(" + this.putere + ")";
            }
        }
    }

    public String toStringIntegr(){
        if(this.putere >= 0) {
            if (this.coef >= 0)
                return this.coef + "*" + 1 + "/" + (this.putere+1) + "*" + "x^" + (this.putere+1);
            return "(" + this.coef + ")" + "*" + 1 + "/" + (this.putere+1) + "*" + "x^" + (this.putere+1);
        }
        else {
            if (this.putere == -1) {
                if (this.coef >= 0)
                    return this.coef + "*" + "lnx";
                return "(" + this.coef + ")" + "*" + "lnx";
            }
            else {
                if (this.coef >= 0)
                    return this.coef + "*" + 1 + "/" + (this.putere+1) + "*" + "x^" + "(" + (this.putere+1) + ")";
                return "(" + this.coef + ")" + "*" + 1 + "/" + (this.putere+1) + "*" + "x^" + "(" + (this.putere+1) + ")";
            }
        }
    }

    public void setCoef(int coef){

        this.coef=coef;
    }

    public int getCoef(){

        return this.coef;
    }

    public void setPutere(int putere){

        this.putere=putere;
    }

    public int getPutere(){

        return this.putere;
    }

    public void setEsteVizitat(boolean vizitat){

        this.esteVizitat = vizitat;
    }

    public boolean getEsteVizitat(){

        return this.esteVizitat;
    }

    public int compareTo(Monom m){
        if(this.getPutere() == m.getPutere())
            return 0;
        if(this.getPutere() > m.getPutere())
            return 1;
        else return -1;
    }

}
