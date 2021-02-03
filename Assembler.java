import java.util.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Arrays;
import java.io.*;

// Sorting1 class containing mergeSort1
class Sorting1 {
    public static void merge1(int arr[], int l, int m, int r, int d[]) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
        int AL[] = new int[n1];
        int AR[] = new int[n2];

        for (i = 0; i < n1; i++) {
            L[i] = arr[l + i];
            AL[i] = d[l + i];
        }
        for (j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
            AR[j] = d[m + 1 + j];
        }
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                d[k] = AL[i];
                i++;
            } else {
                arr[k] = R[j];
                d[k] = AR[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            d[k] = AL[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            d[k] = AR[j];
            j++;
            k++;
        }
    }

    public static void mergeSort1(int arr[], int l, int r, int d[]) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort1(arr, l, m, d);
            mergeSort1(arr, m + 1, r, d);
            merge1(arr, l, m, r, d);
        }
    }

    public Sorting1(int arr[], int l, int r, int d[]) {
        mergeSort1(arr, l, r, d);
    }
}

/**
 * next contains the class of the table name of class is just random nothing
 * special!
 */
class League extends JFrame {
    Scanner sc = new Scanner(System.in);
    // reference where u can assign memory containing gui.

    JTable jt;

    // array containing name of column headers and categories

    static String[] column_headers1 = { "Symbol", "Type", "Offset Address", "Value", "Size" };
    // array containing elements corresponding to the categories of the column at
    // respective indices

    /*
     * static String[][] team_statistics1 = { { "Loop1", "Label", "95", "", "" }, {
     * "I", "Variable", "113", "1", "Word(4 bytes)" }, { "J", "Variable", "117",
     * "2", "word" }, { "Loop2", "Label", "105", "", "" }, { "k", "Variable", "121",
     * "3", "byte" }, { "Loop3", "Label", "121", "", "" } };
     */
    static String[][] team_statistics1 = { { " ", " ", " ", " ", " " } };

    public League() {
        // index 0:- Symbol
        // index 1:- Type
        // index 2:- offset add1ress
        // index 3:- value
        // index 4:- size

        // team_statistics1 = this.team_statistics1;
        // assigned reference to memory of gui.
        jt = new JTable(team_statistics1, column_headers1);
        // size of gui(int x,int y,int width,int height)

        jt.setBounds(250, 250, 400, 430);
        // setting view window of the gui.
        JScrollPane js = new JScrollPane(jt);
        // add1ing table
        this.add(js);
        this.setSize(300, 400);
        this.setVisible(true);
        // Sorting1 functionaccording the offsetadd1ress of rows
        // sortRow1(team_statistics1);
    }

    // function Sorting1 of rows
    public static void sortRow1(String[][] ar) {
        int n = ar.length;
        if (n == 1 && ar[0][2].equals(" "))
            return;
        else {
            int[] arr = new int[n];
            String[][] g = new String[n][];
            int[] ind = new int[n];
            for (int i = 0; i < n; i++) {
                if (ar[i][2] != " ")
                    arr[i] = Integer.parseInt(ar[i][2]);
                g[i] = ar[i];
                ind[i] = i;
            }
            Sorting1 s = new Sorting1(arr, 0, n - 1, ind);
            Sorting1.mergeSort1(arr, 0, n - 1, ind);
            for (int i = 0; i < n; i++) {
                ar[i] = g[ind[i]];
            }
        }
    }

    // add1ition of rows function
    public static void addRow1(String[][] ar, String name, String num1, String num2, String num3, String num4) {
        // temp Array for enlarging the size of array
        String temp[][] = new String[ar.length + 1][];
        // row to be add1ed
        String part[];
        if (ar[0].length == 0)
            part = new String[column_headers1.length];
        else
            part = new String[ar[0].length];
        part[0] = name;
        part[1] = num1;
        part[2] = num2;
        part[3] = num3;
        part[4] = num4;
        for (int i = 0; i < ar.length; i++) {
            temp[i] = ar[i];
        }
        temp[ar.length] = part;
        // reassigning add1ress of new array
        team_statistics1 = temp;
    }

    // search header category with key name in string format and if not found returs
    // -1
    public static int search_header1(String ar[], String key) {

        for (int i = 0; i < ar.length; i++) {
            if (key.equals(ar[i])) {
                return i;
            }
        }
        return -1;
    }

    // use this function without creating object of gui table
    // directly use add1(2d array,details as specified)
    public static void add1(String[][] ar, String name, String num1, String num2, String num3, String num4) {
        for (int i = 0; i < 1; i++) {
            League lea = new League();
            addRow1(team_statistics1, name, num1, num2, num3, num4);
            lea.dispose();
        }
        League lea = new League();

    }

    // searches index of row
    public static int search_row1(String[][] ar, String s, int col) {
        if (col == -1) {

            return -1;
        }
        for (int i = 0; i < ar.length; i++) {
            if (ar[i][col].equals(s)) {
                return i;
            }
        }

        return -1;
    }

    public static int search_row1(String[][] ar, String s, int col, int si) {
        if (col == -1) {
            return -1;
        }
        for (int i = si; i < ar.length; i++) {
            if (ar[i][col].equals(s)) {
                return i;
            }
        }
        return -1;
    }

}

// sorting2 class containing mergeSort2
class sorting2 {
    public static void merge2(int arr[], int l, int m, int r, int d[]) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
        int AL[] = new int[n1];
        int AR[] = new int[n2];

