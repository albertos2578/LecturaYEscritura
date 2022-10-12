/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lecturayescritura;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author AlbertoMoralesGalvez
 */
public class NewMain {
    public static void main(String[] args) {
    	System.out.println("Dime el nombre del archivo");
        Scanner sc1 = new Scanner(System.in);

        
        String name = sc1.nextLine();
    	
    	String NuevoTextoUTF8 = "";
    	

BufferedReader in = null;
try {
	in = new BufferedReader(new InputStreamReader(new FileInputStream(name+".txt"), "utf-8"));//pasamos a utf 8 por las tildes
} catch (UnsupportedEncodingException e) {

	e.printStackTrace();
} catch (FileNotFoundException e) {

	e.printStackTrace();
}
				  Scanner sc = new Scanner(in);
				  
				  while(sc.hasNextLine()) {
					
					NuevoTextoUTF8+=sc.nextLine()+" ";
						  
				  }
				  sc.close();   
				  
		String texto = NuevoTextoUTF8;
        texto = texto.replaceAll("[\\.\\,\\(\\):*¿?=<>Ç+ºª;¡!/-]", " ");//Quitamos los caracteres especiales
        texto= texto.toLowerCase();
        texto= texto.replaceAll("ó", "o");
        texto= texto.replaceAll("á", "a");
        texto= texto.replaceAll("é", "e");
        texto= texto.replaceAll("í", "i");
        texto= texto.replaceAll("ú", "u");
      
        int contador = 0;
        String[] palabras2 = texto.split(" ");
         ArrayList palabras = new ArrayList(contador);
 
          System.out.println("Numero de palabras contando con las menores de 2 letras: "+palabras2.length);
        for (int i = 0; i<palabras2.length; i++){
            if (palabras2[i].length()>2){
                  
                    palabras.add(palabras2[i]);
                   contador=contador+1;
                   
            }
          
        }
        System.out.println("Numero de palabras sin contar las menores de 2 letras: "+palabras.size());
     
        for (int i = 0; i<palabras2.length; i++){      
        HashMap<String, Integer> mapa = new HashMap<>();
        for (Object palabra : palabras) {
            if (mapa.containsKey(palabra)) {
                mapa.put((String) palabra, mapa.get(palabra) + 1);
            } else {
                mapa.put((String) palabra, 1);
            }
        }
        if (i==1){
           System.out.println(mapa);}
           //Pasamos el hashmap a csv
           String eol = System.getProperty("line.separator");

try (Writer writer = new FileWriter(name+".csv")) {
  for (Map.Entry<String, Integer> entry :  mapa.entrySet()) {
    writer.append(entry.getKey()) .append('=') .append(entry.getValue()+"") .append(eol);
  }
} catch (IOException ex) {
  ex.printStackTrace(System.err);
}
        }
    }
    }


