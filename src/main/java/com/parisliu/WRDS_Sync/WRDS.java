package com.parisliu.WRDS_Sync;

import java.io.File;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.parisliu.SFTP_Sync.SFTP;

/**
 * Hello world!
 *
 */
public class WRDS 
{
    public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException, JSchException
    {
    	// create Options object
    	Options options = new Options();
		options.addOption("f", false, "Download folder");
		options.addOption("o", false, "Output path");
		options.addOption("u", false, "User name");
		options.addOption("p", false, "Password"); 
		options.addOption("r", false, "WinRAR"); 
		options.addOption(new Option("n", "New backup")); 
    	
    	
    	CommandLineParser parser = new DefaultParser();
    	try {
			CommandLine cmd = parser.parse( options, args);
			

	    	
	        SFTP sftp;
	        if(cmd.hasOption("o")) {
	        	sftp = new SFTP(new File(cmd.getOptionValue("o")));	        	
	        }
	        else {
	        	sftp = new SFTP(new File(""));
	        }
	        sftp.setServer("wrds.wharton.upenn.edu");
	        if(cmd.hasOption("u")) {
		        sftp.setUser(cmd.getOptionValue("u")); 	        	
	        }
	        if(cmd.hasOption("p")) {
		        sftp.setPassword(cmd.getOptionValue("p")); 	        	
	        }
	        if(cmd.hasOption("f")) {
	        	sftp.setFolder(cmd.getOptionValue("f")); 	        	
	        }
	        if(cmd.hasOption("n")) {
	        	sftp.startNewTask();
	        }
	        if(cmd.hasOption("r")) {
	        	sftp.setWinRAR(cmd.getOptionValue('r'));;
	        }
	        sftp.printInfo();
	        if(sftp.connect()) {
	        	sftp.archiveAllFiles();
	        	try {
					sftp.download();
				} catch (SftpException e) {
					e.printStackTrace();
				}
	        	sftp.disconnect();
	        }
	        
	        
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
}
