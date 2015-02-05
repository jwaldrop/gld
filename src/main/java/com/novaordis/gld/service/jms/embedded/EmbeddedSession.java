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

package com.novaordis.gld.service.jms.embedded;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TemporaryQueue;
import javax.jms.TemporaryTopic;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;
import java.io.Serializable;

public class EmbeddedSession implements Session
{
    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    private boolean transacted;
    private int acknowledgment;

    // Constructors ----------------------------------------------------------------------------------------------------

    public EmbeddedSession(boolean transacted, int acknowledgment)
    {
        this.transacted = false;
        this.acknowledgment = acknowledgment;
    }

    // Session implementation ------------------------------------------------------------------------------------------

    @Override
    public String toString()
    {
        return "EmbeddedSession[" + "]";
    }

    @Override
    public BytesMessage createBytesMessage() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public MapMessage createMapMessage() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public Message createMessage() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public ObjectMessage createObjectMessage() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public ObjectMessage createObjectMessage(Serializable serializable) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public StreamMessage createStreamMessage() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public TextMessage createTextMessage() throws JMSException
    {
        return new EmbeddedTextMessage();
    }

    @Override
    public TextMessage createTextMessage(String s) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public boolean getTransacted() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public int getAcknowledgeMode() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public void commit() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public void rollback() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public void close() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public void recover() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public MessageListener getMessageListener() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public void setMessageListener(MessageListener messageListener) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public void run()
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public MessageProducer createProducer(Destination destination) throws JMSException
    {
        return new EmbeddedProducer(destination);
    }

    @Override
    public MessageConsumer createConsumer(Destination destination) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public MessageConsumer createConsumer(Destination destination, String s) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public MessageConsumer createConsumer(Destination destination, String s, boolean b) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public Queue createQueue(String s) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public Topic createTopic(String s) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public TopicSubscriber createDurableSubscriber(Topic topic, String s) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public TopicSubscriber createDurableSubscriber(Topic topic, String s, String s1, boolean b) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public QueueBrowser createBrowser(Queue queue) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public QueueBrowser createBrowser(Queue queue, String s) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public TemporaryQueue createTemporaryQueue() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public TemporaryTopic createTemporaryTopic() throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @Override
    public void unsubscribe(String s) throws JMSException
    {
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    // Public ----------------------------------------------------------------------------------------------------------

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}