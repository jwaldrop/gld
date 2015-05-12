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

package com.novaordis.gld.service;

import com.novaordis.gld.Operation;
import com.novaordis.gld.Service;

public class EmbeddedGenericService implements Service
{
    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    private volatile boolean started;

    // Constructors ----------------------------------------------------------------------------------------------------

    // Service implementation ------------------------------------------------------------------------------------------

    @Override
    public void start() throws Exception
    {
        started = true;
    }

    @Override
    public void stop() throws Exception
    {
        started = false;
    }

    @Override
    public boolean isStarted()
    {
        return started;
    }

    @Override
    public void perform(Operation o) throws Exception
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    // Public ----------------------------------------------------------------------------------------------------------

    @Override
    public String toString()
    {
        return "EmbeddedGenericService[" + "]";
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}