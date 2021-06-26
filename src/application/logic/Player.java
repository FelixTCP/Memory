package application.logic;

public class Player {

    private String name;
    private int points;
    public boolean onMove;

    public Player(String name, int points, boolean onMove) {
        this.name = name;
        this.points = points;
        this.onMove = onMove;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isOnMove() {
        return onMove;
    }

    public void setOnMove(boolean onMove) {
        this.onMove = onMove;
    }
}
