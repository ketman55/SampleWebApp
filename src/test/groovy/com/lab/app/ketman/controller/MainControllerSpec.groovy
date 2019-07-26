package com.lab.app.ketman.controller
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@AutoConfigureMockMvc
@SpringBootTest
class MainControllerSpec  extends Specification {
	// 主にwhere句で扱いやすくするために空文字などを変数化しておく
	@Shared
	def blank = "" //空文字
	@Shared
	def point = "/v1/analysis" //空文字

	@Autowired
	protected MockMvc mvc

	@Unroll
	def "MainControllerSpec：アクセスポイントのバリエーション：#testCase"(String url, int status, String testCase) {
		when:
		def actual = mvc.perform(get(url)).andReturn().getResponse()
		then:
		actual.getStatus() == status
		where:
		url		|status		|testCase
		""		|500		|"アクセスポイント指定なし"
		"/"		|500		|"アクセスポイント指定なし（/）"
		"/hoge"	|404		|"URL NotFound（指定誤り）"
		point	|400		|"パラメータ未設定"
	}

	@Unroll
	def "MainControllerSpec：パラメータのバリエーション：#testCase"(
			String url,
			String paramName1,
			String paramVal1,
			String paramName2,
			String paramVal2,
			int status,
			String testCase) {
		when:
		def actual = mvc.perform(get(url).param(paramName1, paramVal1).param(paramName2, paramVal2)).andReturn().getResponse()
		then:
		actual.getStatus() == status
		where:
		url		|paramName1	|paramVal1	|paramName2	|paramVal2	|status		|testCase
		point	|"Dammy"	|blank		|"Dammy"	|blank		|400		|"パラメータ誤り"
		point	|"dicType"	|blank		|"Dammy"	|blank		|400		|"パラメータ誤り"
		point	|"Dammy"	|blank		|"inputText"|blank		|400		|"パラメータ誤り"
		point	|"dicType"	|blank		|"inputText"|blank		|500		|"パラメータ設定（値なし）"
		point	|"dicType"	|"@"		|"inputText"|blank		|500		|"パラメータ設定（値なし）"
		point	|"dicType"	|blank		|"inputText"|"@"		|500		|"パラメータ設定（値なし）"
		point	|"dicType"	|"@"		|"inputText"|"@"		|500		|"パラメータ設定（DicType不正）"
		point	|"dicType"	|"WABUN"	|"inputText"|"a"		|200		|"パラメータ設定（値あり：WABUN半角）"
		point	|"dicType"	|"WAKAN"	|"inputText"|"a"		|200		|"パラメータ設定（値あり：WAKAN半角）"
		point	|"dicType"	|"WABUN"	|"inputText"|"あああ"		|200		|"パラメータ設定（値あり：WABUN全角）"
		point	|"dicType"	|"WAKAN"	|"inputText"|"あああ"		|200		|"パラメータ設定（値あり：WAKAN全角）"
	}
}