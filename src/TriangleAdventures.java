
/**
 * Edit this file to play Triangle Adventures!
 * 
 * Available commands: player.move() player.turnLeft() player.turnRight()
 * player.attack()
 *
 */

public class TriangleAdventures {

	// Change the level by changing the number below
	public static final int LEVEL_NUMBER = 15;
	static Player p;

	// Player commands for Level 1
	public static void solveLevel1(Player player) {
		p = player;
		movedist(2);
		p.attack();
	}

	// Player commands for Level 2
	public static void solveLevel2(Player player) {
		p = player;
		movedist(5);
		p.turnRight();
		p.move();
		p.attack();
	}

	// Player commands for Level 3
	public static void solveLevel3(Player player) {
		p = player;
		p.turnRight();
		p.turnRight();
		p.move();
		p.attack();
	}

	// Player commands for Level 4
	public static void solveLevel4(Player player) {
		p = player;
		p.turnLeft();
		p.move();
		p.turnRight();
		movedist(4);
		p.turnRight();
		p.attack();
	}

	// Player commands for Level 5
	public static void solveLevel5(Player player) {
		p = player;
		p.turnLeft();
		movedist(2);
		p.turnRight();
		movedist(3);
		p.turnRight();
		movedist(2);
		p.turnRight();
		p.attack();
	}

	// Player commands for Level 6
	public static void solveLevel6(Player player) {
		p = player;
		movedist(6);
		p.turnRight();
		movedist(4);
		p.turnRight();
		movedist(7);
		p.turnRight();
		movedist(2);
		p.turnRight();
		movedist(4);
		p.attack();
	}

	// Player commands for Level 7
	public static void solveLevel7(Player player) {
		p = player;
		if (Level7.CODE == 1) {
			p.attack();
		} else if (Level7.CODE == 2) {
			p.turnRight();
			p.turnRight();
			p.attack();
		}

	}

	// Player commands for Level 8
	public static void solveLevel8(Player player) {
		p = player;
		movedist(Level8.DISTANCE);
		p.attack();
	}

	// Player commands for Level 9
	public static void solveLevel9(Player player) {
		p = player;
		movedist(Level9.WALL_LENGTH);
		p.turnRight();
		movedist(4);
		p.turnRight();
		movedist(Level9.WALL_LENGTH - 1);
		p.attack();

	}

	// Player commands for Level 10
	public static void solveLevel10(Player player) {
		p = player;
		moveto(Level10.KEY_LOC[0], Level10.KEY_LOC[1]);
		moveto(Level10.DOOR_LOC[0] - 1, Level10.DOOR_LOC[1]);
		turn(0);
		p.move();
		moveto(Level10.ENEMY_LOC[0] - 1, Level10.ENEMY_LOC[1]);
		turn(0);
		p.attack();
	}

	// Player commands for Level 11
	public static void solveLevel11(Player player) {
		p = player;
		moveto(Level11.KEY_1_LOC[0], Level11.KEY_1_LOC[1]);
		moveto(Level11.KEY_2_LOC[0], Level11.KEY_2_LOC[1]);
		moveto(Level11.DOOR_LOC[0] - 1, Level11.DOOR_LOC[1]);
		turn(0);
		p.move();
		moveto(Level11.ENEMY_LOC[0] - 1, Level11.ENEMY_LOC[1]);
		turn(0);
		p.attack();
	}

	// Player commands for Level 12
	public static void solveLevel12(Player player) {
		p = player;
		for (int i = Level12.N; i > 1; i--) {
			movedist(i);
			p.turnRight();
		}
		p.attack();
	}

	// Player commands for Level 13
	public static void solveLevel13(Player player) {
		p = player;
		moveto(Level13.KEY_LOCATION[0], Level13.KEY_LOCATION[1]);
		moveto(5, 5);
		turn(0);
		p.move();
		p.attack();
	}

	// Player commands for Level 14
	// INCOMPLETE
	public static void solveLevel14(Player player) {
		p = player;

		moveto(5, 5);

		if (Level14.ENEMY_X >= Level14.ENEMY_Y) {
			moveto2(Level14.ENEMY_X + 1, Level14.ENEMY_Y);
			turn(2);
			p.attack();
		} else {
			moveto(Level14.ENEMY_X, Level14.ENEMY_Y + 1);
			turn(1);
			p.attack();
		}

	}

	// Player commands for Level 15
	public static void solveLevel15(Player player) {
		p = player;
		p.move();
		
	}

	// Player commands for Level 16
	public static void solveLevel16(Player player) {
		p = player;
		//dir 0 - Right 3 - Down 2 - Left 1 - Up
		int px = (int) p.getLocation().getX();
		while (px == p.getLocation().getX()){
			turn(3);
			p.move();
			turn(0);
			p.move();
		}
		p.move();
		p.turnLeft();
		p.move();
		p.turnRight();
		p.move();
		px = (int) p.getLocation().getX();
		while (px == p.getLocation().getX()){
			turn(1);
			p.move();
			turn(0);
			p.move();
		}
		p.move();
		p.turnRight();
		px = (int) p.getLocation().getX();
		while (px == p.getLocation().getX()){
			turn(3);
			p.move();
			turn(0);
			p.move();
		}
		p.move();
		p.turnRight();
		movedist((int) (5-p.getLocation().getY()));
	}

	// Run game
	public static void main(String[] args) {
		final Main game = new Main();
		game.run();
	}

	private static void movedist(int dist) {
		for (int i = 0; i < dist; i++) {
			p.move();
		}
	}

	private static void moveto(int newx, int newy) {
		// x then y
		// int d = player.getDirection();
		// d = resetTurn(player);

		int oldX = (int) p.getLocation().getX();
		int oldY = (int) p.getLocation().getY();
		boolean xset = false, yset = false;
		if ((oldX - newx) < 0) {
			turn(0);
			movedist(Math.abs(oldX - newx));
		} else if ((oldX - newx) > 0) {
			turn(2);
			movedist(Math.abs(oldX - newx));
		} else {
			xset = true;
		}

		if ((oldY - newy) < 0) {
			turn(3);
			movedist(Math.abs(oldY - newy));
		} else if ((oldY - newy) > 0) {
			turn(1);
			movedist(Math.abs(oldY - newy));

		} else {
			yset = true;
		}

		if (!(xset && yset)) {
			moveto(newx, newy);
		}
		/**
		 * dir 0 - Right 3 - Down 2 - Left 1 - Up
		 */
	}

	private static void moveto2(int newx, int newy) {
		// y then x
		// int d = player.getDirection();
		// d = resetTurn(player);

		int oldX = (int) p.getLocation().getX();
		int oldY = (int) p.getLocation().getY();
		boolean xset = false, yset = false;
		if ((oldY - newy) < 0) {
			turn(3);
			movedist(Math.abs(oldY - newy));
		} else if ((oldY - newy) > 0) {
			turn(1);
			movedist(Math.abs(oldY - newy));

		} else {
			yset = true;
		}
		if ((oldX - newx) < 0) {
			turn(0);
			movedist(Math.abs(oldX - newx));
		} else if ((oldX - newx) > 0) {
			turn(2);
			movedist(Math.abs(oldX - newx));
		} else {
			xset = true;
		}
		if (!(xset && yset)) {
			moveto2(newx, newy);
		}
		/**
		 * dir 0 - Right 3 - Down 2 - Left 1 - Up
		 */
	}

	private static void turn(int goal) {
		int dir = p.getDirection() / 90;
		while (dir % 4 != goal) {
			p.turnLeft();
			dir = (dir + 1) % 4;
		}
		// return dir%4;
	}

}
