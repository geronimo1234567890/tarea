package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ventana.Ventana;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class Main extends JFrame {
    public static void main(String[] args) {

        Ventana ventana=new Ventana("calculadora");

    }

    public static class CalculadoraSteps {//ejemplificacion uso de cocumber
        private Calculadora_Sencilla calculadora;
        private double resultado;

        @Given("una calculadora")
        public void inicializarCalculadora() {
            calculadora = new Calculadora_Sencilla();
        }

        @When("sumo {double} y {double}")
        public void sumarNumeros(double num1, double num2) {
            resultado = calculadora.sumar(num1, num2);
        }

        @When("resto {double} y {double}")
        public void restarNumeros(double num1, double num2) {
            resultado = calculadora.restar(num1, num2);
        }

        @When("multiplico {double} y {double}")
        public void multiplicarNumeros(double num1, double num2) {
            resultado = calculadora.multiplicar(num1, num2);
        }

        @When("divido {double} entre {double}")
        public void dividirNumeros(double num1, double num2) {
            resultado = calculadora.dividir(num1, num2);
        }

        @Then("el resultado debe ser {double}")
        public void verificarResultado(double esperado) {
            assertEquals(esperado, resultado, 0.0001);
        }
    }
}