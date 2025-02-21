package Principal;

import DirectoryManager.*;
import CommandHandler.*;
import Terminal.*;

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
                apagar(a);

                // arrumar pra esse caso aqui quando der o echo
                a = Comando.trataComando("curama do caminosflau"); 
                apagar(a);
                
                a = Comando.trataComando("cd      ..");    
                apagar(a);   

                cmd.Ls(DirectoryManager.diretorioAtual());
        }

        // deletar essa função, ela só existe pra testes
        public static void apagar(String[] algo){
                for(int a = 0; a < algo.length; a++){
                        System.out.printf("parte %d: %s \n", a + 1, algo[a]);
                }

                System.out.println("");
        }


}