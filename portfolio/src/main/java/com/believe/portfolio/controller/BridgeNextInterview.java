package com.believe.portfolio.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class BridgeNextInterview {

	class A {
		private int a;
	}

	class B extends A {

		void accessData() {
			A aclass = new B();
			System.out.println(aclass.a);
		}

	}

	/***
	 * Scenario: Finding Pairs of Participants for a Team Activity We are organizing
	 * a team-building event and have a list of participants, each with their
	 * respective age. The participants are seated in a line, and their positions
	 * are numbered sequentially.
	 * 
	 * List<Integer> participantAge; age, sequentially index: positions List
	 *
	 * 
	 * For the team-building activity, you need to form pairs of participants, where
	 * the sum of their ages is 50, and both participants in the pair must be seated
	 * in even-numbered positions. The participants seated at odd-numbered positions
	 * are not eligible to form pairs, so you only need to consider participants
	 * seated at even-numbered positions.
	 * 
	 * pair of participants?? sum()==50 i%2==0 even condition
	 * 
	 * 
	 * summarization: Given the list of participants' ages and their positions, task
	 * is to find all pairs of participants seated in even positions whose ages add
	 * up to 50.
	 * 
	 **/

	private List<List<Integer>> findPairsOfPariticipants(List<Integer> ages) {

		List<Integer> evenPositions = ages.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
		for (int i = 0; i < evenPositions.size(); i++) {
			for (int j = 1; j < evenPositions.size(); j++) {

				if ((evenPositions.get(i) + evenPositions.get(j)) == 50) {
					System.out.print(false);
				}
			}
		}

		return null;
	}

	/***
	 *HTTPUtility
	 * 
	 * 
	 *  
	 * 
	 * 
	 * ***/

//	interface A1 {
//		void display();
//	}
//
//	@Service
//	class B1 implements A1 {
//		@Override
//		void display(){
//		  System.out.println("IN B");
//		 }
//	}
//
//	@Service
//	class C implements A {
//		@Override
//		void display(){
//		  System.out.println("IN C");
//		 }
//	}
//
//	class MainClass {
//
//		@Autowired
//		A a;
//
//		public static void main(String[] args) {
//			System.out.print(a.display());
//		}
//	}
	
	
	
	

}
