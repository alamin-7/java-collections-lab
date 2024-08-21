import java.net.Inet4Address;
import java.util.*;


public class Main {
    public static void main(String[] args) {

       /* // using sort and loops

        List<String> list = Arrays.asList("eat", "ate", "bcd", "cbd", "ccb");
        List<List<String>> anagrams = new ArrayList<>();

        boolean[] visited = new boolean[list.size()];

        for(int i = 0; i < list.size(); i++) {

            List<String> groups = new ArrayList<>();

            if(!visited[i]){
                groups.add(list.get(i));
            }

            if(visited[i]){
                continue;
            }

            char[] c1 = list.get(i).toCharArray();

            for(int j = i+1; j < list.size(); j++){

                if(visited[j]){
                    continue;
                }

                char[] c2 = list.get(j).toCharArray();

                Arrays.sort(c1);
                Arrays.sort(c2);

                if(Arrays.equals(c1, c2)){
                    if(!visited[j]){
                        visited[j] = true;
                        groups.add(list.get(j));
                    }
                }
            }

            anagrams.add(groups);
        }

        System.out.println(anagrams);*/



        List<String> list = Arrays.asList("eat", "ate", "bcd", "cbd", "ccb");
        List<List<String>> anagrams = new ArrayList<>();

        boolean[] visited = new boolean[list.size()];

        for(int i = 0; i < list.size(); i++){

            List<String> group = new ArrayList<>();

            if(visited[i]){
                continue;
            }

            System.out.println("i ==== "+i);

                group.add(list.get(i));
                visited[i] = true;

                String s1 = list.get(i);

                Map<Character, Integer> mymap = buildFrequencyMap(s1);

                System.out.println("i = " + i + " and group = " + group);

            for(int j = i+1; j < list.size(); j++){

                if(visited[j]){
                    continue;
                }

                String s2 = list.get(j);

                Map<Character, Integer> tempMap = new HashMap<>(mymap);

                for(int l = 0; l < s2.length(); l++){

                    char ch = s2.charAt(l);

                    if(!tempMap.containsKey(ch)){
                        break;
                    } else if (tempMap.get(ch) == 1) {
                        tempMap.remove(ch);
                    } else {
                        tempMap.put(ch, tempMap.get(ch) -1);
                    }
                }

                System.out.println("map size for j = "+j+" "+tempMap.size());

                if(tempMap.isEmpty()){
                    visited[j] = true;
                    group.add(list.get(j));
                }

            }
            anagrams.add(group);
            System.out.println("after first iteration "+group);
        }

        System.out.println(anagrams);
    }

    private static Map<Character, Integer> buildFrequencyMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}