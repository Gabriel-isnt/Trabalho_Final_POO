package Terminal;

import java.io.File;

interface Comandos{

        void Ls();
        void Pwd();
        void cd(File diretorio);

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

        public void cd(File diretorio){
                
                if(!(diretorio.exists() && diretorio.isDirectory())){
                        System.out.println("diretório não existe");
                        return;
                }                

                File[] arquivos = diretorio.listFiles();

                if(arquivos == null){
                        System.out.println("nenhum arquivo encontrado no diretório");
                        return;
                }                

                for(File arquivo : arquivos){
                        System.out.printf("arquivo: %s \n", arquivo);
                }
        }
}