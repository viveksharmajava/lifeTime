package atlassian;

public class VotingForm {
 
 private String [] candidates;
 
  public VotingForm(String [] votes)
   {
	  this.candidates =  votes;
   }
  
  public String [] getCandidates() {
	  return candidates;
  }
}