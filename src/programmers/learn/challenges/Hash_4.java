package programmers.learn.challenges;

import java.util.*;

public class Hash_4 {
    private class Song implements Comparable<Song> {
        String genre;
        int number;
        int play;

        public Song(String genre, int number, int play) {
            this.genre = genre;
            this.number = number;
            this.play = play;
        }

        @Override
        public int compareTo(Song other) {
            if (this.play < other.play) return 1;
            else if (this.play == other.play) {
                if (this.number > other.number) return 1;
            }
            return -1;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        // calc total plays
        Map<String, Integer> total = new HashMap<>();
        for (int i = 0; i < genres.length; i++)
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
        // sort
        List<Map.Entry<String, Integer>> totalSorted = new ArrayList<>(total.entrySet());
        totalSorted.sort(Map.Entry.comparingByValue());
        Collections.reverse(totalSorted);

        // numbering
        List<Song> list = new ArrayList<>();
        for (int i = 0; i < genres.length; i++)
            list.add(new Song(genres[i], i, plays[i]));
        // sort
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : totalSorted) {
            String genre = entry.getKey();
            List<Song> songs = new ArrayList<>();
            for (Song s : list)
                if (s.genre.equals(genre)) songs.add(s);
            Collections.sort(songs);

            List<Integer> r = new ArrayList<>();
            for (Song s : songs) {
                if (r.size() >= 2) break;
                r.add(s.number);
            }
            result.addAll(r);
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);

        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "classic"};
        int[] plays = {500, 600, 150, 800, 2500, 500};
        Hash_4 h = new Hash_4();
        System.out.println(h.solution(genres, plays));
    }
}