        for (i = 0; i < n1; i++) {
            L[i] = arr[l + i];
            AL[i] = d[l + i];
        }
        for (j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
            AR[j] = d[m + 1 + j];
        }
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                d[k] = AL[i];
                i++;
            } else {
                arr[k] = R[j];
                d[k] = AR[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            d[k] = AL[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            d[k] = AR[j];
            j++;
            k++;
        }
    }

    public static void mergeSort2(int arr[], int l, int r, int d[]) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort2(arr, l, m, d);
            mergeSort2(arr, m + 1, r, d);
            merge2(arr, l, m, r, d);
        }
    }

    public sorting2(int arr[], int l, int r, int d[]) {
        mergeSort2(arr, l, r, d);
    }
}

/**
 * next contains the class of the table name of class is just random nothing
 * special!
 */
class League2 extends JFrame {
    Scanner sc = new Scanner(System.in);
    // reference where u can assign memory containing gui.
    JTable jt;
    // array containing name of column headers and categories
    static String[] column_headers2 = { "Opcode", "Type", "NumOperands", "Corresponding Code", "length" };
    // array containing elements corresponding to the categories of the column at
    // respective indices
    /*
     * static String[][] team_statistics2 = { { "AAA", "1", "2", "I", "4 bytes" }, {
     * "add2", "-1", "3", "j", "4 bytes" }, { "add2", "-2", "5", "D", "8 bytes" }, {
     * "AND", "25", "1", "l", "2 bytes" }, { "AND", "-1", "4", "K", "4 bytes" } };
     */
    static String[][] team_statistics2 = { { "CLA", "0", "0", "0000", "4 bits" }, { "LAC", "1", "1", "0001", "4 bits" },
            { "SAC", "2", "1", "0010", "4 bits" }, { "ADD", "3", "1", "0011", "4 bits" },
            { "SUB", "4", "1", "0100", "4 bits" }, { "BRZ", "5", "1", "0101", "4 bits" },
            { "BRN", "6", "1", "0110", "4 bits" }, { "BRP", "7", "1", "0111", "4 bits" },
            { "INP", "8", "1", "1000", "4 bits" }, { "DSP", "9", "1", "1001", "4 bits" },
            { "MUL", "10", "1", "1010", "4 bits" }, { "DIV", "11", "1", "1011", "4 bits" },
            { "STP", "12", "0", "1100", "4 bits" } };

    public League2() {
        // index 0:- Opcode
        // index 1:- type
        // index 2:- number of opnds
        // index 3:- Opnd
        // index 4:- length
        // team_statistics2 = this.team_statistics2;
        // assigned reference to memory of gui.
        jt = new JTable(team_statistics2, column_headers2);
        // size of gui(int x,int y,int width,int height)
        jt.setBounds(250, 250, 400, 430);
        // setting view window of the gui.
        JScrollPane js = new JScrollPane(jt);
        this.add(js);
        this.setSize(300, 400);
        this.setVisible(true);
        // sorting2 functionaccording the offsetadd2ress of rows
        // sortRow2(team_statistics2);
    }

    // function sorting2 of rows
    public static void sortRow2(String[][] ar) {
        int n = ar.length;
        if (n == 1 && ar[0][1].equals(" ")) {
            return;
        } else {
            int[] arr = new int[n];
            String[][] g = new String[n][];
            int[] ind = new int[n];
            for (int i = 0; i < n; i++) {
                if (ar[i][1] != " ") {
                    arr[i] = Integer.parseInt(ar[i][1]);
                }
                g[i] = ar[i];
                ind[i] = i;
            }
            sorting2 s = new sorting2(arr, 0, n - 1, ind);
            sorting2.mergeSort2(arr, 0, n - 1, ind);
            for (int i = 0; i < n; i++) {
                ar[i] = g[ind[i]];
            }
        }
    }

    // add2ition of rows function
    public static void addRow2(String[][] ar, String name, String num1, String num2, String num3, String num4) {
        // temp Array for enlarging the size of array
        String temp[][] = new String[ar.length + 1][];
        // row to be add2ed
        String part[];
        if (ar[0].length == 0) {
            part = new String[column_headers2.length];
        } else
            part = new String[ar[0].length];
        part[0] = name;
        part[1] = num1;
        part[2] = num2;
        part[3] = num3;
        part[4] = num4;
        for (int i = 0; i < ar.length; i++) {
            temp[i] = ar[i];
        }
        temp[ar.length] = part;
        // returning of add2ress of new array
        team_statistics2 = temp;
    }

    // search header category with key name in string format and if not found returs
    // -1
    public static int search_header2(String ar[], String key) {

        for (int i = 0; i < ar.length; i++) {
            if (key.equals(ar[i])) {
                return i;
            }
        }
        return -1;
    }

    // just write add2 with following specifictaions without creating an object of
    // the same
    public static void add2(String[][] ar, String name, String num1, String num2, String num3, String num4) {
        for (int i = 0; i < 1; i++) {
            League2 lea2 = new League2();
            addRow2(team_statistics2, name, num1, num2, num3, num4);
            lea2.dispose();
        }
        League2 lea2 = new League2();
    }

    // gives the index of row when you provide the col index of the same
    public static int search_row2(String[][] ar, String s, int col) {
        if (col == -1) {
            return -1;
        }
        for (int i = 0; i < ar.length; i++) {
            if (ar[i][col].equals(s)) {
                return i;
            }
        }
        return -1;
    }

}

// Sort3ing class containing mergeSort3
class Sort3 {
    public static void merge3(int arr[], int l, int m, int r, int d[]) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
        int AL[] = new int[n1];
        int AR[] = new int[n2];

