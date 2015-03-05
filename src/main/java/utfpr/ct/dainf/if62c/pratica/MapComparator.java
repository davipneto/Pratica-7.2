/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author davip_000
 */
public class MapComparator implements Comparator<String> {
    
    private Map<String,Integer> palavras;
    
    public MapComparator(Map<String,Integer> palavras){
        this.palavras = palavras;
    }
    
    @Override
    public int compare(String a, String b){
        return palavras.get(a) > palavras.get(b)?-1:1;
    }
}
