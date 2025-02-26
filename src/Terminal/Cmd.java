package Terminal;

import DirectoryManager.GerenciaDiretorio;

import FileManager.GerenciarArquivos;

import java.io.File;

import CommandHandler.Comando;

public class Cmd {
	
		private static String entrada;
	
        public Cmd(){
        }
        
        public static void armazenamento(String nome) {
        	entrada = nome;
        }

        public static Runnable Pwd(){
               System.out.printf("diretório: %s", System.getProperty("user.dir"));
			return null; 
        }

        public static Runnable Ls(){

                File diretorio = GerenciaDiretorio.diretorioAtual();

                File[] arquivos = diretorio.listFiles();

                if(arquivos == null){
                        System.out.println("nenhum arquivo encontrado no diretório");
                        return null;
                }                

                for(File arquivo : arquivos){
                        System.out.printf("arquivo: %s \n", arquivo.getName());
                }
				return null;               
        }

        public static Runnable Cd() {
        	
        		String[] separacao = Comando.pegaComando(entrada);
        		String caminho = separacao[1];

                // Verifica se o caminho é nulo ou vazio
                if (caminho == null || caminho.isEmpty()) {
                        return null;
                }

                // Pega o separador de arquivos do sistema operacional atual
                String separador = File.separator;

                // Caso especial: volta ao diretório pai
                if (caminho.equals("..")) {

                        String diretorioPai = GerenciaDiretorio.diretorioAtual().getParent();
                        
                        if (diretorioPai == null) {
                                System.out.println("Já está no diretório raiz!");
                                return null;
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
				return null;
        }
        
        public static Runnable Mkdir() {
        	
        	String[] separacao = Comando.pegaComando(entrada);
    		String nome = separacao[1];
        	
        	File novoDiretorio = new File (nome);
        	
                if (novoDiretorio.exists()) {
                        System.out.println("Erro: O diretorio ja existe!");
                        return null;
                }
        	
        	if(novoDiretorio.mkdir()) {
        		System.out.println("Novo diretorio criado com sucesso!");

        	}else {
        		System.out.println("Erro ao criar diretorio!");
        	}
			return null;
        }
        
        public static Runnable Touch() {
        	
        	String[] separacao = Comando.pegaComando(entrada);
    		String nome = separacao[1];
        	
        	GerenciarArquivos.criarArquivo(nome);
			return null;
        }
        
    public static Runnable Rm() {
    	
    	String[] separacao = Comando.pegaComando(entrada);
		String nome = separacao[1];
		return null;
    	
    }


	public static Runnable Cat() {
				
				String[] separacao = Comando.pegaComando(entrada);
				String nome = separacao[1];
                GerenciarArquivos.lerArquivo(nome);
				return null;
        }
	
    public static Runnable Echo() {
    	
    	String[] separacao = Comando.pegaComando(entrada);
		String texto = separacao[1];
		String nome = separacao[2];
		return null;
    	
    }
    
    public static Runnable History() {
		return null;
    	
    }
}