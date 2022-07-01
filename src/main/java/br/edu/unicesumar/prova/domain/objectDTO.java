package br.edu.unicesumar.prova.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class objectDTO {
	
	private String message;
	
	public static final String myUser = "felipe-magrinelli";
	private String user = objectDTO.myUser;
	private String grupo;

}