        for (i = 0; i < n1; i++) {
            L[i] = arr[l + i];
            AL[i] = d[l + i];
        }
        for (j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
            AR[j] = d[m + 1 + j];
        }
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                d[k] = AL[i];
                i++;
            } else {
                arr[k] = R[j];
                d[k] = AR[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            d[k] = AL[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            d[k] = AR[j];
            j++;
            k++;
        }
    }

    public static void mergeSort3(int arr[], int l, int r, int d[]) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort3(arr, l, m, d);
            mergeSort3(arr, m + 1, r, d);
            merge3(arr, l, m, r, d);
        }
    }

    public Sort3(int arr[], int l, int r, int d[]) {
        mergeSort3(arr, l, r, d);
    }
}

/**
 * next contains the class of the table name of class is just random nothing
 * special!
 */
class League3 extends JFrame {
    Scanner sc = new Scanner(System.in);
    // reference where u can assign memory containing gui.
    JTable jt;
    // array containing name of column headers and categories
    static String[] column_headers3 = { "Value", "Size" };
    // array containing elements corresponding to the categories of the column at
    // respective indices
    static String[][] team_statistics3 = { { " ", " " } };

    public League3() {
        // team_statistics3 = this.team_statistics3;
        // loop to add3 t number of rows
        // index 0:- value
        // index 1:- size of word

        // assigned reference to memory of gui.
        jt = new JTable(team_statistics3, column_headers3);
        // size of gui(int x,int y,int width,int height)
        jt.setBounds(250, 250, 400, 430);
        // setting view window of the gui.
        JScrollPane js = new JScrollPane(jt);
        this.add(js);
        this.setSize(300, 400);
        this.setVisible(true);
        // Sort3ing functionaccording the offsetadd3ress of rows
        // SortRow3(team_statistics3);
    }

    // function Sort3ing of rows
    public static void SortRow3(String[][] ar) {
        int n = ar.length;
        if (n == 1 && ar[0][1].equals(" ")) {
            return;
        } else {
            int[] arr = new int[n];
            String[][] g = new String[n][];
            int[] ind = new int[n];
            for (int i = 0; i < n; i++) {
                if (ar[i][1] != " ")
                    arr[i] = Integer.parseInt(ar[i][0]);
                g[i] = ar[i];
                ind[i] = i;
            }
            Sort3 s = new Sort3(arr, 0, n - 1, ind);
            Sort3.mergeSort3(arr, 0, n - 1, ind);
            for (int i = 0; i < n; i++) {
                ar[i] = g[ind[i]];
            }
        }
    }

    // add3ition of rows function
    public static void addRow3(String[][] ar, String name, String num1) {
        // temp Array for enlarging the size of array
        String temp[][] = new String[ar.length + 1][];
        // row to be add3ed
        String part[];
        if (ar[0].length == 0)
            part = new String[column_headers3.length];
        else
            part = new String[ar[0].length];
        part[0] = name;
        part[1] = num1;
        for (int i = 0; i < ar.length; i++) {
            temp[i] = ar[i];
        }
        temp[ar.length] = part;
        // reassigning of add3ress of new array
        team_statistics3 = temp;
    }

    // search header category with key name in string format and if not found
    // returns -1
    public static int search_header3(String ar[], String key) {

        for (int i = 0; i < ar.length; i++) {
            if (key.equals(ar[i])) {
                return i;
            }
        }
        return -1;
    }

    // write add3 without writing object of gui as per specifications
    public static void add3(String[][] ar, String name, String num1) {
        for (int i = 0; i < 1; i++) {
            League3 lea3 = new League3();
            addRow3(team_statistics3, name, num1);
            lea3.dispose();
        }
        League3 lea3 = new League3();
    }

    // gives index of row when you give the col index
    public static int search_row3(String[][] ar, String s, int col) {
        if (col == -1) {
            return -1;
        }
        for (int i = 0; i < ar.length; i++) {
            if (ar[i][col].equals(s)) {
                return i;
            }
        }
        return -1;
    }

}

class Sorts {
    public static void merge4(int arr[], int l, int m, int r, int d[]) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
        int AL[] = new int[n1];
        int AR[] = new int[n2];

        for (i = 0; i < n1; i++) {
            L[i] = arr[l + i];
            AL[i] = d[l + i];
        }
        for (j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
            AR[j] = d[m + 1 + j];
        }
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                d[k] = AL[i];
                i++;
            } else {
                arr[k] = R[j];
                d[k] = AR[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            d[k] = AL[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            d[k] = AR[j];
            j++;
            k++;
        }
    }

    public static void mergeSort4(int arr[], int l, int r, int d[]) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort4(arr, l, m, d);
            mergeSort4(arr, m + 1, r, d);
            merge4(arr, l, m, r, d);
        }
    }

    public Sorts(int arr[], int l, int r, int d[]) {
        mergeSort4(arr, l, r, d);
    }
}

class League4 extends JFrame {
    Scanner sc = new Scanner(System.in);
    JTable jt;
    static String[] column_headers4 = { "Error Statement", "Type Of Error", "Offset Address" };
    // static String[][] team_statistics4=
    // {{"Heys","Error1","95"},{"His","Error2","113"},{"hues! hi nahi bol sakta
    // sidha","Error3","123"}};
    static String[][] team_statistics4 = { { " ", " ", " " } };

