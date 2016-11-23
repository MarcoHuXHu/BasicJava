package Workshop3;

import Workshop2.Person;

public class Member extends Person{
	int memberNumber;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
		memberNumber = 0;
	}

	public Member(String surName, String firstName, String secondName, int memberNumber) {
		super(surName, firstName, secondName);
		// TODO Auto-generated constructor stub
		this.memberNumber = memberNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	@Override
	public String toString() {
		return memberNumber + "-" + super.toString();
	}
	// 添加了comparTo, 才能用Collections.sort()
	public int compareTo(Member member2) {
		return this.memberNumber - member2.memberNumber;
	}
}
