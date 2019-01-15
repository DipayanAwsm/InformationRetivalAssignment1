/*
Author:Dipayan Das
Roll:cs1726
IR
Assignment1 Method1
Prototype version
*/

import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;

public class Vocabulary implements Comparable<Vocabulary> , Comparator<Vocabulary>{
	private Set<String> vocabulary;

	public Vocabulary(){
		this.vocabulary=new HashSet<String>();		
	}
	public void setVocabulary(Set<String> vocabulary){
		this.vocabulary=vocabulary;	
	}
	public Set<String> getVocabulary(){
		return this.vocabulary;	
	}

	public void addWordToPostingList(String data){
		this.vocabulary.add(data);
	}
	@Override
    public int compareTo(Vocabulary vocabularyObj) {
        //let's sort the employee based on an id in ascending order
        //returns a negative integer, zero, or a positive integer as this employee id
        //is less than, equal to, or greater than the specified object.
        if(this.vocabulary.containsAll(vocabularyObj.getVocabulary( ) ) ) {

        	return 1;
        }
        return 0;
    }

    @Override
    public int compare(Vocabulary o1, Vocabulary o2) {
         if(o1.getVocabulary() == null || o2.getVocabulary() ==null){
            return 0;
        }
         if(o1.getVocabulary().size()!=o2.getVocabulary().size()){
            return 0;
        }

        return o1.getVocabulary().containsAll(o2.getVocabulary())?1:0;
    }

    @Override
    public String toString(){
    	String result="";
    	for(String temp:this.vocabulary){
    		result=result+" "+temp;
    	}
    	return result;
    }



}