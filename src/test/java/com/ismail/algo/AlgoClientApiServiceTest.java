package com.ismail.algo;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ismail.algo.config.AlgoClientConfig;
import com.ismail.algo.model.Algo;
import com.ismail.algo.model.AlgoExecStyle;
import com.ismail.algo.model.AlgoParamValue;
import com.ismail.algo.model.ChildOrder;
import com.ismail.algo.model.ChildOrdersResult;
import com.ismail.algo.model.Instrument;
import com.ismail.algo.model.NewOrderRequest;
import com.ismail.algo.model.NewOrderResponse;
import com.ismail.algo.model.Order;
import com.ismail.algo.model.OrderBook;
import com.ismail.algo.model.OrderCancelRequest;
import com.ismail.algo.model.OrderCancelResponse;
import com.ismail.algo.model.OrderSide;
import com.ismail.algo.model.OrderType;
import com.ismail.algo.model.OrdersResult;
import com.ismail.algo.model.TimeInForce;
import com.ismail.algo.model.TopOfBook;
import com.ismail.algo.model.Trade;
import com.ismail.algo.model.TradesResult;
import com.ismail.algo.service.AlgoClientApiService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class AlgoClientApiServiceTest
{
    @Autowired
    private AlgoClientApiService service;

    @Autowired
    private AlgoClientConfig config;

    @Test
    public void getAlgos()
    {
        List<Algo> algos = service.getAlgos();

        Assertions.assertTrue(algos != null && algos.size() > 0);

        System.out.println("getAlgos:\n " + algos);
    }

    @Test
    public void getAlgoByStrategyID()
    {
        String strategyID = "VWAP";

        Algo algo = service.getAlgoByStrategyID(strategyID);

        Assertions.assertTrue(algo != null && strategyID.equals(algo.getStrategyID()));

        System.out.println("getAlgoByStrategyID:\n" + algo);
    }

    @Test
    public void getInstruments()
    {
        List<Instrument> list = service.getInstruments();

        Assertions.assertTrue(list != null && list.size() > 0);

        System.out.println("getInstruments:\n " + list);
    }

    @Test
    public void getInstrumentByInstID()
    {
        String instID = "BTCBUSD.CR";

        Instrument algo = service.getInstrumentByInsID(instID);

        Assertions.assertTrue(algo != null && instID.equals(algo.getInstrumentID()));

        System.out.println("getInstrumentByInstID:\n" + algo);
    }

    @Test
    public void getTopOfBooks()
    {
        List<TopOfBook> list = service.getTopOfBooks();

        Assertions.assertTrue(list != null && list.size() > 0);

        System.out.println("getTopOfBooks:\n " + list);
    }

    @Test
    public void getTopOfBookByInstrumentID()
    {
        String instID = "BTCBUSD.CR";

        TopOfBook algo = service.getTopOfBookByInstrumentID(instID);

        Assertions.assertTrue(algo != null && instID.equals(algo.getInstrumentID()));

        System.out.println("getTopOfBookByInstrumentID:\n" + algo);
    }

    @Test
    public void getOrderBooks()
    {
        List<OrderBook> list = service.getOrderBooks();

        Assertions.assertTrue(list != null && list.size() > 0);

        System.out.println("getOrderBooks:\n " + list);
    }

    @Test
    public void getOrderBookByInstrumentID()
    {
        String instID = "BTCBUSD.CR";

        OrderBook algo = service.getOrderBookByInstrumentID(instID);

        Assertions.assertTrue(algo != null && instID.equals(algo.getInstrumentID()));

        System.out.println("getOrderBookByInstrumentID:\n" + algo);
    }

    @Test
    public void getOrders()
    {
        int pageNum = 1;
        int pageSize = 50;
        
        OrdersResult ordersResult = service.getOrders(pageNum, pageSize);

        Assertions.assertTrue(ordersResult.orders != null && ordersResult.orders.size() > 0);

        System.out.println("getOrders:\n " + ordersResult.orders);
    }

    @Test
    public void getOrderByParentOrderID()
    {
        long parentOrderID = 1L;

        Order algo = service.getOrderByOrderID(parentOrderID);

        Assertions.assertTrue(algo != null && parentOrderID == algo.getOrderID());

        System.out.println("getOrderByOrderID:\n" + algo);
    }

    @Test
    public void getChildOrdersByParentOrderID()
    {
        long parentOrderID = 1;

        ChildOrdersResult result = service.getChildOrdersByParentOrderID(parentOrderID, 1, 50);

        Assertions.assertTrue(result.childOrders != null && result.childOrders.size() > 0);

        System.out.println("getChildOrdersByParentOrderID:\n " + result.childOrders);
    }

    @Test
    public void getChildOrderByChildOrderID()
    {
        long childOrderID = 1L;

        ChildOrder algo = service.getChildOrderByChildOrderID(childOrderID);

        Assertions.assertTrue(algo != null && childOrderID == algo.getChildOrderID());

        System.out.println("getChildOrderByChildOrderID:\n" + algo);
    }

    @Test
    public void getTradesByParentOrderID()
    {
        long parentOrderID = 1;

        TradesResult result = service.getTradesByParentOrderID(parentOrderID, 1, 50);

        Assertions.assertTrue(result.trades != null && result.trades.size() > 0);

        System.out.println("getTradesByParentOrderID:\n " + result.trades);
    }

    @Test
    public void getTradesByChildOrderID()
    {
        long childOrderID = 1;

        List<Trade> list = service.getTradesByChildOrderID(childOrderID);

        Assertions.assertTrue(list != null && list.size() > 0);

        System.out.println("getTradesByChildOrderID:\n " + list);
    }

    @Test
    public void getTradeByTradeID()
    {
        long tradeID = 1L;

        Trade algo = service.getTradeByTradeID(tradeID);

        Assertions.assertTrue(algo != null && tradeID == algo.getTradeID());

        System.out.println("getTradeByTradeID:\n" + algo);
    }

    @Test
    public void submitNewOrderRequest()
    {
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
            formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
            String clientOrderID = formatter.format(System.currentTimeMillis());

            NewOrderRequest req = new NewOrderRequest();

            req.setClientID(config.getClientId());

            req.setClOrdID(clientOrderID);

            req.setRequestTime(System.currentTimeMillis());

            req.setInstrumentID("ETHBUSD.CR");
            req.setSide(OrderSide.Buy.getCode());
            req.setOrderType(OrderType.Market.getCode());
            req.setTimeInForce(TimeInForce.Good_till_cancel.getCode());
            req.setQuantity(10.0);
            req.setPrice(0.0);

            req.setAlgoStrategyID("TWAP");
            req.addAlgoParam(new AlgoParamValue("StartTime", "now", null));
            req.addAlgoParam(new AlgoParamValue("EndTime", "10m", null));
            req.addAlgoParam(new AlgoParamValue("ExecStyle", AlgoExecStyle.Aggressive.getCodeAsString(), AlgoExecStyle.Aggressive.toString()));

            System.out.println("submitOrderRequest:\n" + req);

            NewOrderResponse resp = service.submitNewOrderRequest(req);

            System.out.println("submitOrderRequest:\n" + resp);

            Assertions.assertTrue(resp != null && resp.getClientOrderID().equals(resp.getClientOrderID()) && resp.getOrderID() > 0L);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void submitOrderCancelRequest()
    {
        try
        {
            // Submit a limit order far from market

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
            formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
            String clientOrderID = formatter.format(System.currentTimeMillis());

            NewOrderRequest req = new NewOrderRequest();

            req.setClientID(config.getClientId());

            req.setClOrdID(clientOrderID);

            req.setRequestTime(System.currentTimeMillis());

            req.setInstrumentID("ETHBUSD.CR");
            req.setSide(OrderSide.Buy.getCode());
            req.setOrderType(OrderType.Limit.getCode());
            req.setTimeInForce(TimeInForce.Good_till_cancel.getCode());
            req.setQuantity(1.0);
            req.setPrice(1000.0);

            req.setAlgoStrategyID("DMA");

            System.out.println("submitOrderRequest:\n" + req);

            NewOrderResponse resp = service.submitNewOrderRequest(req);

            // Cancel order
            {
                OrderCancelRequest cancelReq = new OrderCancelRequest();

                cancelReq.setClientID(config.getClientId());

                cancelReq.setOrderID(resp.getOrderID());

                cancelReq.setRequestTime(System.currentTimeMillis());

                System.out.println("submitOrderCancelRequest:\n" + cancelReq);

                //OrderCancelResponse cancelResp = service.submitOrderCancelRequest(cancelReq);

                OrderCancelResponse cancelResp = service.cancelOrder(config.getClientId(), clientOrderID, resp.getOrderID());
                
                System.out.println("submitOrderCancelRequest:\n" + cancelResp);

                Assertions.assertTrue(resp != null && cancelResp.isSuccess() && cancelResp.getOrderID() == cancelReq.getOrderID());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void submitOrderCancelRequest_TooLate()
    {
        try
        {
            // Submit a limit order far from market

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
            formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
            String clientOrderID = formatter.format(System.currentTimeMillis());

            NewOrderRequest req = new NewOrderRequest();

            req.setClientID(config.getClientId());

            req.setClOrdID(clientOrderID);

            req.setRequestTime(System.currentTimeMillis());

            req.setInstrumentID("ETHBUSD.CR");
            req.setSide(OrderSide.Buy.getCode());
            req.setOrderType(OrderType.Market.getCode());
            req.setTimeInForce(TimeInForce.Good_till_cancel.getCode());
            req.setQuantity(1.0);
            req.setPrice(0.0);

            req.setAlgoStrategyID("DMA");

            System.out.println("submitOrderRequest:\n" + req);

            NewOrderResponse resp = service.submitNewOrderRequest(req);

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ie)
            {

            }

            // Cancel order
            {
                OrderCancelRequest cancelReq = new OrderCancelRequest();

                cancelReq.setClientID(config.getClientId());

                cancelReq.setOrderID(resp.getOrderID());

                cancelReq.setRequestTime(System.currentTimeMillis());

                System.out.println("submitOrderCancelRequest:\n" + cancelReq);

                //OrderCancelResponse cancelResp = service.submitOrderCancelRequest(cancelReq);

                OrderCancelResponse cancelResp = service.cancelOrder(config.getClientId(), clientOrderID, resp.getOrderID());
                
                System.out.println("submitOrderCancelRequest:\n" + cancelResp);

                Assertions.assertTrue(cancelReq != null && cancelResp.isSuccess() == false && cancelReq.getOrderID() == cancelReq.getOrderID());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
