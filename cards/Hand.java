package cards;

public class Hand {

    private Card[] cards;
    private int length; 

    public Hand(int maxCards) {
        if (maxCards < 0) maxCards = 0;
        cards = new Card[maxCards];
        length = 0;
    }


    public void add(Card c) {
        if (c == null) return;
        if (length < cards.length) {
            cards[length++] = c;
        }
    }


    public int length() {
        return length;
    }


    public Card get(int index) {
        if (index < 0 || index >= length) return null;
        return cards[index];
    }


    public Card remove(int index) {
        if (index < 0 || index >= length) return null;
        Card removed = cards[index];
        for (int i = index; i < length - 1; i++) {
            cards[i] = cards[i + 1];
        }
        cards[length - 1] = null;
        length--;
        return removed;
    }

    @Override
    public String toString() {
        if (length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb.append(cards[i].toString());
            if (i < length - 1) sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
