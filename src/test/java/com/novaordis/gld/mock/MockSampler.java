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

import com.novaordis.gld.Operation;
import com.novaordis.gld.sampler.Counter;
import com.novaordis.gld.sampler.Sampler;
import com.novaordis.gld.sampler.SamplingConsumer;
import com.novaordis.gld.sampler.metrics.Metric;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MockSampler implements Sampler
{
    // Constants -------------------------------------------------------------------------------------------------------

    private static final Logger log = Logger.getLogger(MockSampler.class);

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    private List<OperationThrowablePair> recorded;

    private Set<Class<? extends Operation>> operations;

    private boolean started;

    private boolean wasStarted;

    // Constructors ----------------------------------------------------------------------------------------------------

    public MockSampler()
    {
        this.recorded = new ArrayList<>();
        this.operations = new HashSet<>();
        this.started = false;
        this.wasStarted = false;
    }

    // Sampler implementation ------------------------------------------------------------------------------------------

    @Override
    public void setSamplingIntervalMs(long ms)
    {
        throw new RuntimeException("setSamplingIntervalMs() NOT YET IMPLEMENTED");
    }

    @Override
    public long getSamplingIntervalMs()
    {
        throw new RuntimeException("getSamplingIntervalMs() NOT YET IMPLEMENTED");
    }

    @Override
    public void setSamplingTaskRunIntervalMs(long ms)
    {
        throw new RuntimeException("setSamplingTaskRunIntervalMs() NOT YET IMPLEMENTED");
    }

    @Override
    public long getSamplingTaskRunIntervalMs()
    {
        throw new RuntimeException("getSamplingTaskRunIntervalMs() NOT YET IMPLEMENTED");
    }

    @Override
    public Counter registerOperation(Class<? extends Operation> operationType)
    {
        operations.add(operationType);
        return null;
    }

    @Override
    public boolean registerConsumer(SamplingConsumer consumer)
    {
        throw new RuntimeException("registerConsumer() NOT YET IMPLEMENTED");
    }

    @Override
    public List<SamplingConsumer> getConsumers()
    {
        throw new RuntimeException("getConsumers() NOT YET IMPLEMENTED");
    }

    @Override
    public boolean registerMetric(Class<? extends Metric> metricType)
    {
        throw new RuntimeException("registerMetric() NOT YET IMPLEMENTED");
    }

    @Override
    public void start()
    {
        started = true;
        wasStarted = true;
        log.info(this + " started");
    }

    @Override
    public boolean isStarted()
    {
        return started;
    }

    @Override
    public void stop()
    {
        started = false;
        log.info(this + " stopped");
    }

    @Override
    public void record(long t0Ms, long t0Nano, long t1Nano, Operation op, Throwable... t)
    {
        recorded.add(new OperationThrowablePair(op, t.length == 0 ? null : t[0]));
    }

    @Override
    public void annotate(String line)
    {
        throw new RuntimeException("annotate() NOT YET IMPLEMENTED");
    }

    @Override
    public Counter getCounter(Class<? extends Operation> operationType)
    {
        throw new RuntimeException("getCounter() NOT YET IMPLEMENTED");
    }

    // Public ----------------------------------------------------------------------------------------------------------

    @SuppressWarnings("UnusedDeclaration")
    public List<OperationThrowablePair> getRecorded()
    {
        return recorded;
    }

    /**
     * @return true if start() method was called at least once
     */
    public boolean wasStarted()
    {
        return wasStarted;
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}
