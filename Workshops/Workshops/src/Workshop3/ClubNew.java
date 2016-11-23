package Workshop3;

import java.util.ArrayList;
import java.util.HashMap;

public class ClubNew {
	// currentNumber is used to set memberNumber starts from 1
	int currentNumber;
	ArrayList<Member> members;
	HashMap<String, Member> hashMember;
	// constructor
	public ClubNew() {
		currentNumber = 0;
		members = new ArrayList<Member>();
		hashMember = new HashMap<String, Member>();
	}
	public Integer getCurrentNumber() {
		return members.size();
	}
	public Member addMember(String surName, String firstName, String secondName) {
		// using currentNumber+1 as memberNumber so it starts at 1
		currentNumber ++;
		Member mem = new Member(surName, firstName, secondName, currentNumber);
		members.add(mem);
		hashMember.put(String.valueOf(currentNumber), mem);
		return mem;
	}
	public void addMember(Member member) {
		currentNumber ++;
		if (member.memberNumber == 0) 
			member.memberNumber = currentNumber;
		members.add(member);
		hashMember.put(String.valueOf(member.memberNumber), member);
	}
	public void removeMember(int number) {
		String stringNumber = "" + number;
		Member m = hashMember.get(stringNumber);
		members.remove(m);
		hashMember.remove(stringNumber);
	}
	public void removeMember(Member m) {
		members.remove(m);
		// hashMember can only remove by key
		//hashMember.remove(m);
		hashMember.remove(m.memberNumber);
	}
	public void showMembers() {
		for (Member m : members) {
			System.out.println(m.toString());
		}
	}
}
