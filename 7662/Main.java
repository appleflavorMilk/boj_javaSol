import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        //Test case 입력
        Scanner scanner = new Scanner(System.in);
        int Testcase = scanner.nextInt();
        String[][] arr = new String[Testcase][2];

        for(int i = 0; i < Testcase; i++) {
            int n = scanner.nextInt();
            TreeMap<Integer, Integer> Tm = new TreeMap<>();

            // 각 Test case 마다 n번 만큼 D x 또는 I x를 입력받아 정해진 역할을 수행.
            for(int j = 0; j < n; j++) {
                String command = scanner.next();
                int value = scanner.nextInt();

                if(command.equals("I")) {
                    Tm.put(value, Tm.getOrDefault(value, 0) + 1);
                } else if(command.equals("D") && !Tm.isEmpty()) {
                    if(Tm.size()==0)continue;
                    if(value == 1) {
                        int maxKey = Tm.lastKey();
                        if(Tm.get(maxKey) == 1) {
                            Tm.remove(maxKey);
                        } else {
                            Tm.put(maxKey, Tm.get(maxKey) - 1);
                        }
                    } else if(value == -1) {

                        int minKey = Tm.firstKey();
                        if(Tm.get(minKey) == 1) {
                            Tm.remove(minKey);
                        } else {
                            Tm.put(minKey, Tm.get(minKey) - 1);
                        }
                    }
                }
            }

            if(!Tm.isEmpty()) {
                arr[i][0] = Tm.lastKey().toString();
                arr[i][1] = Tm.firstKey().toString();
            } else {
                arr[i][0] = "EMPTY";
                arr[i][1] = "EMPTY";
            }
        }

        for(int i = 0; i < Testcase; i++) {
            if(arr[i][0].equals("EMPTY")) {
                System.out.println("EMPTY");
            } else {
                System.out.println(arr[i][0] + " " + arr[i][1]);
            }
        }
    }
}
