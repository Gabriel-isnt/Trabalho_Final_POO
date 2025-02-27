package Principal;

import Terminal.Cmd;

import CommandHandler.Comando;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main{
	
        private static Map<String, Runnable> comandos = new HashMap<>();;
	
        public static void main(String[] args){

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
                
                // inicialização das classes e scanner pro terminal.
                Scanner sc = new Scanner(System.in);
                String entrada;
                String[] entradaSeparada = new String[3];
                
                // Corpo
                do {
                	
                	System.out.printf("\nJavaComand>>");
                	
                	entrada = sc.nextLine();
                	Cmd.armazenamento(entrada);
                	
                	entradaSeparada = Comando.pegaComando(entrada);
                	
                	final String[] comandoAtual = entradaSeparada;
                	
                	comandos.forEach((chave, valor) ->{
                		
                		if(chave.equals(comandoAtual[0])) {
                			valor.run();
                		}
                		
                	});
                	
                	
                	
                }while(!entrada.equals("exit"));

        }
}