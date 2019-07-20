package com.lab.app.ketman.integration
import static groovyx.net.http.ContentType.*

import org.apache.http.client.HttpResponseException

import groovyx.net.http.RESTClient
import spock.lang.Specification
import spock.lang.Unroll

class RestApiGetAnalysisSpec  extends Specification {

	def ROOT = "http://133.18.170.171:8080/"
	def http = new RESTClient(ROOT)

	def "URL NotFound"() {
		when:
		http.get(path: "hoge")

		then:
		def e = thrown(HttpResponseException)
		e.statusCode == 404
	}

	@Unroll
	def "result 疎通確認"() {
		when:
		def resultList = http.get(path: "v1/analysis", query:[inputText:"つれづれ"], contentType: JSON)
		def resData = resultList.responseData
		then:
		notThrown(HttpResponseException)
		System.out.println(resultList)
		System.out.println(resData)
	}
}