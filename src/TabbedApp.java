import javax.swing.JTabbedPane;

import Calculadora.Calculadora;
import CalcTemp.CalcTemperatura;
import CalcIMC.CalcIMC;

public class TabbedApp extends JTabbedPane {
    public TabbedApp() {
        super();
        this.add("Calculadora",new Calculadora());
        this.add("Conversor Temperatura",new CalcTemperatura());
        this.add("IMC",new CalcIMC());
    }
}