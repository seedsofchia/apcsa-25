package cards;

import java.util.Random;

public class Deck {

    private Card[] cards;
    private int topIndex;  

    public Deck() {
        cards = new Card[52];
        int pos = 0;
        // suits 0..3 and values 0..12 (A..K)
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 0; value < 13; value++) {
                cards[pos++] = new Card(suit, value);
            }
        }
        topIndex = 0;
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
        topIndex = 0;
    }


    public void cut(int cutIndex) {
        if (cutIndex < 0 || cutIndex >= cards.length) return;
        if (topIndex != 0) return; // only allowed on a complete deck per spec

        Card[] newDeck = new Card[cards.length];
        int pos = 0;
    
        for (int i = cutIndex; i < cards.length; i++) {
            newDeck[pos++] = cards[i];
        }
     
        for (int i = 0; i < cutIndex; i++) {
            newDeck[pos++] = cards[i];
        }
        cards = newDeck;
        topIndex = 0;
    }

    public Card draw() {
        if (topIndex >= cards.length) return null;
        return cards[topIndex++];
    }


    public void print(int count) {
        if (count <= 0) {
            System.out.println();
            return;
        }
        StringBuilder sb = new StringBuilder();
        int available = Math.max(0, cards.length - topIndex);
        int toPrint = Math.min(count, available);

        for (int i = 0; i < toPrint; i++) {
            if (i > 0) sb.append(" ");
            sb.append(cards[topIndex + i].toString());
        }
        System.out.println(sb.toString());
    }

    
    public int remaining() {
        return Math.max(0, cards.length - topIndex);
    }

    public void reset() {
        topIndex = 0;
    }
}
