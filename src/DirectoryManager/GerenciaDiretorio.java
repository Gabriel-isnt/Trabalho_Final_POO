package DirectoryManager;

import DirectoryManager.DirectoryManager;

import java.io.File;

public class GerenciaDiretorio extends DirectoryManager{

        public static boolean isDiretorio(File diretorio){
                return diretorio.isDirectory();
        }

        public static File diretorioAtual(){
                
                File diretorioAtual = new File(System.getProperty("user.dir"));

                return diretorioAtual;
        }

}

