package com.lab.app.ketman.dto;

import java.util.List;

import lombok.Data;

@Data
public class AnalysisReturnDto {
	private List<MecabResultDto> mrd;
	private List<MeaningConverterDto> mcd;

	public AnalysisReturnDto(List<MecabResultDto> mrd, List<MeaningConverterDto> mcd) {
		this.mrd = mrd;
		this.mcd = mcd;
	}
}
