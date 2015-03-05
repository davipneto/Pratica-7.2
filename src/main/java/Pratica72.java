
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import utfpr.ct.dainf.if62c.pratica.ContadorPalavras;
import utfpr.ct.dainf.if62c.pratica.MapComparator;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica72 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo: ");
        String arquivo = scanner.nextLine();
        ContadorPalavras cp = null;
        try{
            cp = new ContadorPalavras(arquivo);
        } catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        Map<String,Integer> palavras = null;
        try{
            palavras = (cp.getPalavras());
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        try{
            cp.escrever(palavras);
        } catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    
}
