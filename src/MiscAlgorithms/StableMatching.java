package MiscAlgorithms;

import java.util.HashMap;

/**
 * Created by Gurkanwal on 8/29/2017.
 */
public class StableMatching {
    String[] men, women;
    String[][] menPref,womenPref;

    int[][] womenRanking;

    StableMatching(String[] men, String[] women, String[][] menPref, String[][] womenPref ){
        this.men = men;
        this.women = women;
        this.menPref = menPref;
        this.womenPref = womenPref;

        HashMap<String,Integer> menIndexes = new HashMap<>(men.length);
        for (int i = 0; i < men.length; i++) {
            menIndexes.put("M" + i, i);
        }

        HashMap<String,Integer> womenIndexes = new HashMap<>(men.length);
        for (int i = 0; i < men.length; i++) {
            womenIndexes.put("W" + i, i);
        }

        womenRanking = new int[women.length][men.length];
        for (int i = 0; i < women.length ; i++) {
            for (int j = 0; j < men.length; j++) {
                womenRanking[i][j]= menIndexes.get(womenPref[i][j]);
            }
        }
        LinkedList.LinkedList<String> freeMen = new LinkedList.LinkedList<String>();
        freeMen.appendArrayToFront(freeMen.head, men);

        int[] menNextPartner = new int[men.length];
        int[] womenCurrentPartner = new int[men.length];

        for (int i = 0; i < menNextPartner.length ; i++) {
            menNextPartner[i] = 0;
            womenCurrentPartner[i] = -1;
        }

        HashMap<String,String> marriages = new HashMap<>();

        while(freeMen.head!=null){
            String currentMan = freeMen.deleteFromFront(freeMen.head);
            String currentWoman = menPref[menIndexes.get(currentMan)][menNextPartner[menIndexes.get(currentMan)]];
            if(womenCurrentPartner[womenIndexes.get(currentWoman)] == -1){
                marriages.put(currentMan,currentWoman);
                menNextPartner[menIndexes.get(currentMan)] = menNextPartner[menIndexes.get(currentMan)] + 1;
                womenCurrentPartner[womenIndexes.get(currentWoman)] = menIndexes.get(currentMan);
            } else if(womenRanking[womenIndexes.get(currentWoman)][menIndexes.get(currentMan)] < womenRanking[womenIndexes.get(currentWoman)][womenCurrentPartner[womenIndexes.get(currentWoman)]]){
                marriages.put(currentMan,currentWoman);
                freeMen.appendToFront(freeMen.head, "M"+womenCurrentPartner[womenIndexes.get(currentWoman)]);
                womenCurrentPartner[womenIndexes.get(currentWoman)] = menIndexes.get(currentMan);
                menNextPartner[menIndexes.get(currentMan)] = menNextPartner[menIndexes.get(currentMan)] + 1;
            } else {
                menNextPartner[menIndexes.get(currentMan)] = menNextPartner[menIndexes.get(currentMan)] + 1;
                freeMen.appendToFront(freeMen.head, currentMan);
            }
        }

        for (String marriage: marriages.keySet()){
            System.out.println(marriage +"=>"+ marriages.get(marriage));
        }
    }





    public static void main(String[] args) {
        System.out.println("Gale Shapley Marriage Algorithm\n");
        /** list of men **/
        String[] m = {"M0", "M1", "M2", "M3", "M4"};
        /** list of women **/
        String[] w = {"W0", "W1", "W2", "W3", "W4"};

        /** men preference **/
        String[][] mp = {{"W4", "W1", "W2", "W3", "W0"},
                {"W4", "W1", "W0", "W2", "W3"},
                {"W4", "W2", "W1", "W0", "W3"},
                {"W0", "W1", "W2", "W3", "W4"},
                {"W4", "W1", "W2", "W3", "W0"}};
        /** women preference **/
        String[][] wp = {{"M4", "M2", "M3", "M0", "M1"},
                {"M0", "M1", "M2", "M4", "M3"},
                {"M3", "M4", "M2", "M1", "M0"},
                {"M4", "M1", "M3", "M0", "M2"},
                {"M1", "M0", "M3", "M2", "M4"}};

        StableMatching sm = new StableMatching(m, w, mp, wp);
    }

}
