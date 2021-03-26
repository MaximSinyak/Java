import org.junit.Assert;
import org.junit.Test;

public class TestArray {
    @Test
    public void test1arrayAfter4() {
        int[] in = new int[]{1, 3, 4, 5, 5, 6, 8};
        int[] out = new int[]{5, 5, 6, 8};
        Assert.assertArrayEquals(out, Main.arrayAfter4(in));
    }

    @Test(expected = RuntimeException.class)
    public void test2arrayAfter4() {
        int [] in = new int[]{1, 3, 5, 5, 6, 8};
        Main.arrayAfter4(in);
    }

    @Test
    public void test1arrayContainsOnly1and4(){
        int[] in = new int[]{1, 3, 4, 5};
        Assert.assertFalse(Main.arrayContainsOnly1and4(in));
    }

    @Test
    public void test2arrayContainsOnly1and4(){
        int[] in = new  int[]{1, 4, 1};
        Assert.assertTrue(Main.arrayContainsOnly1and4(in));
    }

    @Test
    public  void testAdd(){
        Assert.assertEquals(5, Main.add(2,3));
    }

}
