package com.ismail.algo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import com.ismail.algo.config.ColorThemeConfig;
import com.ismail.algo.controller.PageInfo;
import com.ismail.algo.model.BusinessApiException;

/**
 * Utility class
 * 
 * @author ismail
 * @since 20220603
 */
public class AlgoUtil
{

    /**
     * Convert a string into HTML format string; by maintaining new lines etc
     * 
     * @param pInputString input string
     * @return html format
     */
    public static String toHtmlFormat(String pInputString)
    {
        if (pInputString == null || pInputString.length() == 0)
            return "";

        String str = pInputString.replaceAll("ï¿½", "'");

        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");

        // replace double spaces
        str = str.replaceAll("    ", "&nbsp;&nbsp;&nbsp;&nbsp;");
        str = str.replaceAll("   ", "&nbsp;&nbsp;&nbsp;");
        str = str.replaceAll("  ", "&nbsp;&nbsp;");

        // new line chars
        str = str.replaceAll("\n", "\n<br>\n");

        // Enable HTML links

        return str;
    }

    /**
     * @param pVal
     * @return
     */
    public final static boolean isDefined(final String pVal)
    {
        return (pVal != null && pVal.length() > 0);
    }

    
    // --------------------------------------------------------------------------------------------------
    // Web / Servlet utilities
    // --------------------------------------------------------------------------------------------------
   
    
    public static String getParameter(HttpServletRequest request, String pParamName)
    {
        String str = request.getParameter(pParamName);

        if (str != null)
            return str;
        else
            throw new BusinessApiException("Required parameter missing: " + pParamName);
    }

    public static String getParameter(HttpServletRequest request, String pParamName, String pDefaultValue)
    {
        String str = request.getParameter(pParamName);

        if (str != null)
            return str;
        else
            return pDefaultValue;
    }

    public static char getParameterAsChar(HttpServletRequest request, String pParamName)
    {
        String str = request.getParameter(pParamName);

        if (str != null && str.length() > 0)
            return str.charAt(0);
        else
            throw new BusinessApiException("Required parameter missing: " + pParamName);
    }

    public static char getParameterAsChar(HttpServletRequest request, String pParamName, char pDefaultValue)
    {
        String str = request.getParameter(pParamName);

        if (str != null && str.length() > 0)
            return str.charAt(0);
        else
            return pDefaultValue;
    }

    public static double getParameterAsDouble(HttpServletRequest request, String pParamName)
    {
        String str = request.getParameter(pParamName);

        if (str != null && str.length() > 0)
            return Double.parseDouble(str);
        else
            throw new BusinessApiException("Required parameter missing: " + pParamName);
    }

    public static double getParameterAsDouble(HttpServletRequest request, String pParamName, double pDefaultValue)
    {
        String str = request.getParameter(pParamName);

        if (str != null && str.length() > 0)
            return Double.parseDouble(str);
        else
            return pDefaultValue;
    }

    public static int getParameterAsInt(HttpServletRequest request, String pParamName)
    {
        String str = request.getParameter(pParamName);

        if (str != null && str.length() > 0)
            return Integer.parseInt(str);
        else
            throw new BusinessApiException("Required parameter missing: " + pParamName);
    }

    public static int getParameterAsInt(HttpServletRequest request, String pParamName, int pDefaultValue)
    {
        String str = request.getParameter(pParamName);

        if (str != null && str.length() > 0)
            return Integer.parseInt(str);
        else
            return pDefaultValue;
    }
    
    
    public static long getParameterAsLong(HttpServletRequest request, String pParamName)
    {
        String str = request.getParameter(pParamName);

        if (str != null && str.length() > 0)
            return Long.parseLong(str);
        else
            throw new BusinessApiException("Required parameter missing: " + pParamName);
    }

    public static long getParameterAsLong(HttpServletRequest request, String pParamName, long pDefaultValue)
    {
        String str = request.getParameter(pParamName);

        if (str != null && str.length() > 0)
            return Long.parseLong(str);
        else
            return pDefaultValue;
    }
    
    /**
     * Get Request Page Info; and if null; create one
     * 
     * @param request
     * @return
     */
    public static PageInfo getPageInfo(HttpServletRequest request)
    {
        PageInfo pageInfo = (PageInfo)request.getAttribute(PageInfo.PAGE_INFO_KEY);
        
        if (pageInfo == null)
        {
             pageInfo = new PageInfo();
             request.setAttribute(PageInfo.PAGE_INFO_KEY, pageInfo);
        }
        
        return pageInfo;
    }
    
    
    // --------------------------------------------------------------------------------------------------
    // Formatting utilities
    // --------------------------------------------------------------------------------------------------
   
    

    public static final String numericFormat(double value, int decimals)
    {
        NumberFormat formatter = null;

        if (decimals <= 0)
        {
            formatter = new DecimalFormat("#0");

        }
        else
        {
            StringBuilder sb = new StringBuilder("#0.");
            for (int i = 0; i < decimals; i++)
                sb.append('0');

            formatter = new DecimalFormat(sb.toString());
        }

        return formatter.format(value);
    }

    
    public static SimpleDateFormat getFormatter(String pFormat)
    {
        return getFormatter(pFormat, null, false);
    }

    public static SimpleDateFormat getFormatter(String pFormat, String pTimeZoneID)
    {
        return getFormatter(pFormat, pTimeZoneID, false);
    }

    public static SimpleDateFormat getFormatter(String pFormat, String pTimeZoneID, boolean pLenient)
    {
        SimpleDateFormat dateParser = new SimpleDateFormat(pFormat);
        dateParser.setLenient(pLenient);

        if (pTimeZoneID != null)
        {
            TimeZone tz = TimeZone.getTimeZone(pTimeZoneID);
            dateParser.setTimeZone(tz);
        }

        return dateParser;
    }


}
