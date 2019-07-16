package com.lab.app.ketman
import spock.lang.Specification

class MainControllerSpec  extends Specification {

	/*
	def ROOT = "http://localhost:8080/"
	def http = new RESTClient(ROOT)

	@Unroll
	def "URL NotFound"() {
		when:
		http.get(path: "hoge")

		then:
		def e = thrown(HttpResponseException)
		e.statusCode == 404
		e.message == "status code: 404"
	}

	@Unroll
	def "result 疎通確認"() {
		when:
		http.handler.failure = http.handler.success
		def resultList = http.get(path: "result", query:[inputText:"つれづれ"], contentType: JSON)
		def resData = resultList.responseData

		then:
		notThrown(HttpResponseException)
		System.out.println(resultList)
		System.out.println(resData)



	}
	*/

	def "OKテスト"() {
		expect:
		1 + 1 == 2
	}

}