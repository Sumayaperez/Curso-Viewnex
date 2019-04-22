/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplospoo.Geometria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author German
 */
public class LectorFiguras {

    public void coleccionesFiguras() {
        Figura[] figuras = {
            new Rectangulo(5, 5),
            new Circulo(5, "blanco"),
            new Triangulo("Triangulo: base=5.5, altura=3.3, color=morado")
    };
       
    for (Figura fig : figuras){
        System.out.println(fig.toString());
        System.out.println(" - Area: " + fig.calcArea());
      
    }
    
    ArrayList<Figura> arrayList = new ArrayList<>();
    arrayList.add(new Rectangulo(4, 3, "verde"));
    arrayList.add(new Circulo(5, "verde"));
    //array.add("Texto cualquiera");
    //array.add(200);
    for (Figura fig : arrayList) {
        System.out.println(fig.toString());
        System.out.println(" - Area: " + fig.calcArea());
      
    }
    IImprimible[] objImp = {
        new Circulo(5),
        new Cuadrado(6),
        // new Linea(),
       
    };
    
    
            
    IMostrable[] objMos = {
        new Triangulo(5, 7, null),
        new Cuadrado(6),
        // new Linea(),
       
    };
    
    for (IMostrable mostrable : objMos) {
        mostrable.mostrar();
    }
    
    for (IMostrable mostrable : objMos) {
        mostrable.mostrar();
    }
    
    Cuadrado cuadrado = new Cuadrado(5, "negro");
    Rectangulo cuadr = cuadrado;
    FiguraConLados cuadFL =cuadrado;
    Figura cuadF = cuadrado;
    cuadF.setColor("gris");
    IImprimible cuadI = cuadrado;
    cuadI.imprimir();
    IMostrable cuadM = cuadrado;
    cuadM.mostrar();
    
    arrayList.add(cuadrado);
    arrayList.add(cuadrado);
            
    
    
    Set <Figura> setFig = new HashSet<>();
    setFig.add(new Triangulo(3,5, null));
    setFig.addAll(arrayList);
    
    System.out.println(">> ARRAY LIST: ");
    for (Figura fig : arrayList) {
           System.out.println(fig.toString());
    }
    System.out.println(">> SET: ");
    for (Figura fig : setFig){
           System.out.println(fig.toString());
    }
    
    Map <String,Figura> mapFig = new HashMap<>();
    mapFig.put("Triangulo", new Triangulo(3,5, null, "verde"));
    mapFig.put("Cuadrado", new Cuadrado(3));
    
    
    System.out.println(">> MAP LIST: ");
    System.out.println("Buscando: "+ mapFig.get("Triangulo").toString());
    
    for (Map.Entry<String, Figura> entrada : mapFig.entrySet()) {
           System.out.println("Clave: " + entrada.getKey() + "; Valor: " + entrada.getValue());
    }
    Map<Figura, String > mapaFig = new TreeMap<>();
    mapaFig.put(new Triangulo(3,9, null, "verde"), "tri 3");
    mapaFig.put(new Cuadrado(7), "cuadrado 7");
    mapaFig.put(new Cuadrado(5), "cuadrado 5");
    mapaFig.put(new Circulo(5), "circulo 5");

    System.out.println(">> MAPA ORDENADO: ");
    
    mapaFig.forEach((Figura clave, String valor) -> {
        System.out.println("Clave: " + clave
                + "; Area: " + clave.calcArea()
                + "; Valor: " + valor.toString());
    });
    
    
    /* Figura fig2 = new Circulo(5,"blanco");
        
        System.out.println(fig2.toString() + " - Area: " + fig2.calcArea());
        
    */    
        
        /*Rectangulo rec = (Rectangulo) fig;
        System.out.println(rec.toString() + "\nArea: " + rec.calcArea());

        */
        
        /*
            fig = new Figura("azul");
            System.out.println(fig.toString());

            Rectangulo rec = new Rectangulo(2, 3);
            System.out.println(rec.toString());

            fig = rec;
            System.out.println(fig.toString());

            fig.setColor("blanco");
            System.out.println(fig.toString());

            fig = new Circulo(10, "amarillo");
            System.out.println(fig.toString());
        */
    }
}
