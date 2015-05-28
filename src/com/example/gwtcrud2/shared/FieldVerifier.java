package com.example.gwtcrud2.shared;

import java.util.Date;
import com.google.gwt.i18n.shared.DateTimeFormat;

public class FieldVerifier {

	public static boolean isValidName(String name) {
		if (name == null) return false;
		else return name.matches("([A-ZĄĆĘŁŃÓŚŹŻ]{1}[a-ząćęłóńśźż]+\\s{1}){1,}([A-ZĄĆĘŁŃÓŚŹŻ]{1}[a-ząćęłóńśźż]+\\s?){1,}");
	}
	
	public static boolean isValidDob(Integer dob) {
		int year = Integer.parseInt(DateTimeFormat.getFormat("d-M-yyyy").format(new Date()).split("-")[2]);
		if (dob == null || dob > year || year - dob > 120) return false;
		else return true;
	}
	
	public static boolean isValidMsg(String msg) {
		if (msg == null) return false;
		else return true;
	}
	
}
