package com.indentaCode.util.indentor.core.parsers;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.indentaCode.util.indentor.Constants;
import com.indentaCode.util.indentor.core.Indentor;

public class XmlIndentor extends Indentor {

	public void format(FileInputStream inputFile, FileOutputStream outputFile) {
		_pattern1 = Constants.markUpPattern1;
		_pattern2 = Constants.markUpPattern2;
		
		super.format(inputFile, outputFile);
	}

}
