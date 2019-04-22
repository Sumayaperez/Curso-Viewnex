/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Default
 */
public class DesdeFicheros {

    public static void guardarectangulos() {

        Rectangulo rec = new Rectangulo(10, 5);
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fichero = new FileWriter("c:/figuras/rectangulo.txt");
            pw = new PrintWriter(fichero);
            pw.println("Rectangulo: base= " + rec.getBase() + ", altura = " + rec.getAltura() + ", color =" + rec.getColor());
        } catch (Exception ex) {
            // si ocurre algun error catch() captura la excecpción
            ex.printStackTrace();
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void leerRectangulo() {
        File fichero = null;
        FileReader fr = null;
        BufferedReader br = null;
        float base = 0;
        float altura = 0 ;
        String color = "";
        
        
        
        try {
            fichero = new File("C:/figuras/rectangulo.txt");
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            String linea;
            linea = br.readLine();
            if (linea != null) {
                System.out.println(linea);

                String[] partes = linea.split(",");
                
                /*
                String parte1 = partes[0];
                String parte2 = partes[1];
                String parte3 = partes[2];
                
                System.out.println("primera parte: " + parte1);
                System.out.println("segunda parte: " + parte2);
                System.out.println("tercera parte: " + parte3);
                */
                
                int i = 0;
                while (i < partes.length) {

                    String parteIndice = partes[i];
                    System.out.println("Parte del ciclo: " + parteIndice);
                
                    int indiceIgual = parteIndice.indexOf("=");

                    if ((parteIndice.contains("base")) == true) {
                        //int indice1 = parte1.indexOf("=");
                        base = Float.parseFloat(parteIndice.substring(indiceIgual + 1).trim());
                        System.out.println("Asigno la base " +base );

                    } else if ((parteIndice.contains("altura")) == true) {
                        altura = Float.parseFloat(parteIndice.substring(indiceIgual + 1).trim());
                        System.out.println("Asigno la altura " +altura );
                        
                    } else if ((parteIndice.contains("color")) == true) {
                        color = parteIndice.substring(indiceIgual + 1).trim();
                         System.out.println("Asigno el color " +color );
                    } else {
                        System.out.println("No contiene ningun valor de interes");
                    }
                    
                    i++;
                
                }
                
                
                    /*
                int indice1 = parte1.indexOf("=");
                float base = Float.parseFloat(parte1.substring(indice1+1).trim());
                
                int indice2 = parte2.indexOf("=");
                float altura = Float.parseFloat(parte2.substring(indice2+1).trim());
                
                int indice3 = parte3.indexOf("=");
                String color = parte3.substring(indice3+1).trim();
                     */
 /*
                System.out.println("Base: " + base);
                System.out.println("Altura: " + altura);
                System.out.println("Color: " + color);
                     */
 
               
                    Rectangulo rec = new Rectangulo(base, altura, color);
                    System.out.println("Area rectangulo: " + rec.calcArea());
                    System.out.println("Perimetro del rectangulo: " + rec.calcPerimetro());
               
            }
            
            }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        }
    }
