package com.lab.app.ketman.common;

public class CheckInputText {
	// 引数の妥当性チェック
	public boolean execute(String inputText) {
		if(inputText == null || inputText.equals("")) {
			return false;
		}
		return true;
	}
}
