/*
Author:Dipayan Das
Roll:cs1726
Information Retrival
Assignment1 Method1
Prototype version
*/
import java.util.Map;
import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DipayanWriter{
	

	/*Writes Posting List in a file return postive for success and negetive for faliure */
	public int writeMapTofile(Map<String ,PostingList> data,String fileName)throws FileNotFoundException,IOException{
		int result=1;
		ObjectOutputStream objectStream=null;
		try{
			objectStream=new ObjectOutputStream(new FileOutputStream(fileName));
			objectStream.writeObject(data);
			

		return result;
		}catch(FileNotFoundException fileNotFoundException){
			System.out.println("File Not Found:"+fileNotFoundException);
			result=-2;
		}catch(IOException iOException){
			System.out.println("File Not Found:"+iOException);
			result=-1;
		}finally{
			if(null!=objectStream){
				objectStream.close();
			}
		}

		return result;
	}

	/*creates Directory of folder name*/
	public void createDirectory(String folderName){

/*		File file = new File(folderName);
		if (!file.exists()) {
		    if (file.mkdir()) {
		        System.out.println("Directory is created:"+folderName);
		    } else {
		        System.out.println("Failed to create directory!");
		    }
		}else{
			System.out.println("Folder is there:"+folderName+" ");
 		}
*/
		Path path = Paths.get(folderName);
	    //if directory exists?
        	if (!Files.exists(path)) {
		try {
	                Files.createDirectories(path);
	        } catch (IOException e) {
                //fail to create directory
                e.printStackTrace();
            }
        }
	}



	/*Writes Posting List in a file return postive for success and negetive for faliure */
	public int writeMapTofileUsingBuffer(Map<String ,PostingList> data,String fileName)throws FileNotFoundException,IOException{
		int result=1;				
		System.out.println("Writing to :"+fileName+ "" );
		String line;
		try {
				
				FileWriter outFile = new FileWriter(fileName);
				BufferedWriter bWriter = new BufferedWriter(outFile); 
				for(Map.Entry<String,PostingList> tempMap:data.entrySet()){
					line=tempMap.getKey()+" "+tempMap.getValue().toString()+"\n";
					bWriter.write(line);	
					//System.out.println("*from DipayanWriter* Wrote "+fileName);		
				}
				
		} catch (IOException e) {
			e.printStackTrace();
			result=-1;
		}
		return result;
	}










}
