package DirectoryManager;

import java.io.File;

public abstract class DirectoryManager{

        public static boolean mudaDiretorio(File novoDiretorio){
        
                if(!novoDiretorio.isDirectory()){
                        System.out.println("\nDiretório passado não é um diretório");
                        return false;
                }

                System.setProperty("user.dir", novoDiretorio.getAbsolutePath());
                return true;
        }

}