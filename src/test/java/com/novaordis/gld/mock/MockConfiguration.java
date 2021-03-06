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

import com.novaordis.gld.Command;
import com.novaordis.gld.Configuration;
import com.novaordis.gld.LoadStrategy;
import com.novaordis.gld.Node;
import com.novaordis.gld.Service;
import com.novaordis.gld.StorageStrategy;
import com.novaordis.gld.sampler.Sampler;

import java.util.List;
import java.util.Properties;

public class MockConfiguration implements Configuration
{
    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    private String keyStoreFile;
    private String exceptionFile;
    private int keySize;
    private int valueSize;
    private boolean useDifferentValues;
    private Service service;
    private LoadStrategy loadStrategy;
    private StorageStrategy storageStrategy;
    private Command command;
    private String username;
    private boolean waitForConsoleQuit;
    private int threads;
    private Sampler sampler;
    private long sleepMs;

    // Constructors ----------------------------------------------------------------------------------------------------

    public MockConfiguration()
    {
        this.command = null;
        this.username = null;
        this.keySize = 1;
        this.valueSize = 1;
        this.useDifferentValues = false;
        this.exceptionFile = null;
        this.threads = 1;
        this.sleepMs = -1L;
    }

    // Configuration implementation ------------------------------------------------------------------------------------

    @Override
    public Service getService()
    {
        return service;
    }

    @Override
    public LoadStrategy getLoadStrategy()
    {
        return loadStrategy;
    }

    @Override
    public void setLoadStrategy(LoadStrategy ls)
    {
        this.loadStrategy = ls;
    }

    @Override
    public StorageStrategy getStorageStrategy()
    {
        return storageStrategy;
    }

    @Override
    public void setStorageStrategy(StorageStrategy storageStrategy)
    {
        this.storageStrategy = storageStrategy;
    }

    @Override
    public Command getCommand()
    {
        return command;
    }

    @Override
    public void setCommand(Command c)
    {
        this.command = c;
    }

    @Override
    public Sampler getSampler()
    {
        return sampler;
    }

    @Override
    public void setSampler(Sampler s)
    {
        this.sampler = s;
    }

    @Override
    public int getThreads()
    {
        return threads;
    }

    @Override
    public int getMaxTotal()
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public long getMaxWaitMillis()
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public List<Node> getNodes()
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public long getSleepMs()
    {
        return sleepMs;
    }

    @Override
    public int getKeySize()
    {
        return keySize;
    }

    @Override
    public int getValueSize()
    {
        return valueSize;
    }

    @Override
    public boolean isUseDifferentValues()
    {
        return useDifferentValues;
    }

    @Override
    public String getOutputFile()
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public String getPassword()
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public long getKeyExpirationSecs()
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public String getExceptionFile()
    {
        return exceptionFile;
    }

    @Override
    public String getCacheName()
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public String getKeyStoreFile()
    {
        return keyStoreFile;
    }

    @Override
    public String getUsername()
    {
        return username;
    }

    @Override
    public boolean inBackground()
    {
        return false;
    }

    @Override
    public Properties getConfigurationFileContent()
    {
        return null;
    }

    @Override
    public boolean waitForConsoleQuit()
    {
        return waitForConsoleQuit;
    }

    @Override
    public void setWaitForConsoleQuit(boolean b)
    {
        this.waitForConsoleQuit = b;
    }

    // Public ----------------------------------------------------------------------------------------------------------

    public void setKeySize(int i)
    {
        this.keySize = i;
    }

    public void setValueSize(int i)
    {
        this.valueSize = i;
    }

    public void setKeyStoreFile(String s)
    {
        this.keyStoreFile = s;
    }

    public void setService(Service cs)
    {
        this.service = cs;
    }

    public void setUseDifferentValues(boolean b)
    {
        this.useDifferentValues = b;
    }

    public void setThreads(int threads)
    {
        this.threads = threads;
    }

    public void setSleepMs(long sleepMs)
    {
        this.sleepMs = sleepMs;
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}
