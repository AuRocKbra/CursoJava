package com.aurock.CursoJava.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * Classe criada para realizar o tratamento de erro quando o ID procurado não existir
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Não foi possível encontrar o recurso de id ="+id);
	}
}
