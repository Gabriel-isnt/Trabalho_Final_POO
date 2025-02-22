package Principal;

import Terminal.Cmd;
import CommandHandler.Comando;

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
                Cmd cmd = new Cmd();

                // testes básicos
                String[] partes = Comando.pegaComando("echo <caminosflau pequeno> > sem escandalo.txt");  
                mostraPartes(partes);

                partes = Comando.pegaComando("cabelo bacana");
                mostraPartes(partes);

                partes = Comando.pegaComando("sei lá <coisa loka>");
                mostraPartes(partes);
                

                  
                // cmd.Ls(DirectoryManager.diretorioAtual());
        }

        // será apago, essa função é pra testes apenas
        public static void mostraPartes(String[] seila){
                for(int a = 0; a < seila.length; a++){
                        System.out.printf("parte %d: %s\n", a + 1, seila[a]);
                }

                System.out.println("");
        }
}