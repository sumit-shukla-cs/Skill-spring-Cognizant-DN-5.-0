package com.example.junit;

import org.junit.Assert;
import org.junit.Test;

public class MathTest {

    @Test
    public void addsTwoNumbers() {
        Assert.assertEquals(4, 2 + 2);
    }
}
