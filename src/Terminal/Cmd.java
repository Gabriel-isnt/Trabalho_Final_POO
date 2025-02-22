package Terminal;

import DirectoryManager.GerenciaDiretorio;

import FileManager.GerenciarArquivos;

import java.io.File;

interface Comandos{

        void Pwd();
        void Ls();
        void Cd(String caminho);
        void Mkdir(String nome);
        void Touch(String nome);
        void Cat(String nome);

}

public class Cmd implements Comandos{

        public Cmd(){
        }
        
        
        public static void executarComando(String comando) {
        	
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

                if(caminho == null || caminho.isEmpty()){
                        return;
                }
                
                if(caminho.equals("..")){
                        String diretorioPai = GerenciaDiretorio.diretorioAtual().getParent();
                                
                        if(diretorioPai == null)
                                return;

                        File diretorioAtual = new File(diretorioPai);

                        GerenciaDiretorio.mudaDiretorio(diretorioAtual);

                        
                // temrinar depois isso aqui
                } else if(){
                        File diretorioNovo  = new File(GerenciaDiretorio.diretorioAtual(), caminho); 
                        GerenciaDiretorio.mudaDiretorio(diretorioNovo);

                }

        }
        
        public void Mkdir(String nome) {
        	
        	File novoDiretorio = new File (nome);
        	
            if (novoDiretorio.exists()) {
                System.out.println("Erro: O diretorio ja existe!");
                return;
            }
        	
        	if(novoDiretorio.mkdir()) {
        		System.out.println("Novo diretorio criado com sucesso!");
        	}else {
        		System.out.println("Erro ao criar diretorio!");
        	}
        }
        
        public void Touch(String nome) {
        	
        	GerenciarArquivos.criarArquivo(nome);
        }


		public void Cat(String nome) {
			
			GerenciarArquivos.lerArquivo(nome);
		}
}