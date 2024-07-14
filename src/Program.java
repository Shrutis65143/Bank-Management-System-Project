import java.util.*;

public class Program {
    public static void main(String args[]){

        Scanner s = new Scanner(System.in);

        String t[] = new String[3];

        System.out.println("enter the three string");

        for(int i=0;i<3;i++){
            t[i]=s.nextLine();
        }

        System.out.println(commonprefix(t));

    }

    public static String commonprefix(String q[]) {

        Arrays.sort(q);
        String s1 = q[0];
        String s2 = q[q.length - 1];
        int index = 0;
        for (int j = 0; j < s1.length(); j++) {
            if (s1.charAt(j) == s2.charAt(j)) {
                index++;
            } else {
                break;
            }
        }

        return index==0?"":s1.substring(0,index);

    }
}
