package Workshop4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import Workshop2.Facility;
import Workshop3.Member;

public class Club {
	// members 用ArrayList储存, get一个特定Member, 利用Iterator来遍历完成
	private ArrayList<Member> members;
	// facilities 用HashMap储存, facilities.values()为值对应的ArrayList
	private HashMap<String, Facility> facilities;
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
}
