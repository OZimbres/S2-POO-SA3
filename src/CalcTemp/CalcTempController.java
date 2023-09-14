package CalcTemp;

import java.util.ArrayList;
import java.util.HashMap;

public class CalcTempController {
    // Pegando informações
    TemperaturaTop tempTop = new TemperaturaTop();
    TemperaturaBottom tempBottom = new TemperaturaBottom();

    public void Converter(){
        String opcaoTop = tempTop.comboBox.getSelectedItem().toString();
        String opcaoBottom = tempBottom.comboBox.getSelectedItem().toString();

        HashMap<String, String> combinacoes = new HashMap<String, String>();
        combinacoes.put("CELCIUS", "CELCIUS");
        combinacoes.put("CELCIUS", "FAHRENHEIT");
        combinacoes.put("CELCIUS", "KELVIN");
        combinacoes.put("FAHRENHEIT", "CELCIUS");
        combinacoes.put("FAHRENHEIT", "FAHRENHEIT");
        combinacoes.put("FAHRENHEIT", "KELVIN");
        combinacoes.put("KELVIN", "CELCIUS");
        combinacoes.put("KELVIN", "FAHRENHEIT");
        combinacoes.put("KELVIN", "KELVIN");

        ArrayList<HashMap> listaCombinacoes = new ArrayList<HashMap>();

        listaCombinacoes.add(combinacoes);

        for (int i = 0; i < listaCombinacoes.size(); i++) {
            if(i == 0 || i == 4 || i == 9){
                int a = 0;
            }
            else if(i == 2){
                int b = 0;
            }
            else{
                int c = 0;
            }
        }
    }
}
