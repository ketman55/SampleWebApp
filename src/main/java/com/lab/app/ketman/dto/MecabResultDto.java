package com.lab.app.ketman.dto;

public class MecabResultDto{
	private String Surface;//表層
	private String PartOfSpeech0;//品詞０
	private String PartOfSpeech1;//品詞１
	private String PartOfSpeech2;//品詞２
	private String PartOfSpeech3;//品詞３
	private String Utilization0;//活用０
	private String Utilization1;//活用１
	private String Original;//原形
	private String Reading;//読み
	private String Pronunciation;//発音


	// コンストラクタ
	public MecabResultDto(String[] data){
		// lengthが設定以下の場合は何かがおかしいのでエラーを吐く
		if(data.length < 10) throw new IllegalArgumentException("DTO Making Error：This data length is " + Integer.toString(data.length));

		// nullを空文字に変換
		for(int i=0; i<data.length; i++) {
			if(data[i] == null) data[i] = "";
		}

		// 値をセット
		this.Surface = data[0];
		this.PartOfSpeech0 = data[1];
		this.PartOfSpeech1 = data[2];
		this.PartOfSpeech2 = data[3];
		this.PartOfSpeech3 = data[4];
		this.Utilization0 = data[5];
		this.Utilization1 = data[6];
		this.Original = data[7];
		this.Reading = data[8];
		this.Pronunciation = data[9];
	}

	// getter/setter
	public String getSurface() {
		return Surface;
	}
	public void setSurface(String surface) {
		Surface = surface;
	}
	public String getPartOfSpeech0() {
		return PartOfSpeech0;
	}
	public void setPartOfSpeech0(String partOfSpeech0) {
		PartOfSpeech0 = partOfSpeech0;
	}
	public String getPartOfSpeech1() {
		return PartOfSpeech1;
	}
	public void setPartOfSpeech1(String partOfSpeech1) {
		PartOfSpeech1 = partOfSpeech1;
	}
	public String getPartOfSpeech2() {
		return PartOfSpeech2;
	}
	public void setPartOfSpeech2(String partOfSpeech2) {
		PartOfSpeech2 = partOfSpeech2;
	}
	public String getPartOfSpeech3() {
		return PartOfSpeech3;
	}
	public void setPartOfSpeech3(String partOfSpeech3) {
		PartOfSpeech3 = partOfSpeech3;
	}
	public String getUtilization0() {
		return Utilization0;
	}
	public void setUtilization0(String utilization0) {
		Utilization0 = utilization0;
	}
	public String getUtilization1() {
		return Utilization1;
	}
	public void setUtilization1(String utilization1) {
		Utilization1 = utilization1;
	}
	public String getOriginal() {
		return Original;
	}
	public void setOriginal(String original) {
		Original = original;
	}
	public String getReading() {
		return Reading;
	}
	public void setReading(String reading) {
		Reading = reading;
	}
	public String getPronunciation() {
		return Pronunciation;
	}
	public void setPronunciation(String pronunciation) {
		Pronunciation = pronunciation;
	}
}
