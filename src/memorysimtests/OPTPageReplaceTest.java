package memorysimtests;

import memorysim.MemoryReference;
import memorysim.OPTPageReplace;
import memorysim.ReferenceString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OPTPageReplaceTest {
    OPTPageReplace optPageReplace;
    List<Boolean> pageFaults;
    List<String> victimFrames;
    @Before
    public void setUp() throws Exception {
        ReferenceString referenceString = new ReferenceString(
                "1", "7", "5", "4", "0",
                "1", "4", "7", "3", "6",
                "5", "0", "4", "7", "3",
                "2", "1");

        optPageReplace = new OPTPageReplace(referenceString);

        pageFaults = Arrays.asList(true, true, true, true, true, false, false,
                false, true, true, true, false, false, false, true, true, true);
        victimFrames = Arrays.asList(" ", " ", " ", " ", "5", " ", " ",
                " ", "1", "3", "6", " ", " ", " ", "5", "3", "2");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void OPTPageReplaceTest() {
        optPageReplace.execute();
        assertEquals(pageFaults, optPageReplace.getPageFaults());
        assertEquals(victimFrames, optPageReplace.getVictimFrames());
    }

    @Test
    public void getVictimFrameTest() {
        List<MemoryReference> physicalFrameList = Arrays.asList(
                new MemoryReference("1"),
                new MemoryReference("7"),
                new MemoryReference("5"),
                new MemoryReference("4")
        );
        optPageReplace.setFrames(physicalFrameList);
        int startIndex = 4;
        assertEquals(physicalFrameList.get(2), optPageReplace.getVictimFrame(startIndex));

        physicalFrameList = Arrays.asList(
                new MemoryReference("1"),
                new MemoryReference("7"),
                new MemoryReference("0"),
                new MemoryReference("4"));
        optPageReplace.setFrames(physicalFrameList);
        startIndex = 7;
        assertEquals(physicalFrameList.get(0), optPageReplace.getVictimFrame(startIndex));

        physicalFrameList = Arrays.asList(
                new MemoryReference("5"),
                new MemoryReference("7"),
                new MemoryReference("0"),
                new MemoryReference("4"));
        optPageReplace.setFrames(physicalFrameList);
        startIndex = 14;
        assertEquals(physicalFrameList.get(0), optPageReplace.getVictimFrame(startIndex));

        physicalFrameList = Arrays.asList(
                new MemoryReference("6"),
                new MemoryReference("7"),
                new MemoryReference("0"),
                new MemoryReference("4"));

        optPageReplace.setFrames(physicalFrameList);
        startIndex = 10;
        assertEquals(physicalFrameList.get(0), optPageReplace.getVictimFrame(startIndex));
    }
}