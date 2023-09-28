package deque;

public class WordUtils {
    public static String longest(Deque<String> list) {
        int maxDex = 0;
        for (int i = 0; i < list.size(); i += 1) {
            String longestString = list.get(maxDex);
            String thisString = list.get(i);
            if (thisString.length() > longestString.length()) {
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    /** LLD still have bugs, due to not resolve sentinel which plays part in length comparison. */
    public static void main(String[] args) {
        ArrayDeque<String> someList = new ArrayDeque<>();
        someList.addLast("elk");
        someList.addLast("are");
        someList.addLast("watching");
        someList.printDeque();
        System.out.println(longest(someList));
    }
}
