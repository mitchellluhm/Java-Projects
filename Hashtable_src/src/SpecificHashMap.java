import java.util.LinkedList;

public class SpecificHashMap extends MyHashMap {

	public SpecificHashMap() {
		
		// TODO: IMPLEMENT CONSTRUCTOR
		// 50 is the how many elements there are in keywords.txt
		buckets = new LinkedList[50];

		// initialize every spot as a linked list
		int c = 0;
		while (c < buckets.length) {
			buckets[c] = new LinkedList<String>();
			c++;
		}
	}

	@Override
	protected int hash(String token) {
		
		// TODO: IMPLEMENT HASHING FUNCTION FOR GENERAL HASHMAP
		// return a differnt index value for every keyword
		switch(token) {
			case "abstract": return 0;
			case "continue": return 1;
			case "for": return 2;
			case "new": return 3;
			case "switch": return 4;
			case "assert": return 5;
			case "default": return 6;
			case "goto*": return 7;
			case "package": return 8;
			case "synchronized": return 9;
			case "boolean": return 10;
			case "do": return 11;
			case "if": return 12;
			case "private": return 13;
			case "this": return 14;
			case "break": return 15;
			case "double": return 16;
			case "implements": return 17;
			case "protected": return 18;
			case "throw": return 19;
			case "byte": return 20;
			case "else": return 21;
			case "import": return 22;
			case "public": return 23;
			case "throws": return 24;
			case "case": return 25;
			case "enum": return 26;
			case "instanceof": return 27;
			case "return": return 28;
			case "transient": return 29;
			case "catch": return 30;
			case "extends": return 31;
			case "int": return 32;
			case "short": return 33;
			case "try": return 34;
			case "char": return 35;
			case "final": return 36;
			case "interface": return 37;
			case "static": return 38;
			case "void": return 39;
			case "class": return 40;
			case "finally": return 41;
			case "long": return 42;
			case "strictfp": return 43;
			case "volatile": return 44;
			case "const": return 45;
			case "float": return 46;
			case "native": return 47;
			case "super": return 48;
			case "while": return 49;
		}
		// if for some reason the token was not above...
		return -1;
	}

	@Override
	public void add(String token) {

		// TODO: IMPLEMENT ADD METHOD USING BUCKETS
		// gets index for token's location in hashtable
		int index = hash(token);
		// puts token there
		buckets[index].add(token);
	
	}

	@Override
	public void display() {
		// TODO: IMPLEMENT DISPLAY METHOD TO SHOW CONTENTS OF ALL BUCKETS
		// displays all values with their indices
		for (int i=0; i < buckets.length; i++) {
			System.out.println("Index " + (i) + "'s value is: " + buckets[i]);
		}
	}
	
}
