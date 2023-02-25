package controller;

import GUI.View;
import Model.Operations;
import Model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Model.Operations.resultCat;
import static Model.Operations.resultRest;


public class Controller {
    private View view;
    private Operations op;

    public Controller(View v){
        this.view = v;

        view.addAddListener(new AddListener());
        view.addSubListener(new SubListener());
        view.addMulListener(new MulListener());
        view.addDivListener(new DivListener());
        view.addDerivListener(new DerivListener());
        view.addIntegrListener(new IntegrListener());
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input1 = "";
            String input2 = "";
            input1 = view.getPolinom1Field();
            input2 = view.getPolinom2Field();
            Polinom polinom1 = Polinom.regex(input1);
            Polinom polinom2 = Polinom.regex(input2);

            Polinom polinom = Operations.add(Polinom.regex(input1), Polinom.regex(input2));

            view.setResultField1(polinom.toString());

        }
    }

    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input1 = "";
            String input2 = "";
            input1 = view.getPolinom1Field();
            input2 = view.getPolinom2Field();

            Polinom polinom1 = Polinom.regex(input1);
            Polinom polinom2 = Polinom.regex(input2);

            Polinom polinom = Operations.sub(Polinom.regex(input1), Polinom.regex(input2));

            view.setResultField1(polinom.toString());

        }
    }

    class MulListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input1 = "";
            String input2 = "";
            input1 = view.getPolinom1Field();
            input2 = view.getPolinom2Field();

            Polinom polinom1 = Polinom.regex(input1);
            Polinom polinom2 = Polinom.regex(input2);

            Polinom polinom = Operations.mul(Polinom.regex(input1), Polinom.regex(input2));

            view.setResultField1(polinom.toString());


        }
    }

    class DivListener implements ActionListener { //nu ii implementaat inca
        public void actionPerformed(ActionEvent e) {
            String input1 = "";
            String input2 = "";
            input1 = view.getPolinom1Field();
            input2 = view.getPolinom2Field();

            Polinom polinom1 = Polinom.regex(input1);
            Polinom polinom2 = Polinom.regex(input2);

            Operations.div(polinom1, polinom2);

            view.setResultField1(resultCat.toString());
            view.setResultField2(resultRest.toString());

        }
    }

    class DerivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input1 = "";
            input1 = view.getPolinom1Field();

            Polinom polinom1 = Polinom.regex(input1);

            Polinom polinom = Operations.deriv(Polinom.regex(input1));

            view.setResultField1(polinom.toString());


        }
    }

    class IntegrListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input1 = "";
            input1 = view.getPolinom1Field();
            Polinom polinom1 = Polinom.regex(input1);

            String result = Operations.integr(polinom1);

            view.setResultField1(result);


        }
    }


}
