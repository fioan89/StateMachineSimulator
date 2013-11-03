package org.faur.statemachine.api;


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
public interface StateMachine {
    /**
     * Initializes the state machine with the first state in which it will start.
     * @param state
     */
    void addFirstState(State state);

    /**
     * Starts the execution of this state machine.
     */
    void runStateMachine();

    /**
     * Stops state machine execution.
     */
    void stopStateMachine();
}
