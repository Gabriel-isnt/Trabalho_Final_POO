package FileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GerenciarArquivos{
	
	public static void criarArquivo(String nome) {
		
		File arquivo = new File(nome);
		
                try {
                        if (arquivo.createNewFile()) {
                                System.out.println("Arquivo criado com sucesso!");
                        } else {
                                System.out.println("O arquivo ja existe.");
                        }
                        
                } catch (IOException erro) {
                        System.out.println("Erro ao criar o arquivo: " + erro.getMessage());
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
                        System.out.println("Erro ao ler o arquivo: " + erro.getMessage());
                }
	}
}