package org.example.ventana;

import org.example.estilo.Boton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
    String informacion = "";
    String valor = "";
    String valor2 = "";

    String texto = "";


    //texto
    JLabel resultadoLabel;
    JTextField operacion;

    //btn operacion
    Boton btnSuma, btnResta, btnMultiplicacion, btnDivision, btnPotencia, btnAc, igual, parentesisA, parentesisB;

    //btn numeros y simbolos
    Boton uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero, punto;

    public Ventana(String titulo) {
        super(titulo);

        //configuracion del panel
        this.getContentPane().setLayout(null);
        this.setBounds(750, 750, 750, 750);
        this.setLocationRelativeTo(null);

        //configuracion labels y text fields

        resultadoLabel = new JLabel();
        resultadoLabel.setBounds(100, 280, 450, 40);
        resultadoLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        operacion = new JTextField();
        operacion.setBounds(100, 320, 450, 20);
        operacion.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        //configuracion de los botones operaciones
        btnSuma = new Boton();
        btnSuma.setBounds(450, 350, 100, 30);
        btnSuma.setText("+");
        btnSuma.addActionListener(this);

        btnResta = new Boton();
        btnResta.setBounds(450, 390, 100, 30);
        btnResta.setText("-");
        btnResta.addActionListener(this);

        btnMultiplicacion = new Boton();
        btnMultiplicacion.setBounds(450, 430, 100, 30);
        btnMultiplicacion.setText("*");
        btnMultiplicacion.addActionListener(this);

        btnDivision = new Boton();
        btnDivision.setBounds(450, 470, 100, 30);
        btnDivision.setText("/");
        btnDivision.addActionListener(this);

        btnPotencia = new Boton();
        btnPotencia.setBounds(450, 510, 100, 30);
        btnPotencia.setText("^");
        btnPotencia.addActionListener(this);

        btnAc = new Boton();
        btnAc.setBounds(100, 350, 100, 30);
        btnAc.setText("AC");
        btnAc.addActionListener(this);

        parentesisA = new Boton();
        parentesisA.setBounds(220, 350, 100, 30);
        parentesisA.setText("(");
        parentesisA.addActionListener(this);

        parentesisB = new Boton();
        parentesisB.setBounds(340, 350, 100, 30);
        parentesisB.setText(")");
        parentesisB.addActionListener(this);

        //configuracion botones numericos
        siete = new Boton();
        siete.setBounds(100, 390, 100, 30);
        siete.setText("7");
        siete.addActionListener(this);

        ocho = new Boton();
        ocho.setBounds(220, 390, 100, 30);
        ocho.setText("8");
        ocho.addActionListener(this);

        nueve = new Boton();
        nueve.setBounds(340, 390, 100, 30);
        nueve.setText("9");
        nueve.addActionListener(this);

        cuatro = new Boton();
        cuatro.setBounds(100, 430, 100, 30);
        cuatro.setText("4");
        cuatro.addActionListener(this);

        cinco = new Boton();
        cinco.setBounds(220, 430, 100, 30);
        cinco.setText("5");
        cinco.addActionListener(this);

        seis = new Boton();
        seis.setBounds(340, 430, 100, 30);
        seis.setText("6");
        seis.addActionListener(this);

        uno = new Boton();
        uno.setBounds(100, 470, 100, 30);
        uno.setText("1");
        uno.addActionListener(this);

        dos = new Boton();
        dos.setBounds(220, 470, 100, 30);
        dos.setText("2");
        dos.addActionListener(this);

        tres = new Boton();
        tres.setBounds(340, 470, 100, 30);
        tres.setText("3");
        tres.addActionListener(this);

        cero = new Boton();
        cero.setBounds(100, 510, 100, 30);
        cero.setText("0");
        cero.addActionListener(this);

        punto = new Boton();
        punto.setBounds(220, 510, 100, 30);
        punto.setText(".");
        punto.addActionListener(this);

        igual = new Boton();
        igual.setBounds(340, 510, 100, 30);
        igual.setText("=");
        igual.addActionListener(this);

        //organizacion botones en el panel
        JLayeredPane layered = new JLayeredPane();
        layered.setBounds(0, 0, this.getWidth(), getHeight());
        layered.add(operacion);
        layered.add(resultadoLabel);

        layered.add(btnSuma);
        layered.add(btnResta);
        layered.add(btnMultiplicacion);
        layered.add(btnDivision);
        layered.add(btnPotencia);
        layered.add(btnAc);
        layered.add(parentesisA);
        layered.add(parentesisB);

        layered.add(siete);
        layered.add(ocho);
        layered.add(nueve);
        layered.add(cuatro);
        layered.add(cinco);
        layered.add(seis);
        layered.add(uno);
        layered.add(dos);
        layered.add(tres);
        layered.add(cero);
        layered.add(punto);
        layered.add(igual);
        this.getContentPane().add(layered);


        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        boolean labelEmpty = resultadoLabel.getText().isBlank();//validacion operaciones seguidas
        if (e.getActionCommand().equals("AC")) {//eliminacion
            texto = texto.substring(0, texto.length() - 1);
            operacion.setText(texto);
        } else {
            operacion.setText(operacion.getText() + e.getActionCommand());
            texto = operacion.getText();
        }
        switch (e.getActionCommand()) {//operaciones
            case "^" -> {
                valor = validar(labelEmpty);
                informacion = "^";
            }
            case "/" -> {
                valor = validar(labelEmpty);
                informacion = "/";
            }
            case "*" -> {
                valor = validar(labelEmpty);
                informacion = "*";
            }
            case "+" -> {
                valor = validar(labelEmpty);
                informacion = "+";
            }
            case "-" -> {
                valor = validar(labelEmpty);
                informacion = "-";
            }
            case "=" -> {
                valor2 = operacion.getText().substring(0, operacion.getText().length() - 1);
                operacion.setText("");
                opera();

                texto = "";
            }
        }
    }

    public String validar(boolean validacion) {
        if (validacion) {
            valor = String.valueOf(operacion.getText().charAt(0));
            operacion.setText("");
        } else {
            valor = operacion.getText().substring(0, operacion.getText().length() - 1);
            operacion.setText("");
        }
        return valor;
    }

    public void opera() {

        if ((resultadoLabel.getText().isBlank()) || (!valor.isBlank() && !valor2.isBlank())) {
            switch (informacion) {
                case "^" -> {
                        resultadoLabel.setText(String.valueOf(potenciacion(Double.parseDouble(valor),Double.parseDouble(valor2))));
                        System.out.println(Math.pow(Double.parseDouble(valor), Double.parseDouble(valor2)) == Double.parseDouble(resultadoLabel.getText()));

                }
                case "/" -> {
                    resultadoLabel.setText(String.valueOf((Double.parseDouble(valor) / Double.parseDouble(valor2))));
                    System.out.println(Double.parseDouble(valor) / Double.parseDouble(valor2) == Double.parseDouble(resultadoLabel.getText()));
                }
                case "*" -> {
                    resultadoLabel.setText(String.valueOf((Double.parseDouble(valor) * Double.parseDouble(valor2))));
                    System.out.println(Double.parseDouble(valor) * Double.parseDouble(valor2) == Double.parseDouble(resultadoLabel.getText()));
                }
                case "+" -> {
                    resultadoLabel.setText(String.valueOf((Double.parseDouble(valor) + Double.parseDouble(valor2))));
                    System.out.println(Double.parseDouble(valor) + Double.parseDouble(valor2) == Double.parseDouble(resultadoLabel.getText()));
                }
                case "-" -> {
                    resultadoLabel.setText(String.valueOf((Double.parseDouble(valor) - Double.parseDouble(valor2))));
                    System.out.println(Double.parseDouble(valor) - Double.parseDouble(valor2) == Double.parseDouble(resultadoLabel.getText()));
                }
            }
            valor = "";
        } else if (!valor2.isBlank()) {//operaciones seguidas
            double validacion;
            switch (informacion) {
                case "^" -> {
                    validacion = Double.parseDouble(resultadoLabel.getText());
                    resultadoLabel.setText(String.valueOf(potenciacion(Double.parseDouble(resultadoLabel.getText()),Double.parseDouble(valor2))));
                    System.out.println(Math.pow(validacion, Double.parseDouble(valor2)) == Double.parseDouble(resultadoLabel.getText()));
                }
                case "/" -> {
                    validacion = Double.parseDouble(resultadoLabel.getText());
                    resultadoLabel.setText(String.valueOf((Double.parseDouble(resultadoLabel.getText()) / Double.parseDouble(valor2))));
                    System.out.println(validacion / Double.parseDouble(valor2) == Double.parseDouble(resultadoLabel.getText()));
                }
                case "*" -> {
                    validacion = Double.parseDouble(resultadoLabel.getText());
                    resultadoLabel.setText(String.valueOf((Double.parseDouble(resultadoLabel.getText()) * Double.parseDouble(valor2))));
                    System.out.println(validacion * Double.parseDouble(valor2) == Double.parseDouble(resultadoLabel.getText()));
                }
                case "+" -> {
                    validacion = Double.parseDouble(resultadoLabel.getText());
                    resultadoLabel.setText(String.valueOf((Double.parseDouble(resultadoLabel.getText()) + Double.parseDouble(valor2))));
                    System.out.println(validacion + Double.parseDouble(valor2) == Double.parseDouble(resultadoLabel.getText()));
                }
                case "-" -> {
                    validacion = Double.parseDouble(resultadoLabel.getText());
                    resultadoLabel.setText(String.valueOf((Double.parseDouble(resultadoLabel.getText()) - Double.parseDouble(valor2))));
                    System.out.println(validacion - Double.parseDouble(valor2) == Double.parseDouble(resultadoLabel.getText()));
                }
            }
        }

    }//usar cocumber para la programacion bdd
    public double potenciacion(double base,double exponente){
        double resultado=1;
        if(exponente==0){
            resultadoLabel.setText(String.valueOf(resultado));
        } else if (base<0) {
            resultadoLabel.setText("0");
        }else {
            for (int i = 1; i <= exponente; i++) {
                resultado *= base;
            }
        }
        return resultado;
    }

        public double calcularRaizCuadrada(double numero) {
            if (numero < 0) {
                throw new IllegalArgumentException("El número debe ser positivo");
            }

            double tolerancia = 0.00001; // Precisión deseada
            double estimacion = numero / 2.0; // Valor inicial de la estimación

            while (Math.abs(estimacion * estimacion - numero) > tolerancia) {
                estimacion = (estimacion + numero / estimacion) / 2.0; // Fórmula de Newton-Raphson
            }

            return estimacion;
        }
    }





