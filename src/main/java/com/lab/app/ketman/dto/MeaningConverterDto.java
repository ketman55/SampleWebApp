package com.lab.app.ketman.dto;

import lombok.Data;

@Data
public class MeaningConverterDto {
	private String id;
	private String title;
	private String meaning;

	public MeaningConverterDto(String id, String title, String meaning){
		this.id = id;
		this.title = title;
		this.meaning = meaning;
	}
}
