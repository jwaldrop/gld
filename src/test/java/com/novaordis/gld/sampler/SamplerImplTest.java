/*
 * Copyright (c) 2015 Nova Ordis LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.novaordis.gld.sampler;

import com.novaordis.gld.strategy.load.cache.MockOperation;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SamplerImplTest extends SamplerTest
{
    // Constants -------------------------------------------------------------------------------------------------------

    private static final Logger log = Logger.getLogger(SamplerImplTest.class);

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------------------------------------------------

    // Public ----------------------------------------------------------------------------------------------------------

    @Test
    public void exceptionInRunDoesNotPreventReleasingTheMutex() throws Exception
    {
        // start the sampler with a very large sampling interval, so the stop timeout will be very large; hoewever,
        // keep the sampling thread run interval small
        long twoDays = 2L * 24 * 60 * 60 * 1000L;
        SamplerImpl si = new SamplerImpl(250L, twoDays);
        si.registerOperation(MockOperation.class);

        si.start();

        assertTrue(si.isStarted());

        // "break" the sampler, so when run() is invoked, it'll throw an exception. Setting the consumers to
        // null will cause an NPE

        si.setConsumers(null);

        log.info(si + " has been broken ...");

        // attempt to stop, the stop must not block indefinitely, if it does, the JUnit will kill the test and fail

        long t0 = System.currentTimeMillis();

        si.stop();

        long t1 = System.currentTimeMillis();

        log.info("the sampler stopped, it took " + (t1 - t0) + " ms to stop the sampler");
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    @Override
    protected SamplerImpl getSamplerToTest() throws Exception
    {
        return new SamplerImpl();
    }

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}