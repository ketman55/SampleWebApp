package com.lab.app.ketman.dto

import org.springframework.boot.test.context.SpringBootTest

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
class MeaningConverterDtoSpec  extends Specification {

	// 主にwhere句で扱いやすくするために空文字などを変数化しておく
	@Shared
	String blank = "" //空文字

	def "MeaningConverterDtoSpec　MeaningConverterDtoの無名コンストラクタ"() {
		when:
		MeaningConverterDto mcd = new MeaningConverterDto()
		then:
		mcd.getListNo() == "";
		mcd.getId() == "";
		mcd.getWord() == "";
		mcd.getMeaning() == "";
	}

	def "MeaningConverterDtoSpec　MeaningConverterDtoのnullコンストラクタ"() {
		when:
		MeaningConverterDto mcd = new MeaningConverterDto(null,null,null,null)
		then:
		mcd.getListNo() == "";
		mcd.getId() == "";
		mcd.getWord() == "";
		mcd.getMeaning() == "";
	}

	@Unroll
	def "MeaningConverterDtoSpec　MeaningConverterDtoの引数 #testCase"(
		String listNo,
		String id,
		String word,
		String meaning,
		String testCase) {
		when:
		MeaningConverterDto mcd = new MeaningConverterDto(listNo,id,word,meaning);
		then:
		mcd.getListNo() == listNo;
		mcd.getId() == id;
		mcd.getWord() == word;
		mcd.getMeaning() == meaning;
		where:
		listNo		|id			|word		|meaning	|testCase
		blank		|blank		|blank		|blank		|"空文字"
		"a"			|"a"		|"a"		|"a"		|"最小文字"
		"a1あい@"	|"a1あい@"	|"a1あい@"	|"a1あい@"	|"適当な文字列"
	}
}