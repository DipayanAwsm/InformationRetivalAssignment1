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
		
	public DipayanReaderInvertedIndex(){
		this.vocabulary=new HashMap<String,PostingList>();
	}
	/*When the given argument is file*/
	public void readSingleFile(String fileName){
		//System.out.println("Hello Frrom Dipayan file  reader single");
		List<String> result=new ArrayList<String>();		
		try{
			File file=new File(fileName);	
			BufferedReader br=new BufferedReader(new FileReader(file));
			String tempString;
			String []arrayOfWords;
			String delims = " ";
			while(null != (tempString=br.readLine())){
				//System.out.println(tempString);
				arrayOfWords=tempString.split(delims);
				tempString.trim();
				
				PostingList postingListTemp;
				for(String temp:arrayOfWords){
					temp=temp.replaceAll("[^A-Za-z]","").toLowerCase();						
					if(null==this.vocabulary.get(temp)){
						postingListTemp=new PostingList();
						postingListTemp.addFileNameToPostingList(fileName);	
						this.vocabulary.put(temp,postingListTemp);
					}else{
						postingListTemp=this.vocabulary.get(temp);
						postingListTemp.addFileNameToPostingList(fileName);	
						this.vocabulary.put(temp,postingListTemp);
					}
				}
			}
		}catch(FileNotFoundException fileNotFoundException){
			System.out.println("No such file exist:"+fileNotFoundException);
		}catch(IOException ioexception){
			System.out.println("Buffered reader exception:"+ioexception);
		}catch(Exception exception){
			System.out.println("Exception:"+exception);
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
		for(File tempFiles:listOfFiles){
			if(tempFiles.isFile()){
				//System.out.print(" "+tempFiles.getName());
				allFileListresult.add(folderLocation+"/"+tempFiles.getName());
			}else if(tempFiles.isDirectory()){
				//System.out.print(" "+tempFiles.getName());
			}
		}

		return allFileListresult;
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
		for(String fileName:listOfAllFiles){
			readSingleFile(fileName);
		}

		System.out.println(" Word -> file location");	
		System.out.println("======================");	
		for(Map.Entry<String,PostingList> tempMap:this.vocabulary.entrySet()){
			System.out.println(tempMap.getKey()+" -> "+tempMap.getValue().toString());			
		
		}
		return this.vocabulary;

	}


}