    public League4() {

        // team_statistics4=this.team_statistics4;
        jt = new JTable(team_statistics4, column_headers4);
        jt.setBounds(250, 250, 400, 430);
        JScrollPane js = new JScrollPane(jt);
        this.add(js);
        this.setSize(300, 400);
        this.setVisible(true);
        // sortRow4(team_statistics4);
    }

    public static void sortRow4(String[][] ar) {
        int n = ar.length;
        if (n == 1 && ar[0][2].equals(" ")) {
            return;
        } else {
            int[] arr = new int[n];
            String[][] g = new String[n][];
            int[] ind = new int[n];
            for (int i = 0; i < n; i++) {
                if (ar[i][2] != " ")
                    arr[i] = Integer.parseInt(ar[i][2]);
                g[i] = ar[i];
                ind[i] = i;
            }
            Sorts s = new Sorts(arr, 0, n - 1, ind);
            Sorts.mergeSort4(arr, 0, n - 1, ind);
            for (int i = 0; i < n; i++) {
                ar[i] = g[ind[i]];
            }
        }
    }

    public static void addRow4(String[][] ar, String name, String num1, String num2) {
        String temp[][] = new String[ar.length + 1][];
        String part[];
        if (ar[0].length == 0)
            part = new String[column_headers4.length];
        else
            part = new String[ar[0].length];
        part[0] = name;
        part[1] = num1;
        part[2] = num2;
        for (int i = 0; i < ar.length; i++) {
            temp[i] = ar[i];
        }
        temp[ar.length] = part;
        team_statistics4 = temp;
    }

    public static int search_header4(String ar[], String key) {

        for (int i = 0; i < ar.length; i++) {
            if (key.equals(ar[i])) {
                return i;
            }
        }
        return -1;
    }

    public static void add4(String[][] ar, String name, String num1, String num2) {
        for (int i = 0; i < 1; i++) {
            League4 lea4 = new League4();
            addRow4(team_statistics4, name, num1, num2);
            lea4.dispose();
        }
        League4 lea4 = new League4();

    }

    public static int search_row4(String[][] ar, String s, int col) {
        if (col == -1) {
            return -1;
        }
        for (int i = 0; i < ar.length; i++) {
            if (ar[i][col].equals(s)) {
                return i;
            }
        }
        return -1;
    }

}

public class Assembler {

   
    League symbol_table = new League();
    League2 opcode_table = new League2();
    League3 literal_table = new League3();
    League4 Error_table = new League4();

    private static Scanner in = new Scanner(System.in);

