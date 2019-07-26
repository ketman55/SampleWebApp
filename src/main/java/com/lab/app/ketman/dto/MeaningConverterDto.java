package com.lab.app.ketman.dto;

import lombok.Data;

@Data
public class MeaningConverterDto {
	private String listNo;
	private String id;
	private String word;
	private String meaning;

	public MeaningConverterDto(String listNo, String id, String word, String meaning){
		this.listNo = listNo;
		this.id = id;
		this.word = word;
		this.meaning = meaning;
	}
}
