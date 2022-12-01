package com.ismail.algo.model;

import com.ismail.algo.EnumIntGeneric;

/**
 * Rest message types
 * 
 * @author ismail
 * @since 20221001
 */
public class ApiMsgType extends EnumIntGeneric
{
    private static int Counter = -1;

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

    public static int OrderSingleResponse = Counter++;

    public static int OrderCancelRequest = Counter++;

    public static int OrderCancelResponse = Counter++;

    public static int ExecutionReport = Counter++;

    public static int OrderStatusRequest = Counter++;

    public static int OrderStatusResponse = Counter++;

    // Orders / Trades
    
    public static int Order = Counter++;

    public static int OrdersResult = Counter++;

    public static int ChildOrder = Counter++;

    public static int ChildOrdersResult = Counter++;

    public static int Trade = Counter++;

    public static int TradesResult = Counter++;

    // Algos
    public static int AlgoDefinition = Counter++;

    public static int AlgosResult = Counter++;

    // positions
    
    public static int Position = Counter++;

    public static int PositionsResult = Counter++;

    public static int PositionTrade = Counter++;

    public static int PositionTradesResult = Counter++;


    // static data

    public static int Exchange = Counter++;

    public static int ExchangesResult = Counter++;

    public static int Client = Counter++;

    public static int ClientsResult = Counter++;

    public static int Instrument = Counter++;

    public static int InstrumentsResult = Counter++;

    // market data
    
    public static int TopOfBook = Counter++;

    public static int TopOfBooksResult = Counter++;

    public static int TopOfBookFormatted = Counter++;

    public static int OrderBook = Counter++;

    public static int OrderBooksResult = Counter++;

    // 

    public static int ContactUsRequest = Counter++;

    public static int ServerTime = Counter++;

    public static int System = Counter++;

    public static int SystemsResult = Counter++;


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
