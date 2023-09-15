package CalcTemp;

import java.util.ArrayList;
import java.util.HashMap;

public class CalcTempController {
    // Pegando informações
    TemperaturaTop tempTop = new TemperaturaTop();
    TemperaturaBottom tempBottom = new TemperaturaBottom();

    //Opções escolhidas durante a conversão
    String opcaoTop;
    String opcaoBottom;

    public void Converter(){
        //Opção escolhida durante a conversão
        opcaoTop = tempTop.comboBox.getSelectedItem().toString();
        opcaoBottom = tempBottom.comboBox.getSelectedItem().toString();

        //Temperatura na partre de cima durante a conversão
        String temperaturaOriginal= PegarTemperaturaOriginal(opcaoTop);

        // Realizar as conversões com base nos valores lidos
    switch (opcaoTop) {
        case "CELCIUS":
            switch (opcaoBottom) {
                case "CELCIUS":
                    DefinirCampoTranformado(temperaturaOriginal, "CELCIUS");
                    break;
                case "FAHRENHEIT":
                    DefinirCampoTranformado(CelciusToFahrenheit(temperaturaOriginal), "FAHRENHEIT");
                    break;
                case "KELVIN":
                    DefinirCampoTranformado(CelciusToKelvin(temperaturaOriginal), "KELVIN");
                    break;
            }
            break;

        case "FAHRENHEIT":
            switch (opcaoBottom) {
                case "CELCIUS":
                    DefinirCampoTranformado(FahrenheitToCelcius(temperaturaOriginal), "CELCIUS");
                    break;
                case "FAHRENHEIT":
                    DefinirCampoTranformado(temperaturaOriginal, "FAHRENHEIT");
                    break;
                case "KELVIN":
                    DefinirCampoTranformado(FahrenheitToKelvin(temperaturaOriginal), "KELVIN");
                    break;
            }
            break;

        case "KELVIN":
            switch (opcaoBottom) {
                case "CELCIUS":
                    DefinirCampoTranformado(KelvinToCelcius(temperaturaOriginal), "CELCIUS");
                    break;
                case "FAHRENHEIT":
                    DefinirCampoTranformado(KelvinToFahrenheit(temperaturaOriginal), "FAHRENHEIT");
                    break;
                case "KELVIN":
                    DefinirCampoTranformado(temperaturaOriginal, "KELVIN");
                    break;
            }
            break;
    }
    }

    public String PegarTemperaturaOriginal(String opcao) {
        float temperatura = 0;
    
        if (opcao.equalsIgnoreCase("CELCIUS")) {
            String textoCampo = tempTop.campoC.getText().trim();
            if (!textoCampo.isEmpty()) {
                try {
                    temperatura = Float.parseFloat(textoCampo);
                } catch (NumberFormatException e) {
                    System.out.println(tempTop.campoC.getText());
                }
            }
            else{
                System.out.println(tempTop.campoC.getText().trim());
            }
        } else if (opcao.equalsIgnoreCase("FAHRENHEIT")) {
            String textoCampo = tempTop.campoF.getText().trim();
            if (!textoCampo.isEmpty()) {
                try {
                    temperatura = Float.parseFloat(textoCampo);
                } catch (NumberFormatException e) {
                    System.out.println(tempTop.campoF.getText());
                }
            }
        } else {
            String textoCampo = tempTop.campoK.getText().trim();
            if (!textoCampo.isEmpty()) {
                try {
                    temperatura = Float.parseFloat(textoCampo);
                } catch (NumberFormatException e) {
                    System.out.println(tempTop.campoK.getText());
                }
            }
        }
    
        return String.valueOf(temperatura);
    }
    public void DefinirCampoTranformado(String resultado, String opcao) {
        if (opcao.equalsIgnoreCase("CELCIUS")) {
            tempBottom.campoC.setText(resultado);
        } else if (opcao.equalsIgnoreCase("FAHRENHEIT")) {
            tempBottom.campoF.setText(resultado);
        } else {
            tempBottom.campoK.setText(resultado);
        }
    }

    public String CelciusToFahrenheit(String TempOriginal){
        float tempOriginal = Float.parseFloat(TempOriginal); // tranforma de string pra float pra calcular

        float tempCalculada = (tempOriginal * (9 / 5)) + 32; // fórmula

        return String.valueOf(tempCalculada); //retorn Retorna como string (faz a conversão aqui mesmo)
    }

    public String CelciusToKelvin(String TempOriginal){
        float tempOriginal = Float.parseFloat(TempOriginal); // tranforma de string pra float pra calcular

        float tempCalculada = tempOriginal + 273.15f; // fórmula

        return String.valueOf(tempCalculada); //retorn Retorna como string (faz a conversão aqui mesmo)
    }

    public String FahrenheitToCelcius(String TempOriginal){
        float tempOriginal = Float.parseFloat(TempOriginal); // tranforma de string pra float pra calcular

        float tempCalculada = (tempOriginal - 32) * (5 / 9); // fórmula

        return String.valueOf(tempCalculada); //retorn Retorna como string (faz a conversão aqui mesmo)
    }

    public String FahrenheitToKelvin(String TempOriginal){
        float tempOriginal = Float.parseFloat(TempOriginal); // tranforma de string pra float pra calcular

        float tempCalculada = (tempOriginal - 32) * (5 / 9) + 273.15f; // fórmula

        return String.valueOf(tempCalculada); //retorn Retorna como string (faz a conversão aqui mesmo)
    }

    public String KelvinToCelcius(String TempOriginal){
        float tempOriginal = Float.parseFloat(TempOriginal); // tranforma de string pra float pra calcular

        float tempCalculada = tempOriginal - 273.15f; // fórmula

        return String.valueOf(tempCalculada); //retorn Retorna como string (faz a conversão aqui mesmo)
    }

    public String KelvinToFahrenheit(String TempOriginal){
        float tempOriginal = Float.parseFloat(TempOriginal); // tranforma de string pra float pra calcular

        float tempCalculada = (tempOriginal - 273.15f) * (9 / 5) + 32; // fórmula

        return String.valueOf(tempCalculada); //retorn Retorna como string (faz a conversão aqui mesmo)
    }
}
