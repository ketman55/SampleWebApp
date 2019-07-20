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
		"abcdefghijklmnopqrstuvwxyz"
		]

	def ROOT = "http://133.18.170.171:8080/"
	def http = new RESTClient(ROOT)

	@Unroll
	def "RestApiGetAnalysisSpec：mecabとの一気通貫テスト：#testCase"(String inputText, String testCase) {
		when:
		def result = http.get(path: "v1/analysis", query:[inputText:inputText], contentType: JSON)
		then:
		notThrown(HttpResponseException)
		where:
		inputText	|testCase
		text[0]		|text[0]
		text[1]		|text[1]
		text[2]		|text[2]
		text[3]		|text[3]
		text[4]		|text[4]
		text[5]		|text[5]
		text[6]		|text[6]
		text[7]		|text[7]
		text[8]		|text[8]
		text[9]		|text[9]
		text[10]	|text[10]
		text[11]	|text[11]
		text[12]	|text[12]
		text[13]	|text[13]
		text[14]	|text[14]
	}
}