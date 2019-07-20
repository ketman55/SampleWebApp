package com.lab.app.ketman.logic

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class CallOutSideMecabSpec  extends Specification {

	// 主にwhere句で扱いやすくするために空文字などを変数化しておく
	@Shared
	String blank = "" //空文字

	@Unroll
	def "CallOutSideMecabSpec：mecabが呼べずにInternalExceptionを発生させるテスト #testCaseのパタン"(String inputText, String testCase) {
		setup:
		CallOutsideMecab com = new CallOutsideMecab();
		when:
		com.execute(inputText);
		then:
		notThrown(Exception)
		where:
		inputText	| testCase
		"あ"		| "最小全角"
		"あbckteいおらｇｒごいばんれ；＠：・１８４０５ん。"	| "適当な文字列"
	}

	@Unroll
	def "CallOutSideMecabSpec：引数チェックに引っかかってIllegalArgumentExceptionを返すテスト #testCaseのパタン"(String inputText, String testCase) {
		setup:
		CallOutsideMecab com = new CallOutsideMecab();
		when:
		com.execute(inputText);
		then:
		thrown(IllegalArgumentException)
		where:
		inputText	| testCase
		null		| "null"
		blank		| "空文字"
	}
}