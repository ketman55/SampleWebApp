package com.lab.app.ketman
import com.lab.app.ketman.dto.MecabResultDto

import spock.lang.Specification

class MecabResultDtoSpec  extends Specification {

	def "引数にNULLが与えられた場合にエラーを返すテスト"() {
		setup:
		def list = null
		when:
		new MecabResultDto(list)
		then:
		thrown(IllegalArgumentException)
	}

	def "引数に空のリストが与えられた場合に空のDTOを返すテスト"() {
		setup:
		String list = []
		expect:
		new MecabResultDto(list).asBoolean() == true
	}
}