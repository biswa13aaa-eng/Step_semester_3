package array.class_problems;

public class DuplicateTeamNameFinder {

    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i] != null && teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String res1 = findDuplicateTeam(new String[]{"ByteForce", "CodeCrafters", "ByteForce"});
        System.out.println(res1);

        String res2 = findDuplicateTeam(new String[]{"ByteForce", "CodeCrafters", "NullPointers"});
        System.out.println(res2);
    }
}