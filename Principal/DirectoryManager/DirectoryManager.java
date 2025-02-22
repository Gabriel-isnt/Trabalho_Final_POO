package DirectoryManager;

import java.io.File;

public class DirectoryManager{

        public static boolean mudaDiretorio(File novoDiretorio){
                
                if(!isDiretorio(novoDiretorio)){
                        System.out.println("diretório passado não é um diretório");
                        return false;
                }

                System.setProperty("user.dir", novoDiretorio.getAbsolutePath());
                return true;
        }

        public static boolean isDiretorio(File diretorio){
                return diretorio.isDirectory();
        }

        public static File diretorioAtual(){
                
                File diretorioAtual = new File(System.getProperty("user.dir"));

                return diretorioAtual;
        }

}

