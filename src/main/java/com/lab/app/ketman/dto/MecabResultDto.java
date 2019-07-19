package com.lab.app.ketman.dto;

import lombok.Data;

@Data
public class MecabResultDto{
	private String surface;//表層
	private String partOfSpeechMain;//主たる品詞
	private String partOfSpeechSub1;//品詞１
	private String partOfSpeechSub2;//品詞２
	private String partOfSpeechSub3;//品詞３
	private String utilizationType;//活用型
	private String utilizationForm;//活用形
	private String lexicalElementReading;//語彙素（読み）
	private String lexicalElement;//語彙素
	private String original;//原形
	private String writingShapeSurfaceFrom;//書字形（表層形）
	private String pronunciationAppearanceForm;//発音形出現形
	private String kanaAppearanceFrom;//仮名形出現形
	private String wordType;//語種
	private String writingShapeBasicFrom;//書字形（基本形）
	private String pronunciationBasicForm;//発音形(基本形)
	private String kanaBasicFrom;//仮名形(基本形)
	private String wordBasicForm;//語形(基本形)

	// コンストラクタ
	public MecabResultDto(String[] data){
		// 引数がNULLの場合はエラーを返す
		if( data == null ) throw new IllegalArgumentException();
		// 作業用の箱
		String[] allData = new String[18];
		// AllDataに初期値を設定
		for(int i=0; i<allData.length; i++) {
			allData[i] = "";
		}
		// AllDataに引数の値を設定
		for(int i=0; i<data.length; i++) {
			// nullまたは*の場合は保存しない
			if(data[i] == null || data[i].equals("*")) {

			}else {
				allData[i] = data[i];
			}
			// 解析結果は18以上存在するが、現状は足切り
			if(i == 17) break;
		}
		// 各変数へ値を設定
		this.surface = allData[0];
		this.partOfSpeechMain = allData[1];
		this.partOfSpeechSub1 = allData[2];
		this.partOfSpeechSub2 = allData[3];
		this.partOfSpeechSub3 = allData[4];
		this.utilizationType = allData[5];
		this.utilizationForm = allData[6];
		this.lexicalElementReading = allData[7];
		this.lexicalElement = allData[8];
		this.original = allData[9];
		this.writingShapeSurfaceFrom = allData[10];
		this.pronunciationAppearanceForm = allData[11];
		this.kanaAppearanceFrom = allData[12];
		this.wordType = allData[13];
		this.writingShapeBasicFrom = allData[14];
		this.pronunciationBasicForm = allData[15];
		this.kanaBasicFrom = allData[16];
		this.wordBasicForm = allData[17];
	}
}