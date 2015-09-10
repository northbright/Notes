# Set Mouse Speed(sensitivity) Programmatically

#### Mothod 1: Windows API

###### Call `SystemParametersInfo()` with `SPI_SETMOUSESPEED`:

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

###### Source Code
* [MouseSensitivityTweak](https://github.com/northbright/MouseSensitivityTweak)

#### Method 2: Offline Modify Ntuser.dat HIVE
* [Edit Ntuser.dat Hive to Set Default Reg Keys for Different Users](https://github.com/northbright/Notes/blob/master/Windows/registry/edit_ntuser_hive_to_set_default_reg_keys_for_different_users.md)