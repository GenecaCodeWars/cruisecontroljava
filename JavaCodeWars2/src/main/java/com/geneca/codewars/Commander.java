package com.geneca.codewars;

import java.util.ArrayList;
import java.util.List;

import com.geneca.codewars.data.BoardStatus;
import com.geneca.codewars.data.Command;

public class Commander {
	
    public BoardStatus _currentBoard;

    public Commander()
    {
        _currentBoard = new BoardStatus();
    }

    // Do not alter/remove this method signature
    public List<Command> GiveCommands()
    {
        List<Command> cmds = new ArrayList<Command>();

        // Add Commands Here.
        // You can only give as many commands as you have un-sunk vessels. Powerup commands do not count against this number. 
        // You are free to use as many powerup commands at any time. Any additional commands you give (past the number of active vessels) will be ignored.

        return cmds;
    }

    // Do NOT modify or remove! This is where you will receive the new board status after each round.
    public void GetBoardStatus(BoardStatus board)
    {
        _currentBoard = board;
    }

    // This method runs at the start of a new game, do any initialization or resetting here 
    public void Reset()
    {
        
    }
}
