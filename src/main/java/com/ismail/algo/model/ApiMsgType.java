package com.ismail.algo.model;

import com.ismail.algo.EnumIntGeneric;

/**
 * Rest message types
 * 
 * @author ismail
 * @since 20221001
 */
public class ApiMsgType  extends EnumIntGeneric
{
    private static int Counter = 0;

    public static int None = Counter++;

    //
    
    public static int Request = Counter++;

    public static int Response = Counter++;

    public static int Error = Counter++;

    public static int Ping = Counter++;

    public static int Pong = Counter++;

    /**
     * resetting context
     */
    public static int Clear = Counter++;

    // subscriptions
    public static int Subscribed = Counter++;

    public static int Subscription = Counter++;

    public static int OrderSingleRequest = Counter++;

    public static int OrderSingleResponse =Counter++;

    public static int OrderCancelRequest = Counter++;

    public static int OrderCancelResponse = Counter++;

    public static int ExecutionReport = Counter++;

    public static int OrderStatusRequest = Counter++;

    public static int OrderStatusResponse = Counter++;


    public static int Order = Counter++;
    
    public static int ChildOrder = Counter++;
    
    public static int Trade = Counter++;
    
    // static data

    public static int Instrument = Counter++;

    public static int InstrumentResults = Counter++;

    // market data
    
    public static int TopOfBook = Counter++;
    
    public static int TopOfBookResults = Counter++;
    
    public static int OrderBook = Counter++;
    
    public static int OrderBookResults = Counter++;
    
    // order grid results
    
    public static int OrderResult = Counter++;
    
    public static int ChildOrderResult = Counter++;
    
    public static int TradeResult = Counter++;
    
     
    // Algos
    public static int AlgoDefinition = Counter++;
    
    // others
    
    public static int ContactUsRequest = Counter++;
    
    // --------------------------------------------------------
    // copy/paste this block to all generic enum integers
    // --------------------------------------------------------
    private static IntFieldData sFieldData = null;

    static
    {
        sFieldData = getFieldData(ApiMsgType.class);
    }

    public final static String toString(int pValue)
    {
        String val = null;

        if (sFieldData.mFieldNameByValue.containsKey(pValue))
        {
            val = sFieldData.mFieldNameByValue.get(pValue);
        }

        return val;
    }

    public final static int fromString(String pValue)
    {
        int val = -1;

        if (sFieldData.mFieldValueByName.containsValue(pValue))
        {
            val = sFieldData.mFieldValueByName.get(pValue);
        }

        return val;
    }

    public static final int[] getValues()
    {
        return sFieldData.mFieldValues;
    }

    public static final String[] getNames()
    {
        return sFieldData.mFieldNames;
    }

    // --------------------------------------------------------
}
