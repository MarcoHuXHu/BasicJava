package Workshop3;

public class testArrayListHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ClubNew club = new ClubNew();

        //Member member1, member2, member3, member4, member5;
        club.addMember (null, "Einstein", "Albert");
        club.addMember ("Ruiz", "Picasso", "Pablo");
        Member member3 = club.addMember ("Lloyd", "Webber","Andrew");
        club.addMember (null, "Baggio", "Roberto");
        Member member5 = club.addMember (null, "Raffles", "Stamford");

        System.out.println ("Current Members:");
        club.showMembers ();

        System.out.println ("Deleting " + member3 + "," + member5);
        int id = member3.getMemberNumber ();
        club.removeMember(id);
        club.removeMember (member5);
        
        //Member member6 = new Member(null, "Lunch", "Dinner", 5); this member will be removed later as memberNumber = 5
        Member member6 = new Member(null, "Lunch", "Dinner", 0);
        club.addMember(member6);
        
        System.out.println ("Current members:");
        club.removeMember(5);
        club.showMembers ();
	}

}
