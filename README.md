# WRDS-Sync
Sync data from WRDS SFTP server to local hard drive.

Options:
	* f: Remote Download folder (Default value is the root folder)
	* o: Output path (Default value is the current folder)
	* u: User name (If not specified, you will be asked later)
	* p: Password (If not specified, you will be asked later)
	* s: Save password (N for not saving, otherwise save)
	* r: WinRAR path (The path to WinRAR folder. The default vale is 'C:\\Program Files\\WinRAR'. With it the downloaded data will be compressed, and its size will be reduced by upto 90% depending on data types.)
 	* n: Update the current sync.
 	
 	
All options except password will be saved in the 'config.cfg' file under the program folder after each executation, and will be loaded as default values for the next executation. Password will not be saved if option 's' is set to 'N'. 

The saved option values can be overrided by options or can be changed in the 'config.cfg' file. 

 


Quick Start:
	1. Download the latest file from release.
 	1. Copy the rel	ease file to the destination folder.
 	1. Open command console (cmd).
 	1. Change the path to the destination folder (cd [your destination folder]).
 	1. Run "java -jar WRDS-Sync-0.0.1-Beta-jar-with-dependencies.jar"
 	1. Enter the information. 
 	1. To cancel the program before it finishes: 'Ctrl+C'
 	

 	