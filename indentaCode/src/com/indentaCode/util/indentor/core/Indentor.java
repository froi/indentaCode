package com.indentaCode.util.indentor.core;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.apache.regexp.RE;

public abstract class Indentor {
	
	protected int _numTabs = 0;
	protected String _pattern1 = null;
	protected String _pattern2 = null;
	
	public void format( String inputFile, String outputFile ) {
		
		try
		{
			this.format( new FileInputStream(inputFile), new FileOutputStream(outputFile) );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		
	}
	
	public void format( FileInputStream inputFile, FileOutputStream outputFile ) {
		Pattern pattern1 = null;
		Pattern pattern2 = null;
//		RE regExp1 = null;
//		RE regExp2 = null;

		DataInputStream in = null;
		DataOutputStream out = null;

		String line = null;
		String tmpTabs = null;

		try {
			pattern1 = Pattern.compile(_pattern1);
			pattern2 = Pattern.compile(_pattern2);

//			regExp1 = new RE(_pattern1);
//			regExp2 = new RE(_pattern2);

			in = new DataInputStream(inputFile);
			out = new DataOutputStream(outputFile);

			while (in.available() != 0) {
				// TODO: change the way the lines are read
				line = in.readLine().trim() + "\n";
				Matcher matcher1 = pattern1.matcher(line);
				Matcher matcher2 = pattern2.matcher(line);

				if (matcher1.matches() && matcher2.matches()) {
					out.writeBytes((tmpTabs == null ? "" : tmpTabs) + line);
				}
				else if(matcher1.matches()) {
					out.writeBytes((tmpTabs == null ? "" : tmpTabs) + line);
					
					this._numTabs++;
					tmpTabs = addElimTabs();
				}
				else if(matcher2.matches()) {
					this._numTabs--;
					tmpTabs = addElimTabs();
					
					out.writeBytes((tmpTabs == null ? "" : tmpTabs) + line);
				}
				else {
					out.writeBytes((tmpTabs == null ? "" : tmpTabs) + line);
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage() + " " + e.getCause() + " " + e.getClass());
		}
		finally {
			pattern1 = null;
			pattern2 = null;
						
			if (in != null){
				try {
					in.close();
				}
				catch (Exception e) {
					System.out.println(e.getMessage() + " " + e.getCause() + " " + e.getClass());
				}
			}
			
			if (out != null) {
				try {
					out.close();
				}
				catch(Exception e) {
					System.out.println(e.getMessage() + " " + e.getCause() + " " + e.getClass());
				}
			}
		}
	}
	
	private String addElimTabs(){
		String tmpString = "";
		
		for(int i = 0; i < _numTabs; i++) {
			tmpString += "\t";
		}
		
		return tmpString;
	}
}
