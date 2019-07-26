package com.lab.app.ketman.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.lab.app.ketman.dto.MeaningConverterDto;
import com.lab.app.ketman.dto.MecabResultDto;

@Service
public class MeaningConverter {
	private final static String TABLE = "WORD_DICTIONARY";
	private static final String SELECT_SQL = "SELECT * FROM WORD_DICTIONARY WHERE ID = \"1\"";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<MeaningConverterDto> execute(List<MecabResultDto> mrdList) {
		ArrayList<MeaningConverterDto> rcdList = new ArrayList<MeaningConverterDto>();
		// 引数チェック
		if(mrdList == null) {

		}else {
			// DBから引っ張ってくる
			for(int i=0; i<mrdList.size(); i++) {
				// originalがnullや空文字の場合
				if(mrdList == null || mrdList.get(i).getOriginal() == null || mrdList.get(i).getOriginal().equals("")) continue;

				// DB検索
				Map<String, Object> actualData = this.jdbcTemplate.queryForMap(SELECT_SQL);
				// 見つからなかった場合
				if(actualData.isEmpty()) continue;

				// 見つかった場合
				MeaningConverterDto mcd = new MeaningConverterDto(
						actualData.get("ID").toString(),
						actualData.get("WORD").toString(),
						actualData.get("MEANING").toString()
						);
				rcdList.add(mcd);
			}
		}
		return rcdList;
	}
}
