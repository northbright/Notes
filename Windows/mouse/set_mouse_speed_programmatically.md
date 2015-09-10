# Set Mouse Speed(sensitivity) Programmatically

#### Call `SystemParametersInfo()` with `SPI_SETMOUSESPEED`:

    BOOL SetMouseSpeed(int nSpeed) {
        if (!IsSpeedValid(nSpeed)) {
            return FALSE;
        }

        int nOldSpeed = GetMouseSpeed();
        if (nOldSpeed == nSpeed) {
            return TRUE;
        }

        BOOL fResult = SystemParametersInfo(SPI_SETMOUSESPEED,  // Get mouse information
                                            0,                  // Not used
                                            PVOID(nSpeed),      // Holds mouse speed
                                            SPIF_SENDCHANGE);   // Broadcasts the WM_SETTINGCHANGE message

        return fResult;
    }

#### Source Code
* [MouseSensitivityTweak](https://github.com/northbright/MouseSensitivityTweak)