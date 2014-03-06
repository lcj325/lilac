package com.snail.lilac.core.logging;

import org.junit.Test;

import com.snail.lilac.core.AbstractUtilTests;

/**
 * @author andy
 */
public class Slf4jImplTest extends AbstractUtilTests {

    private static final Logger log = LoggerFactory.getLogger(Slf4jImplTest.class);

    @Test
    public void testLogging() {
        log.info("the method name is {}", "testIsDebugEnabled");
        log.info("Whart is marker ?");
    }

}
