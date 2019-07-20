package com.lab.app.ketman.logic;

import com.ibm.icu.text.Transliterator;

public class CallHankakuToZenkaku {
	public String getZenkaku(String hankaku) {
		Transliterator transliterator = Transliterator.getInstance("Halfwidth-Fullwidth");
		String zenkaku = transliterator.transliterate(hankaku);
		return zenkaku;
	}
}
