import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Valued Customer on 9/9/2016.
 * 353. Design Snake Game
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

 The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

 You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

 Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

 When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

 Example:
 Given width = 3, height = 2, and food = [[1,2],[0,1]].

 Snake snake = new Snake(width, height, food);

 Initially the snake appears at position (0,0) and the food at (1,2).

 |S| | |
 | | |F|

 snake.move("R"); -> Returns 0

 | |S| |
 | | |F|

 snake.move("D"); -> Returns 0

 | | | |
 | |S|F|

 snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

 | |F| |
 | |S|S|

 snake.move("U"); -> Returns 1

 | |F|S|
 | | |S|

 snake.move("L"); -> Returns 2 (Snake eats the second food)

 | |S|S|
 | | |S|

 snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */
public class p353 {
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    int[][] food;
    int ind = 0;
    int width = 0;
    int height = 0;
    List<int[]> snake;
    public p353(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snake = new LinkedList<>();
        snake.add(new int[]{0,0});
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = new int[]{snake.get(0)[0], snake.get(0)[1]};
        switch (direction) {
            case "U": {
                if (head[0] == 0) return -1;
                head[0]--;
                break;
            }
            case "L": {
                if (head[1] == 0) return -1;
                head[1]--;
                break;
            }
            case "R": {
                if (head[1] == width-1) return -1;
                head[1]++;
                break;
            }
            case "D": {
                if (head[0] == height-1) return -1;
                head[0]++;
                break;
            }
        }
        int ind = findInList(snake, head);
        if (ind != -1 && ind != snake.size()-1) return -1;
        update(head);
        return snake.size()-1;
    }

    private void update(int[] head) {
        snake.add(0, head);
        if (ind < food.length && (head[0] == food[ind][0] && head[1] == food[ind][1])){
            ind++;
        } else {
            snake.remove(snake.size()-1);
        }
    }

    private int findInList(List<int[]> snake, int[] pos) {
        for (int i = 0; i < snake.size(); i++) {
            if (snake.get(i)[0] == pos[0] && snake.get(i)[1] == pos[1]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] food = new int[6][];
        food[0] = new int[]{2,0};
        food[1] = new int[]{0,0};
        food[2] = new int[]{0,2};
        food[3] = new int[]{0,1};
        food[4] = new int[]{2,2};
        food[5] = new int[]{0,1};
        p353 sol = new p353(3,3,food);
        String[] dir = new String[]{"D","D","R","U","U","L","D","R","R","U","L","L","D","R","U"};
        for (String d : dir) {
            System.out.print(sol.move(d)+",");
        }
    }
}
