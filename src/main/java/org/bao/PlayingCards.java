package org.bao;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PlayingCards {

    public static void main(String[] args)  {
        Card[] cardSerder = CardFactory.create54CardDeck();
        CardFactory.disorderCards(cardSerder);
        showCards(cardSerder);
        //Mutilple thread pool initiate
        ThreadPoolExecutor executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        Player p1 = new Player("Kristoff");
        Player p2 = new Player("Anna");
        Player p3 = new Player("Elsa");
        for (int i = 0; i < cardSerder.length; i++) {
            //Players are ready
            p1.resetStatus();
            p2.resetStatus();
            p3.resetStatus();
            //Sender is sendind cards
            p1.setCurrentCard(cardSerder[i]);
            p2.setCurrentCard(cardSerder[++i]);
            p3.setCurrentCard(cardSerder[++i]);
            //Players are counting
            executor.execute(p1);
            executor.execute(p2);
            executor.execute(p3);
            //Sender inquiring players
            while (!p1.isDone() || !p2.isDone() || !p3.isDone()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //check result
            if (p1.sum >= 50) {
                System.out.println(p1.name + " is the winner.");
                break;
            } else if (p2.sum >= 50) {
                System.out.println(p2.name + " is the winner.");
                break;
            } else if (p3.sum >= 50) {
                System.out.println(p3.name + " is the winner.");
                break;
            }
        }
        executor.shutdown();
    }

    private static void showCards(Card[] cardSerder) {
        //show cards
        for (int i = 0; i < cardSerder.length; i++) {
            System.out.print(cardSerder[i].getName() + " ");
        }
        System.out.print( " \n");

        int p1=0;
        for (int i = 0; i < cardSerder.length; i++) {
            if(i%3==0){
                p1+=cardSerder[i].getPoint();
                System.out.print(cardSerder[i].getPoint() + "->"+p1+"  ");
            }
        }
        System.out.print( " \n");

        int p2=0;
        for (int i = 0; i < cardSerder.length; i++) {
            if(i%3==1){
                p2+=cardSerder[i].getPoint();
                System.out.print(cardSerder[i].getPoint() + "->"+p2+"  ");
            }
        }
        System.out.print( " \n");

        int p3=0;
        for (int i = 0; i < cardSerder.length; i++) {
            if(i%3==2){
                p3+=cardSerder[i].getPoint();
                System.out.print(cardSerder[i].getPoint() + "->"+p3+"  ");
            }
        }
        System.out.print( " \n");


    }

}

class Player implements Runnable {
    boolean done = false;
    int sum = 0;
    Card currentCard;
    String name;

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void run() {
       sum+=currentCard.getPoint();
       this.done=true;
    }

    public void resetStatus() {
        this.done=false;
    }

    public boolean isDone() {
        return done;
    }
}

class CardFactory {

    public static Card createA() {
        Card card = new Card("A", 1);
        return card;
    }

    public static Card createTwo() {
        Card card = new Card("2", 2);
        return card;
    }

    public static Card createThree() {
        Card card = new Card("3", 3);
        return card;
    }

    public static Card createFour() {
        Card card = new Card("4", 4);
        return card;
    }

    public static Card createFive() {
        Card card = new Card("5", 5);
        return card;
    }

    public static Card createSix() {
        Card card = new Card("6", 6);
        return card;
    }

    public static Card createSeven() {
        Card card = new Card("7", 7);
        return card;
    }

    public static Card createEight() {
        Card card = new Card("8", 8);
        return card;
    }

    public static Card createNine() {
        Card card = new Card("9", 9);
        return card;
    }

    public static Card createTen() {
        Card card = new Card("10", 10);
        return card;
    }

    public static Card createJ() {
        Card card = new Card("J", 11);
        return card;
    }

    public static Card createQ() {
        Card card = new Card("Q", 12);
        return card;
    }

    public static Card createK() {
        Card card = new Card("K", 13);
        return card;
    }

    public static Card createBlacJoke() {
        Card card = new Card("Black Joke", 20);
        return card;
    }

    public static Card createRedJoke() {
        Card card = new Card("Red Joke", 20);
        return card;
    }

    public static Card[] create54CardDeck() {
        Card[] cards = new Card[54];
        int count = -1;
        for (int i = 0; i < 4; i++) {
            cards[++count] = createA();
            cards[++count] = createTwo();
            cards[++count] = createThree();
            cards[++count] = createFour();
            cards[++count] = createFive();
            cards[++count] = createSix();
            cards[++count] = createSeven();
            cards[++count] = createEight();
            cards[++count] = createNine();
            cards[++count] = createTen();
            cards[++count] = createJ();
            cards[++count] = createQ();
            cards[++count] = createK();
        }
        cards[++count] = createBlacJoke();
        cards[++count] = createRedJoke();
        return cards;
    }

    public static void disorderCards(Card[] cards) {
        for (int i = 0; i < 54; i++) {
            int index = (int) (Math.random() * (cards.length - 1));
            Card card = cards[i];
            cards[i] = cards[index];
            cards[index] = card;
        }
    }


}

class Card {
    private String name;
    private int point;

    public Card(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }
}
