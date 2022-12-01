package com.ismail.algo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlgosResult extends ApiMsg
{
    @JsonProperty("r")
    public int recordsCount;

    @JsonProperty("algos")
    public List<Algo> algos;

    public AlgosResult()
    {
        super(ApiMsgType.AlgosResult);
    }
}
