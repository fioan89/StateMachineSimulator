package org.faur.statemachine.factory;

import org.faur.statemachine.model.GeneralPurposeSM;

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
public class MainClass {

    public static void main(String[] args) {
        GeneralPurposeSM turnstileSM = TurnstileFactory.getInstance().getTurnstileSM();
        GeneralPurposeSM userSM = UserFactory.getInstance().getUserStateMachine();

        turnstileSM.runStateMachine();
        userSM.runStateMachine();
    }
}
