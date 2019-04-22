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
public class Rectangulo extends FigurasconLados {
   
 
    public Rectangulo(float altura, float base){
        super(altura, base);
       
    }
    
    public Rectangulo(float altura, float base, String color){
        super(altura, base, color);
    }
    
    
    /** Calcula el area del Rectangulo*/
   public float calcArea() {
           return this.base * this.altura;
   }

   public float calcPerimetro(){
       return 2* base + 2 * altura;
   }
}
