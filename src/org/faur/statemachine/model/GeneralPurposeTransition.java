package org.faur.statemachine.model;

import org.faur.statemachine.api.InputPort;
import org.faur.statemachine.api.OutputPort;
import org.faur.statemachine.api.Transition;

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
public class GeneralPurposeTransition implements Transition {
    private InputPort inputPort;
    private OutputPort outputPort;

    @Override
    public void setInputPort(InputPort port) {
        inputPort = port;
    }

    @Override
    public void setOutputPort(OutputPort port) {
        outputPort = port;
    }

    @Override
    public void fireTransition() {
        if (inputPort != null) {
            System.out.println("GeneralPurposeTransition.fireTransition reading input port");
            inputPort.readMessage();
        }

        if (outputPort != null) {
            System.out.println("GeneralPurposeTransition.fireTransition send message on output port");
            outputPort.sendMessage();
        }
    }
}
