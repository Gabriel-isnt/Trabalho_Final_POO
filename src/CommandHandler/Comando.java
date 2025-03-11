package CommandHandler;

public class Comando {

        private static String trataComando(String comando){
               
                if(comando == null || comando.trim().isEmpty()){
                        return null;
                }

               return comando.trim();
        }

        // ainda vou arrumar esses ifs muito confusos 
        public static String[] pegaComando(String comando){

                comando = trataComando(comando);

                if(comando == null){
                        return new String[0];
                }

                // a entrada seria: comando <texto> > arquivo
                String parte1 = null;  // antes do <
                String parte2 = null;  // entre o <>
                String parte3 = null;  // depois do segundo > 

                // indexof retorna -1 se não encontrar
                int comecaParte2  = comando.indexOf('<');
                int terminaParte2 = comando.indexOf('>', comecaParte2 + 1);
                int comecaParte3  = comando.indexOf('>', terminaParte2 + 1);

                // caso só tenha 1 comando
                if(comecaParte2 == -1){
                        parte1 = comando;
                        return new String[] {parte1, null, null};
                } 
                 
                // com 2 comandos ou mais
                parte1 = comando.substring(0, comecaParte2).trim();

                if(terminaParte2 != -1){
                        parte2 = comando.substring(comecaParte2 + 1, terminaParte2).trim();
                }

                if(comecaParte3 != -1){
                        parte3 = comando.substring(comecaParte3 + 1).trim();

                        // caso não tenha parte2, só parte3
                        if(terminaParte2 == -1 && comecaParte2 != -1){
                                parte1 = comando.substring(0, comecaParte2).trim();
                        }

                        if(terminaParte2 == -1 && comecaParte3 != comecaParte2){
                                terminaParte2 = comando.indexOf('>');

                                if(terminaParte2 != -1){
                                        parte2 = comando.substring(comecaParte2 + 1, terminaParte2).trim();
                                }
                        }

                } else if(terminaParte2 != -1 && terminaParte2 < comando.length() - 1){
                        parte3 =  comando.substring(terminaParte2 + 1).trim();
                }

                return new String[] {parte1, parte2, parte3};
        }




}

