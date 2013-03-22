package com.indentaCode.util.indentor;

//import org.apache.regexp.RE;

import com.indentaCode.util.indentor.core.Indentor;
import com.indentaCode.util.indentor.core.parsers.HtmlIndentor;
import com.indentaCode.util.indentor.core.parsers.JavaIndentor;
import com.indentaCode.util.indentor.core.parsers.XmlIndentor;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IndentationMain{
	
	
	public static void main(String [] args){
		Indentor indent = null;

		int fileInLength = args[Constants.fileIn].length();
		int fileOutLength = args[Constants.fileOut].length();

		try {
			if(fileInLength != 0 && fileOutLength != 0) {
				Matcher matcher = Pattern.compile(
						Constants.javaFileExt).matcher(
								args[Constants.fileIn]);

				//RE regExp = new RE(Constants.javaFileExt);
				if(matcher.matches()) {
					indent = new JavaIndentor();
				}
				
				matcher = Pattern.compile(
						Constants.htmlFileExt).matcher(
								args[Constants.fileIn]);
				if(matcher.matches()) {
					indent = new HtmlIndentor();
				}

				matcher = Pattern.compile(
						Constants.xmlFileExt).matcher(
								args[Constants.fileIn]);
				if(matcher.matches()) {
					indent = new XmlIndentor();
				}
				
				indent.format(args[Constants.fileIn], args[Constants.fileOut]);
			}
			else {
				if(fileInLength == 0) {
					throw new Exception("Input file missing.");
				}
				else {
					throw new Exception("Output file missing.");
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage() + " " + e.getCause() + " " + e.getClass());			
		}
	}
}