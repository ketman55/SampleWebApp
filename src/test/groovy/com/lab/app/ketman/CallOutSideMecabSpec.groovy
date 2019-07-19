package com.lab.app.ketman
import com.lab.app.ketman.mecab.CallOutsideMecab

import spock.lang.Shared
import spock.lang.Specification

// 外部プロセスを呼ぶ部分はControllerとの内部結合で巻き取って、ここでは異常チェックのみテストする
class CallOutSideMecabSpec  extends Specification {

	// 主にwhere句で扱いやすくするために空文字などを変数化しておく
	@Shared
	String blank = "" //空文字

	def "CallOutSideMecabSpec：引数チェックに引っかかってIllegalArgumentExceptionを返すテスト #testCaseのパタン"(String inputText, String testCase) {
		setup:
		CallOutsideMecab com = new CallOutsideMecab();
		when:
		com.execute(inputText);
		then:
		thrown(IllegalArgumentException)
		where:
		inputText| testCase
		null	| "null"
		blank	| "空文字"
		"!"		| "!"
		"\""	| "\""
		"\'"	| "\'"
		"#"		| "#"
		"*"		| "*"
		"\$"	| "\$"
		"%"		| "%"
		"&"		| "&"
		"("		| "("
		")"		| ")"
		"-"		| "-"
		"^"		| "^"
		"\\"	| "\\"
		"@"		| "@"
		"["		| "["
		";"		| ";"
		":"		| ":"
		"]"		| "]"
		","		| ","
		"."		| "."
		"/"		| "/"
		"ああ/"	| "文字＋記号"
		"/ああ"	| "記号＋文字"
		"あ/あ"	| "文字＋記号＋文字"
	}
}