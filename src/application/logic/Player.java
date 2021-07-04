package application.logic;

/**
 *<h2>The class Player manages the players</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 25-06-2021
 */

public class Player {

    private String name;
    private int points;
    private boolean onMove;

    /**
     * @param name The displayed name
     * @param points The players current score
     * @param onMove Boolean that indicates whether the player is currently on Move
     */
    public Player(String name, int points, boolean onMove) {
        this.name = name;
        this.points = points;
        this.onMove = onMove;
    }

    /**
     * Returns the cardList
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the players name
     * @param name The name the player wants to be displayed
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the the players points
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets the players score
     * @param points current amount of points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Returns if the player is on move
     * @return onMove
     */
    public boolean isOnMove() {
        return onMove;
    }


    /**
     * Sets the players status
     * @param onMove onMove value
     */
    public void setOnMove(boolean onMove) {
        this.onMove = onMove;
    }
}
