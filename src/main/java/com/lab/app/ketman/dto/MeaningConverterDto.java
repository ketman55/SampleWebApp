package com.lab.app.ketman.dto;

import lombok.Data;

@Data
public class MeaningConverterDto {
	private String listNo = "";
	private String id = "";
	private String word = "";
	private String meaning = "";

	public MeaningConverterDto(String listNo, String id, String word, String meaning){
		if(listNo != null) this.listNo = listNo;
		if(id != null) this.id = id;
		if(word != null) this.word = word;
		if(meaning != null) this.meaning = meaning;
	}

	public MeaningConverterDto() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
}
