package com.lab.app.ketman.service

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class CallOutSideMecabSpec  extends Specification {

	// 主にwhere句で扱いやすくするために空文字などを変数化しておく
	@Shared
	String blank = "" //空文字

	@Unroll
	def "CallOutSideMecabSpec：mecabが呼べずにInternalExceptionを発生させるテスト #testCaseのパタン"(
			String dicType,
			String inputText,
			String testCase) {
		setup:
		CallOutsideMecab com = new CallOutsideMecab();
		when:
		com.execute(dicType, inputText);
		then:
		notThrown(Exception)
		where:
		dicType	| inputText							| testCase
		"WAKAN"	|"あ"								| "最小全角"
		"WABUN"	|"あ"								| "最小全角"
		"WAKAN"	|"あbckteいおらｇｒごいばんれ；＠：・１８４０５ん。"	| "適当な文字列"
		"WABUN"	|"あbckteいおらｇｒごいばんれ；＠：・１８４０５ん。"	| "適当な文字列"
	}

	@Unroll
	def "CallOutSideMecabSpec：引数チェックに引っかかってIllegalArgumentExceptionを返すテスト #testCaseのパタン"(
			String dicType,
			String inputText,
			String testCase) {
		setup:
		CallOutsideMecab com = new CallOutsideMecab();
		when:
		com.execute(dicType, inputText);
		then:
		thrown(IllegalArgumentException)
		where:
		dicType	| inputText	| testCase
		null	| null		| "null"
		null	| blank		| "null空文字"
		blank	| null		| "空文字null"
		blank	| blank		| "空文字空文字"
	}
}