package org.EngDrom.StringParser;

import java.util.HashMap;
import java.util.HashSet;

class FntLineConfig {
	public HashSet<String>         args   = new HashSet<String>();
	public HashMap<String, String> kwargs = new HashMap<String, String>();
}

public class FntLineParser {
	
	public static FntLineConfig parse ( String line ) {
		FntLineConfig conf = new FntLineConfig();
		
		int idx = -1;
		while (line.length() - 1 > idx) {
			idx++;
			if (line.charAt(idx) == ' ') continue;
			
			int start = idx;
			while (line.length() > idx && line.charAt(idx) != ' ') {
				idx ++;
			}
			int end = idx;
			
			String message = line.substring(start, end);
			String[] datas = message.split("=");
			
			if (datas.length == 1) {
				conf.args.add(datas[0]);
			} else {
				conf.kwargs.put(datas[0], datas[1]);
			}
		}
		
		return conf;
	}
	
}
