package DirectoryManager;

import java.io.File;

public class DirectoryManager{


        public static void mudaDiretorio(String diretorioAtual, String novoDiretorio){



                System.setProperty(diretorioAtual, novoDiretorio);
        }

        public static boolean isDiretorio(){
                return true;
        }

        public static File diretorioAtual(){

                File diretorio = new File(System.getProperty("user.dir"));

                return diretorio;
        }

}

