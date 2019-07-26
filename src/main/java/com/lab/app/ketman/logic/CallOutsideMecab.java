package com.lab.app.ketman.logic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lab.app.ketman.common.CheckInputText;
import com.lab.app.ketman.dto.MecabResultDto;

@Service
public class CallOutsideMecab {
	ArrayList<MecabResultDto> resultList = new ArrayList<MecabResultDto>();

	public List<MecabResultDto> execute(String inputText) throws Exception{
		// 引数の妥当性を確認
		CheckInputText cit = new CheckInputText();
		if(cit.execute(inputText) == false)throw new IllegalArgumentException("CallOutsideMecab：inputText has something problem");

		// mecabにかける
		// Windowsの場合は cmd /c
		//String[] command = {"cmd", "/c", "echo", inputText,"|", "mecab", "-d", "src\\main\\resources\\UniDic-wabun_1603"};
		//CentOSの場合は bash -c command(ひと囲みにすること)
		String com =
				"echo"
						+ " "
						+ inputText
						+ " "
						+ "|"
						+ " "
						+ "mecab"
						+ " "
						+ "-d"
						+ " "
						+ "/usr/local/lib/UniDic-wabun_1603";
		String[] command = {"bash", "-c", com};
		System.out.println(com);

		try {
			Process process = new ProcessBuilder(command).start();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);

			// 結果をDTOへ格納
			String c;
			while ((c = reader.readLine()).equals("EOS") == false) {
				//調査用：コンソールへ出力
				System.out.println(c);
				//タブとカンマで分割
				String[] data = c.split("(\\t|,)");
				//結果をDtoListに格納
				MecabResultDto mrd = new MecabResultDto(data);
				resultList.add(mrd);
			}
		}catch(Exception e) {
			// Mecabが取れなくても200応答で返す
		}
		return resultList;
	}
}

