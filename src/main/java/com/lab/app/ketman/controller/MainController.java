package com.lab.app.ketman.controller;

import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab.app.ketman.dto.MecabResultDto;
import com.lab.app.ketman.logic.CallHankakuToZenkaku;
import com.lab.app.ketman.logic.CallOutsideMecab;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = {"/v1/analysis","/"})
public class MainController {

	// @ApiOperationでリソースの概要を設定
    @ApiOperation(value = "フロントエンドから古文データを受け取って解析結果を返却する")
	@GetMapping("/v1/analysis")
	public List<MecabResultDto> GetAnalysedData(@RequestParam("inputText") String inputText) throws Exception {
		try {
			// 前処理（半角を全角に変換）
			inputText = new CallHankakuToZenkaku().getZenkaku(inputText);

			// mecab解析
			CallOutsideMecab com = new CallOutsideMecab();
			List<MecabResultDto> resultList = com.execute(inputText);

			// 意味拾い



			// 結果返却
			return resultList;
		} catch (Exception e) {
			throw new MethodArgumentNotValidException (null, null);
		}
	}

    // アクセスポイント指定なしで来た場合もエラーを返す
	@GetMapping("/")
	public List<MecabResultDto> BlankAccessPoint() throws Exception {
			throw new MethodArgumentNotValidException (null, null);
	}
}
