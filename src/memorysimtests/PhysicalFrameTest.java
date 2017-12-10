package memorysimtests;

import memorysim.MemoryReference;
import memorysim.PhysicalFrame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhysicalFrameTest {
    PhysicalFrame physicalFrame;
    @Before
    public void setUp() throws Exception {
        physicalFrame = new PhysicalFrame(new MemoryReference("1"));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testPhysicalFrameGet() {
        assertEquals(new MemoryReference("1"), physicalFrame.getMemoryReference());
    }

    @Test
    public void testPhysicalFrameSet() {
        assertEquals(new MemoryReference("1"), physicalFrame.getMemoryReference());
        physicalFrame.setMemoryReference(new MemoryReference("2"));
        assertEquals(new MemoryReference("2"), physicalFrame.getMemoryReference());
    }

}