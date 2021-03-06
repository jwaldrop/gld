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

package com.novaordis.gld.strategy.load.cache;

import com.novaordis.gld.Configuration;
import com.novaordis.gld.KeyStore;
import com.novaordis.gld.Operation;
import com.novaordis.gld.strategy.load.LoadStrategyBase;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * We keep this class in this package ("com.novaordis.gld.strategy.load") and not in the mock package
 * com.novaordis.gld.mock because, among other things, we test reflection-based instantiation, and for that we need
 * to be in certain packages.
 */
public class MockLoadStrategy extends LoadStrategyBase
{
    // Constants -------------------------------------------------------------------------------------------------------

    private static final Logger log = Logger.getLogger(MockLoadStrategy.class);

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    private String mockArgument;
    private String mockLoadArgument;

    private AtomicInteger remainingOperations;

    // Constructors ----------------------------------------------------------------------------------------------------

    /**
     * Will generate an unlimited number of operations.
     */
    public MockLoadStrategy()
    {
        this(-1);
    }

    /**
     * @param operationCount the number of operations to generate.
     */
    public MockLoadStrategy(int operationCount)
    {
        if (operationCount >= 0)
        {
            remainingOperations = new AtomicInteger(operationCount);
        }
    }

    // LoadStrategy implementation -------------------------------------------------------------------------------------

    @Override
    public void configure(Configuration config, List<String> arguments, int from) throws Exception
    {
        super.configure(config, arguments, from);

        for(int i = 0; i < arguments.size(); i ++)
        {
            if ("--mock-argument".equals(arguments.get(i)))
            {
                arguments.remove(i);
                mockArgument = arguments.remove(i --);
            }
            else if ("--mock-load-argument".equals(arguments.get(i)))
            {
                arguments.remove(i);
                mockLoadArgument = arguments.remove(i --);
            }
        }
    }

    @Override
    public Operation next(Operation lastOperation, String lastWrittenKey)
    {
        if (remainingOperations != null)
        {
            if (remainingOperations.getAndDecrement() <= 0)
            {
                return null;
            }
        }

        return new MockOperation();
    }

    @Override
    public Set<Class<? extends Operation>> getOperationTypes()
    {
        HashSet<Class<? extends Operation>> result = new HashSet<>();
        result.add(MockOperation.class);
        return result;
    }

    // Public ----------------------------------------------------------------------------------------------------------

    public void setKeyStore(KeyStore ks)
    {
        super.setKeyStore(ks);
    }

    public String toString()
    {
        return "MockLoadStrategy[" + Integer.toHexString(System.identityHashCode(this)) + "]";
    }

    public String getMockArgument()
    {
        return mockArgument;
    }

    public String getMockLoadArgument()
    {
        return mockLoadArgument;
    }

    public int getRemainingOperations()
    {
        int i = remainingOperations.get();

        // the counter is decremented under 0, and that has "0" semantics

        if (i < 0)
        {
            i = 0;
        }

        return i;
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}
