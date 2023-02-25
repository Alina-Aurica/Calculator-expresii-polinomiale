package GUI;
import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JLabel titleLabel;
    private JLabel polinom1Label;
    private JLabel polinom2Label;
    private JLabel resultLabel1;
    private JLabel resultLabel2;
    private JTextField polinom1Field;
    private JTextField polinom2Field;
    private JTextField resultField1;
    private JTextField resultField2;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton derivButton;
    private JButton integrButton;

    public View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();

        polinom1Label = new JLabel("Polinom1: ");
        polinom1Field = new JTextField( 15);

        panel1.add(polinom1Label);
        panel1.add(polinom1Field);

        polinom2Label = new JLabel("Polinom2: ");
        polinom2Field = new JTextField(15);

        panel2.add(polinom2Label);
        panel2.add(polinom2Field);

        resultLabel1 = new JLabel("Rezultat (cat): ");
        resultField1 = new JTextField(20);

        panel3.add(resultLabel1);
        panel3.add(resultField1);

        resultLabel2 = new JLabel("Rezultat (rest): ");
        resultField2 = new JTextField(20);

        panel4.add(resultLabel2);
        panel4.add(resultField2);

        addButton = new JButton("add");
        mulButton = new JButton("mul");
        integrButton = new JButton("integr");

        panel5.add(addButton);
        panel5.add(mulButton);
        panel5.add(integrButton);

        subButton = new JButton("sub");
        divButton = new JButton("div");
        derivButton = new JButton("deriv");

        panel6.add(subButton);
        panel6.add(divButton);
        panel6.add(derivButton);

        titleLabel = new JLabel("Polynomial Calculator");

        JPanel panel = new JPanel();
        panel.add(titleLabel);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);
        panel.add(panel6);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.setContentPane(panel);

    }

    public String getPolinom1Field() {
        return polinom1Field.getText();
    }

    public void setPolinom1Field(String sir) {
        polinom1Field.setText(sir);
    }

    public String getPolinom2Field() {
        return polinom2Field.getText();
    }

    public void setPolinom2Field(String sir) {
        polinom2Field.setText(sir);
    }

    public String getResultField1() {
        return resultField1.getText();
    }

    public void setResultField1(String sir) {
        resultField1.setText(sir);
    }

    public String getResultField2() {
        return resultField2.getText();
    }

    public void setResultField2(String sir) {
        resultField2.setText(sir);
    }

    public void addAddListener(ActionListener e) {
        addButton.addActionListener(e);
    }

    public void addSubListener(ActionListener e) {
        subButton.addActionListener(e);
    }

    public void addMulListener(ActionListener e) {
        mulButton.addActionListener(e);
    }

    public void addDivListener(ActionListener e) {
        divButton.addActionListener(e);
    }

    public void addDerivListener(ActionListener e) {
        derivButton.addActionListener(e);
    }

    public void addIntegrListener(ActionListener e) {
        integrButton.addActionListener(e);
    }



}
