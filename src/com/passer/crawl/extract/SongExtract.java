package com.passer.crawl.extract;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/** 
 * @ClassName: SongExtract<p>

 * @description: <p>

 * @author: passer<p>

 * @Date: 2019年3月25日 下午6:07:45<p>
 */
public class SongExtract {
	
	public static String ExtractSongNameById(Long id) throws IOException {
		Document document = Jsoup.connect("https://music.163.com/song?id=" + id).get();
		String song = document.select("title").text();
		return song.substring(0, song.indexOf(" -"));
	}
}
