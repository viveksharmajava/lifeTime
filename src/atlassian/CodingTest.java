/*
 * package atlassian;
 * 
 * import java.util.ArrayList; import java.util.HashMap; import java.util.List;
 * import java.util.Map; import java.util.PriorityQueue;
 * 
 * public class CodingTest {
 * 
 * public static void main(String[] args) {
 * 
 * }
 *//**
	 * For a list of votingForms, return an ordered set of candidate in descending
	 * order of their total points.
	 *//*
		 * List<String> findWinner(List<VotingForm> votingForms){ //base case
		 * if(votingForms == null || votingForms.size() == 0) return null; Map
		 * <String,VotingInforation> map = new HashMap<>(); List <String> result = new
		 * ArrayList<>(); for(VotingForm form : votingForms) { int point = 3; for(String
		 * candidate : form.getCandidates() ) { map.putIfAbsent(candidate, new
		 * VotingInforation(candidate)); //map.put(candidate,map.getOrDefault(candidate,
		 * 0)+ point); VotingInforation voting = map.get(candidate); voting.points =
		 * voting.points + point; voting.voters = voting.voters + 1; point--; } }
		 * 
		 * // C*O(N*logN) + o (Nlog N)
		 * 
		 * PriorityQueue <VotingInforation> pq = new PriorityQueue((a,b)-> (
		 * ((VotingInforation)a ).points == ((VotingInforation)b ).points?
		 * ((VotingInforation)a ).voters - ((VotingInforation)b ).voters:
		 * ((VotingInforation)a ).points - ((VotingInforation)b ).points );
		 * for(Map.Entry<String,Integer> me : map.entrySet()) { pq.add(me); }
		 * 
		 * while(!pq.isEmpty()) { result.add(pq.poll().getKey()); } return result; }
		 * 
		 * }
		 * 
		 * class VotingInforation{ String candidateName; int voters; int points;
		 * VotingInforation(String candidate){ this.candidateName = candidate; }
		 * 
		 * 
		 * }
		 * 
		 * 
		 * id , name c1 ,, c1 = new Candidate(); C2 = new Candidate(); put ,, val1 , V3
		 * ... .Vn ..
		 * 
		 * 
		 * 
		 * 1. each voter has to vote to 3 different candidates. 2. Order of the voting
		 * decide ranking 3 points(1st vote ) 2 for second vote and 1 for 3rd vote. 3.
		 * Winner will be based on total voting points a participant got.
		 * 
		 * 
		 */