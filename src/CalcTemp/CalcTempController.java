package CalcTemp;

import java.util.ArrayList;
import java.util.HashMap;

public class CalcTempController {
    // Pegando informações
    TemperaturaTop tempTop;
    TemperaturaBottom tempBottom;

    //Construtor
    public CalcTempController(TemperaturaTop tempTop, TemperaturaBottom tempBottom) {
        this.tempTop = tempTop;
        this.tempBottom = tempBottom;
    }

    public String Converter(String OpcaoTop, String OpcaoBottom, String TemperaturaOriginal){
        // Realizar as conversões com base nos valores lidos
        switch (OpcaoTop) {
            case "CELCIUS":
                switch (OpcaoBottom) {
                    case "CELCIUS":
                        return TemperaturaOriginal;

                    case "FAHRENHEIT":
                        return CelciusToFahrenheit(TemperaturaOriginal);

                    case "KELVIN":
                        return CelciusToKelvin(TemperaturaOriginal);
                }
                break;

            case "FAHRENHEIT":
                switch (OpcaoBottom) {
                    case "CELCIUS":
                        return FahrenheitToCelcius(TemperaturaOriginal);

                    case "FAHRENHEIT":
                        return TemperaturaOriginal;

                    case "KELVIN":
                        return FahrenheitToKelvin(TemperaturaOriginal);
                }
                break;

            case "KELVIN":
                switch (OpcaoBottom) {
                    case "CELCIUS":
                        return KelvinToCelcius(TemperaturaOriginal);

                    case "FAHRENHEIT":
                        return KelvinToFahrenheit(TemperaturaOriginal);

                    case "KELVIN":
                        return TemperaturaOriginal;
                }
                break;
        }

        return "uau";
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
