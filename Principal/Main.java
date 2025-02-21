package Principal;

import CommandHandler.CommandHandler;
import CommandHandler.Comando;
import Terminal.Terminal;

import java.util.ArrayList;


public class Main{
        public static void main(String[] args){

                // só pra ter um começo, sujeito a guincho (mudança)
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
                
                // inicialização das classes pro terminal
                CommandHandler ch = new CommandHandler(comandos);
                Terminal cmd = new Terminal();

               // testes básicos
               String[] a = Comando.trataComando("echo mamae comando.txt"); 
               a = Comando.trataComando("ls"); 
               a = Comando.trataComando("curama"); 

        }


}