//no tener en cuenta estas pruebas (este es un algoritmo automatizado con parentesis y otras cosa no terminado)

/*
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getActionCommand().equals("="))) {
            //  resultadoLabel.setText(recorrer(informacion));
            operacion.setText("");
            informacion = "";
        } else if (e.getActionCommand().equals("AC")) {
            informacion = informacion.substring(0, informacion.length() - 1);
            operacion.setText(informacion);

        } else {
            informacion = informacion + e.getActionCommand();
            operacion.setText(informacion);
        }
    }
    */

/*
    public String recorrer(String texto) {
        int contadorParentesis = 0;
        int contadorI = 0;
        double resultado = 0.0;
        ArrayList<Integer> inicio = new ArrayList<>();

        ArrayList<Integer> fin = new ArrayList<>();
        int contadorF = 0;

        Character caracter;//equilibrio de parentesis
        if (texto.contains("(")) {
            for (int i = 0; i < texto.length(); i++) {
                caracter = texto.charAt(i);
                if (caracter.equals('(')) {
                    inicio.add(contadorI, i);
                    contadorI++;
                } else if (caracter.equals(')')) {
                    fin.add(contadorF, i);
                    contadorF++;
                }
            }
            if (contadorI != contadorF) {
                return "Error";
            }
        }
        int i = contadorI > 0 ? inicio.get(contadorI - 1) : 0;
        System.out.println(i);
        contadorI--;
        for (; i < Objects.requireNonNull(texto).length(); i++) {
            if (!texto.contains("(") || !texto.contains(")")) {//problema
                switch (texto.charAt(i)) {
                    case '^' ->
                            resultado = resultado + Math.pow(preOperacion(texto, i - 1), preOperacion(texto, i + 1));
                    case '/' -> resultado = resultado + (preOperacion(texto, i - 1) / preOperacion(texto, i + 1));

                    case '*' -> resultado = resultado + (preOperacion(texto, i - 1) * preOperacion(texto, i + 1));

                    case '+' -> resultado = resultado + (preOperacion(texto, i - 1) + preOperacion(texto, i + 1));

                    case '-' -> resultado = ((preOperacion(texto, i - 1) - preOperacion(texto, i + 1)));
                }


            } else {
                if (i < fin.get(contadorParentesis)) {
                        if (i == 0) {
                            resultado = resultado+operacion(texto,i);
                            String aux = texto.substring(inicio.get(contadorParentesis), fin.get(contadorParentesis) + 1);
                            System.out.println(fin.get(contadorParentesis));
                            System.out.println(aux);
                            texto = texto.replace(aux, "");//terminar el resto de metodos
                        } else{
                            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
                            resultado = resultado +operacion(texto, i);
                            String aux = texto.substring(inicio.get(contadorParentesis), fin.get(contadorParentesis) + 1);
                            texto = texto.replace(aux, "");
                        }

                        contadorParentesis++;
                }
            }

            if (contadorI > 0 && i == fin.get(1)) {
                i = inicio.get(contadorF - 1);
                contadorI--;
                contadorF++;
            }
        }
        return Double.toString(resultado);
    }

    //hacer que el preOperacion pueda hacer operaciones con numeros negativos

    public double preOperacion(String texto, int indice) {//solucionar 10-1000
        Double valor = 0.0;
        var inIni = 0;
        var inFin = 1;
        if ((texto.charAt(indice) >= 48 && texto.charAt(indice) <= 57) || (texto.charAt(indice) >= 40 && texto.charAt(indice) <= 41)) {
            for (; indice < texto.length(); indice++) {
                if (texto.charAt(indice) >= 40 && texto.charAt(indice) <= 41) {
                    indice++;
                }
                if (texto.charAt(indice) >= 48 && texto.charAt(indice) <= 57) {
                    valor = Double.parseDouble(String.valueOf(valor).substring(inIni, inFin).concat(String.valueOf(texto.charAt(indice))));
                    if ((texto.charAt(indice) >= 48 && texto.charAt(indice) <= 57) || (texto.charAt(indice) >= 40 && texto.charAt(indice) <= 41)) {
                        inIni++;
                    } else if ((texto.charAt(inFin + 1) >= 48 && texto.charAt(inIni + 1) <= 57 && texto.charAt(indice) == '0') || texto.charAt(indice) >= 40 && texto.charAt(indice + 1) <= 41) {
                        inFin++;
                    }
                } else {
                    break;
                }
            }
            return valor;
        } else {
            return Double.parseDouble(String.valueOf(texto.charAt(indice+1)));
        }
    }

    public double operacion(String texto,int indice){
        double resultado=0;

       while (true){
            if(indice==0 && texto.contains("^")){
                resultado= Math.pow(preOperacion(texto, indice), preOperacion(texto, indice + 1));
                break;
            } else if(indice>0&&texto.contains("^")){
                resultado = resultado + Math.pow(preOperacion(texto, indice - 1), preOperacion(texto, indice + 1));
                break;
            }if(indice==0&&texto.contains("/")){
                resultado= preOperacion(texto, indice)/ preOperacion(texto, indice + 1);
                break;
            } else if (indice>0&&texto.contains("/")){
                resultado = resultado + (preOperacion(texto, indice - 1)/preOperacion(texto, indice + 1));
                break;
            }if(indice==0&&texto.contains("*")){
                resultado= preOperacion(texto, indice)*preOperacion(texto, indice + 1);
                break;
            } else if (indice>0&&texto.contains("*")){
                resultado = resultado + (preOperacion(texto, indice - 1)*preOperacion(texto, indice + 1));
                break;
            }   if(indice==0&&texto.contains("+")){
                resultado= preOperacion(texto, indice)+ preOperacion(texto, indice + 1);
                break;
            } else if (indice>0&&texto.contains("+")){
                resultado = resultado + (preOperacion(texto, indice - 1)+preOperacion(texto, indice + 1));
                break;
            }   if(indice==0&&texto.contains("-")){
                resultado= preOperacion(texto, indice)-preOperacion(texto, indice + 1);
                break;
            } else if (indice>0&&texto.contains("-")){
                resultado = resultado + (preOperacion(texto, indice - 1)-preOperacion(texto, indice + 1));
                break;
            }

        }

        return resultado;
    }
*/



