package org.example;

public class Calculadora_Sencilla {
        public double sumar(double a, double b) {
            return a + b;
        }//operaciones con cucumber

        public double restar(double a, double b) {
            return a - b;
        }

        public double multiplicar(double a, double b) {
            return a * b;
        }

        public double dividir(double a, double b) {
            if (b == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            return a / b;
    }
}
