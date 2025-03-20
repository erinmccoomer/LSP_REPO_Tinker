package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * A class representing a voting machine for an election.
 * The voting machine allows adding candidates, casting votes, 
 * and determining the winner of the election based on votes.
 */
public class VotingMachine {
    private Map<String, Integer> candidates;

    /**
     * Constructor that initializes the voting machine with an empty list of candidates.
     */
    public VotingMachine() {
        candidates = new HashMap<>();
    }

    /**
     * Adds a candidate to the election.
     * If the candidate already exists, this method does nothing.
     * 
     * @param candidateName The name of the candidate to add.
     */
    public void addCandidate(String candidateName) {
        // Add candidate to the candidates list if not already present
        if (!candidates.containsKey(candidateName)) {
            candidates.put(candidateName, 0);
        }
    }

    /**
     * Casts a vote for a candidate.
     * If the candidate does not exist, the vote will not be counted.
     * 
     * @param candidateName The name of the candidate to vote for.
     * @return boolean Returns true if the vote was successful, false if the candidate does not exist.
     */
    public boolean castVote(String candidateName) {
        if (candidates.containsKey(candidateName)) {
            // Increment the vote count for the candidate
            candidates.put(candidateName, candidates.get(candidateName) + 1);
            return true;
        }
        return false; // Candidate does not exist
    }

    /**
     * Determines the winner of the election based on the total votes.
     * 
     * @return String The name of the candidate with the most votes.
     * If there is a tie, it returns the candidate who appeared first in the list.
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (entry.getValue() > maxVotes) {
                winner = entry.getKey();
                maxVotes = entry.getValue();
            }
        }

        return winner + " WINS with " + maxVotes + " votes!!";
    }
}
