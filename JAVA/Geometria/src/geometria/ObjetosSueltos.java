/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometria;

/**
 *
 * @author Default
 */
public class ObjetosSueltos {
    
    public static void calculosSueltos() {
        // TODO code application logic here
        Rectangulo rec = new Rectangulo(10,5);
        //rec.setAltura(10);
        //rec.setBase(5);
       System.out.println("Area rectangulo: " + rec.calcArea());
       System.out.println("Perimetro del rectangulo: " + rec.calcPerimetro());
        
       float[] ladosTri ={2,3,5};
       Triangulo tri = new Triangulo(10,5,ladosTri);
        //tri.setAltura(10);
        //tri.setBase(5);
        System.out.println("Area Triangulo: " + tri.calcArea());
        System.out.println("Perimeto del Triangulo: " + tri.calcPerimetro());
        
        Circulo cir = new Circulo(10);
        //cir.setRadio(10);
        System.out.println("Area Circulo: " + cir.calcArea());
        System.out.println("Perimetro del Circulo: " + cir.calcPerimetro());
        
        Cuadrado cuad = new Cuadrado(12, "rojo");
        //cir.setRadio(10);
        System.out.println("Area Cuadrado: " + cuad.calcArea());
        System.out.println("Perimetro del Cuadrado: " + cuad.calcPerimetro());
        
        
    }

}