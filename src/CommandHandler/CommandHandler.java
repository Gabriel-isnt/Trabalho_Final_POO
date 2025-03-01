package CommandHandler;

import java.util.ArrayList;

public class CommandHandler{

        private String comando;
        private ArrayList<String> comandos;

        public CommandHandler(ArrayList<String> comandos){
                this.comandos = comandos; 
        }


        public void setComando(String comando){
                this.comando = comando;
        }

        public String getComando() {
                return comando;
        }

        public void comandosAceitos(){
                for(String comando : comandos)
                        System.out.printf("\nComando: %s", comando);
                
        }

        public boolean isComandoAceito(String comando){
                return comandos.contains(comando);
        }




}
