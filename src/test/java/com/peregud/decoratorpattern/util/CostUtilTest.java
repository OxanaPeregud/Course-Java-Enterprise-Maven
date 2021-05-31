package com.peregud.decoratorpattern.util;

import com.peregud.decoratorpattern.model.Size;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CostUtilTest {

    @Test
    void getCost() {
        assertEquals(15, CostUtil.getCost(Size.LARGE, 10));
        assertEquals(10, CostUtil.getCost(Size.MEDIUM, 10));
        assertEquals(6.67, CostUtil.getCost(Size.SMALL, 10));
    }
}
