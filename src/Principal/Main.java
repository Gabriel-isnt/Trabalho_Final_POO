package Principal;

import Terminal.Cmd;
import CommandHandler.Comando;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    private static Map<String, Runnable> comandos = new HashMap<>();
    
    public static void main(String[] args) {

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
