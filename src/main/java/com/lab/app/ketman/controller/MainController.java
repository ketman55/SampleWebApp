package com.lab.app.ketman.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab.app.ketman.dto.MecabResultDto;
import com.lab.app.ketman.mecab.CallOutsideMecab;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/analysis")
public class MainController {

	// @ApiOperationでリソースの概要を設定
    @ApiOperation(value = "フロントエンドから古文データを受け取って解析結果を返却する")
	@GetMapping
	public List<MecabResultDto> GetAnalysedData(@RequestParam("inputText") String inputText) {
		try {
			// mecab解析
			CallOutsideMecab com = new CallOutsideMecab();
			List<MecabResultDto> resultList = com.execute(inputText);

			// 意味拾い

			// 結果返却
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
