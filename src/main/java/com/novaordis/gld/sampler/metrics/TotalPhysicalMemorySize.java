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

package com.novaordis.gld.sampler.metrics;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

/**
 * @see com.sun.management.OperatingSystemMXBean#getTotalPhysicalMemorySize
 */
public class TotalPhysicalMemorySize implements Metric
{
    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    private static OperatingSystemMXBean INSTANCE;

    public static OperatingSystemMXBean getJava7OperatingSystemMXBean()
    {
        if (INSTANCE == null)
        {
            INSTANCE = ManagementFactory.getPlatformMXBean(com.sun.management.OperatingSystemMXBean.class);
        }

        return INSTANCE;
    }

    // Attributes ------------------------------------------------------------------------------------------------------

    private Number value;

    // Constructors ----------------------------------------------------------------------------------------------------

    @SuppressWarnings("UnusedDeclaration")
    public TotalPhysicalMemorySize()
    {
        this(getJava7OperatingSystemMXBean().getTotalPhysicalMemorySize());
    }

    public TotalPhysicalMemorySize(long value)
    {
        this.value = value;
    }

    // Metric implementation ------------------------------------------------------------------------------------------

    @Override
    public Number getValue()
    {
        return value;
    }

    @Override
    public String getLabel()
    {
        return "total O/S physical memory";
    }

    @Override
    public MeasureUnit getMeasureUnit()
    {
        return MeasureUnit.BYTE;
    }

    // Public ----------------------------------------------------------------------------------------------------------

    @Override
    public String toString()
    {
        Number n = getValue();
        return n == null ? "null" : n.toString();
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}