    private static String read_next_line(BufferedReader input) throws IOException { // CHECKED
        /*
         * Reads a line delimited by \n; returns the not comment part if the line
         * consists of instructions followed by comment if the line consists entirely of
         * comment then it returns the comment COMMENTs will be everything after ';'
         * output will always be trimmed of trailing whitespaces
         */
        String line="";
        do {
            try {
                line = input.readLine().trim();
                if(line==null){
                    System.out.println("File Ended...\n*PRESS ENTER*");
                    in.nextLine();
                    input.close();
                    System.exit(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("\n*PRESS ENTER*");
                in.nextLine();
                input.close();
                System.exit(0);
            }

        } while (line.length() == 0);
        int i = line.indexOf(';');
        if (i > 0)
            line = line.substring(0, i).trim();
        return line;

        // In first pass function check for comments
    }

    private static boolean line_is_not_comment(String line) { // CHECKED
        /*
         * arguements:(String)line : line to check to be comment return type:true:if
         * line is NOT a comment else false
         */
        line = line.trim();
        if (line.indexOf(";") == 0)
            return false;
        else
            return true;
    }

    private static String check_for_label(String line, int lc) { // CHECKED
        /*
         * Assumption: labels are defined such that a label name is followed by a ':'
         * arguements:(String)line : line to check the label in return type: label name
         * if label is present(String) else returns 'null'; output will always be
         * trimmed String line is the main line of instruction received
         */
        line = line.trim();
        int i = line.indexOf(':');
        if (i == -1)
            return null;
        else {
            String p = line.substring(0, i).trim();
            if (p.equals("")) {
                // Store the error in the error table that the ':' is used but still no label
                // name is provided
                League4.add4(League4.team_statistics4, "':' symbol is used but still no label name is provided",
                        "LabelNotSuppliedError", Integer.toString(lc).trim());
                return null;
            } else {
                return p;
            }
        }

    }

    private static String[] extract_opcode(String line) { // NOT CHECKED: TABLE FILLING
        /*
         * arguement:(String)line:line to extract opcode from input string should be the
         * main line of instruction return type: String array consisting of 3 elements
         * if the String consists of a valid opcode 1st element:opcode 2nd element:type
         * of the opcode 3rd element:remaining trimmed string after the opcode and the
         * 4th element: the no. of operands for the type
         * 
         */
        int i = line.indexOf(':') + 1;
        String str1 = line.substring(i).trim();
        int i1 = str1.indexOf(' ');
        String opcode;
        String remain;
        if (i1 == -1) {
            opcode = str1;
            remain = "";
        } else {
            opcode = str1.substring(0, i1).trim();
            remain = str1.substring(i1).trim();
        }
        if (opcode != "") {

            int f = League2.search_row2(League2.team_statistics2, opcode,
                    League2.search_header2(League2.column_headers2, "Opcode"));
            if (f >= 0) {
                String[] s = new String[4];
                s[0] = opcode;
                s[1] = League2.team_statistics2[f][1].trim();
                s[2] = remain.trim();
                s[3] = League2.team_statistics2[f][2].trim();
                return s;
            } else {
                return null;
            }
        } else
            return null;

    }

    private static int no_of_operands(String str1) { // CHECKED
        /*
         * The given function checks for the number of operands in the given REMAINING
         * string Arguements:str1(String):REMAINING STRING return type:no. of
         * operands(int) ASSUMPTIONS: 1. The operand names cannot have spaces in them 2.
         * Multiple operands will be separated by ',' or ' '(space)
         */
        str1 = str1.trim();
        int c = 0;
        int i;
        do {
            int len = str1.length();
            int i1 = str1.indexOf(' ');
            int i2 = str1.indexOf(',');
            if (i1 == -1) {
                if (i2 != -1) {
                    i = i2;
                } else {
                    i = len;
                }
            } else {
                if (i2 != -1) {
                    i = (i1 < i2) ? i1 : i2;
                } else {
                    i = i1;
                }
            }
            if (i != 0) {
                String a = str1.substring(0, i);
                if (a != "")
                    ++c;
            }
            if (i < (len - 1))
                str1 = str1.substring(i + 1).trim();
            else
                break;
        } while (true);

        return c;
    }

    private static String LiteralOp(String operand, int lc) { // CHECKED
        // ASSUMPTION: in the operands a literal will be given in the form '=1(literal)'
        // form; while defining literal will be given in 1(JUST A SINGLE NO.) form
        /*
         * function checks for the provided operand(String) to be literal(in the given
         * format) if it is:return literal(String) else:if any format error occurs then
         * the given function will return a null and store an error in the error table
         * WARNING:In the given format'=(literal)' the literal must be an integer else
         * the program will terminate if it is written "=" then the function will return
         * null
         */
        operand = operand.trim();
        int i = operand.indexOf('=');
        if (i >= 1) {
            if (operand.charAt(i - 1) == '\'') {
                int i1 = operand.indexOf('\'', i + 1);
                if (i1 == operand.length() - 1) {
                    String literal = operand.substring(i + 1, i1).trim();
                    if (literal.equals(""))
                        return null;

                    else
                        return literal;
                } else {
                    /*
                     * store the error in the error table and move forward(WRONG FORMAT)
                     * 
                     */

                    League4.add4(League4.team_statistics4,
                            "The literal is not provided in the correct format:eg:'=1(literal)'         \\' character is not at the end of literal",
                            "WrongFormatError", Integer.toString(lc).trim());

                    return null;
                }

            } else {
                /*
                 * store the error in the error table and move forward(WRONG FORMAT: BEFORE =
                 * SOMETHING ELSE IS PRESENT)
                 * 
                 */
                League4.add4(League4.team_statistics4,
                        "The literal is not provided in the correct format:eg:'=1(literal)',there is an '=' sign but no preceding \\'",
                        "WrongFormatError", Integer.toString(lc).trim());

                return null;
            }
        } else {
            if (i == 0) {
                /*
                 * store the error in the error table and move forward(the input string is in
                 * format =1(something);NO QUOTATIONS!)
                 * 
                 */

                League4.add4(League4.team_statistics4,
                        "The literal is not provided in the correct format:eg:'=1(literal)',there is an '=' sign but no preceding \\'",
                        "WrongFormatError", Integer.toString(lc).trim());
                return null;
            } else {
                if (operand.charAt(0) == '\'' || operand.charAt(operand.length() - 1) == '\'') {
                    // store the error of wrong format in the error table

                    League4.add4(League4.team_statistics4,
                            "The literal is not provided in the correct format:eg:'=1(literal)',there are \\' characters but not '=' is used",
                            "WrongFormatError", Integer.toString(lc).trim());
                }
                return null;
            }
        }
    }

    private static boolean RangeCheck(int literal) { // CHECKED
        /*
         * check whether the passed integer literal lies in the given range of N=7
         * bits(considering 2s complement for -ve values) returns: true(if it lies) else
         * returns: false
         */
        final int lowl = 0;
        final int highl = 127;
        if (literal >= lowl && literal <= highl) {
            return true;

        } else {
            return false;
        }
    }

    private static boolean Range(int location, boolean isdw) {
        /*
         * location(int) is the location_counter's current value isdw(boolean)is true if
         * the range to be checked has to be changed from the default value returns true
         * if the location is OUT OF RANGE else returns false
         */
        int lowl, highl;
        if (isdw) {
            lowl = 111;
            highl = 127;
        } else {
            lowl = 0;
            highl = 110;
        }
        if (location >= lowl && location <= highl)
            return false;
        else
            return true;

    }

    private static boolean RangeDC(int val) {
        /*
         * Function returns false if the entered value is not within the range eles
         * returns true
         */
        int lowl = 0;
        int highl = 127;
        if (val >= lowl && val <= highl)
            return false;
        else
            return true;
    }

    private static void pass_one() throws Exception {
    	File fi = new File("INPUT.txt");
    	try {
    	BufferedReader input = new BufferedReader(new FileReader(fi));

        File file = new File("TEMP.txt");
        FileWriter out = new FileWriter(file, false);

        boolean more_input = true;
        String line, label, symbol, opcode;
        int location_counter, length, value, type;
        final int END_STATEMENT = 12;
        location_counter = 0;

        while (more_input) {
            // System.out.println("next");
            if (Range(location_counter, false)) {
                System.out.println(
                        "FatalError: The program's length is greater than the allowable range of 111 words(0 to 110)\nTerminating Program...\n*Press ENTER*");
                in.nextLine();
                out.close();
                input.close();
                System.exit(0);
            }
            line = read_next_line(input);

            type = 0;
            if (line_is_not_comment(line)) {
                label = check_for_label(line, location_counter);
                if (label != null) {
                    int f = League.search_row1(League.team_statistics1, label.trim(),
                            League.search_header1(League.column_headers1, "Symbol"));

                    if (f >= 0) {
                        // store error in the error table (LABEL REDEFINITION ERROR)
                        if (League.team_statistics1[f][2].equals("")) {
                            League.team_statistics1[f][1] = "Label";
                            League.team_statistics1[f][2] = Integer.toString(location_counter);
                            League.team_statistics1[f][4] = "";
                        } else
                            League4.add4(League4.team_statistics4,
                                    "Label ''" + label + "'' is being redefined at places: "
                                            + League.team_statistics1[f][2].trim() + " and "
                                            + Integer.toString(location_counter),
                                    "RedefinitionError", Integer.toString(location_counter).trim());

                    } else {
                        League.add1(League.team_statistics1, label.trim(), "Label", Integer.toString(location_counter),
                                "", "");
                    }
                }

                String[] s = extract_opcode(line);

                if (s != null) {
                    opcode = s[0];
                    type = Integer.parseInt(s[1]);
                    String str1 = s[2];
                    int y = Integer.parseInt(s[3]);
                    out.write(
                            Integer.toString(location_counter).trim() + ";" + opcode.trim() + ";" + s[1].trim() + ";");
                    // int
                    // numop=Integer.parseInt(League2.team_statistics2[League2.search_row2(League2.team_statistics2,s[1].trim(),League2.search_header2(League2.column_headers2,"Type"))][2]);
                    // int given_no=no_of_operands(str1);
                    // System.out.println(numop+ " "+given_no);
                    str1 = str1.trim();
                    int x = (str1.length() == 0) ? 0 : 1;
                    if (x != y) {
                        League4.add4(League4.team_statistics4,
                                "The number of operands required and the number of operands supplied for the opcode "
                                        + opcode.trim() + " do not match",
                                "OperandMismatchError", Integer.toString(location_counter).trim());
                    }
                    while (true) {
                        str1 = str1.trim();

                        int i1 = str1.indexOf(' ');
                        int i2 = str1.indexOf(',');
                        int i;
                        if (i1 == -1) {
                            if (i2 != -1) {
                                i = i2;
                            } else {
                                i = str1.length();
                            }
                        } else {
                            if (i2 != -1) {
                                i = (i1 < i2) ? i1 : i2;
                            } else {
                                i = i1;
                            }
                        }

                        String operand = str1.substring(0, i);
                        if (operand.equals(""))
                            break;
                        String literal = LiteralOp(operand, location_counter);

                        if (literal != null) {
                            int lit = Integer.parseInt(literal);
                            if (RangeCheck(lit)) {
                                League3.add3(League3.team_statistics3, Integer.toString(lit).trim(), "7 bits");
                                out.write("l@" + literal.trim() + ";");
                            } else {
                                System.out.println("FatalError: The literal '" + lit
                                        + "' lies outside the allowable value range\nTerminating Program...\n*Press ENTER*");
                                in.nextLine();
                                out.close();
                                input.close();
                                System.exit(0);
                            }

                        } else {
                            int f1 = League.search_row1(League.team_statistics1, operand.trim(),
                                    League.search_header1(League.column_headers1, "Symbol"));
                            // System.out.println("found status="+f1);
                            if (f1 < 0) {

                                League.add1(League.team_statistics1, operand.trim(), "Variable", "", "", "7 bits");
                            }
                            out.write("s@" + operand.trim() + ";");

                        }

                        if (i == str1.length())
                            break;
                        else if (i == (str1.length() - 1)) {
                            // store the error in the table
                            League4.add4(League4.team_statistics4,
                                    "Unnecessary trailing commas have been provided in the operand/literal specification",
                                    "InputFormatError", Integer.toString(location_counter).trim());
                            break; // operands will be separated by ',' and ' ';if there is no operand supplied
                                   // after last ',' or before first ',' then the remaining operands will be
                                   // ignored and the error will stored
                        } else if (i == 0) {
                            // store the error in the table
                            League4.add4(League4.team_statistics4,
                                    "Unnecessary trailing commas have been provided in the operand/literal specification",
                                    "InputFormatError", Integer.toString(location_counter).trim());

                            break;
                        } else {
                            str1 = str1.substring(i + 1);
                        }

                    }

                    out.write(line + "\n");
                }

                else {
                    // variables are reached
                    // use line for all other functions
                    // System.out.println("success");
                    type = 13;
                    line = line.trim();
                    int i = line.indexOf(' ');
                    String literaln = line.substring(0, i).trim();
                    String temp;
                    boolean f = false;
                    // search in the symbol table
                    int f2 = League.search_row1(League.team_statistics1, literaln,
                            League.search_header1(League.column_headers1, "Symbol"));
                    if (f2 < 0) {
                        // issue a warning that the symbol is not being used
                        System.out.println("The provided symbol '" + literaln + "' is not being used anywhere");
                        f = true;
                    }
                    temp = line.substring(i + 1).trim();
                    int i1 = temp.indexOf(' ');
                    String t = temp.substring(0, i1);
                    temp = temp.substring(i1 + 1).trim();

                    if (t.equals("DC")) {
                        // System.out.println("DC block");
                        int i2 = temp.indexOf(' ');
                        String val;
                        if (i2 == -1) {
                            val = temp.trim();
                        } else {
                            val = temp.substring(0, i2);
                        }
                        if (RangeDC(Integer.parseInt(val))) {
                            System.out.println("FatalError: The value of VariableDC '" + literaln + "' = " + val
                                    + " at index: " + location_counter
                                    + ", is not in the allowable range of 0 to 127\nTerminating Program...\n*Press ENTER*");
                            in.nextLine();
                            out.close();
                            input.close();
                            System.exit(0);
                        }
                        if (!f) {
                            League.team_statistics1[f2][3] = val.trim(); // value is defined just as a single number
                                                                         // during the definition part
                            League.team_statistics1[f2][1] = "VariableDC";
                        } else {
                            League.add1(League.team_statistics1, literaln.trim(), "VariableDC", "", val.trim(),
                                    "7 bits");

                        }

                    } else {
                        // System.out.println("DW block");

                        // for DW fill the offset part only
                        // ASSOCIATED ADDRESS FOR A VARIABLE IS GIVEN AS A PLANE NUMBER(for variables
                        // location counter's value is not stored rather the associated address is
                        // stored)
                        int i2 = temp.indexOf(' ');
                        String val;
                        if (i2 == -1) {
                            val = temp.trim();
                        } else {
                            val = temp.substring(0, i2);
                        }
                        if (Range(Integer.parseInt(val), true)) {
                            System.out.println("FatalError: The associated address of VariableDW '" + literaln + "' = "
                                    + val + " at index: " + location_counter
                                    + ", is not in the allowable range of 111 to 127\nTerminating Program...\n*Press ENTER*");
                            in.nextLine();
                            out.close();
                            input.close();
                            System.exit(0);
                        }
                        if (!f) {
                            League.team_statistics1[f2][2] = val.trim(); // value is defined just as a single number
                                                                         // during the definition part
                            League.team_statistics1[f2][1] = "VariableDW";
                        } else {
                            League.add1(League.team_statistics1, literaln.trim(), "VariableDW", val.trim(), "",
                                    "7 bits");

                        }
                    }

                }

                // store all other Statements in line if(is not a comment) block

                // Store in an easy to format manner
                // IMPORTANT STORE THE LITERALS AND CONSTANTS AS WELL

                // System.out.println("Inc..");
                location_counter = location_counter + 1;
                if (type == END_STATEMENT) {
                    // System.out.println("Stop block");
                    more_input = false;

                    // check whether there is anything in the error table
                    int lth = League4.team_statistics4.length;
                    // System.out.println("lth="+lth);
                    if (lth >= 2) {
                        // output all of them
                        // terminate the program
                        for (int i = 1; i < lth; ++i) {
                            System.out.println(League4.team_statistics4[i][1] + ": " + League4.team_statistics4[i][0]
                                    + "\tindex: " + League4.team_statistics4[i][2]);
                        }
                        System.out.println("\n*Press ENTER*");
                        in.nextLine();
                        out.close();
                        input.close();
                        System.exit(0);

                    } else {
                        int si = 0;
                        boolean found = false;
                        int col = League.search_header1(League.column_headers1, "Offset Address");
                        int l;
                        do {
                            l = League.search_row1(League.team_statistics1, "", col, si);
                            if (l >= 0) {
                                if (!(League.team_statistics1[l][1].equals("VariableDC"))) {
                                    found = true;

                                    System.out.println("Symbol's bit address not found: SymbolName:"
                                            + League.team_statistics1[l][0].trim() + ", SymbolSize:"
                                            + League.team_statistics1[l][4].trim());
                                }
                                if (l < League.team_statistics1.length - 1)
                                    si = l + 1;
                                else
                                    l = -1;
                            }
                        } while (l != -1);
                        if (found) {
                            // System.out.println("1st block");
                            System.out.println("\n*Press ENTER*");
                            in.nextLine();
                            out.close();
                            input.close();
                            System.exit(0);
                        }

                    }

                }

            }

        }
        out.close();
    }
    catch(Exception exc){
    	exc.printStackTrace();
    	System.out.println("\n*PRESS ENTER*");
    	in.hasNextLine();
    	System.exit(0);
    }
    }

    // IN CASE THE ADDRESS IS WRITTEN IN THE OPERAND PART WITHOUT USING PNEUMONICS
    // THEN IT MUST BE WRITTEN IN THE FORM OF A LITERAL
    // ALWAYS THE OPERAND WILL BE EITHER AN ADDRESS OR A PNEUMONIC
    // EVERY ADDRESS MUST BE PROVIDED IN DECIMAL FORM

    private static String binary_converter(int operand, int h) {
        /*
         * Given function converts the given no. into a binary string having h bits
         * Arguements:operand(int):the no. to be converted,h(int) the number of bits to
         * convert into return: if more than h bits are required to represent the given
         * no. then null is returned else corresponding f bit String is returned
         */
        String result = "";

        while (operand != 0) {
            int rem = operand % 2;
            operand /= 2;
            result = Integer.toString(rem) + result;

        }

        int len = result.length();
        if ((h - len) < 0)
            return null;
        else {
            for (int i = 0; i < (h - len); ++i)
                result = "0" + result;

            return result;
        }
    }

    private static int typeMeeting(String opcode, String operandt) {
        /*
         * The given function checks whether the symbol's type passed as
         * operandt(String) is similar to the type required for the opcode and also
         * whether the opcode is valid or not if it is:return 1 else if it is not:
         * return 0 else if opcode is not valid: return -1
         **/
        opcode = opcode.trim();
        int f = League2.search_row2(League2.team_statistics2, opcode, 0);
        if (f == -1)
            return -1;
        else {
            String reqt;
            if (opcode.equals("BRZ") || opcode.equals("BRN") || opcode.equals("BRP")) {
                reqt = "Label";
            } else {
                reqt = "VariableDW";
            }
            if (reqt.equals(operandt.trim()))
                return 1;
            else
                return 0;
        }
    }

    private static void pass_two() throws Exception {
        File file = new File("TEMP.txt");
        File file2 = new File("FINAL.txt");
        FileWriter out = new FileWriter(file2, false);

        final int END_STATEMENT = 12;
        final int MAX_CODE = 12;
        String ByteCode;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String temp_line;

            while ((temp_line = br.readLine()) != null) {

                if (temp_line.length() == 0)
                    continue;

                String addressing_mode_bits = "";
                String opcode_bits = "";
                String operand_bits = "";

                int i = temp_line.indexOf(';');
                String location_counter = temp_line.substring(0, i).trim();
                temp_line = temp_line.substring(i + 1).trim();

                i = temp_line.indexOf(';');
                String opcode = temp_line.substring(0, i).trim();
                temp_line = temp_line.substring(i + 1).trim();

                i = temp_line.indexOf(';');
                int type = Integer.parseInt(temp_line.substring(0, i).trim());
                opcode_bits = binary_converter(type, 4).trim();
                temp_line = temp_line.substring(i + 1).trim();
                boolean fo = false;
                do {
                    i = temp_line.indexOf('@');
                    if (i > 0) {
                        fo = true;
                        char mode = temp_line.charAt(i - 1);
                        if (mode == 'l') {
                            int i1 = temp_line.indexOf(';');
                            int operand = Integer.parseInt(temp_line.substring(i + 1, i1).trim());
                            operand_bits = binary_converter(operand, 7).trim();
                            if (operand_bits == null) {
                                System.out
                                        .println("FatalError: More than 7 bits are required to represent the literal: '"
                                                + operand + "' at index: " + location_counter
                                                + "\nTerminating program...\n*Press ENTER*");
                                in.nextLine();
                                br.close();
                                out.close();
                                
                                System.exit(0);

                            }
                            addressing_mode_bits = "0";
                            temp_line = temp_line.substring(i1 + 1).trim();
                        } else if (mode == 's') {
                            int i1 = temp_line.indexOf(';');
                            String operand = temp_line.substring(i + 1, i1).trim();
                            int f = League.search_row1(League.team_statistics1, operand,
                                    League.search_header1(League.column_headers1, "Symbol"));
                            temp_line = temp_line.substring(i1 + 1).trim();
                            if (f >= 0) {
                                int ad;
                                if (League.team_statistics1[f][1].equals("VariableDC"))
                                    ad = Integer.parseInt(League.team_statistics1[f][3]);
                                else {
                                    String t = League.team_statistics1[f][1].trim();
                                    int r = typeMeeting(opcode, t);
                                    if (f == -1) {
                                        System.out.println("FatalError: The given opcode: '" + opcode + "' at index: "
                                                + location_counter
                                                + " is not valid\nTerminating program...\n*Press ENTER*");
                                        in.nextLine();
                                        br.close();
                                        out.close();
                                       
                                        System.exit(0);
                                    } else if (r == 0) {
                                        System.out.println("FatalError: The given opcode: '" + opcode + "' at index: "
                                                + location_counter + " is supplied with a " + t
                                                + " whereas it requires a "
                                                + (t.equals("Label") ? "VariableDW" : "Label")
                                                + "\nTerminating program...\n*Press ENTER*");
                                        in.nextLine();
                                        br.close();
                                        out.close();
                                        
                                        System.exit(0);
                                    }
                                    ad = Integer.parseInt(League.team_statistics1[f][2]);
                                    // BOOKMARK
                                }

                                operand_bits = binary_converter(ad, 7).trim();
                                if (operand_bits == null) {
                                    System.out.println(
                                            "FatalError: More than 7 bits are required to represent the symbol: '"
                                                    + operand + "' at index: " + location_counter
                                                    + "\nTerminating program...\n*Press ENTER*");
                                    in.nextLine();
                                    br.close();
                                    out.close();
                                    
                                    System.exit(0);

                                }
                                addressing_mode_bits = "0";

                            } else {
                                System.out.println("FatalError: Symbol: '" + operand + "' at index: " + location_counter
                                        + " in the temporary file is not found in the Symbol Table\nTerminating program...\n*Press ENTER*");
                                in.nextLine();
                                br.close();
                                out.close();
                                
                                System.exit(0);

                            }
                        }
                    }
                } while (i != -1);
                if (!fo) {
                    addressing_mode_bits = "0";
                    operand_bits = "0000000";
                }
                String line = temp_line;

                ByteCode = addressing_mode_bits.trim() + " " + opcode_bits.trim() + " " + operand_bits.trim();
                out.write(ByteCode + "\n");
                // write_listing(code,line);
                // finishup2()

            }
            out.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {

        System.out.println("Initiating 1st pass...");
        pass_one();
        System.out.println("1st pass successfull...");

        System.out.println("Initiating 2nd pass...");
        pass_two();
        System.out.println("2nd pass successfull...");
        League.add1(League.team_statistics1, "", "", "", "", "");
        League2.add2(League2.team_statistics2, "", "", "", "", "");
        League3.add3(League3.team_statistics3, "", "");
        League4.add4(League4.team_statistics4, "", "", "");
        System.out.println("PRESS *ENTER* TO EXIT...");
        
        in.nextLine();
        System.exit(0);
    }
}
