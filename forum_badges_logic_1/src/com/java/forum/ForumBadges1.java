package com.java.forum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForumBadges1 {
	public static void main(String[] args) {
		
		/** Requirements **/
		List<Integer> values = Arrays.asList(2, 5, 10, 15, 20, 25);
		System.err.println("VALUES: " + values);
		
		/** Requirement to BadgeId Mapping **/
		Map<Integer, Integer> forumPostsBadgeIdsMap = new HashMap<>();
		forumPostsBadgeIdsMap.put(1, 140);
		forumPostsBadgeIdsMap.put(5, 141);
		forumPostsBadgeIdsMap.put(10, 142);
		forumPostsBadgeIdsMap.put(15, 143);
		forumPostsBadgeIdsMap.put(25, 144);
		System.err.println("MAP: " + forumPostsBadgeIdsMap);
		
		/** Total No of Posts as on Date **/
		Integer forumPostCount = 15;
		
		/** DUMMY MAP FOR BADGES ISSUED - MIMICS DATABASE **/
		Map<Integer, Boolean> dummyBadgesIssuedMap = new HashMap<>();
		dummyBadgesIssuedMap.put(140, false);  //1
		dummyBadgesIssuedMap.put(141, false);  //5
		dummyBadgesIssuedMap.put(142, false);  //10
		dummyBadgesIssuedMap.put(143, false);  //15
		dummyBadgesIssuedMap.put(144, false);  //25
		
		for (Integer element : values) {
			if (forumPostsBadgeIdsMap.containsKey(element)) {
				if (dummyBadgesIssuedMap.containsKey(forumPostsBadgeIdsMap.get(element)) && 
					dummyBadgesIssuedMap.get(forumPostsBadgeIdsMap.get(element)) == false &&
					element <= forumPostCount) {
					
					if(dummyBadgesIssuedMap.get(forumPostsBadgeIdsMap.get(element)) == false) {
						System.err.println("ISSUE NEW BADGE FOR NO OF FORUM POST: " + element);
					}
				}
			}
		}
	}
}
