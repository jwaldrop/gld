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

package com.novaordis.gld.mock;

import com.novaordis.gld.CacheService;
import com.novaordis.gld.Configuration;
import com.novaordis.gld.ContentType;
import com.novaordis.gld.Node;
import com.novaordis.gld.Operation;
import com.novaordis.gld.UserErrorException;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A mock cache service that helps us simulate locally interactions that otherwise would have required a remote
 * cache. We can interact with the backing map even if the service is stopped.
 */
public class MockCacheService implements CacheService
{
    // Constants -------------------------------------------------------------------------------------------------------

    private static final Logger log = Logger.getLogger(MockCacheService.class);

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    private Map<String, String> cache;
    private boolean started;

    // Constructors ----------------------------------------------------------------------------------------------------

    /**
     * Create it in started state.
     */
    public MockCacheService() throws Exception
    {
        this.cache = new HashMap<>();
        started = true;
    }

    // Service implementation ------------------------------------------------------------------------------------------

    @Override
    public ContentType getContentType()
    {
        return ContentType.KEYVALUE;
    }

    @Override
    public void setConfiguration(Configuration c)
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public void setTarget(List<Node> nodes)
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    /**
     * @see com.novaordis.gld.Service#configure(List)
     */
    @Override
    public void configure(List<String> commandLineArguments) throws UserErrorException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public void perform(Operation o) throws Exception
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public void start() throws Exception
    {
        started = true;
        log.info(this + " started");
    }

    @Override
    public void stop() throws Exception
    {
        started = false;
        log.info(this + " stopped");
    }

    @Override
    public boolean isStarted()
    {
        return started;
    }

    // CacheService implementation -------------------------------------------------------------------------------------

    @Override
    public void set(String key, String value) throws Exception
    {
        checkStarted();
        cache.put(key, value);
    }

    @Override
    public String get(String key) throws Exception
    {
        checkStarted();
        return cache.get(key);
    }

    @Override
    public Set<String> keys(String pattern)
    {
        checkStarted();
        return new HashSet<>(cache.keySet());
    }

    @Override
    public Object getCache()
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public String delete(String key)
    {
        checkStarted();
        return cache.remove(key);
    }

    // Public ----------------------------------------------------------------------------------------------------------

    @Override
    public String toString()
    {
        return "MockCacheService[" + Integer.toHexString(System.identityHashCode(this)) + "]";
    }

    public Map<String, String> getBackingMap() { return cache; }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    private void checkStarted()
    {
        if (!started)
        {
            throw new IllegalArgumentException(this + " not started");
        }
    }

    // Inner classes ---------------------------------------------------------------------------------------------------

}
