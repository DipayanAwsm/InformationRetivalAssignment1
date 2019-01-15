/*

Author:Dipayan Das
Roll:cs1726
IR
Assignment1 Method1
Prototype version
*/


import java.util.Map;

public class DipayanMainInvertedIndexMethod1{

	static long startTime = System.nanoTime();
	static long endTime   = System.nanoTime();
	static long totalTime = 0;
	

	static void setStratTime(){
		startTime = System.currentTimeMillis();
		startTime = startTime;
	}

	static void setEndTime(){
		endTime = System.currentTimeMillis();
		endTime=endTime;
	}

	static void calculateTotalTime(){
		totalTime =(endTime - startTime)/1000;
		System.out.println("Code is Completed .\nIt took time :-"+totalTime+" sec");
	}

	public static void main(String args[]){
		System.out.println("====================================================================================================");
		System.out.println("Inverted Index Method 1:");
		System.out.println("====================================================================================================");
		System.out.println("Read through each document in the collection.");
		System.out.println(" For each word, lookup whether the word is already in the vocabulary.");
		System.out.println(" If it is, then append the document ID to the posting list corresponding to the word.");
		System.out.println(" Otherwise insert the word into the vocabulary and add the document ID to its posting list.");;
		if(1>args.length){
			System.out.println("Please provide file location");			
			return 		;
		}
		setStratTime();
		
		/*When the given argument is Folder*/
		//reader.listAllFiles(fileOrFolder);
		DipayanReaderInvertedIndex reader=new DipayanReaderInvertedIndex();
		String fileOrFolder=args[0];

		/*When the given argument is file*/
		//reader.readSingleFile(fileOrFolder);
		


		
		/*Read all files from folder*/
		//reader.readAllFilesFromFolder(fileOrFolder);
		
		/* read file and print word and first appearing document*/
		Map<String,PostingList> wordAndFileNameMap=reader.readAllFilesAndGetFirstAppearancce(fileOrFolder);	
		setEndTime();

		writeToFile(wordAndFileNameMap,DipayanConstant.METHOD1_POSTING_LIST_FILE_NAME);
		calculateTotalTime();
	}

	static void writeToFile(Map<String ,PostingList >data,String fileName){
		try{
			DipayanWriter writer=new DipayanWriter();
			writer.createDirectory(DipayanConstant.METHOD1_POSTING_LIST_FOLDER_NAME);
			writer.writeMapTofileUsingBuffer(data,fileName);
		}catch(Exception e){
			System.out.println("There was some Problem");
		}
	}
} 
