package br.com.cliente.client.domain;

public enum Gender {

	  M("Masculino"), // masculino
		F("Feminino"); // feminino
	
	
	  private String label;
	    
	    private Gender(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }

}
