/*
Author:Dipayan Das
Roll:cs1726
IR
Assignment1 Method1
Prototype version
*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class DipayanReaderInvertedIndex{
	
	/*word is key and file name is value*/
	private Map<String ,PostingList> vocabulary;
	private DipayanProgressBar progressBarForLine;
	private DipayanProgressBar progressBarForFile;	
	private long dataTobeProcessed;
	private long dataAlreadybeProcessed;	
	public DipayanReaderInvertedIndex(){
			this.vocabulary=new HashMap<String,PostingList>();
			this.progressBarForLine=new DipayanProgressBar();
			this.progressBarForFile=new DipayanProgressBar();
			
			/*this is initialized to 1 as its going to be divident */			
			this.dataTobeProcessed=1;

			this.dataAlreadybeProcessed=0;
	}
	/*When the given argument is file*/
		public void readSingleFile(String fileName){
		//System.out.println("Hello Frrom Dipayan file  reader single");
		List<String> result=new ArrayList<String>();		
		String progressData;
		try{
			File file=new File(fileName);	
			BufferedReader br=new BufferedReader(new FileReader(file));
			String tempString;
			String []arrayOfWords;
			String delims = " ";	
			this.dataAlreadybeProcessed=this.dataAlreadybeProcessed+file.length();
			String []delimittedFileName=fileName.split("/");
			String valueFileName=	delimittedFileName[delimittedFileName.length-1];				
			while(null != (tempString=br.readLine())){
				//System.out.println(tempString);
				arrayOfWords=tempString.split(delims);
				tempString.trim();				
				PostingList postingListTemp;
				for(String temp:arrayOfWords){
					temp=temp.replaceAll("[^A-Za-z]","").toLowerCase();						
					if(null==this.vocabulary.get(temp)){
						postingListTemp=new PostingList();
						postingListTemp.addFileNameToPostingList(valueFileName);	
						this.vocabulary.put(temp,postingListTemp);
						progressData=""+temp+" added to vocabulary and found in:"+valueFileName;
						//progressBarForLine.showProgress(progressData);
					}else{
						postingListTemp=this.vocabulary.get(temp);
						postingListTemp.addFileNameToPostingList(valueFileName);	
						this.vocabulary.put(temp,postingListTemp);
						progressData=""+temp+" -is in vocabulary and found in file:"+valueFileName;
						//progressBarForLine.showProgress(progressData);
					}
				}

			}
		}catch(FileNotFoundException fileNotFoundException){
			System.out.println("No such file exist:"+fileNotFoundException);
		}catch(IOException ioexception){
			System.out.println("Buffered reader exception:"+ioexception);
		}catch(Exception exception){
			System.out.println("Exception:"+exception);
		}finally{
			System.out.println(fileName+" :is processed .");
		}
				
	}


	/*reading the file and putting key value pair in File*/
	public void readSingleFileAndPuKeyValueInfile(String fileName){
		//System.out.println("Hello Frrom Dipayan file  reader single");
		
		String progressData;
		try{
			File file=new File(fileName);	
			BufferedReader br=new BufferedReader(new FileReader(file));
			String tempString;
			String []arrayOfWords;
			String delims = " ";
			Map<String ,PostingList> vocabularyLocal=new HashMap<String,PostingList>();	
			this.dataAlreadybeProcessed=this.dataAlreadybeProcessed+file.length();					
			String []delimittedFileName=fileName.split("/");
			String valueFileName=	delimittedFileName[delimittedFileName.length-1];
			while(null != (tempString=br.readLine())){
				//System.out.println(tempString);
				arrayOfWords=tempString.split(delims);
				tempString.trim();				
				PostingList postingListTemp;
				for(String temp:arrayOfWords){
					temp=temp.replaceAll("[^A-Za-z]","").toLowerCase();						
					if(null==vocabularyLocal.get(temp)){
						postingListTemp=new PostingList();
						postingListTemp.addFileNameToPostingList(valueFileName);	
						vocabularyLocal.put(temp,postingListTemp);
						progressData=""+temp+" added to vocabulary and found in:"+fileName;
						//progressBarForLine.showProgress(progressData);
					}
				}

			}

			DipayanWriter writer=new DipayanWriter();
			String[] delimittedFile=fileName.split("/");
			String fileNameDelimitted=DipayanConstant.METHOD2_POSTING_LIST_TEMP_FOLDER_NAME+delimittedFile[delimittedFile.length-1];
			//System.out.println("In InvertedIndex+ "+vocabularyLocal.size());
			writer.writeMapTofileUsingBuffer(vocabularyLocal,fileNameDelimitted);
		}catch(FileNotFoundException fileNotFoundException){
			System.out.println("No such file exist:"+fileNotFoundException);
		}catch(IOException ioexception){
			System.out.println("Buffered reader exception:"+ioexception);
		}catch(Exception exception){
			System.out.println("Exception:"+exception);
		}finally{
			System.out.println(fileName+" :is processed .");
		}

	}



	/*when the gilen is the directory returns a empty list if directory not exist or there is no files*/
	public List<String> listAllFiles(String folderLocation){
		List<String> allFileListresult=new ArrayList<String>();		
		File folder;		
		folder=new File(folderLocation);
		File[] listOfFiles=folder.listFiles();
		if(null==listOfFiles){
			System.out.print("No such folder exist, returnning a empty list of files");
		}
		System.out.println("There are total files :"+listOfFiles.length+" in "+folderLocation);
		for(File tempFiles:listOfFiles){
			if(tempFiles.isFile()){
				System.out.println(" File Name:"+tempFiles.getName()+"   Size:"+getFileSize(tempFiles.length())+".");
				allFileListresult.add(folderLocation+"/"+tempFiles.getName());
				this.dataTobeProcessed=this.dataTobeProcessed+tempFiles.length();
			}else if(tempFiles.isDirectory()){
				//System.out.print(" "+tempFiles.getName());
			}
		}
		System.out.println("Total : "+getFileSize(this.dataTobeProcessed)+" data is going to be processed.");
		return allFileListresult;
	}

	/*It converts file size to gb mb or kb */
	public String getFileSize(long fileSize){
		String result="";		
		long size=fileSize;
		if(size<=DipayanConstant.KILO_BYTE_SIZE){
			result = size +" Byte.";
		}else if(size>=DipayanConstant.KILO_BYTE_SIZE && size <= DipayanConstant.MEGA_BYTE_SIZE){
			result = size/DipayanConstant.KILO_BYTE_SIZE +"KB";
		}else if(size>=DipayanConstant.MEGA_BYTE_SIZE && size <= DipayanConstant.GIGA_BYTE_SIZE){
			result = size/DipayanConstant.MEGA_BYTE_SIZE +"MB";
		}else if(size >= DipayanConstant.GIGA_BYTE_SIZE){
			result = size/DipayanConstant.GIGA_BYTE_SIZE +"GB";
		}
		return result;
	}

	/*Read All files*/
	public void readAllFilesFromFolder(String fileOrFolder){
		List<String> listOfAllFiles= listAllFiles(fileOrFolder);
		for(String fileName:listOfAllFiles){
			readSingleFile(fileName);
		}	
	}

	/*Read All files and get 1st occurewnce of words in vocabulary
	@input folder location
	@output  word folder location map
        */
	public Map<String,PostingList> readAllFilesAndGetFirstAppearancce(String fileOrFolder){
		List<String> listOfAllFiles= listAllFiles(fileOrFolder);
		String fileProgressor;
		long percentProgress=0;
		int count=1;
		int numberOfFiles=listOfAllFiles.size();
		for(String fileName:listOfAllFiles){
			
			//progressBarForFile.showProgress(fileProgressor);
			readSingleFile(fileName);
			percentProgress=Math.round((this.dataAlreadybeProcessed/this.dataTobeProcessed)*100);
			fileProgressor=	"============= File Processed:"+getFileSize(this.dataAlreadybeProcessed)+"  out of:"   +getFileSize(this.dataTobeProcessed)+" ============= ";		
			//fileProgressor="=============File Processed:"+percentProgress+"% =============";
			System.out.println(fileProgressor);
		}

		System.out.println("==Posting List Creaion is complete==");	
		System.out.println("======================");	
		//printMap(this.vocabulary);
		//System.out.println(this.vocabulary.size());
		return this.vocabulary;

	}


	/*this is for second method*/	
	public void readAllFilesAndPutKeyValuePairInFile(String fileOrFolder){
		List<String> listOfAllFiles= listAllFiles(fileOrFolder);
		String fileProgressor;
		long percentProgress=0;
		int count=1;
		int numberOfFiles=listOfAllFiles.size();
		for(String fileName:listOfAllFiles){
			
			//progressBarForFile.showProgress(fileProgressor);
			readSingleFileAndPuKeyValueInfile(fileName);
			//percentProgress=Math.round((this.dataAlreadybeProcessed/this.dataTobeProcessed)*100);
			fileProgressor=	"============= File Processed:"+getFileSize(this.dataAlreadybeProcessed)+"  out of:"   +getFileSize(this.dataTobeProcessed)+" ============= ";		
			//fileProgressor="=============File Processed:"+percentProgress+"% =============";
			System.out.println(fileProgressor);
		}

		System.out.println("==Posting List Creaion is complete==");	
		System.out.println("======================");	
		//printMap(this.vocabulary);
		



	}


	public void printMap(Map<String,PostingList>vocabulary){
		for(Map.Entry<String,PostingList> tempMap:vocabulary.entrySet()){
			System.out.println(tempMap.getKey()+" -> "+tempMap.getValue().toString());			
		}
	}


}
