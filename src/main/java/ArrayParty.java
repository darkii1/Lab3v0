public class ArrayParty {
    long[] data;
    int length;

     public static void main (String[] args)
     {
         long []data1 = {};
         data1 = fillingwithThread(99, data1);
     }
    public static long[] fillingwithThread(int size, long[] data) {
        data = new long[size];
        new ThreadParty(10, "First", data, 0, size);
        new ThreadParty(10, "Second", data, 1, size);
        new ThreadParty(10, "Third", data, 2, size);

        return data;
    }
}