package com.neu.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class commonUtils {

	// converting the input time to seconds from epoch 1970 till current time
	public static long stringToSeconds(String value) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd--kk:mm:ss.SSS");
		Date date = sdf.parse(value);
		long inMilliSinceEpoch = date.getTime();
		return inMilliSinceEpoch;
	}
}
