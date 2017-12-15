package memorysimtests;

import org.junit.*;
import static org.junit.Assert.*;
import memorysim.FIFOPageReplace;
import memorysim.ReferenceString;
import java.util.Arrays;
import java.util.List;

public class FIFOPageReplaceTest {

    FIFOPageReplace fifoPageReplace;
    List<Boolean> pageFaults;
    List<String> victimFrames;

    @Before
    public void setUp() throws Exception {
        ReferenceString referenceString = new ReferenceString("1", "7", "5", "4", "0",
                "1", "4", "7", "3", "6",
                "5", "0", "4", "7", "3",
                "2", "1");



        fifoPageReplace = new FIFOPageReplace(referenceString);

        pageFaults = Arrays.asList(true, true, true, true, true, true, false,
                true, true, true, true, true, true, true, true, true, true);
        victimFrames = Arrays.asList(" ", " ", " ", " ", "1", "7", " ",
                "5", "4", "0", "1", "7", "3", "6", "5", "0", "4");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void fifoPageReplaceTest() {
        fifoPageReplace.execute();
        assertEquals(pageFaults, fifoPageReplace.getPageFaults());
        assertEquals(victimFrames, fifoPageReplace.getVictimFrames());
    }

}