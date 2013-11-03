package org.faur.statemachine.model;

import org.faur.statemachine.api.OutputPort;

/**
 * ****************************************************************************
 * Copyright (c) 2005-2013 Faur Ioan-Aurel.                                     *
 * All rights reserved. This program and the accompanying materials             *
 * are made available under the terms of the MIT License                        *
 * which accompanies this distribution, and is available at                     *
 * http://opensource.org/licenses/MIT                                           *
 * *
 * For any issues or questions send an email at: fioan89@gmail.com              *
 * *****************************************************************************
 */
public class GeneralOutputPort implements OutputPort{

    private Object syncObject;

    @Override
    public void addSyncObject(Object syncObject) {
        this.syncObject = syncObject;
    }

    @Override
    public synchronized void sendMessage() {
        System.out.println("GeneralOutputPort.sendMessage");
        synchronized (syncObject) {
            syncObject.notify();
        }
    }
}
