package com.joye.health.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.core.Response;

import com.joye.health.error.AppException;
import com.joye.health.model.common.PageParam;

public class RestUtil {

	public static boolean checkDateFormat(String date) throws AppException {
		if (date == null || "".equals(date)) {
			return false;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		try {
			formatter.parse(date);
		} catch (Exception e) {
			throw new AppException(Response.Status.BAD_REQUEST.getStatusCode(),
					"The date (" + date + ") in url not in the format of yyyyMMdd");
		}
		return true;
	}

	public static void constructDate(PageParam page, String startDate, String endDate) throws AppException {
		if (RestUtil.checkDateFormat(startDate) && !RestUtil.checkDateFormat(endDate)) {
			page.constructDate(startDate);
		}
		if (!RestUtil.checkDateFormat(startDate) && RestUtil.checkDateFormat(endDate)) {
			page.constructDate(endDate);
		}
		if (RestUtil.checkDateFormat(startDate) && RestUtil.checkDateFormat(endDate)) {
			page.constructDate(startDate, endDate);
		}
	}

	public static String getCurrentDate() {
		// 获取系统日期，查询当天的数据
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

}
