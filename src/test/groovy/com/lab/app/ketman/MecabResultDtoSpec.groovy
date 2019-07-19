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

}