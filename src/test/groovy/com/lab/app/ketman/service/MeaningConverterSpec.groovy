package com.lab.app.ketman.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import com.lab.app.ketman.dto.MeaningConverterDto
import com.lab.app.ketman.dto.MecabResultDto

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
class MeaningConverterSpec  extends Specification {

	// 主にwhere句で扱いやすくするために空文字などを変数化しておく
	@Shared
	String blank = "" //空文字

	@Autowired
	MeaningConverter mc = new MeaningConverter()

	def "MeaningConverterSpec　MecabResultDtoがnullの場合"() {
		when:
		mc.execute(null)
		then:
		notThrown(Exception)
	}

	@Unroll
	def "MeaningConverterSpec　MecabResultDtoの引数 #testCase"(
		String original,
		int listNum,
		String testCase) {
		setup:
		MecabResultDto mrd = new MecabResultDto();
		ArrayList<MecabResultDto> mrdList = new ArrayList<MecabResultDto>()
		when:
		mrd.setOriginal(original)
		mrdList.add(mrd)
		List<MeaningConverterDto> resultList = mc.execute(mrdList)
		then:
		resultList.size() == listNum
		where:
		original	|listNum	| testCase
		null		|0			| "null"
		blank		|0			| "空文字"
		"testword"	|1			| "DBに入っている値（1件）"
		"okashi"	|0			| "DBに入っていない値"
	}
}