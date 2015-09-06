
# Reg Export without Prompt

To avoid block by prompt, add `/y` for `reg export`

    /y       Force overwriting the existing file without prompt.

    Ex:
    reg export "HKLM\XX" d:\1.reg /y