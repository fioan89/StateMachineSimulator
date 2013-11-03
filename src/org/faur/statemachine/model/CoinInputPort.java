package org.faur.statemachine.model;

import org.faur.statemachine.api.InputPort;

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
public class CoinInputPort implements InputPort {
    private Object syncObject;

    @Override
    public void addSyncObject(Object syncObject) {
        this.syncObject = syncObject;
    }

    @Override
    public void readMessage() {
        System.out.println("CoinInputPort.readMessage");
        synchronized (syncObject) {
            try {
                syncObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                Thread.currentThread().interrupt();
            }
        }
    }
}
