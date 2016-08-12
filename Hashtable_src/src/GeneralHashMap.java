import java.lang.*;
import java.util.LinkedList;
import java.util.List;

public class GeneralHashMap extends MyHashMap {

	public GeneralHashMap() {

		// TODO: IMPLEMENT CONSTRUCTOR
		// 143 is the length of the buckets list, we used a for loop and a stats method to keep track of the best size
		// with average score for all six text files to get to this number.
		buckets = new LinkedList[143];

		// this initializes every spot in buckets to have another list to hold multiple values in same bucket location
		int c = 0;
		while (c < buckets.length) {
			buckets[c] = new LinkedList<String>();
			c++;
		}
	}

	@Override
	protected int hash(String token) {
		
		// TODO: IMPLEMENT HASHING FUNCTION FOR GENERAL HASHMAP
		// first generates a number based on the first character in the token string
		// absolute value is used because some special characters return negative numbers with the getNumericValue method
		int first = Math.abs(Character.getNumericValue(token.charAt(0)));
		// if the token string is more than one character, we want to use the second too in order to generate a more
		// unique value
		if (token.length() > 1) {
			int second = Math.abs(Character.getNumericValue(token.charAt(1)));
			return (first * second) % buckets.length;
		}
		else {
			return (first) % buckets.length;
		}
	}

	@Override
	public void add(String token) {
		// index uses the hashing function to give us its location in the buckets list
		int index = hash(token);


		// this adds the token to the correct place in the list
		buckets[index].add(token);

		// TODO: IMPLEMENT ADD METHOD USING BUCKETS
	
	}

	@Override
	public void display() {

		// TODO: IMPLEMENT DISPLAY METHOD TO SHOW CONTENTS OF ALL BUCKETS
		// prints out the value and index of all the items in the hashtable
		for (int i=0; i < buckets.length; i++) {
			System.out.println("Index " + (i) + "'s value is: " + buckets[i]);
		}
	}


}
