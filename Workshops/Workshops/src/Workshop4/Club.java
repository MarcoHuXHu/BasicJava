package Workshop4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import Workshop2.Facility;
import Workshop3.Member;

public class Club {
	
	// members 用ArrayList储存, get一个特定Member, 利用Iterator来遍历完成
	private ArrayList<Member> members;
	// facilities 用HashMap储存, facilities.values()为值对应的ArrayList
	private HashMap<String, Facility> facilities;
	
	//constructor
	public Club() {
		members = new ArrayList<Member>();
		facilities = new HashMap<String, Facility>();
	}
	
	// get members facilities
	public ArrayList<Member> getMembers() {
		//return members;
		ArrayList<Member> result = new ArrayList<Member>(members);
		Collections.sort(result, (left, right) -> left.compareTo(right));
		//如果不用compareTo, 也可以用这种类似Lambda函数的形式
		//Collections.sort(result, (left, right) -> left.getMemberNumber()-right.getMemberNumber());
		return result;
	}
	public ArrayList<Facility> getFacilities() {
		//return new ArrayList<Facility>(facilities.values());
		ArrayList<Facility> result = new ArrayList<Facility>(facilities.values());
		Collections.sort(result, (left, right) -> left.compareTo(right));
		return result;
	}
	// get certain member facility
	public Member getMember(int memberNumber) {
		Iterator<Member> i = members.iterator();
		while (i.hasNext()) {
			Member m = i.next();
			if (m.getMemberNumber() == memberNumber)
				return m;
		}
		return null;
	}
	public Facility getFacility(String name) {
		return facilities.get(name);
	}
	// add member facility
	public Member addMember(String surName, String firstName, String secondName) {
		// using currentNumber+1 as memberNumber so it starts at 1
		Member m = new Member(surName, firstName, secondName, members.size()+1);
		members.add(m);
		return m;
	}
	public void addMember(Member member) {
		if (member.getMemberNumber() == 0) 
			member.setMemberNumber(members.size()+1);
		members.add(member);
	}
	public Facility addFacility(String name, String description) {
		if (name == null)
			return null;
		Facility f = new Facility(name, description);
		facilities.put(name, f);
		return f;
	}
	// remove member facility
	public void removeMember(int memberNumber) {
		// using the created method getMember(find certain member by memberNumber)
		Member m = getMember(memberNumber);
		if (m != null)
			members.remove(m);
	}
	public void removeFacility(String name) {
		facilities.remove(name);
	}
	// show
	public void showMembers() {
		for (Member m : members)
			System.out.println(m);
	}
	public void showFacilities() {
		for (Facility f : facilities.values())
			System.out.println(f);
	}
    public void show() {
        System.out.println ("Current Members:");
        showMembers();
        System.out.println();
        System.out.println ("Facilities:");
        showFacilities	();
    }
}
