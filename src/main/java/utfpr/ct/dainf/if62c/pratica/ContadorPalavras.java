/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author davip_000
 */
public class ContadorPalavras {
    
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public ContadorPalavras(String caminho) throws FileNotFoundException, IOException{
        try{
            reader = new BufferedReader(new FileReader(new File(caminho)));
            writer = new BufferedWriter(new FileWriter(new File(caminho + ".out")));
        } catch(IOException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    public Map<String,Integer> getPalavras() throws IOException{
        Map<String,Integer> mapa = new HashMap<>();
        try {
            String leitura = reader.readLine(), palavra = "";
            while(leitura != null){
                for(int i=0; i<leitura.length(); i++){
                    if(Character.isAlphabetic(leitura.charAt(i))){
                        palavra += leitura.charAt(i);
                    }
                    else if(palavra != ""){
                        palavra = palavra.toLowerCase();
                        if(mapa.containsKey(palavra)){
                            mapa.replace(palavra, mapa.get(palavra)+1);
                        }
                        else{
                            mapa.put(palavra, 1);
                        }
                        palavra = "";
                    }
                }
                leitura = reader.readLine();
            }
        } catch(IOException e){
            System.out.println(e.getLocalizedMessage());
        } finally {
            try {
            reader.close();
            } catch(Exception e){
                System.out.println(e.getLocalizedMessage());
            }
        }
        return mapa;
    }
    
    private Map<String,Integer> ordenaMapa(Map<String,Integer> palavras){
        TreeMap<String,Integer> palavrasOrdenadas = new TreeMap<>(new MapComparator(palavras));
        palavrasOrdenadas.putAll(palavras);
        return palavrasOrdenadas;
    }
    
    public void escrever(Map<String,Integer> mapa) throws IOException{
        for(Map.Entry<String,Integer> set: ordenaMapa(mapa).entrySet()){
            String s = (set.getKey() + "," + set.getValue());
            writer.write(s);
            writer.newLine();
        }
        writer.close();
    }
    
}
    
