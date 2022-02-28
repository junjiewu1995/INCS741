import java.util.*;


public class ColumnarTranspositionCipher {

    private static int  [] keyPosition;
    private static char [] keyArray;
    private static char [] messageArray;
    private static char [][] plainTextArray;
    private static char [] dArray;

    private static String rtcencrytion(String key, String message) {

        int keylen= key.length();
        keyArray = key.toCharArray();
        messageArray = message.toCharArray(); 
        keyPosition = new int [keylen];

        /* Sort the Key */
        Arrays.sort(keyArray);

        /* KeyPosition records the key's postion */
        int x = 0;
        for (char c : keyArray) {
            keyPosition[x++] = key.indexOf(c);
            System.out.print(key.indexOf(c) + " ");
        }
        System.out.println();

        /* Find the rows length */
        int cols = keylen, rows = 0;
        if (message.length() % cols == 0) rows = message.length() / cols;
        else rows = message.length() / cols + 1;

        /* Message to CharArray */
        plainTextArray = new char[rows][cols]; 
        
        /* Insert each character to the matrix */
        int k = 0; 
        for (int i = 0; i < rows; ++ i) 
        { 
            for (int j = 0; j < cols; ++ j) 
            { 
                if (k == message.length()) break; 
                plainTextArray[i][j] = messageArray[k++];  
                System.out.print(plainTextArray[i][j] + " "); 
            } 
            System.out.println(); 
        } 

        /* Append the encrypted message line by line through matrix */
        StringBuilder str = new StringBuilder(); 
        for (int i = 0; i < cols; i ++) {
            for (int j = 0; j < rows; j ++) {
                str.append(plainTextArray[j][keyPosition[i]]);  
            } 
        }
        return str.toString(); 
    } 

    
    private static String rtcdecryption(String key, String message) {

        int keylen = key.length();
        keyArray = key.toCharArray();
        messageArray = message.toCharArray();
        keyPosition = new int [keylen];

        /* Sort the Key */
        Arrays.sort(keyArray);

        /* KeyPosition records the key's postion */
        int x = 0;
        for (char c : keyArray) {
            keyPosition[x++] = key.indexOf(c);
            System.out.print(key.indexOf(c) + " ");
        }
        System.out.println();

        /* Find the rows length */
        int cols= keylen, rows = 0;
        if (message.length() % cols == 0) rows = message.length() / cols;
        else rows = message.length() / cols + 1;

        plainTextArray = new char[rows][cols];

        /* Message to CharArray */
        int k = 0;
        for (int i = 0; i < cols; ++ i) 
        {
            for (int j = 0; j < rows; ++ j) 
            {
                if (k == message.length()) break;
                plainTextArray[j][keyPosition[i]] = messageArray[k++];
            }
        }

        /* Append the encrypted message line by line through matrix */
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < rows; i ++) 
        {
            for (int j = 0; j < cols; j ++) 
            {
                str.append(plainTextArray[i][j]);
            }
        }
        return str.toString();
    }

    public static void main (String [] args) {
        String key = "NYITV"; 
        String enmessage = "CRYPTOLOGY IS THE PRACTICE AND STUDY OF TECHNIQUES FOR SECURE COMMUNICATION IN THE PRESENCE OF THIRD PARTIES CALLED ADVERSARIES"; 
        String demessage = "eroohalpsmeptroohalsefxphtnlefhhxtwstiiiieoecrastitosplmgeasentmitrasnefylypnhiasnetoiroitaetaxoeetonicrasetltesnicrfwmurnhrrhitrcrxhtpipsrmaimiitpiphlaleiucciptotpe"; 
        key = key.replaceAll("\\s+", ""); 
        enmessage = enmessage.replaceAll("\\s+", ""); 
        demessage = demessage.replaceAll("\\s+", ""); 

        System.out.println("Test 1 ======================================> ");
        System.out.println("M : [ " + enmessage + " ]");
        System.out.println("w : [ " + key + " ]");
        String res = rtcencrytion(key, enmessage); 
        System.out.println("C : [ " + res + " ]");      
        String decode = rtcdecryption(key, res).trim();
        System.out.println("D : [ " + decode + " ]");
        System.out.println("Comparing M and D : " + enmessage.equals(decode) + "\n");

        System.out.println("Test 2 ======================================> ");
        System.out.println("*******");
        System.out.println("C : [ " + demessage + " ]");    
        System.out.println("w : [ " + key + " ]");
        String d = rtcdecryption(key, demessage);
        System.out.println("M : [ " + d + " ]");
        String r = rtcencrytion(key, d).trim(); 
        System.out.println("E : [ " + r + " ]");
        String text = "therowtranspositioncipherisafairlysimpleeasytoimplementcipheritisatranspositioncipherthatfollowsasimpleruleformixingupthecharactersintheplaintexttoformtheciphertextx";
        System.out.println("Comparing C and E : " + d.equals(text) + "\n");

    }
}




