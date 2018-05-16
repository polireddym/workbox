package oneapp.incture.workbox.util;
//package com.incture.pmc.util;
//
//import com.sap.tc.logging.Category;
//import com.sap.tc.logging.Location;
//import com.sap.tc.logging.Severity;
//
//public class LogUtil {
//
//	private Category category;
//	private Location location;
//
//	public LogUtil(Class<?> forClass) {
//		this.category = Category.getCategory(Category.APPLICATIONS, forClass.getSimpleName());
//		this.location = Location.getLocation(forClass);
//	}
//
//	public void logInfo(String message) {
//		category.infoT(location, message);
//	}
//
//	public void logWarning(String message) {
//		category.warningT(location, message);
//	}
//
//	public void logError(String message) {
//		category.errorT(location, message);
//	}
//
//	public void logDebug(String message) {
//		category.logT(Severity.DEBUG, location, message);
//	}
//
//	public void logFatal(String message) {
//		category.fatalT(location, message);
//	}
//}
