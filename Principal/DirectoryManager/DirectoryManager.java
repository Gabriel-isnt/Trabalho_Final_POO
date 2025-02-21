package DirectoryManager;

import java.io.File;

public class DirectoryManager{

        // preciso terminar essa classe pra tudo funcionar como deve
        public static void mudaDiretorio(String diretorioAtual, String novoDiretorio){
                System.setProperty(diretorioAtual, novoDiretorio);
        }

        public static boolean isDiretorio(){
                return true;
        }


        // dava lendo e percebi um problema que isso pode causar
        // vou mexer de noite nessa parte do código
        public static File diretorioAtual(){

                File diretorio = new File(System.getProperty("user.dir"));

                return diretorio;
        }



}

