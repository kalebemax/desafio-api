import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
       ConsultaCep consultaCep = new ConsultaCep();
       Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um CEP válido:");
        var cep = leitura.nextLine();

       try {
           Endereco endereco = consultaCep.buscaEndereco(cep);
           GeradorDeArquivo gerador = new GeradorDeArquivo();
           gerador.salvaJson(endereco);
           System.out.println(endereco);
       } catch (RuntimeException e) {
           System.out.println(e.getMessage());
       } catch (IOException e) {
           throw new RuntimeException(e.getMessage());
       } finally {
           System.out.println("Aplicação finalizada.");
       }
    }
}
