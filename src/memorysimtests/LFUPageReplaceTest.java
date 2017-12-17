package memorysimtests;

import memorysim.LFUPageReplace;
import memorysim.MemoryReference;
import memorysim.ReferenceString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LFUPageReplaceTest {
    List<Boolean> pageFaults;
    List<String> victimFrames;
    private LFUPageReplace lfuPageReplace;

    @Before
    public void setUp() throws Exception {

        ReferenceString referenceString = new ReferenceString("1", "7", "5", "4", "0",
                "1", "4", "7", "3", "6",
                "5", "0", "4", "7", "3",
                "2", "1");



        lfuPageReplace = new LFUPageReplace(referenceString);

        pageFaults = Arrays.asList(true, true, true, true, true, true, false,
                false, true, true, true, true, false, false, true, true, true);
        victimFrames = Arrays.asList(" ", " ", " ", " ", "1", "0", " ", " ", "5", "3", "6", "1",
                " ", " ", "0", "3", "2");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void lfuPageReplaceTest() {
        lfuPageReplace.execute();
        assertEquals(pageFaults, lfuPageReplace.getPageFaults());
        assertEquals(victimFrames, lfuPageReplace.getVictimFrames());
    }

}