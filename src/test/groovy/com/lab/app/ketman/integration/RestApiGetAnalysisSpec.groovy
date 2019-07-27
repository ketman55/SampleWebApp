package com.lab.app.ketman.integration
import static groovyx.net.http.ContentType.*

import org.apache.http.client.HttpResponseException

import groovyx.net.http.RESTClient
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class RestApiGetAnalysisSpec  extends Specification {

	// 主にwhere句で扱いやすくするために空文字などを変数化しておく
	@Shared
	String[] text = [
		"あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわゐうゑをん",
		"ゔがぎぐげござじずぜぞだぢづでどばびぶべぼぱぴぷぺぽ",
		"ぁぃぅぇぉっゃゅょゎ",
		"アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヰウヱヲン",
		"ヴガギグゲゴザジズゼゾダヂヅデドバビブベボヷヸヹヺパピプペポ",
		"ァィゥェォヵㇰヶㇱㇲッㇳㇴㇵㇶㇷㇸㇹㇺャュョㇻㇼㇽㇾㇿヮ",
		"ゝゞヽヾ",
		"゛゜。、",
		"ー－―～",
		"１２３４５６７８９０",
		"ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ",
		"ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ",
		"0123456789",
		"ABCDEFGHIJKLMNOPQRSTUVWXYZ",
		"abcdefghijklmnopqrstuvwxyz",
		"むかし、男初冠して、奈良の京春日の里に、しるよしして、狩りに往にけり。"
		]

	def ROOT = "http://133.18.170.171:8080/"
	def http = new RESTClient(ROOT)

	@Unroll
	def "RestApiGetAnalysisSpec：mecabとの一気通貫テスト：#testCase"(String dicType, String inputText, String testCase) {
		when:
		def result = http.get(path: "v1/analysis", query:[dicType:dicType, inputText:inputText], contentType: JSON)
		then:
		notThrown(HttpResponseException)
		where:
		dicType	|inputText	|testCase
		"WABUN"	|text[0]	|text[0]
		"WABUN"	|text[1]	|text[1]
		"WABUN"	|text[2]	|text[2]
		"WABUN"	|text[3]	|text[3]
		"WABUN"	|text[4]	|text[4]
		"WAKAN"	|text[5]	|text[5]
		"WAKAN"	|text[6]	|text[6]
		"WAKAN"	|text[7]	|text[7]
		"WAKAN"	|text[8]	|text[8]
		"WAKAN"	|text[9]	|text[9]
		"MANYO"	|text[10]	|text[10]
		"MANYO"	|text[11]	|text[11]
		"MANYO"	|text[12]	|text[12]
		"MANYO"	|text[13]	|text[13]
		"MANYO"	|text[14]	|text[14]
		"WABUN"	|text[15]	|text[15]
	}
}