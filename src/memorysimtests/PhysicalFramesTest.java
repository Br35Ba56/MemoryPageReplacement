package memorysimtests;

import memorysim.MemoryReference;
import memorysim.PhysicalFrame;
import memorysim.PhysicalFrames;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PhysicalFramesTest {

    PhysicalFrames physicalFrames;

    @Before
    public void setUp() throws Exception {
        List<PhysicalFrame> frameList = new ArrayList();
        frameList.add(new PhysicalFrame(new MemoryReference("1")));
        frameList.add(new PhysicalFrame(new MemoryReference("4")));
        frameList.add(new PhysicalFrame(new MemoryReference("2")));
        frameList.add(new PhysicalFrame(new MemoryReference("3")));
        physicalFrames = new PhysicalFrames(frameList);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testPhysicalFrameGet() throws Exception {
        assertEquals(new PhysicalFrame(
                new MemoryReference("1")),
                physicalFrames.getFrame(0));

        assertEquals(new PhysicalFrame(
                        new MemoryReference("4")),
                physicalFrames.getFrame(1));

        assertEquals(new PhysicalFrame(
                        new MemoryReference("2")),
                physicalFrames.getFrame(2));

        assertEquals(new PhysicalFrame(
                        new MemoryReference("3")),
                physicalFrames.getFrame(3));

        boolean exceptionThrown = false;
        try {
            physicalFrames.getFrame(4);
        } catch (Exception e) {
            exceptionThrown = true;
        }
        assert(exceptionThrown);
    }

    @Test
    public void testPhysicalFrameSet() throws Exception {
        physicalFrames.setFrame(0, new MemoryReference("3"));
        assertEquals(new PhysicalFrame(
                new MemoryReference("3")),
                physicalFrames.getFrame(0));
    }

}