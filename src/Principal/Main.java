package Principal;

import Terminal.Cmd;
import CommandHandler.Comando;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


public class Main{
	
	    private static Map<String, Runnable> comandos;
	
        public static void main(String[] args){

                // Lista de comandos aceitos.
                comandos.put("pwd", Cmd.Pwd());
                comandos.put("ls", Cmd.Ls());
                comandos.put("cd", Cmd.Cd(null));
                comandos.put("mkdir", Cmd.Mkdir(null));
                comandos.put("touch", Cmd.Touch(null));
                comandos.put("rm", Cmd.Rm());
                comandos.put("cat", Cmd.Cat(null));
                comandos.put("echo", Cmd.Echo());
                comandos.put("history", Cmd.History());
                
                // inicialização das classes e scanner pro terminal.
                Cmd cmd = new Cmd();
                Scanner sc = new Scanner(System.in);
                String entrada;
                String[] entradaSeparada = new String[3];
                
                // Corpo
                do {
                	
                	System.out.printf("JavaComand>>");
                	
                	entrada = sc.nextLine();
                	entradaSeparada = Comando.pegaComando(entrada);
                	
                	
                	
                	
                	
                	
                }while(!entrada.equals("exit"));

        }
}