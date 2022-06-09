package com.ismail.algo.model;

/**
 * An exception which can occur while invoking methods of the Binance API.
 */
public class BusinessApiException extends RuntimeException
{
    private static final long serialVersionUID = 3788669840036201041L;


    
    private AlgoApiError apiError = null;
    
    /**
     * Instantiates a new binance api exception.
     */
    public BusinessApiException()
    {
        super();
    }
 
    public BusinessApiException(AlgoApiError apiError)
    {
        super(apiError.getErrorCode() + "-" + apiError.getErrorMsg());
        
        this.apiError = apiError;
    }
    
    public BusinessApiException(int pErrorCode, String pErrorMsg)
    {
        super(pErrorCode + "-" + pErrorMsg);
    }
    
    /**
     * Instantiates a new binance api exception.
     *
     * @param message the message
     */
    public BusinessApiException(String message)
    {
        super(message);
    }

    /**
     * Instantiates a new binance api exception.
     *
     * @param cause the cause
     */
    public BusinessApiException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Instantiates a new binance api exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public BusinessApiException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public AlgoApiError getErrorCode()
    {
        return apiError;
    }
    
}