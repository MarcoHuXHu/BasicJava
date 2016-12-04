package Workshop3;

import java.util.Arrays;

public class Club {
	// currentNumber is used to set memberNumber starts from 1
	// members start at member[1] with member[0] reserved
	private int currentNumber;
	private Member[] members;
	// 我也就是试着搞一下final而已
	private static final int ARRAY_SIZE_INCREMENT = 1;
	//constructor
	public Club() {
		currentNumber = 0;
		members = new Member[1];
	}
	public Member addMember(String surName, String firstName, String secondName) {
		// using currentNumber+1 as memberNumber so it starts at 1
		currentNumber ++;
		Member m = new Member(surName, firstName, secondName, currentNumber);
		members = Arrays.copyOf(members, members.length + ARRAY_SIZE_INCREMENT);
		members[currentNumber] = m;
		return m;
	}
	public void removeMember(int i) {
		if ((i>0) && (i<=currentNumber))
			members[i] = null;
	}
	public void showMembers() {
		for (int i=0; i<=currentNumber; i++)
			if (members[i] != null)
				System.out.println(members[i]);
	}
}
