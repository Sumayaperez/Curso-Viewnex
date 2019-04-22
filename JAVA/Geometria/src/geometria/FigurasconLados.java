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
public class FigurasconLados extends Figuras {
    protected float altura;
    protected float base;
    
   /* public FigurasconLados(){
        super("blanco");
    }*/
    
    public FigurasconLados(float altura, float base){
        super("blanco");
        this.altura = altura;
        this.base = base;
    }

    public FigurasconLados(float altura, float base, String color) {
        super(color);
        this.altura = altura;
        this.base = base;
    }
    
    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }
}
