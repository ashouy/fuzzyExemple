package main;


import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class ExemploFuzzy {
    public ExemploFuzzy() {
    }

    public static void main(String[] args) {
        FIS fis = FIS.load("src/resource/model.fcl", true);
        if (fis == null) {
            System.err.println("Can't load file");
            System.exit(1);
        }

        JFuzzyChart.get().chart(fis.getFunctionBlock("biomassa"));
        fis.setVariable("dinheiro", 35);
        fis.setVariable("pessoal", 60);

        fis.evaluate();
        Variable model = fis.getFunctionBlock("model").getVariable("risco");
        JFuzzyChart.get().chart(model, model.getDefuzzifier(), true);
        System.out.println(model.getValue());
    }
}