package com.lab.app.ketman.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.lab.app.ketman.dto.MeaningConverterDto;
import com.lab.app.ketman.dto.MecabResultDto;

@Service
public class MeaningConverter {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<MeaningConverterDto> execute(List<MecabResultDto> mrdList) {
		ArrayList<MeaningConverterDto> mcdList = new ArrayList<MeaningConverterDto>();
		// 引数チェック
		if(mrdList == null) {

		}else {
			// DBから引っ張ってくる
			for(int i=0; i<mrdList.size(); i++) {
				MeaningConverterDto mcd = new MeaningConverterDto();
				mcd.setListNo(Integer.toString(i));
				// originalがnullや空文字の場合
				if(mrdList == null || mrdList.get(i).getOriginal() == null || mrdList.get(i).getOriginal().equals("")) {

				}else {
					// DB検索
					try {
						String SELECT_SQL = "SELECT * FROM WORD_DICTIONARY WHERE WORD = "
								+ "\'"
								+ mrdList.get(i).getOriginal()
								+ "\'";

						Map<String, Object> actualData = this.jdbcTemplate.queryForMap(SELECT_SQL);
						// 見つかった場合
						mcd.setId(actualData.get("ID").toString());
						mcd.setWord(actualData.get("WORD").toString());
						mcd.setMeaning(actualData.get("MEANING").toString());
						System.out.println("mcd log " + mcd.getId() + mcd.getWord());
					}catch(EmptyResultDataAccessException e){
						// 見つからなかった場合
						System.out.println(mrdList.get(i).getOriginal());
					}
				}
				mcdList.add(mcd);
			}
		}
		return mcdList;
	}
}
