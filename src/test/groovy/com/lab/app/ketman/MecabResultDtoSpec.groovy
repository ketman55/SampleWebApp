package com.lab.app.ketman
import com.lab.app.ketman.dto.MecabResultDto

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class MecabResultDtoSpec  extends Specification {

	// 主にwhere句で扱いやすくするために空文字などを変数化しておく
	@Shared
	def blank = "" //空文字
	@Shared
	def aster = "*" //アスタリスク
	@Shared
	def minim = "a" //有件最小文字数
	@Shared
	def large = "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわゐうゑをんゔがぎぐげござじずぜぞだぢづでどばびぶべぼぱぴぷぺぽぁぃぅぇぉっゃゅょゎ" //適当なボリュームの文字数

	def "引数がNULLの場合にIllegalArgumentExceptionを返すテスト"() {
		setup:
		String[] data = null
		when:
		new MecabResultDto(data)
		then:
		thrown(IllegalArgumentException)
	}

	def "MecabResultDtoSpec：引数が空のリストの場合に全項目空文字の入ったDTOを返すテスト"() {
		setup:
		String[] data = []
		when:
		def mrd = new MecabResultDto(data)
		then:
		mrd.getSurface() == blank
		mrd.getPartOfSpeechMain() == blank
		mrd.getPartOfSpeechSub1() == blank
		mrd.getPartOfSpeechSub2() == blank
		mrd.getPartOfSpeechSub3() == blank
		mrd.getUtilizationType() == blank
		mrd.getUtilizationForm() == blank
		mrd.getLexicalElementReading() == blank
		mrd.getLexicalElement() == blank
		mrd.getOriginal() == blank
		mrd.getWritingShapeSurfaceForm() == blank
		mrd.getPronunciationAppearanceForm() == blank
		mrd.getKanaAppearanceForm() == blank
		mrd.getWordType() == blank
		mrd.getWritingShapeBasicForm() == blank
		mrd.getPronunciationBasicForm() == blank
		mrd.getKanaBasicForm() == blank
		mrd.getWordBasicForm() == blank
	}

	def "MecabResultDtoSpec：引数のリストが17項目以下であってもエラーが発生しないことの確認テスト"() {
		setup:
		String[] data = ["00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16"]
		expect:
		new MecabResultDto(data)
	}

	def "MecabResultDtoSpec：引数のリストが19項目以上あってもエラーが発生しないことの確認テスト"() {
		setup:
		String[] data = ["00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18"]
		expect:
		new MecabResultDto(data)
	}

	@Unroll
	def "MecabResultDtoSpec：引数のバリエーションテスト：#testCaseのパタン"(
			String i00,String i01,String i02,String i03,String i04,String i05,String i06,String i07,String i08,String i09,
			String i10,String i11,String i12,String i13,String i14,String i15,String i16,String i17,
			String m00,String m01,String m02,String m03,String m04,String m05,String m06,String m07,String m08,String m09,
			String m10,String m11,String m12,String m13,String m14,String m15,String m16,String m17,
			String testCase
	) {
		when:
		String[] data = [i00, i01,i02,i03,i04,i05,i06,i07,i08,i09,i10,i11,i12,i13,i14,i15,i16,i17]
		def mrd = new MecabResultDto(data)
		then:
		mrd.getSurface() == m00
		mrd.getPartOfSpeechMain() == m01
		mrd.getPartOfSpeechSub1() == m02
		mrd.getPartOfSpeechSub2() == m03
		mrd.getPartOfSpeechSub3() == m04
		mrd.getUtilizationType() == m05
		mrd.getUtilizationForm() == m06
		mrd.getLexicalElementReading() == m07
		mrd.getLexicalElement() == m08
		mrd.getOriginal() == m09
		mrd.getWritingShapeSurfaceForm() == m10
		mrd.getPronunciationAppearanceForm() == m11
		mrd.getKanaAppearanceForm() == m12
		mrd.getWordType() == m13
		mrd.getWritingShapeBasicForm() == m14
		mrd.getPronunciationBasicForm() == m15
		mrd.getKanaBasicForm() == m16
		mrd.getWordBasicForm() == m17
		where:
		i00		|i01	|i02	|i03	|i04	|i05	|i06	|i07	|i08	|i09	|i10	|i11	|i12	|i13	|i14	|i15	|i16	|i17	|m00	|m01	|m02	|m03	|m04	|m05	|m06	|m07	|m08	|m09	|m10	|m11	|m12	|m13	|m14	|m15	|m16	|m17	|testCase
		null	|null	|null	|null	|null	|null	|null	|null	|null	|null	|null	|null	|null	|null	|null	|null	|null	|null	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|"null⇒空文字"
		blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|"空文字⇒空文字"
		aster	|aster	|aster	|aster	|aster	|aster	|aster	|aster	|aster	|aster	|aster	|aster	|aster	|aster	|aster	|aster	|aster	|aster	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|blank	|"アスタリスク⇒空文字"
		"00"	|"01"	|"02"	|"03"	|"04"	|"05"	|"06"	|"07"	|"08"	|"09"	|"10"	|"11"	|"12"	|"13"	|"14"	|"15"	|"16"	|"17"	|"00"	|"01"	|"02"	|"03"	|"04"	|"05"	|"06"	|"07"	|"08"	|"09"	|"10"	|"11"	|"12"	|"13"	|"14"	|"15"	|"16"	|"17"	|"インプットとアウトプットのデータマッピングが想定通りか確認"
		minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|minim	|"有件最小（半角1文字）"
		large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|large	|"有件複数（全角沢山）"
	}
}