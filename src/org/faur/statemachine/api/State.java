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
public interface State {

    /**
     * Adds next state to be executed.
     * @param state
     */
    void addNextState(State state);

    State getNextState();

    /**
     * Adds next transition that will be executed before
     * getting to the next state.
     * @param transition
     */
    void addNextTransition(Transition transition);

    Transition getNextTransition();

    /**
     * Executes the state and fires the next transition
     */
    void executeState();

    /**
     * Executes code before exiting the state.
     */
    void outOfState();
}
