package memorysimtests;

import memorysim.LRUPageReplace;
import memorysim.ReferenceString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LRUPageReplaceTest {
    LRUPageReplace lruPageReplace;
    List<Boolean> pageFaults;
    List<String> victimFrames;
    @Before
    public void setUp() throws Exception {
        ReferenceString referenceString = new ReferenceString(
                "1", "7", "5", "4", "0",
                "1", "4", "7", "3", "6",
                "5", "0", "4", "7", "3",
                "2", "1");

        lruPageReplace = new LRUPageReplace(referenceString);

        pageFaults = Arrays.asList(true, true, true, true, true, true, false,
                true, true, true, true, true, true, true, true, true, true);
        victimFrames = Arrays.asList(" ", " ", " ", " ", "1", "7", " ", "5",
                "4", "0", "1", "7", "3", "6", "5", "0", "4");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void lruPageReplaceTest() {
        lruPageReplace.execute();
        assertEquals(pageFaults, lruPageReplace.getPageFaults());
        assertEquals(victimFrames, lruPageReplace.getVictimFrames());
    }
}