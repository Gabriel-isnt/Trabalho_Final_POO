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
        

        // ?        
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

        public void Cd(String caminho) {

                // Verifica se o caminho é nulo ou vazio
                if (caminho == null || caminho.isEmpty()) {
                        return;
                }

                // Pega o separador de arquivos do sistema operacional atual
                String separador = File.separator;

                // Caso especial: volta ao diretório pai
                if (caminho.equals("..")) {

                        String diretorioPai = GerenciaDiretorio.diretorioAtual().getParent();
                        
                        if (diretorioPai == null) {
                                System.out.println("Já está no diretório raiz!");
                                return;
                        }

                        File diretorioAtual = new File(diretorioPai);
                        
                        if (diretorioAtual.exists() && diretorioAtual.isDirectory()) {
                                GerenciaDiretorio.mudaDiretorio(diretorioAtual);
                        
                        } else {
                                System.out.println("Erro: Diretório pai inválido!");
                        }
                }
        
                // Caminho absoluto ou relativo
                else {
                        File diretorioNovo;

                        // Verifica se é um caminho absoluto
                        boolean ehAbsoluto = false;
                        if (caminho.startsWith(separador)) { 
                                ehAbsoluto = true;
                        
                        //     vendo se pelo menos é C:     vendo se começa com uma letra            vendo se depois da letra é : 
                        } else if (caminho.length() >= 2 && Character.isLetter(caminho.charAt(0)) && caminho.charAt(1) == ':') { 
                                ehAbsoluto = true;
                        }

                        if (ehAbsoluto) {
                                diretorioNovo = new File(caminho);
                        
                        } else {
                                diretorioNovo = new File(GerenciaDiretorio.diretorioAtual(), caminho);
                        }

                        // Verifica se o diretório existe e é válido antes de mudar
                        if (diretorioNovo.exists() && diretorioNovo.isDirectory()) {
                                GerenciaDiretorio.mudaDiretorio(diretorioNovo);
                        
                        } else {
                                System.out.printf("Erro: Diretório '%s' não existe ou não é um diretório!", caminho);
                        }
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