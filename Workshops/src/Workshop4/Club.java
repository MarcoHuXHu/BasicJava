package Workshop4;

import java.sql.Date;
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
	private BookingRegister bookingRegister;
	
	//constructor
	public Club() {
		members = new ArrayList<Member>();
		facilities = new HashMap<String, Facility>();
		bookingRegister = new BookingRegister();
	}
	
	// get members facilities
	public ArrayList<Member> getMembers() {
		//return members;
		ArrayList<Member> result = new ArrayList<Member>(members);
		Collections.sort(result);
		// Once the Member class implements Comparable<T>, sort() will automatically call compareTo
		// Otherwise, sort should be like followed
		// Collections.sort(result, (left, right) -> left.compareTo(right));
		// Or don't use compareTo, instead, using something like Lambda
		Collections.sort(result, (left, right) -> left.getMemberNumber()-right.getMemberNumber());
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
		Iterator<Member> iterator = getMembers().iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next().toString());
	}
	public void showFacilities() {
		Iterator<Facility> iterator = getFacilities().iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next().toString());
	}
    public void show() {
        System.out.println ("Current Members:");
        showMembers();
        System.out.println();
        System.out.println ("Facilities:");
        showFacilities	();
    }
    public void addBooking(Member member, Facility facility, Date startDate, Date endDate)
    		throws BadBookingException {
    	bookingRegister.addBooking(member, facility, startDate, endDate);
    }
    public ArrayList<Booking> getBookings(Facility facility, Date startDate, Date endDate) {
    	return bookingRegister.getBookings(facility, startDate, endDate);
    }
}

