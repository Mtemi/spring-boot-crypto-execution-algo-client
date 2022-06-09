package com.ismail.algo.model;

import lombok.Getter;

@Getter
public enum AlgoExecStyle
{
    Very_Passive(1), //
    Passive(3), //
    Normal(5), //
    Aggressive(7), //
    Very_Aggressive(9);

    private final int code;

    AlgoExecStyle(int code)
    {
        this.code = code;
    }
    
    public String getCodeAsString()
    {
        return Integer.toString(code);
    }
}