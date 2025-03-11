package Principal;

import Terminal.Cmd;
import CommandHandler.Comando;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


public class Main {
    
    private static Map<String, Runnable> comandos = new HashMap<>();
    public static String caminhoArquivo;

    public static void main(String[] args) {

        // criando arquivo txt para salvar o histórico
        String dirAtual = System.getProperty("user.dir");
        caminhoArquivo = dirAtual + File.separator + "historico.txt";
        File historico = new File(caminhoArquivo);

        try{
                if(!historico.exists()){
                        historico.createNewFile();
                }

                try(FileWriter escreve = new FileWriter(historico, false)){
                        escreve.write("");
                }

        } catch(IOException e){
                System.out.printf("Erro ao criar ou limpar o arquivo: %s", e.getMessage());
        }



        // Lista de comandos aceitos.
        comandos.put("pwd", Cmd::Pwd);
        comandos.put("ls", Cmd::Ls);
        comandos.put("cd", Cmd::Cd);
        comandos.put("mkdir", Cmd::Mkdir);
        comandos.put("touch", Cmd::Touch);
        comandos.put("rm", Cmd::Rm);
        comandos.put("cat", Cmd::Cat);
        comandos.put("echo", Cmd::Echo);
        comandos.put("history", Cmd::History);
        comandos.put("exit", Cmd::Exit);

        // Inicialização do Scanner
        Scanner sc = new Scanner(System.in);
        String entrada;
        boolean space = false;


        // Corpo do loop
        do {
        	// Para evitar espaço desnecessario no inicio.
             if(!space) {
        		System.out.printf("JavaComand>> ");
        		space = true;
        	}else {
        		System.out.printf("\n\nJavaComand>> ");
        	}

            entrada = sc.nextLine();
            Cmd.armazenamento(entrada);

            // escrevendo no histórico
            try (FileWriter writer = new FileWriter(historico, true)) {
                writer.write(entrada + "\n");

            } catch (IOException e) {
                System.out.printf("Erro ao escrever no arquivo de histórico: %s%n", e.getMessage());
            }

            // tratando para pegar os argumentos
            String[] entradaSeparada = Comando.pegaComando(entrada);
            
            if (entradaSeparada.length == 0 || entradaSeparada[0].isEmpty() || !comandos.containsKey(entradaSeparada[0])) {
                	
                System.out.println("\nDigite um comando válido!\n- pwd\n- ls\n- cd\n- mkdir\n- touch\n- rm\n- cat\n- echo\n- history\n- exit");
                continue;
            }
            Runnable comando = comandos.get(entradaSeparada[0]);
            if (comando != null) {
                comando.run();
            }

        } while (!entrada.equals("exit"));

        sc.close(); 
    }
}
