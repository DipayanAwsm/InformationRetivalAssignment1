/*

Author:Dipayan Das
Roll:cs1726
IR
Assignment1 Method1

*/
import java.util.Comparator;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
public class PostingList implements Comparable<PostingList> , Comparator<PostingList>{
	private Set<String> postingList;
	public PostingList(){
		postingList=new HashSet<String>();
	}

	public void setPostingList(Set<String> postingList){

		this.postingList=postingList;
	}

	public Set<String> getPostingList(){

		return this.postingList;
	}

	public void addFileNameToPostingList(String data){
		this.postingList.add(data);
	}
	@Override
    public int compareTo(PostingList postingListObj) {
        //let's sort the employee based on an id in ascending order
        //returns a negative integer, zero, or a positive integer as this employee id
        //is less than, equal to, or greater than the specified object.
        if(this.postingList.containsAll(postingListObj.getPostingList( ) ) ) {

        	return 1;
        }
        return 0;
    }

    @Override
    public int compare(PostingList o1, PostingList o2) {
         if(o1.getPostingList() == null || o2.getPostingList() ==null){
            return 0;
        }
         if(o1.getPostingList().size()!=o2.getPostingList().size()){
            return 0;
        }

        return o1.getPostingList().containsAll(o2.getPostingList())?1:0;
    }

    @Override
    public String toString(){
    	String result="";
    	for(String temp:this.postingList){
    		result=result+" "+temp;
    	}
    	return result;
    }



}