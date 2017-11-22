/**
 * Class is for commonly used functions
 */

package com.webcrawler.bal;

import java.sql.Timestamp;

public class Common {
	
	public static Timestamp getTimestamp() {
		java.util.Date date = new java.util.Date();
		return new Timestamp(date.getTime());
	}

}
