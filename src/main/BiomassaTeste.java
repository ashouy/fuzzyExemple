package main;


import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class BiomassaTeste {
    public BiomassaTeste() {
    }

    public static void main(String[] args) {
        FIS fis = FIS.load("src/resource/biomassa.fcl", true);
        if (fis == null) {
            System.err.println("Can't load file");
            System.exit(1);
        }

        JFuzzyChart.get().chart(fis.getFunctionBlock("biomassa"));
        fis.setVariable("dinheiro", 35);
        fis.setVariable("pessoal", 60);

        fis.evaluate();
        Variable biomassa = fis.getFunctionBlock("biomassa").getVariable("risco");
        JFuzzyChart.get().chart(biomassa, biomassa.getDefuzzifier(), true);
        System.out.println(biomassa.getValue());
    }
}