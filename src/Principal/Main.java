package Principal;

import Terminal.Cmd;
<<<<<<< HEAD

=======
>>>>>>> branch 'main' of https://github.com/Gabriel-isnt/Trabalho_Final_POO.git
import CommandHandler.Comando;

import java.util.ArrayList;
import java.util.Scanner;


public class Main{
	
        public static void main(String[] args){

                // Lista de comandos aceitos.
                ArrayList<String> comandos = new ArrayList<>();
                comandos.add("pwd");
                comandos.add("ls");
                comandos.add("cd");
                comandos.add("mkdir");
                comandos.add("touch");
                comandos.add("rm");
                comandos.add("cat");
                comandos.add("echo");
                comandos.add("history");
                comandos.add("exit");
                
                // inicialização das classes e scanner pro terminal.
                Cmd cmd = new Cmd();
                Scanner sc = new Scanner(System.in);
                String entrada = null;
                
                String[] entradaSeparada = new String[3];
                
                // Corpo
                do {
                	
                	System.out.printf("JavaComand>>");
                	
                	entrada = sc.nextLine();
                	entradaSeparada = Comando.pegaComando(entrada);
                	
                	
                	
                	
                }while(!entrada.equals("exit"));

        }
}