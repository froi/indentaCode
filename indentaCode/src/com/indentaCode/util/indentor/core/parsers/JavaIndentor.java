package com.indentaCode.util.indentor.core.parsers;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.indentaCode.util.indentor.Constants;
import com.indentaCode.util.indentor.core.Indentor;

public class JavaIndentor extends Indentor {

	public void format(FileInputStream inputFile, FileOutputStream outputFile) {
		_pattern1 = Constants.javaPattern1;
		_pattern2 = Constants.javaPattern2;
		
		super.format(inputFile, outputFile);
	}

}
