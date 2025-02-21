package Terminal;

interface Comandos{

        void Ls();
        void Pwd();

}

public class Terminal implements Comandos{

        public Terminal(){

        }

        public void Pwd(){
               System.out.printf("diretório: %s", System.getProperty("user.dir")); 
        }

        public void Ls(){
                System.out.println("nada ainda");
        }
}