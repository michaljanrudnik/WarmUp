public class TableSort {

    int[] sort(int[] table){
        int temp,check;
        do {
            check = 0;
            for (int i = 0; i < table.length - 1; i++) {
                if (table[i] > table[i + 1]) {
                    temp = table[i];
                    table[i] = table[i + 1];
                    table[i + 1] = temp;
                    check++;
                }
            }
        }
        while(check != 0);
        return table;
    }

    public static void main(String[] args) {
        int[] table = {2,4,1,9,5,7,6,12,16,37,23};
        TableSort ts = new TableSort();
        table = ts.sort(table);
        for (int i : table)
            System.out.println(i);

    }
}
