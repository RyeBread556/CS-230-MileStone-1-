package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// Will create a static instance within the class itself.
 private static GameService instance = new GameService();
 
 //private constructor ensures instantiation internally.
 private GameService() {

}
 // returns said instance.
 public static GameService getInstance () {
	 return instance;
 }




	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

	// iterator will look for existing game with matching name by iterating through the list and returning if matching
		//Note: not sure why it wont accept "game"
		
		Iterator<Game> iterator = games.iterator();
		while(iterator.hasNext()) {
			Game game  = iterator.next();
			if(game.getName().equals(name)) {
				return game;
			}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
			}
		}
	

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// iterator will look for existing ID with matching ID by iterating through the list and returning if matching,
		//otherwise will return null
		// Note: not sure why it wont accept "game"
		
		Iterator<Game> iterator = games.iterator();
		while(iterator.hasNext()) {
			Game Id = iterator.next();
			if(game.getId()== id) {
			return game;
			}
		}
		return null;
	}

		
	
	
		
	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// iterator will look for existing game with matching name by iterating through the list and returning if matching
		// otherwise will return null
		//Note: not sure why it wont accept "game"
		Iterator<Game> iterator = games.iterator();
		while(iterator.hasNext()) {
			Game game  = iterator.next();
			if(game.getName().equals(name)) {
				return game;
			}
		}
		return null;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}

// the iterator pattern allows for a way to access all elements without exposing any important underlying representations of details.
