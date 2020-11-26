package utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class LeitorJsonWithGson {
	// create Gson instance
    Gson gson = new Gson();
    Reader reader;
    Map<String, String> map;
	
	/*
     * Faz a leitura de arquivos jSon no diretorio desejado
     */
	
	@SuppressWarnings("unchecked")
	public void leitorJson(String casoDeTeste) throws IOException {

	    // Leitor do Java
	    reader = new FileReader("C:\\Users\\F15M0M5\\Desktop\\AutomacaoLogin\\massa_testes.json");
	    @SuppressWarnings("rawtypes")
		List listJson = new ArrayList<Map<String, String>>();
	    
	    //Objeto do Tipo Lista com varios Maps
	    
	    
	    // converte JSON file to map
	    listJson = gson.fromJson(reader, List.class);
	    
	    if (casoDeTeste.equals("LoginStandardUser")) {
	    	map = (Map<String, String>) listJson.get(0);
	    	
	    }else if (casoDeTeste.equals("LoginLockedOutUser")) {
	    	map = (Map<String, String>) listJson.get(1);
	    	
	    }else if (casoDeTeste.equals("LoginProblemUser")) {
	    	map = (Map<String, String>) listJson.get(2);
	    	
	    }else if (casoDeTeste.equals("LoginPerformanceGlitchUser")) {
	    	map = (Map<String, String>) listJson.get(3);
	    	
	    }else if (casoDeTeste.equals("UsernameEmBranco")) {
	    	map = (Map<String, String>) listJson.get(4);
	    
	    }else if (casoDeTeste.equals("PasswordEmBranco")) {
	    	map = (Map<String, String>) listJson.get(5);
	    
	    }else if (casoDeTeste.equals("UsernameInvalido")) {
	    	map = (Map<String, String>) listJson.get(6);
	    
	    }else if(casoDeTeste.equals("PasswordInvalida")) {
	    	map = (Map<String, String>) listJson.get(7);
	    
	    }
	    
	    exibirmapJson(map);

	    // close reader
	    reader.close();

	}
	
	/*
     * Exibe os registros np arquivo jSon
     */

	private void exibirmapJson(Map<String, String> map) {
		// print map entries
	    for (Map.Entry<String, String> entry : map.entrySet()) {
	        System.out.println(entry.getKey() + "=" + entry.getValue());
	    }
	}
	
	/*
	 * Captura a chave que identifica o valor que queremos utilizar no arquivo jSon
	 */
	
	public String getMassa(String chave) {
		return map.get(chave);
	}
	

}
