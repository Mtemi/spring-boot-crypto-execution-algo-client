package com.ismail.algo.service;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ismail.algo.AlgoConstants;
import com.ismail.algo.AlgoUtil;
import com.ismail.algo.HttpContentTypes;
import com.ismail.algo.HttpHeaders;
import com.ismail.algo.config.AlgoClientConfig;
import com.ismail.algo.model.Algo;
import com.ismail.algo.model.AlgoApiError;
import com.ismail.algo.model.AlgosResult;
import com.ismail.algo.model.BusinessApiException;
import com.ismail.algo.model.ChildOrder;
import com.ismail.algo.model.ChildOrdersResult;
import com.ismail.algo.model.ContactUsRequest;
import com.ismail.algo.model.Instrument;
import com.ismail.algo.model.InstrumentsResult;
import com.ismail.algo.model.NewOrderRequest;
import com.ismail.algo.model.NewOrderResponse;
import com.ismail.algo.model.Order;
import com.ismail.algo.model.OrderBook;
import com.ismail.algo.model.OrderBooksResult;
import com.ismail.algo.model.OrderCancelResponse;
import com.ismail.algo.model.OrdersResult;
import com.ismail.algo.model.TopOfBook;
import com.ismail.algo.model.TopOfBooksResult;
import com.ismail.algo.model.Trade;
import com.ismail.algo.model.TradesResult;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlgoClientApiService
{
    private final AlgoClientConfig config;

    public List<Algo> getAlgos()
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getAlgosUrl();

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    AlgosResult result = mapper.readValue(body, AlgosResult.class);

                    List<Algo> list = result.algos;

                    return list;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
    }

    public Algo getAlgoByStrategyID(String strategyID)
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getAlgoUrl();

            url += "?algoID=" + strategyID;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                // parse json into an object
                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    Algo items = mapper.readValue(body, Algo.class);

                    return items;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public Map<String, Instrument> getInstrumentsMapByID()
    {
        List<Instrument> list = getInstruments();

        HashMap<String, Instrument> map = new HashMap<>();
        for (Instrument inst : list)
            map.put(inst.getInstrumentID(), inst);

        return map;
    }

    public List<Instrument> getInstruments()
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getInstrumentsUrl();
            url += "?tob=true";
            
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                // parse json into an object
                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    InstrumentsResult result = mapper.readValue(body, InstrumentsResult.class);

                    List<Instrument> list = result.instruments;

                    return list;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public Instrument getInstrumentByInsID(String instrumentID)
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getInstrumentUrl();

            url += "?instrumentID=" + instrumentID;
            url += "&tob=true";
            url += "&tobm=true";

            log.info("Url: ", url);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                // parse json into an object
                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    Instrument items = mapper.readValue(body, Instrument.class);

                    return items;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public List<TopOfBook> getTopOfBooks()
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getTopOfBookUrl();
            
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                // parse json into an object
                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    TopOfBooksResult result = mapper.readValue(body, TopOfBooksResult.class);

                    List<TopOfBook> list = result.topOfBooks;

                    return list;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public TopOfBook getTopOfBookByInstrumentID(String instrumentID)
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getTopOfBookUrl();

            url += "?instrumentID=" + instrumentID;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                // parse json into an object
                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    TopOfBook items = mapper.readValue(body, TopOfBook.class);

                    return items;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public List<OrderBook> getOrderBooks()
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getOrderBookUrl();

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                // parse json into an object
                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    OrderBooksResult result = mapper.readValue(body, OrderBooksResult.class);

                    List<OrderBook> list = result.orderBooks;

                    return list;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public OrderBook getOrderBookByInstrumentID(String instrumentID)
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getOrderBookUrl();

            url += "?instrumentID=" + instrumentID;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                // parse json into an object
                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    OrderBook items = mapper.readValue(body, OrderBook.class);

                    return items;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public OrdersResult getOrders(int pageNum, int pageSize)
    {
        try
        {
            String url = config.getUrlPrefix();
            url += config.getOrdersUrl();

            url += "?pageNum=" + pageNum;
            url += "&pageSize=" + pageSize;
            

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    OrdersResult result = mapper.readValue(body, OrdersResult.class);

                    return result;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public Order getOrderByOrderID(long orderID)
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getOrderUrl();

            url += "?orderID=" + orderID;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    Order items = mapper.readValue(body, Order.class);

                    return items;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }

        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
    }
    
    public ChildOrdersResult getChildOrders(int pageNum, int pageSize)
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getChildOrdersUrl();

            url += "?pageNum=" + pageNum;

            url += "&pageSize=" + pageSize;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    ChildOrdersResult result = mapper.readValue(body, ChildOrdersResult.class);

                    return result;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public ChildOrdersResult getChildOrdersByParentOrderID(long orderID, int pageNum, int pageSize)
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getChildOrdersUrl();

            url += "?parentOrderID=" + orderID;

            url += "&pageNum=" + pageNum;

            url += "&pageSize=" + pageSize;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    ChildOrdersResult result = mapper.readValue(body, ChildOrdersResult.class);

                    return result;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }


    public ChildOrder getChildOrderByChildOrderID(long childOrderID)
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getChildOrderUrl();

            url += "?childOrderID=" + childOrderID;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    ChildOrder items = mapper.readValue(body, ChildOrder.class);

                    return items;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public TradesResult getTradesByParentOrderID(long parentOrderID, int pageNum, int pageSize)
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getTradesUrl();

            url += "?parentOrderID=" + parentOrderID;

            url += "&pageNum=" + pageNum;
            url += "&pageSize=" + pageSize;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    TradesResult result = mapper.readValue(body, TradesResult.class);

                    return result;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public List<Trade> getTradesByChildOrderID(long childOrderID)
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getTradesUrl();

            url += "?childOrderID=" + childOrderID;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    Trade[] items = mapper.readValue(body, Trade[].class);

                    List<Trade> list = Arrays.asList(items);

                    return list;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public Trade getTradeByTradeID(long tradeID)
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getTradeUrl();

            url += "?tradeID=" + tradeID;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder() //
                    .GET() //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    .uri(URI.create(url)) //
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                ObjectMapper mapper = new ObjectMapper();

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    Trade items = mapper.readValue(body, Trade.class);

                    return items;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }
        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public NewOrderResponse submitNewOrderRequest(NewOrderRequest orderRequest)
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getOrderUrl();

            HttpClient client = HttpClient.newHttpClient();

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(orderRequest);
            // StringEntity json = new StringEntity(addPostStr, ContentType.APPLICATION_JSON);

            log.info("submitOrderRequest() >>\n" + json);

            HttpRequest request = HttpRequest.newBuilder() //
                    .uri(URI.create(url)) //
                    .header(HttpHeaders.CONTENT_TYPE,  HttpContentTypes.APPLICATION_JSON) //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    //.header(BinanceApiConstants.API_KEY_HEADER, apiKey)
                    .POST(BodyPublishers.ofString(json)) //
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                log.info("submitOrderRequest() <<\n" + body);

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    NewOrderResponse resp = mapper.readValue(body, NewOrderResponse.class);

                    return resp;
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }

        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }

    public OrderCancelResponse cancelOrder(String clientID, String clientOrderID, long orderID)
    {

        try
        {
            String url = config.getUrlPrefix();
            url += config.getOrderUrl();

            url += "?clientID=" + clientID;

            if (AlgoUtil.isDefined(clientOrderID))
                url += "&clientOrderID=" + clientOrderID;

            if (orderID > 0L)
                url += "&orderID=" + orderID;

            HttpClient client = HttpClient.newHttpClient();

            ObjectMapper mapper = new ObjectMapper();

            log.info("cancelOrder()");

            HttpRequest request = HttpRequest.newBuilder() //
                    .uri(URI.create(url)) //
                    .header(HttpHeaders.CONTENT_TYPE,  HttpContentTypes.APPLICATION_JSON) //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    //.header(BinanceApiConstants.API_KEY_HEADER, apiKey)
                    .DELETE() //
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                log.info("cancelOrder() <<\n" + body);

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    OrderCancelResponse resp = mapper.readValue(body, OrderCancelResponse.class);

                    return resp;

                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }

        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }

    }
    
    
    public void contactUs(ContactUsRequest contactRequest)
    {
        try
        {
            String url = config.getUrlPrefix();
            url += config.getContactUsUrl();

            HttpClient client = HttpClient.newHttpClient();

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(contactRequest);

            log.info("contactUs() >>\n" + json);

            HttpRequest request = HttpRequest.newBuilder() //
                    .uri(URI.create(url)) //
                    .header(HttpHeaders.CONTENT_TYPE,  HttpContentTypes.APPLICATION_JSON) //
                    .header(HttpHeaders.ACCEPT, HttpContentTypes.APPLICATION_JSON) //
                    //.header(BinanceApiConstants.API_KEY_HEADER, apiKey)
                    .POST(BodyPublishers.ofString(json)) //
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HttpStatus.SC_OK)
            {
                String body = response.body();

                log.info("contactUs() <<\n" + body);

                if (body.contains("errorCode"))
                {
                    AlgoApiError err = mapper.readValue(body, AlgoApiError.class);

                    throw new BusinessApiException(err);
                }
                else
                {
                    // all good
                }
            }
            else
            {
                throw new BusinessApiException(response.statusCode(), "Unexpected Response");
            }

        }
        catch (InterruptedException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
        catch (ConnectException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(AlgoConstants.ERROR_MSG_SERVER_UNREACHABLE);
        }
        catch (IOException e)
        {
            log.error(e.getMessage(), e);

            throw new BusinessApiException(e);
        }
    }
}
