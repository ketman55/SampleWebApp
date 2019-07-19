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

	def "引数に空のリストが与えられた場合に全項目空文字の入ったDTOを返すテスト"() {
		setup:
		String list = []
		when:
		def mrd = new MecabResultDto(list)
		then:
		mrd.getKanaAppearanceForm() == ""
		mrd.getKanaBasicForm() == ""
		mrd.getLexicalElement() == ""
		mrd.getLexicalElementReading() == ""
		mrd.getOriginal() == ""
		mrd.getPartOfSpeechMain() == ""
		mrd.getPartOfSpeechSub1() == ""
		mrd.getPartOfSpeechSub2() == ""
		mrd.getPartOfSpeechSub3() == ""
		mrd.getPronunciationAppearanceForm() == ""
		mrd.getPronunciationBasicForm() == ""
		mrd.getSurface() == ""
		mrd.getUtilizationForm() == ""
		mrd.getUtilizationType() == ""
		mrd.getWordBasicForm() == ""
		mrd.getWordType() == ""
		mrd.getWritingShapeBasicForm() == ""
		mrd.getWritingShapeSurfaceForm() == ""
	}
}