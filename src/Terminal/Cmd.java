package Terminal;

import DirectoryManager.GerenciaDiretorio;

import java.io.File;

interface Comandos{

        void Pwd();
        void Ls();
        void Cd(String caminho);

}

public class Cmd implements Comandos{

        public Cmd(){
        }
        

        public void Pwd(){
               System.out.printf("diretório: %s", System.getProperty("user.dir")); 
        }

        public void Ls(){

                File diretorio = GerenciaDiretorio.diretorioAtual();

                File[] arquivos = diretorio.listFiles();

                if(arquivos == null){
                        System.out.println("nenhum arquivo encontrado no diretório");
                        return;
                }                

                for(File arquivo : arquivos){
                        System.out.printf("arquivo: %s \n", arquivo.getName());
                }               
        }

        public void Cd(String caminho){
                
                // if()



        }
}