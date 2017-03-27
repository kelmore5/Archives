package kelmore5.java.hackerrank.java.data_structures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <pre class="doc_header">
 * <p>
 * </pre>
 *
 * @author kelmore5
 * @custom.date 3/22/17
 */

class JavaComparator{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

class Checker implements Comparator<Player> {
    public int compare(Player one, Player two) {
        if(one.score > two.score) {
            return -1;
        } else if(one.score == two.score) {
            return one.name.compareTo(two.name);
        } else {
            return 1;
        }
    }

    public boolean equals(Player one, Player two) {
        return one.name == two.name && one.score == two.score;
    }
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}