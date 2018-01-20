import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayPartyTest {
    static ThreadParty t1;
    @Test
    public void fillingwithThreadTest() {
        int length = 100;
        long  []test =new long[length];
        for (int i=0; i<length; i++) {
            test[i]=0;
        }

        test = ArrayParty.fillingwithThread(length, test);

        int expected = length;
        int actual =0;
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actual = check(test);

        assertEquals("Запись в файл с многопоточностью прошла успешно", expected, actual);
    }

    public int check (long [] mas)
    {
        int tmp=0;
        for (int i=0; i<mas.length; i++)
        {
            if (0!=mas[i]) {
                tmp++;
            }
        }
        return tmp;
    }
}