/*

Author:Dipayan Das
Roll:cs1726
IR
Assignment1 Method1
Prototype version
*/


import java.util.Map;

public class DipayanMainInvertedIndexMethod2{

	static long startTime = System.nanoTime();
	static long endTime   = System.nanoTime();
	static long totalTime = 0;
	private static Runtime processRunTime=Runtime.getRuntime();
	

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
		System.out.println("Inverted Index Method 2:");
		System.out.println("====================================================================================================");
		System.out.println("Read through each document in the collection.");
		System.out.println(" For each word, write out (word, document ID) pairs in a separate file");
		System.out.println(" Then, sort the file by word (you are encouraged to use some built in sorting, for example linux sort command)");
		System.out.println(" Now, scan through the sorted file once to create the posting lists.");
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
		//Map<String,PostingList> wordAndFileNameMap=reader.readAllFilesAndGetFirstAppearancce(fileOrFolder);	
		
		createFileForMethod2();		
		reader.readAllFilesAndPutKeyValuePairInFile(fileOrFolder);	
		
		Map<String,PostingList> wordAndFileNameMap=reader.readAllFilesAndGetFirstAppearancce(DipayanConstant.METHOD2_POSTING_LIST_TEMP_FOLDER_NAME);
		//System.out.println("In Main"+wordAndFileNameMap.size());
		writeToFile(wordAndFileNameMap,DipayanConstant.METHOD2_POSTING_LIST_FILE_NAME);
		

		try{	
				
				
			processRunTime.exec("sort -o "+DipayanConstant.METHOD2_POSTING_LIST_FILE_NAME+" " + DipayanConstant.METHOD2_POSTING_LIST_FILE_NAME+" -k 1 ");
		}catch(Exception e){
			System.out.println("There was Some Problem"+e);
		}		
		setEndTime();		
		calculateTotalTime();
	}
	


	/*creating tempFolder for Method2*/
	static void createFileForMethod2( ){
		try{
			DipayanWriter writer=new DipayanWriter();
			writer.createDirectory(DipayanConstant.METHOD2_POSTING_LIST_FOLDER_NAME);
			writer.createDirectory(DipayanConstant.METHOD2_POSTING_LIST_TEMP_FOLDER_NAME);
			
		}catch(Exception e){
			System.out.println("There was some Problem");
		}
	}

	static void writeToFile(Map<String ,PostingList >data,String fileName){
		try{
			DipayanWriter writer=new DipayanWriter();
			writer.createDirectory(DipayanConstant.METHOD2_POSTING_LIST_FOLDER_NAME);
			writer.writeMapTofileUsingBuffer(data,fileName);
		}catch(Exception e){
			System.out.println("There was some Problem");
		}
	}
} 
