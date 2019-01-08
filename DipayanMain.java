/*

Author:Dipayan Das
Roll:cs1726
IR
Assignment1 Method1
Prototype version
*/


import java.util.Map;

public class DipayanMain{

	public static void main(String args[]){

		if(1>args.length){
			System.out.println("Please provide file location");			
			return 		;
		}
		System.out.println("Hello World");
		DipayanReaderInvertedIndex reader=new DipayanReaderInvertedIndex();
		String fileOrFolder=args[0];

		/*When the given argument is file*/
		//reader.readSingleFile(fileOrFolder);
		


		/*When the given argument is Folder*/
		//reader.listAllFiles(fileOrFolder);
		
		/*Read all files from folder*/
		//reader.readAllFilesFromFolder(fileOrFolder);
		
		/* read file and print word and first appearing document*/
		Map<String,PostingList> wordAndFileNameMap=reader.readAllFilesAndGetFirstAppearancce(fileOrFolder);	
	}
} 
