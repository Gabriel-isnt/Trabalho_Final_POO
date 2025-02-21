package CommandHandler;

public class Comando{

        public static String[] trataComando(String comando){

                String[] entrada = comando.trim().split("\\s+");

                for(int a = 0; a < entrada.length; a++)
                        System.out.printf("parte %d: %s \n", a + 1, entrada[a]);
                
                return entrada;                
        }

        


}

