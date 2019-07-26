package com.lab.app.ketman.logic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

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
		setup:
		MeaningConverter mc = new MeaningConverter()
		when:
		mc.execute(null)
		then:
		notThrown(Exception)
	}

	@Unroll
	def "MeaningConverterSpec　MecabResultDtoの引数 #testCase"(String original, String testCase) {
		setup:
		MecabResultDto mrd = new MecabResultDto();
		ArrayList<MecabResultDto> mrdList = new ArrayList<MecabResultDto>()
		when:
		mrd.setOriginal(original)
		mrdList.add(mrd)
		mc.execute(mrdList)
		then:
		notThrown(Exception)
		where:
		original							| testCase
		null								| "null"
		blank								| "空文字"
	}
}