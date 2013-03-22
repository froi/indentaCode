package com.indentaCode.util.indentor.unittest;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.TestCase;

import com.indentaCode.util.indentor.core.Indentor;
import com.indentaCode.util.indentor.core.parsers.XmlIndentor;


public class Indentation extends TestCase {
	
	static protected Logger log = Logger.getLogger(Indentation.class.getName());
	
	static protected String FILE_IN = "sampleXML.xml";
	static protected String FILE_OUT = FILE_IN + "_OUT";
	
	
	protected void setUp() throws Exception {
		super.setUp();

		Handler[] handlers = log.getParent().getHandlers();
		for ( int i = 0; i < handlers.length; i ++ )
		{
			handlers[i].setLevel( Level.ALL );
		}
		log.setLevel( Level.ALL );
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testXmlIndentation(){
		
		try {
			
			Indentor indent = new XmlIndentor();
			
			indent.format(FILE_IN, FILE_OUT);

		}
		catch(Exception e) {
			e.printStackTrace();			
		}
	}
}