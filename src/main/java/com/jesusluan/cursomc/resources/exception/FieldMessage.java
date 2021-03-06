package com.jesusluan.cursomc.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String message;

	public FieldMessage() {
		
	}

	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getCampo() {
		return fieldName;
	}

	public void setCampo(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMensagem() {
		return message;
	}

	public void setMensagem(String message) {
		this.message = message;
	}
	
}
