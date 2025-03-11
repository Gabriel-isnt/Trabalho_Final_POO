package FileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;          
import java.io.FileReader;
import java.io.FileWriter;   
import java.io.IOException;

public class GerenciarArquivos{
	
	public static void criarArquivo(String nome) {
		
		File arquivo = new File(nome);
		
                try {
                        if (arquivo.createNewFile()) {
                                System.out.println("\nArquivo criado com sucesso!");
                        } else {
                                System.out.println("\nO arquivo ja existe.");
                        }
                        
                } catch (IOException erro) {
                        System.out.println("\nErro ao criar o arquivo: " + erro.getMessage());
                }
	}
	
	public static void lerArquivo(String nome) {
		
		File arquivo = new File(nome);
		
		if(!arquivo.exists()) {
			System.out.println("Arquivo inexistente!");
                        return; // adicionei pq se não existir já sai da função
		}
		
                try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
                        String linha;
                        while ((linha = leitor.readLine()) != null) {
                                System.out.println(linha);
                        }
                
                } catch (IOException erro) {
                        System.out.println("\nErro ao ler o arquivo: " + erro.getMessage());
                }
	}

        public static boolean escreverArquivo(String nome, String nome2){

                if(nome2 ==  null){
                        return false;
                }

                File arquivo = new File(nome2);

                if(!arquivo.exists()){
                        criarArquivo(nome2);
                } 
                
                if(!arquivo.isFile()){
                        return false;
                }

                try(BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
                        bw.newLine(); 
                        bw.write(nome); 

                        return true;
                        
                } catch(IOException e) {
                        return false;
                }


        }
}